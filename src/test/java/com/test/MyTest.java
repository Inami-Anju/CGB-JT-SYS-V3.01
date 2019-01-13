package com.test;

import com.jt.sys.dao.SysLogDao;
import com.jt.sys.entity.SysLog;
import com.jt.sys.service.SysLogService;
import org.junit.Test;

import java.util.List;

public class MyTest extends TestBase {
    @Test
    public void testLogService(){
        final SysLogService sysLogService = ac.getBean("sysLogServiceImpl", SysLogService.class);
        final List<SysLog> admin = sysLogService.findPageObjects("admin", 1, 2);
        for (SysLog sysLog : admin) {
            System.out.println(sysLog);
        }
    }

    @Test
    public void testLogMapperSelectRow(){
        final SysLogDao sysLogDao = ac.getBean("sysLogDao", SysLogDao.class);
        final Integer row = sysLogDao.getRowCount("admin");
        System.out.println(row);
    }

    @Test
    public void testLogMapperSelectAll(){
        final SysLogDao sysLogDao = ac.getBean("sysLogDao", SysLogDao.class);
        final List<SysLog> sysLogs = sysLogDao.findPageObjects("admin", 1, 10);
        for (SysLog sysLog : sysLogs) {
            System.out.println(sysLog);
        }
    }

}
