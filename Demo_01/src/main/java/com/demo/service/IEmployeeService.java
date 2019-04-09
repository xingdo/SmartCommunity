package com.demo.service;

import com.demo.base.IBaseService;
import com.demo.domain.Employee;

public interface IEmployeeService extends IBaseService<Employee> {

    Employee queryOne(String phone);
}
