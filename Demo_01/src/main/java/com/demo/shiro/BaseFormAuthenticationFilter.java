package com.demo.shiro;

import com.demo.domain.Employee;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/*
* 继承shiro的FormAuthenticationFilter类 ，重写里面的一些方法。实现shiro登录跳转到指定页面，验证码的实现，不注销之前已登录用户下，重新登录
* */
public class BaseFormAuthenticationFilter extends FormAuthenticationFilter {

    private static final Logger log = LoggerFactory.getLogger(BaseFormAuthenticationFilter.class);

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        if (isLoginRequest(request, response)) {
            if (isLoginSubmission(request, response)) {
                //本次用户登陆账号 
                String account = this.getUsername(request); 
                Subject subject = this.getSubject(request, response); 
                //之前登陆的用户 
                 Employee employee = (Employee) subject.getPrincipal(); 
                 //如果两次登陆的用户不一样，则先退出之前登陆的用户,（有问题，相同用户无法跳转页面）解决：
                // 可以不判断，都退出之前的登录，再重新登录 
                 if (account != null && employee != null && !account.equals(employee.getPhone())) {
                     //获取session，获取验证码
                     Employee user = UserContext.getUser();

                    //注销登录，同时会使session失效
                     subject.logout();
                     //所以重新设置session
                      UserContext.setUser((Employee) subject);
                 } 
            } 
        } 
        return super.isAccessAllowed(request, response, mappedValue);
    }
    /**
     * 重写FormAuthenticationFilter的onLoginSuccess方法
     * 指定的url传递进去，这样就实现了跳转到指定的页面；
     */ @Override protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
         WebUtils.getAndClearSavedRequest(request);
         //清理了session中保存的请求信息
        WebUtils.redirectToSavedRequest(request, response, getSuccessUrl());
        return false;
     }
}
