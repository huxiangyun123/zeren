package com.dj.zeren.utils;

import com.dj.zeren.annotation.InvoicingBiz;
import com.dj.zeren.enums.ProcessName;
import org.reflections.Reflections;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author ：yangxingwen
 * @date ：Created in 2019/3/7 15:01
 * @description：服务启动自动扫描包 并且将需要执行的类添加到 map 中方便后面调用
 */
public class ServiceAutoLoad {

    public static Map<ProcessName, String> map = new TreeMap<ProcessName, String>(new MapKeyComparator());
    private static final String ORDER_STEP_PKG_PATH = "com.dj.zeren";

    static {
        // 反射工具包，指明扫描路径
        Reflections reflections = new Reflections(ORDER_STEP_PKG_PATH);
        //获取带OrderBiz注解的类
        Set<Class<?>> classList = reflections.getTypesAnnotatedWith(InvoicingBiz.class);
        for (Class classes : classList) {
            InvoicingBiz t = (InvoicingBiz) classes.getAnnotation(InvoicingBiz.class);
            map.put(t.processName(), StringUtils.toLowerCaseFirstOne(classes.getSimpleName()));
        }
    }

    /**
     * 初始化触发器
     */
    public static void initialization() {

    }


    static class MapKeyComparator implements Comparator<ProcessName> {

        @Override
        public int compare(ProcessName orderBiz1, ProcessName orderBiz2) {

            return orderBiz1.ordinal() - orderBiz2.ordinal();
        }
    }
}
