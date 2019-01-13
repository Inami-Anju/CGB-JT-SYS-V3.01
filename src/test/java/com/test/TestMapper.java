package com.test;


import com.jt.sys.dao.SysMenuDao;
import org.junit.Test;

public class TestMapper extends TestBase {
    @Test
    public void testLruCache(){
        final SysMenuDao sysMenuDao = ac.getBean("sysMenuDao", SysMenuDao.class);
        final int childCount = sysMenuDao.getChildCount(46);
        System.out.println(childCount);
    }
}
