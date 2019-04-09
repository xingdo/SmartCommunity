package com.demo.controller;

import com.demo.Application;
import com.demo.mapper.EventhandleMapper;
import com.demo.service.IDepartmentService;
import com.demo.service.IEmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.annotation.Resource;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class DepartmentControllerTest {
    @Autowired
    private IDepartmentService departmentService;
    @Resource
    private IEmployeeService employeeService;
    @Autowired
    private EventhandleMapper eventhandleMapper;
    @Test
    public void get() {
        System.out.println(departmentService.selectOne(1l));
    }

    @Test
    public void list() {
        System.out.println(employeeService.selectAll());
    }

    @Test
    public void testsss()throws Exception{
        System.out.println(eventhandleMapper.queryNow(1l));
    }
    @Test
    public void test22()throws Exception{
        eventhandleMapper.submit(1l);
    }
}