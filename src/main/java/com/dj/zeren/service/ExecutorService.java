package com.dj.zeren.service;


import com.dj.zeren.model.ServiceContext;

/**
 * @author ：yangxingwen
 * @date ：Created in 2019/3/21 14:46
 * @description：${description}
 */
public interface ExecutorService {

    /**
     * 服务开始
     *
     * @param serviceContext
     */
    void start(ServiceContext serviceContext);
    /**
     * 执行所有的业务
     *
     * @param serviceContext
     */
    void run(ServiceContext serviceContext);

    /**
     * 服务结束
     *
     * @param serviceContext
     */
    void stop(ServiceContext serviceContext);

    /**
     * 执行业务
     *
     * @param serviceContext
     */
    void execute(ServiceContext serviceContext);
}
