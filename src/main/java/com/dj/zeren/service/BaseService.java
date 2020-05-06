package com.dj.zeren.service;


import com.dj.zeren.model.ServiceContext;

public interface BaseService {
    /**
     * 执行条件
     *
     * @param context
     * @return
     */
    boolean condition(ServiceContext context);

    /**
     * 执行业务逻辑
     *
     * @param context
     */
    void process(ServiceContext context);
}