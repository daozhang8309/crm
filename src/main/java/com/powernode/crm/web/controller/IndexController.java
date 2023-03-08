package com.powernode.crm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//注解
@Controller
public class IndexController {
    /*
        理论上，给Controller方法分配url：@RequestMapping("http://127.0.0.1:8080/crm/")
        为了简便，http://127.0.0.1:8080/crm/ 省去 只保留 / 代表项目根目录
     */
    @RequestMapping("/")
    public String index(){
        //请求转发
        return "index";//视图解析器 增加了前缀（/WEB-INF/pages/）和后缀（.jsp）
    }
}
