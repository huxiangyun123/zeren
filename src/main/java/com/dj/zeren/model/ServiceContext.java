package com.dj.zeren.model;


public class ServiceContext<T> {

    private ServiceRequest request = new ServiceRequest();
    private ServiceResponse response = new ServiceResponse();

    /**
     * 该标识 将会停止所有后续操作
     */
    private Boolean breakFlag;

    private T conditionConfig;

    public ServiceRequest getRequest() {
        return request;
    }

    public ServiceResponse getResponse() {
        return response;
    }

    public Boolean getBreakFlag() {
        return breakFlag;
    }

    public void setBreakFlag(Boolean breakFlag) {
        this.breakFlag = breakFlag;
    }


    public T getConditionConfig() {
        return conditionConfig;
    }

    public void setConditionConfig(T conditionConfig) {
        this.conditionConfig = conditionConfig;
    }

    /**
     * 请求body dto
     */
    public <T> void createRequestBody(T body) {
        request.setBody(body);
    }


    public <T> void createResponseBody(T body) {
        response.setBody(body);
    }


}
