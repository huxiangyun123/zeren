package com.dj.zeren.service;


import com.dj.zeren.enums.ProcessName;
import com.dj.zeren.model.ServiceConditionConfig;
import com.dj.zeren.model.ServiceContext;

import com.dj.zeren.utils.OrderServiceContextUtils;
import com.dj.zeren.utils.ServiceAutoLoad;
import com.dj.zeren.utils.SpringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;


import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
public abstract class AbstractExecutorService implements ExecutorService {


    @Autowired
    protected ApplicationContext context;

    protected AbstractExecutorService proxy;

    @PostConstruct
    public void init() {
        //从Spring上下文中获取AOP代理对象
        proxy = context.getBean(this.getClass());
        System.out.println(proxy);
    }

    @Override
    public void run(ServiceContext serviceContext) {


        ServiceConditionConfig conditionConfig =
                OrderServiceContextUtils.getServiceConditionConfig(serviceContext);
        List<ProcessName> processNameList = conditionConfig.getProcessNameList();

        processNameList.forEach(f -> {

            String v = ServiceAutoLoad.map.get(f);
            BaseService service = (BaseService) SpringUtils.getBean(v);
            if (service != null&&service.condition(serviceContext)&&(f.getMqFlag()==null||!f.getMqFlag())) {
                log.info("run --------------{},{}", f.getName(), f.getValue());
                service.process(serviceContext);
            }
        });


    }


    public void postMQ(ServiceContext serviceContext){
        ServiceConditionConfig conditionConfig =
                OrderServiceContextUtils.getServiceConditionConfig(serviceContext);
        List<ProcessName> processNameList = conditionConfig.getProcessNameList();

        List<ProcessName> mqProcessNameList=processNameList.stream().filter(f->f.getMqFlag()!=null&&f.getMqFlag()).collect(Collectors.toList());

        if(!mqProcessNameList.isEmpty())
        {
            log.info("进入 非回滚性业务 发送业务");
            mqProcessNameList.forEach(f -> {

                String v = ServiceAutoLoad.map.get(f);
                BaseService service = (BaseService) SpringUtils.getBean(v);
                if (service != null&&service.condition(serviceContext)&&(f.getMqFlag()!=null&&f.getMqFlag())) {
                    log.info("run --------------{},{}", f.getName(), f.getValue());
                    service.process(serviceContext);
                }
            });
            log.info("结束 非回滚性业务业务");
        }
    }

    @Override
    public void start(ServiceContext serviceContext) {

        if (OrderServiceContextUtils.getServiceConditionConfig(serviceContext)
                .getRunAll()) {
            runAllSetup(serviceContext);
        }
    }

    @Override
    public void execute(ServiceContext serviceContext) {

        proxy.start(serviceContext);
        try {
            proxy.run(serviceContext);
            proxy.postMQ(serviceContext);

        }
        catch (Exception e) {
            log.info("run --------------异常");
        }
        finally {

        }

        proxy.stop(serviceContext);
    }

    public void runAllSetup(ServiceContext serviceContext) {
        if (OrderServiceContextUtils.getServiceConditionConfig(serviceContext).getProcessNameList() == null) {
            OrderServiceContextUtils.getServiceConditionConfig(serviceContext).setProcessNameList(new ArrayList<>());
        }
        List<ProcessName> allConfigEnumList = ProcessName.getAllEnumType("");
        OrderServiceContextUtils.getServiceConditionConfig(serviceContext).getProcessNameList().addAll(allConfigEnumList);

    }
}
