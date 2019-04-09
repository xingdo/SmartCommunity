package com.demo.mapper;

import com.demo.base.BaseMapper;
import com.demo.domain.Employee;
import com.demo.domain.User;

import java.util.List;

public interface EmployeeMapper extends BaseMapper<Employee> {

    Employee queryOne(String phone);
}