package com.jt.sys.service;

import com.jt.common.vo.Node;
import com.jt.sys.entity.SysMenu;

import java.util.List;
import java.util.Map;

public interface SysMenuService {

     List<Map<String,Object>> findObjects();

     int deleteObject(Integer id);

    public List<Node> findZtreeMenuNodes();

    int saveObject(SysMenu entity);

    int updateObject(SysMenu entity);

}
