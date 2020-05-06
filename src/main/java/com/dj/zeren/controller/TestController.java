package com.dj.zeren.controller;

import com.dj.zeren.dto.TestDto;
import com.dj.zeren.model.ServiceContext;
import com.dj.zeren.model.ServiceResponse;
import com.dj.zeren.service.TestExcutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 2 * @Author: Chris
 * 3 * @Date: 2020/5/3 9:17
 * 4
 */
@RestController
public class TestController {

    @Autowired
    TestExcutorService testExcutorService;

    @PostMapping("/test")
    public ServiceResponse test(@RequestBody TestDto dto){
        ServiceContext context = new ServiceContext();
        context.createRequestBody(dto);
        //基本执行条件
        testExcutorService.execute(context);
        return context.getResponse();
    }
}
