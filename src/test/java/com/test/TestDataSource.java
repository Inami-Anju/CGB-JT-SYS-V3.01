package com.test;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class TestDataSource extends TestBase{
    @Test//测试德鲁伊
    public void testDruidDataSource(){
      //  final DruidDataSource dataSource = ac.getBean("dataSource", DruidDataSource.class);
        final DataSource dataSource = ac.getBean("dataSource", DataSource.class);
        try {
            final Connection connection = dataSource.getConnection();
            System.out.println(connection);//进入断点调试看各个信息，因为没有方法get密码
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(dataSource);
        //final String url = dataSource.getUrl();
       // System.out.println(url);
    }

    @Test//测试c3p0
    public void testC3p0DataSource(){
        //  final DruidDataSource dataSource = ac.getBean("dataSource", DruidDataSource.class);
        final DataSource dataSource = ac.getBean("c3p0", DataSource.class);
        try {
            final Connection connection = dataSource.getConnection();
            System.out.println(connection);//进入断点调试看各个信息，因为没有方法get密码
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(dataSource);
        //final String url = dataSource.getUrl();
        // System.out.println(url);
    }

}
