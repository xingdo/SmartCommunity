package com.demo.shiro;

import com.demo.domain.Employee;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

//拿到登录的当前用户,shior session
public class UserContext {
    public static final String LoginUser = "loginuser";
    //设置当前用户的方法，或者拿到

    //设置当前用户到shior session
    public static void setUser(Employee loginuser){
        //shiro的session ---更广支持分布式，缓存
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute(LoginUser, loginuser);
    }

    //拿到当前用户的方法
    public static Employee getUser() {
        Session session = SecurityUtils.getSubject().getSession();
        return (Employee) session.getAttribute(LoginUser);
    }
}
