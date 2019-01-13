package com.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.jt.sys.dao.SysLogDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {
    /**最基础的jdbc */
    @Test
    public void testJDBC() throws SQLException {
        DruidDataSource  ds= new DruidDataSource() ;
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/jtsys?characterEncoding=utf8&useSSL=false&serverTimezone=UTC");
        ds.setUsername("root");
        ds.setPassword("root");
        final DruidPooledConnection connection = ds.getConnection();
        System.out.println(connection);
        final Statement statement = connection.createStatement();
        final ResultSet resultSet = statement.executeQuery("select * from sys_menus");
        while (resultSet.next()){
            final int id = resultSet.getInt("id");
            final String name = resultSet.getString("name");
            final Date createdTime = resultSet.getDate("createdTime");
            System.out.println(id+name+createdTime);
        }
        connection.close();
        statement.close();
        resultSet.close();
    }

    /** */
    ////jdbcUrl=jdbc\:mysql\://localhost\:3306/jtsys?characterEncoding\=utf8&useSSL\=false&serverTimezone\=UTC
    @Test
    public void testJDBC1() throws IOException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        //InputStream in = Resources.getResourceAsStream("configs.properties");
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        StringBuilder stringBuilder=new StringBuilder();
       /* int d=-1;
        while ((d=in.read())!=-1){
            char c=(char)d;
            stringBuilder.append(c);
        }
        System.out.println(stringBuilder.toString());*/
        final SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
        final SqlSession sqlSession = sqlSessionFactory.openSession(true);
        final SysLogDao mapper = sqlSession.getMapper(SysLogDao.class);
        final Integer admin = mapper.getRowCount("admin");
        System.out.println(admin);
    }

    @Test
    public void testJDBC2() throws Exception {
        DruidDataSource ds=new DruidDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/jtsys?characterEncoding=utf8&useSSL=false&serverTimezone=UTC");
        ds.setUsername("root");
        ds.setPassword("root");
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource mybatisConfigXml = resolver.getResource("mybatis-config.xml");
        System.out.println(mybatisConfigXml);
        final Resource[] resolverResources = resolver.getResources("mappers/sys/*.xml");
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(ds);
        bean.setMapperLocations(resolverResources);
      //  bean.setConfigLocation(mybatisConfigXml);
        final SqlSessionFactory sqlSessionFactory = bean.getObject();
        final SqlSession sqlSession = sqlSessionFactory.openSession(true);
        final SysLogDao mapper = sqlSession.getMapper(SysLogDao.class);//声明接口
        final Integer admin = mapper.getRowCount("admin");
        System.out.println(admin);
    }


}
