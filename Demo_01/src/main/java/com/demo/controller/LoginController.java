package com.demo.controller;

import com.demo.domain.Employee;
import com.demo.service.IEmployeeService;
import com.demo.service.IUserService;
import com.demo.shiro.UserContext;
import com.demo.utils.AjaxResult;
import com.demo.utils.PhoneNumUtil;
import com.demo.utils.SendTelMsgUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/demo")
public class LoginController {

    @Autowired
    private IEmployeeService employeeService;
    //验证码
    private String num;
    /*
     * 登录
     * */
    /*@RequestMapping(value = "/login",method = RequestMethod.POST)
    public AjaxResult login(User user){
        if (user.getPassword()!=null&&user.getUsername()!=null){
            //先判断用户名存不存在，在判断密码正确性
            User userOne = userService.queryUser(user.getUsername());
            if (userOne==null){
                return AjaxResult.getAjaxResult().setLog(false).setMsg("用户名不存在");
            }else{
                if (userOne.getPassword().equals(user.getPassword())){
                    return AjaxResult.getAjaxResult().setLog(true).setMsg("登录成功");
                }else{
                    return AjaxResult.getAjaxResult().setLog(false).setMsg("密码错误");
                }
            }
        }
        return new AjaxResult().setLog(false).setMsg("请输入用户");
    }*/
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public AjaxResult login(Employee employee, HttpServletRequest req, HttpServletResponse resp){
        if (StringUtils.isEmpty(employee.getPassword())&&StringUtils.isEmpty(employee.getPhone())){
            return new AjaxResult().setLog(false).setMsg("用户名或密码不能为空");
        }
        //得到当前主体
        Subject subject = SecurityUtils.getSubject();
        //判断是否登录过了
        if(!subject.isAuthenticated()){
            //没有登录 -->将用户名和密码封装一个令牌
            UsernamePasswordToken token = new UsernamePasswordToken(employee.getPhone(),employee.getPassword());
            try {
                subject.login(token);
            }catch (UnknownAccountException e) {
                e.printStackTrace();
                return AjaxResult.getAjaxResult().setLog(false).setMsg("用户名不存在");
            } catch (IncorrectCredentialsException e) {
                e.printStackTrace();
                return AjaxResult.getAjaxResult().setLog(false).setMsg("密码错误");
            }
            catch (AuthenticationException ae) {
                //其它认证异常
                ae.printStackTrace();
                return AjaxResult.getAjaxResult().setLog(false).setMsg("登录异常");
            }
        }
        //for ()
        //由操作主题得到发当前对象
        Employee loginuser = (Employee)subject.getPrincipal();
        //登录成功,存入session
        UserContext.setUser(loginuser);
        //登陆成功
        return AjaxResult.getAjaxResult().setLog(true).setMsg("登录成功");
    }


}
