package com.demo.controller;

import com.demo.domain.Employee;
import com.demo.service.IEmployeeService;
import com.demo.utils.AjaxResult;
import com.demo.utils.PhoneNumUtil;
import com.demo.utils.SendTelMsgUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/*
* 验证接口
* */
@RestController
public class RegisterController {
    @Autowired
    private IEmployeeService employeeService;
    //验证码
    private String num;
    /*
   发送短信验证码
   * */
    @RequestMapping(value = "/getNum",method = RequestMethod.GET)
    public String phone(@PathVariable("phone") String phone){
        String random = PhoneNumUtil.getRandom();
        SendTelMsgUtils.sendMsgTo(phone,random);
        num=random;
        return num;
    }
    /*
     * 提交验证,,验证信息是什么?
     * */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public AjaxResult phoneNum(@RequestBody Employee employee){
        if (!StringUtils.isEmpty(employee.getRannum())&&!StringUtils.isEmpty(employee.getPassword())&&!StringUtils.isEmpty(employee.getPolicecode())){
            //判断生成的验证码，跟输入的验证码是否相同
            if (employee.getRannum().equals(num)){
                //判断手机号是否存在
                Employee one = employeeService.queryOne(employee.getPhone());
                if (one!=null){
                    return AjaxResult.getAjaxResult().setLog(false).setMsg("用户已存在");
                }else{
                employeeService.insert(employee);
                }
                return AjaxResult.getAjaxResult().setLog(true).setMsg("验证成功");
            }else{
                return AjaxResult.getAjaxResult().setLog(false).setMsg("验证码错误");
            }
        }else{
            return AjaxResult.getAjaxResult().setLog(false).setMsg("请输入完整信息");
        }
    }
    /*
     * 修改密码
     * */
    @RequestMapping(value = "/changePwd",method = RequestMethod.POST)
    public AjaxResult changePwd(@RequestBody Employee employee) {
        if (!StringUtils.isEmpty(employee.getRannum())&&!StringUtils.isEmpty(employee.getPassword())&&!StringUtils.isEmpty(employee.getPhone())) {
            //判断生成的验证码，跟输入的验证码是否相同
            if (employee.getRannum().equals(num)) {
                Employee one = employeeService.queryOne(employee.getPhone());
                if (one==null){
                    return AjaxResult.getAjaxResult().setLog(false).setMsg("该用户不存在");
                }else{
                    one.setPassword(employee.getPassword());
                    employeeService.update(one);
                    return AjaxResult.getAjaxResult().setLog(true).setMsg("修改密码成功");
                }
            }else {
                return AjaxResult.getAjaxResult().setLog(false).setMsg("验证码错误");
            }
        }else{
            return AjaxResult.getAjaxResult().setLog(false).setMsg("请输入完整信息");
        }
    }
}
