package com.demo.shiro;

import com.demo.domain.Employee;
import com.demo.domain.User;
import com.demo.service.IEmployeeService;
import com.demo.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

/*
* 完成登录认证
* */
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private IUserService userService;
    @Autowired
    private IEmployeeService employeeService;

    /*
    * 授权
    * */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        User loginUser = (User)principal.getPrimaryPrincipal();
        //添加权限
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        /*String userName = (String)authenticationToken.getPrincipal();

        //处理session
        DefaultWebSecurityManager securityManager = (DefaultWebSecurityManager) SecurityUtils.getSecurityManager();
        DefaultWebSessionManager sessionManager = (DefaultWebSessionManager)securityManager.getSessionManager();
        Collection<Session> sessions = sessionManager.getSessionDAO().getActiveSessions();
        //获取当前已登录的用户session列表
        for(Session session:sessions){
            //清除该用户以前登录时保存的session
            if(userName.equals(String.valueOf(session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY)))) {
                sessionManager.getSessionDAO().delete(session);
            }
        }*/
        //得到认证令牌
        UsernamePasswordToken token= (UsernamePasswordToken)authenticationToken;

        String username = token.getUsername();
        Employee employee = employeeService.queryOne(username);
        if (employee==null){
            return null;
        }
        //盐值
        ByteSource salt = ByteSource.Util.bytes("Smart");

        return new SimpleAuthenticationInfo(employee,employee.getPassword(),salt,getName());
    }
}
