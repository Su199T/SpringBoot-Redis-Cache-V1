package com.javabootpro.appModules.testTemplate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  隐私政策
 */
@Controller
@RequestMapping("/policy")
public class PrivacyPolicyController {

    @GetMapping("/index")
    public String goLogin(){
        return "/privacyPolicy.html";
    }
}
