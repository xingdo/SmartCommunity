package com.demo.service.impl;

import com.demo.base.BaseServiceImpl;
import com.demo.domain.User;
import com.demo.mapper.UserMapper;
import com.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class UserServiceImpl extends BaseServiceImpl<User> implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryUser(String username) {
        return userMapper.queryOne(username);
    }
}
