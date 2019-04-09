package com.demo.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
*
* 用于页面跳转的类
*
* */
@Controller
public class PageSkip {

    @RequestMapping(value="/login",method= RequestMethod.GET)
    public String login(){
        return "login";
    }


    //登出方法
    @RequestMapping("/logout")
    public String logout(){
        //登出
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/login";
    }
}
