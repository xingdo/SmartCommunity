package com.demo.shiro;

import com.demo.domain.Employee;
import com.demo.domain.User;
import com.demo.service.IEmployeeService;
import com.demo.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

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
