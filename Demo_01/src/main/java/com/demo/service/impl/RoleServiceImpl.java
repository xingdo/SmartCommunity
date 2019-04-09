package com.demo.service.impl;


import com.demo.base.BaseServiceImpl;
import com.demo.domain.Role;
import com.demo.service.IRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class RoleServiceImpl extends BaseServiceImpl<Role> implements IRoleService {



}
