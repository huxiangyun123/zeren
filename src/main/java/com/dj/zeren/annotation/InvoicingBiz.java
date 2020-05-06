package com.dj.zeren.annotation;


import com.dj.zeren.enums.ProcessName;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface InvoicingBiz {
    /**
     * 验证类唯一键值
     *
     * @return
     */
    String value() default "";

    /**
     * 验证类执行顺序
     *
     * @return
     */
    int order() default 0;

    /**
     * 扩展字段暂时不用
     *
     * @return
     */
    String group() default "";

    ProcessName processName() default ProcessName.Null_Default;

}
