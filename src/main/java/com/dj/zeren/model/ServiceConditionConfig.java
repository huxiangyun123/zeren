package com.dj.zeren.model;


import com.dj.zeren.enums.ProcessName;
import lombok.Data;

import java.util.List;


@Data
public class ServiceConditionConfig {
    /**
     * 所有加入当前集合的类都会执行 反之不执行 如果
     */
    private List<String> conditionList;


    /**
     * 所有加入当前集合的类都会执行 反之不执行 如果
     */
    private List<ProcessName> processNameList;

    /**
     * 是否执行全部
     */
    private Boolean runAll;
}
