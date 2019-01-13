package com.test;

import com.jt.common.cache.LruCache;
import com.jt.common.config.AppRootConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestBase {
    protected AnnotationConfigApplicationContext ac;
    @Before
    public void init(){
        //基于
        ac=new AnnotationConfigApplicationContext(AppRootConfig.class);
        //为什么要传入 Class...   可变参数，底层利用反射加载所以需要传入Class
/*
      ==  new ClassPathXmlApplicationContext()
      都是初始化容器，一个基于xml文件，一个基于配置类
*/
    }
    @Test
    //测试ac是否被初始化，ac应存在地址，不为null值
    public void testSpringFrameWork(){
        System.out.println(ac);
    }
    @Test
    //测试bean是否存入map中,ac应能取出，不报错 notsuchbean
    public void testLruCache(){
        final LruCache lruCache = ac.getBean("lruCache", LruCache.class);
        System.out.println(lruCache);
    }
    @Test
    public void testProperties(){
     /*   Environment ev=ac.getEnvironment();
        final String jdbcUrl = ev.getProperty("jdbcUrl");
        System.out.println(jdbcUrl);*/
    }

    //@After
    public void close(){
        ac.close();
    }
}
