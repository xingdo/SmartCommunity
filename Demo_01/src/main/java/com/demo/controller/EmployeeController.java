package com.demo.controller;


import com.demo.domain.Employee;
import com.demo.query.EmployeeQuery;
import com.demo.service.IEmployeeService;
import com.demo.utils.AjaxResult;
import com.demo.utils.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    /*
    * 高级查询
    * */
    @RequestMapping("/pagelist")
    public PageList<Employee> pagelist(EmployeeQuery employeeQuery) {

        return employeeService.queryPage(employeeQuery);
    }

    /**
     * 删除对象信息
     */
    @RequestMapping(value="/{id}",method= RequestMethod.DELETE)
    public AjaxResult delete(@PathVariable("id") Long id) {
        try {
            employeeService.delete(id);
            return AjaxResult.getAjaxResult();
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.getAjaxResult().setMsg("删除对象失败！"+e.getMessage());
        }
    }

    /**
     * 保存和修改公用的
     */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public AjaxResult saveOrUpdate(Employee employee) {
        if (employee != null) {
            try {
                //判断是否有id,有就是修改,没有就是添加
                if (employee.getId() != null) {
                    //修改
                    employeeService.update(employee);
                } else {
                    //添加
                    employeeService.insert(employee);
                }
                return AjaxResult.getAjaxResult().setLog(true).setMsg("保存对象成功");
            } catch (Exception e) {
                e.printStackTrace();
                return AjaxResult.getAjaxResult().setMsg("保存对象失败！"+e.getMessage());
            }
        }
        return null;
    }
    /**
     * 查看所有的信息
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Employee > list(){
            return employeeService.selectAll();
    }

    //获取用户
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Employee  get(@PathVariable("id")Long id)
            {
            return employeeService.selectOne(id);
            }


        }
