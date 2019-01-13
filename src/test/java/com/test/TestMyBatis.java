package com.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;


public class TestMyBatis extends TestBase {

    @Test
    public void myBatis(){
        final SqlSessionFactory sqlSessionFactory = ac.getBean("sqlSessionFactory", SqlSessionFactory.class);
        final SqlSession sqlSession = sqlSessionFactory.openSession(true);
        System.out.println(sqlSession);
    }
}
