package com.demo.shiro;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.StringUtils;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//为了判断传过来的是否是ajax请求需要复写父类方法
//通过请求头是否是X-Requested-With判断
public class MyAuthorizationFilter extends PermissionsAuthorizationFilter {

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
        Subject subject = this.getSubject(request, response);
        //判断是否登录
        if (subject.getPrincipal()==null){
            this.saveRequestAndRedirectToLogin(request , response );
        }else{
            //有登录之后,判断请求如果是ajax 返回json格式
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse resp = (HttpServletResponse) response;

            //通过XMLhttpRequest判断,获取请求头
            String xmlHttpRequest = req.getHeader("X-Requested-With");
            if (xmlHttpRequest != null && "XMLHttpRequest".equals(xmlHttpRequest)) {
                //返回json
                resp.setContentType("text/json;charset=UTF-8");
                //{"success":false,"msg":"没有权限"} JsonResult --json@RespBody
                resp.getWriter().print("{\"success\":false,\"msg\":\"没有权限\"}");
            } else {
                String unauthorizedUrl = this.getUnauthorizedUrl();
                if (StringUtils.hasText(unauthorizedUrl)) {
                    WebUtils.issueRedirect(request, response, unauthorizedUrl);
                } else {
                    WebUtils.toHttp(response).sendError(401);
                }
            }
        }
        return false;
    }
}
