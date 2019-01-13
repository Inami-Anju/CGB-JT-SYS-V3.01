package com.jt.common.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 对mvc资源整合
 */
@ComponentScan(value="com.jt",useDefaultFilters=false,includeFilters=
        {@ComponentScan.Filter(type=FilterType.ANNOTATION,classes={Controller.class,ControllerAdvice.class})})
@EnableWebMvc
public class AppMVCConfig extends WebMvcConfigurerAdapter {

    @Override
    //这里configure是动词，配置视图解析器
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/pages/",".html");
    }

}
