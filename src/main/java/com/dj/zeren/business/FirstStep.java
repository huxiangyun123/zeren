package com.dj.zeren.business;


import com.dj.zeren.annotation.InvoicingBiz;
import com.dj.zeren.enums.ProcessName;
import com.dj.zeren.model.ServiceContext;
import com.dj.zeren.service.AbstractConditionBaseService;
import org.springframework.stereotype.Service;



@Service
@InvoicingBiz(value = "test", processName = ProcessName.First_Step)
public class FirstStep
        extends AbstractConditionBaseService {


    @Override
    public boolean condition(ServiceContext context) {
        if (super.condition(context)) {
            return true;
        }
        return false;
    }

    @Override
    public void process(ServiceContext context) {
        System.out.println("first step 第一步");
        context.createResponseBody(null);
    }
}