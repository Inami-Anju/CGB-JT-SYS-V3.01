package com.jt.common.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;


/**
 * 项目对系统资源对象进行配置
 * 1xml
 * 2 注解@annotation
 */

@ComponentScan(value = "com.jt",
        excludeFilters =
                {@ComponentScan.Filter(type = FilterType.ANNOTATION,
                        classes ={Controller.class, ControllerAdvice.class} )})
//不加载类型为注解，名为controller，advice
//取代了<context:component-Scan base-package="" >
public class AppRootConfig {//取代了spring-config.xml
    static {
        System.out.println("AppRootConfig被加载进了内存(方法区)");
    }

    public AppRootConfig() {
        System.out.println("AppRootConfig执行了构造方法");
    }
}
