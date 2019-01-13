package com.jt.sys.controller;

import com.jt.common.vo.JsonResult;
import com.jt.common.vo.PageObject;
import com.jt.sys.entity.SysLog;
import com.jt.sys.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/log")
public class SysLogController {

    @Autowired
    SysLogService sysLogService;

    @RequestMapping("/doLogListUI")
    public String doLogListUI(){
        System.out.println("doLogListUI()");
        return "sys/log_list";//返回的是个页面
    }

    @RequestMapping("/doFindPageObjects")
    @ResponseBody
    public JsonResult doFindPageObjects(String name, Integer pageCurrent){
        PageObject<SysLog> pageObject= sysLogService.findPageObjects(name,pageCurrent);
        return new JsonResult(pageObject);
    }

}
