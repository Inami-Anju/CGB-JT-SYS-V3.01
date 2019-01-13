package com.jt.sys.service;


import com.jt.common.exception.ServiceException;
import com.jt.common.vo.PageObject;
import com.jt.sys.dao.SysLogDao;
import com.jt.sys.entity.SysLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class SysLogServiceImpl implements  SysLogService {
    @Autowired/*默认按类型为属性赋值，*/

    SysLogDao sysLogDao;

    @Override
    public PageObject findPageObjects(String username, Integer pageCurrent) {
        if (pageCurrent==null||pageCurrent<1) throw new IllegalArgumentException("当前页码不正确");
        final Integer rowCount = sysLogDao.getRowCount(username);
        if(rowCount==0) throw new ServiceException("系统没有查到对应记录");
        //3.基于条件查询当前页记录(pageSize定义为2)
        //3.1)定义pageSize
        int pageSize=12;
        //3.2)计算startIndex
        int startIndex=(pageCurrent-1)*pageSize;
        //3.3)执行当前数据的查询操作
        List<SysLog> records= sysLogDao.findPageObjects(username, startIndex, pageSize);

        PageObject pageObject=new PageObject();
        pageObject.setPageCurrent(pageCurrent);
        pageObject.setPageSize(pageSize);
        pageObject.setRowCount(rowCount);
        pageObject.setRecords(records);
        pageObject.setPageCount(rowCount/pageSize);

        return pageObject;
    }

    @Override
    public List<SysLog> findPageObjects(String username, Integer startIndex, Integer pageSize) {
        return null;
    }

    @Override
    public Integer getRowCount(String username) {
        return null;
    }



   /* @Override
    public List<SysLog> findPageObjects(String username, Integer startIndex, Integer pageSize) {
        PageHelper.startPage(startIndex, pageSize);
        SysLog sysLog=new SysLog();
        sysLog.setUsername(username);
        Example example=new Example(SysLog.class);
        final Example.Criteria criteria = example.createCriteria().andEqualTo("username", username);
        final List<SysLog> sysLogs = sysLogDao.selectByExample(example);
        return sysLogs;
    }*/


}
