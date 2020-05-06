package com.dj.zeren.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class ServiceRequest<T> {

    private Map<String, Object> header = new ConcurrentHashMap<String, Object>();

    private T body;

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

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

    public void removeHeaderKey(String key)
    {
        if (header.containsKey(key)) {
            header.remove(key);
        }
    }


}
