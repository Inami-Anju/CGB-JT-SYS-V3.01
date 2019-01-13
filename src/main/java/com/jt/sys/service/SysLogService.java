package com.jt.sys.service;

import com.jt.common.vo.PageObject;
import com.jt.sys.entity.SysLog;

import java.util.List;

public interface SysLogService {

    List<SysLog> findPageObjects(String username,Integer startIndex,Integer pageSize);

    Integer getRowCount(String username);
    /**
     * 通过此方法实现分页查询操作
     * @param name 基于条件查询时的参数名
     * @param pageCurrent 当前的页码值
     * @return 当前页记录+分页信息
     */
    PageObject<SysLog> findPageObjects(String name, Integer pageCurrent);

}
