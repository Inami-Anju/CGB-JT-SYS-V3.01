package com.jt.sys.dao;

import com.jt.common.vo.Node;
import com.jt.sys.entity.SysMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SysMenuDao {

    List<Map<String,Object>> findObjects();

    /**
     * 根据菜单id统计子菜单的个数
     * @param id
     * @return
     */
    int getChildCount(@Param("id") Integer id);
    /**
     * 根据id 删除菜单
     * @param id
     * @return
     */
    int deleteObject(@Param("id") Integer id);

    List<Node> findZtreeMenuNodes();

    int insertObject(SysMenu entity);

    int updateObject(SysMenu entity);
}
