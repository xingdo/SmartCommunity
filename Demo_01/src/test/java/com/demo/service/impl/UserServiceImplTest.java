package com.demo.service.impl;

import com.demo.Application;
import com.demo.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserServiceImplTest {
    @Autowired
    private IUserService userService;
    @Test
    public void selectOne() {
        System.out.println(userService.selectOne(1l));
    }

    @Test
    public void selectAll() {
    }
}