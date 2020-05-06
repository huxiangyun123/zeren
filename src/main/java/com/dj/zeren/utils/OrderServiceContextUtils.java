package com.dj.zeren.utils;


import com.dj.zeren.model.ServiceConditionConfig;
import com.dj.zeren.model.ServiceContext;

public class OrderServiceContextUtils {

    private static final String LOCK_KEY = "lock_order";

    private static final String MSG_TOKEN_KEY = "msg_id";


    public static final String HYPERCHAIN_SUPPLIER_ASSIGNMENT = "hyperchain_supplier_assignment";


    public static <T> T getResponseBody(ServiceContext context) {
        return (T) context.getResponse().getBody();
    }

    public static ServiceConditionConfig getServiceConditionConfig(ServiceContext serviceContext) {

        return (ServiceConditionConfig) serviceContext.getConditionConfig();
    }

    public static void setServiceConditionConfig(ServiceContext serviceContext, ServiceConditionConfig serviceConditionConfig) {
        serviceContext.setConditionConfig(serviceConditionConfig);
    }




    public static void addHeader(String key, Object value, ServiceContext context) {
        context.getRequest().setHeaderValueByKey(key, value);

    }



    public static <T> void addMsgToken(T value, ServiceContext context) {
        context.getRequest().setHeaderValueByKey(MSG_TOKEN_KEY, value);
    }


    public static <T> T getMsgToken(ServiceContext context) {
        Object v = context.getRequest().getHeaderValueByKey(MSG_TOKEN_KEY);
        boolean isNull = (v == null);
        if (isNull) {
            return null;
        } else {
            return (T) v;
        }
    }





    public static void addLock(Object value, ServiceContext context) {
        context.getRequest().setHeaderValueByKey(LOCK_KEY, value);

    }

    public static void removeLock(ServiceContext context) {
        context.getRequest().removeHeaderKey(LOCK_KEY);
    }

    public static void removeLock(ServiceContext context, String key) {
        String lockValue = getLockValue(context);

        if (lockValue != null) {
            lockValue = lockValue.replaceAll(key + ",", "");
            lockValue = lockValue.replaceAll("," + key, "");
            lockValue = lockValue.replaceAll(key, "");

            addLock(lockValue, context);
        }

    }


    public static String getLockValue(ServiceContext context) {
        Object v = context.getRequest().getHeaderValueByKey(LOCK_KEY);
        boolean isNull = (v == null);
        if (isNull) {
            return null;
        } else {
            return v.toString();
        }
    }












}
