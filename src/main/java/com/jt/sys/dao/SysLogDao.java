package com.jt.sys.dao;

import com.jt.sys.entity.SysLog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 *
 */

@Repository
public interface SysLogDao extends Mapper<SysLog> {
    /**
     * 基于用户名查询该用户总记录条数
     * @param username
     * @return
     */
    Integer getRowCount(@Param("username") String username);

    List<SysLog> findPageObjects(@Param("username")String username,
                                 @Param("startIndex") Integer startIndex,
                                 @Param("pageSize") Integer pageSize);//

    /**
     *添加用户日志信息
     * @param sysLog
     * @return
     */
    //Integer报错
    int insert(SysLog sysLog);


}
