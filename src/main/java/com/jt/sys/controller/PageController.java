package com.jt.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**系统底层发现@RequestMapping注解以后会
 找到一个HandlerMapping对象(具备全局唯一性)，
 此对象内部对应的是一个map,用于存储url到具体方法的映射
 说明:在spring mvc中会将@Controller注解修饰
 的类理解为Handler对象
 */
//<bean id="" class=""/>
@Controller
@RequestMapping("/")
public class PageController {//类加载，将类读到内存，立即创建字节码对象Class a；

    public PageController() {
        System.out.println("PageController construct()------");
    }

    /**
     * 通过此方法返回首页
     * @return
     */
    @RequestMapping("doIndexUI")
    public String doIndexUI(){
        System.out.println("进入了doIndexUI（）");
        return "starter";//WEB-INF/pages/starter.html
    }

    @RequestMapping("doLoginUI")
    public String doLoginUI(){
        System.out.println("doLoginUI（）");
        return "login";
    }

    /**
     * 返回分页页面
     * @return
     */
    @RequestMapping("doPageUI")
    public String doPageUI(){
        return "common/page";
    }
}
