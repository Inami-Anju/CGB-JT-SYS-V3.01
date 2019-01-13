package com.jt.sys.dao;

import org.apache.ibatis.annotations.Param;

public interface SysRoleMenuDao {
    int deleteObjectsByMenuId(@Param("menuId") Integer menuId);
}
