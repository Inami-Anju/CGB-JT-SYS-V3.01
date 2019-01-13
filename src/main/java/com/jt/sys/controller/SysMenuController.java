package com.jt.sys.controller;

import com.jt.common.vo.JsonResult;
import com.jt.sys.entity.SysMenu;
import com.jt.sys.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/menu")
public class SysMenuController {
    @Autowired
    private SysMenuService sysMenuService;

    /**
     *进入菜单管理界面
     * @return
     */
    @RequestMapping("/doMenuListUI")
    public String doMenuListUI(){
        return "sys/menu_list";
    }

    /**
     *填充信息
     * @return
     */
    @RequestMapping("doFindObjects")
    @ResponseBody
    public JsonResult doFindObjects(){
        return new JsonResult(sysMenuService.findObjects());
    }
    /**
     *删除
     * @return
     */
    @RequestMapping("doDeleteObject")
    @ResponseBody
    public JsonResult doDeleteObject(Integer id){
        sysMenuService.deleteObject(id);
        return new JsonResult("delete OK");
    }

    /**
     * 添加菜单
     * @return
     */
    @RequestMapping("doMenuEditUI")
    public String doMenuEditUI(){
        return "sys/menu_edit";
    }

    /**
     * 基于客户端请求,访问业务层对象方法,获取菜单节点对象,并封装返回.
     * @return
     */
    @RequestMapping("doFindZtreeMenuNodes")
    @ResponseBody
    public JsonResult doFindZtreeMenuNodes(){
        return new JsonResult(
                sysMenuService.findZtreeMenuNodes());
    }

    /**
     * 1）	获取客户端请求数据
     * 2）	调用业务层方法将数据写入数据库
     * @param entity
     * @return
     */
    @RequestMapping("doSaveObject")
    @ResponseBody
    public JsonResult doSaveObject(SysMenu entity){
        sysMenuService.saveObject(entity);
        return new JsonResult("save ok");
    }

    /**
     * 1)	接收客户端数据
     * 2)	将数据通过业务层对象进行更新操作
     * 3)	封装结果并返回
     * @param entity
     * @return
     */
    @RequestMapping("doUpdateObject")
    @ResponseBody
    public JsonResult doUpdateObject(SysMenu entity){
        sysMenuService.updateObject(entity);
        return new JsonResult("update ok");
    }


}
