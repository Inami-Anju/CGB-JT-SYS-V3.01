package com.jt.common.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import javax.sql.DataSource;

@PropertySource(value = "classpath:configs.properties")//告诉框架读取配置文件，内容会被封装到Environment对象
@Configuration//等效于@component，@controller，@service，
// 但用@configuration会继续扫描方法上有@bean的
public class AppDataSourceConfig {
    static {
        System.out.println("AppDataSourceConfig被加载进了内存(方法区)");
    }
    public AppDataSourceConfig() {
        System.out.println("AppDataSourceConfig执行了构造方法");
    }
    /*配置数据源对象*/
    @Lazy(false)
    @Bean(value = "dataSource",initMethod="init",destroyMethod="close")
    //为什么用bean这个注解，因为DataSource类不是自己写的，无法再类上加注解，即第三方的api
    public DataSource newDruidDataSource(Environment ev){
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName(ev.getProperty("jdbcDriver"));
        ds.setUrl(ev.getProperty("jdbcUrl"));
        ds.setUsername(ev.getProperty("jdbcUser"));
        ds.setPassword(ev.getProperty("jdbcPassword"));
        return  ds;
    };

    /*多个数据源*/
    /*@Bean(value = "c3p0",initMethod="init",destroyMethod="close")
    public DataSource newC3P0DataSource(Environment ev) throws PropertyVetoException {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        ds.setDriverClass(ev.getProperty("jdbcDriver"));
        ds.setJdbcUrl(ev.getProperty("jdbcUrl"));
        ds.setUser(ev.getProperty("jdbcUser"));
        ds.setPassword(ev.getProperty("jdbcPassword"));
        return ds;
    }*/
}
