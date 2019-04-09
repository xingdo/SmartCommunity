package com.demo.service;

import com.demo.base.IBaseService;
import com.demo.domain.User;


public interface IUserService extends IBaseService<User> {

    User queryUser(String username);
}
