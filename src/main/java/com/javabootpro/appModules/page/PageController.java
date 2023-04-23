package com.javabootpro.appModules.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  html 页面跳转 处理 Controller
 */
@RequestMapping("/page")
@Controller
public class PageController {

    // 数据展示 页面
    @GetMapping("/data")
    public String index(){
        return "/data.html";
    }

    // 管理员 页面
    @GetMapping("/admin")
    public String admin(){
        return "/admin.html";
    }





}
