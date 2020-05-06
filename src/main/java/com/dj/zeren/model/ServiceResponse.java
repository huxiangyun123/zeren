package com.dj.zeren.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class ServiceResponse<T> {

    public Map<String, Object> header = new ConcurrentHashMap<String, Object>();

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    private T body;

    public Object getHeaderValueByKey(String key) {
        return header.get(key);
    }

    public void setHeaderValueByKey(String key, Object value) {
        if (header.containsKey(key)) {
            header.replace(key, value);
        } else {
            header.put(key, value);
        }

    }
}