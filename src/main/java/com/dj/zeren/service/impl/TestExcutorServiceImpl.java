package com.dj.zeren.service.impl;


import com.dj.zeren.enums.ProcessName;
import com.dj.zeren.model.ServiceConditionConfig;
import com.dj.zeren.model.ServiceContext;
import com.dj.zeren.service.AbstractExecutorService;
import com.dj.zeren.service.TestExcutorService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Chris
 * @Date: 2020/5/3 9:22
 */
@Service
public class TestExcutorServiceImpl extends AbstractExecutorService
        implements TestExcutorService {
    @Override
    public void start(ServiceContext serviceContext) {
        //添加执行业务类
        ServiceConditionConfig serviceConditionConfig = new ServiceConditionConfig();
        serviceConditionConfig.setRunAll(false);
        serviceContext.setConditionConfig(serviceConditionConfig);
        List<ProcessName> list = new ArrayList<>();
        list.add(ProcessName.First_Step);
        list.add(ProcessName.Second_Step);
        serviceConditionConfig.setProcessNameList(list);
        serviceContext.setConditionConfig(serviceConditionConfig);
        super.start(serviceContext);
    }

    @Override
    public void run(ServiceContext serviceContext) {
        super.run(serviceContext);
    }

    @Override
    public void stop(ServiceContext serviceContext) {
        serviceContext.createResponseBody(null);
    }

}
