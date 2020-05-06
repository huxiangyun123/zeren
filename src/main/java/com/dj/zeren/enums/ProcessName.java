package com.dj.zeren.enums;


import java.util.ArrayList;
import java.util.List;

/**
 * @author ：yangxingwen
 * @date ：Created in 2019/4/9 14:18
 * @description：订单执行枚举配置
 */
public enum ProcessName {


    Null_Default("def", "默认值"),

    First_Step("first","第一步"),
    Second_Step("second","第二步")
    ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private String value;

    public Boolean getMqFlag() {
        return mqFlag;
    }

    public void setMqFlag(Boolean mqFlag) {
        this.mqFlag = mqFlag;
    }

    private Boolean mqFlag;


    ProcessName(String name, String value) {
        this.name = name;
        this.value = value;
    }

    ProcessName(String name, String value, Boolean mqFlag) {
        this.name = name;
        this.value = value;
        this.mqFlag = mqFlag;
    }

    public static List<ProcessName> getAllEnumType(String val) {
        List<ProcessName> resultList = new ArrayList<>();
        for (ProcessName type : ProcessName.values()) {
            if (!type.equals(ProcessName.Null_Default)) {
                resultList.add(type);
            }

        }
        return resultList;
    }


    @Override
    public String toString() {
        return super.toString();
    }
}