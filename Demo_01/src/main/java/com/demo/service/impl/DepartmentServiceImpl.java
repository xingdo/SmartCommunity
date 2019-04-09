package com.demo.service.impl;

import com.demo.base.BaseServiceImpl;
import com.demo.domain.Department;
import com.demo.service.IDepartmentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class DepartmentServiceImpl extends BaseServiceImpl<Department> implements IDepartmentService {

}
