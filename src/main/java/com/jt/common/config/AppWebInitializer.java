package com.jt.common.config;

import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * tomcat启动时会加载此类，然后执行相关方法初始化
 * 完成初始化动作（即web.xml中的一些操作）
 */
//要想此类被加载，须符合规范
public class AppWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    //由于没有xml，重写onStartup方法，注册Filter对象
    public void onStartup(ServletContext servletContext) throws ServletException {
       //不留父类的动作super.onStartup(servletContext);
        //因为父类里已经有了注册的动作，尽量按顺序
        System.out.println("onstartup()");
        registerContextLoaderListener(servletContext);
        registerFilter(servletContext);
        registerDispatcherServlet(servletContext);
    }

    private void registerFilter(ServletContext servletContext) {
        //注册Filter对象
        //什么时候需要采用此方式进行注册?
        //项目没有web.xml并且此filter不是自己写的
        FilterRegistration.Dynamic dy=servletContext.addFilter("filterProxy", DelegatingFilterProxy.class);
        dy.setInitParameter("targetBeanName","shiroFilterFactory");
        dy.addMappingForUrlPatterns(
                null,//EnumSet<DispatcherType>
                false,"/*");//url-pattern
    }


    @Override
    //官方建议再此加载model（service，responsity）
    protected Class<?>[] getRootConfigClasses() {
        System.out.println("initalizer getRootConfigClasses");
        return new Class[]{AppRootConfig.class};
    }

    @Override
    //官方建议在此加载view controller
    protected Class<?>[] getServletConfigClasses() {
        System.out.println("initalizer getServletConfigClasses");
        return new Class[]{AppMVCConfig.class};
    }

    @Override
    //官方建议再此定义请求映射
    protected String[] getServletMappings() {
        System.out.println("initalizer getServletMappings");
        return new String[]{"*.do"};
    }


}
