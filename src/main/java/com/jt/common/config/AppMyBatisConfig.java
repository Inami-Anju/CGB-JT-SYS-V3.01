package com.jt.common.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;


import javax.sql.DataSource;
import java.io.IOException;
@MapperScan("com.jt.**.dao")
@Configuration//通过此注解声明这是配置文件
public class AppMyBatisConfig {
 /*   @Autowired
    private DataSource dataSource;
    @Bean(name = "sqlSessionFactory")
    *//*需要注意：有两个数据源实现了DateSource接口，底层首先按类型匹配，自动装配会失败，*//*
    public SqlSessionFactoryBean newSqlSessionFactoryBean(DataSource dataSource) throws IOException {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
       *//* Resource[] mapperLocations=new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapper/sys/*.xml");
        bean.setMapperLocations(mapperLocations);*//*
        return bean;
    }*/

    //假如bean没有指定名字,此bean的默认名字为方法名
    /***
     * 当spring框架调用如下方法时,要为方法参数传入
     * 一个对象,默认首先是从容器按类型查找与此参数
     * 相匹配的对象,假如有多个还会检测哪个bean的id
     * 与参数匹配,有匹配的则直接赋值,没有则抛出异常.
     * @param dataSource
     * @return
     * 外界假如通过sqlSessionFactory(
     * @Bean注解中定义的key的名字)
     * 获取对象, 默认会调用SqlSessionFactoryBean
     * 对象的getObject方法来创建一个工厂对象,对外
     * 提供具体应用.
     */
    @Bean("sqlSessionFactory")
    public SqlSessionFactoryBean newSqlSesionFactoryBean(
            DataSource dataSource)throws IOException{
        //1.构建bean对象
        SqlSessionFactoryBean fBean=
                new SqlSessionFactoryBean();
        //2.配置数据源
        fBean.setDataSource(dataSource);
        //3.设置映射文件
        Resource[] mapperLocations=
                new PathMatchingResourcePatternResolver()
                        .getResources("classpath:mappers/sys/*.xml");
        fBean.setMapperLocations(mapperLocations);

        return fBean;
    }
}
