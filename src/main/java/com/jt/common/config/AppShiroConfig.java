package com.jt.common.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

@Configuration
public class AppShiroConfig {


    @Bean("securityManager")
    public DefaultWebSecurityManager newDefaultWebSecurityManager() {
        DefaultWebSecurityManager sManager =new DefaultWebSecurityManager();
        //此时必须保证realm对象已经存在了
        return sManager;
    }

    //shiroFilterFactory创建了大量的shiroFilter（过滤器）
    @Bean("shiroFilterFactory")
    public ShiroFilterFactoryBean newShiroFilterFactoryBean(DefaultWebSecurityManager securityManager){//shiro 包
        ShiroFilterFactoryBean bean=new ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager);
        //当此用户是一个非认证用户,需要先登陆进行认证
        bean.setLoginUrl("doLoginUI.do");//PageController
        LinkedHashMap<String,String> fcMap= new LinkedHashMap<>();
        fcMap.put("/bower_components/**","anon");//anon表示允许匿名访问
        fcMap.put("/build/**", "anon");
        fcMap.put("/dist/**","anon");
        fcMap.put("/plugins/**","anon");
        fcMap.put("user/doLoginUI.do","anon");
        fcMap.put("user/doLogout.do ","anon");//logou会跳到doLoginUI.do
        fcMap.put("/**", "authc");//必须授权才能访问
        bean.setFilterChainDefinitionMap(fcMap);
        return bean;
    }

}