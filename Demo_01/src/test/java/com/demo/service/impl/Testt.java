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
public class Testt {
    @Autowired
    private IUserService userService;
    @Test
    public void test()throws Exception{
        System.out.println(userService.selectOne(1l));
    }
    @Test
    public void test33()throws Exception{
        System.out.println(userService.queryUser("xing"));
    }

    @Test
    public void test22()throws Exception{
        StringBuffer stringBuffer = new StringBuffer("50dc05a91a115bd306893590f4b0f772.mp4");
        System.out.println(stringBuffer.insert(stringBuffer.lastIndexOf("."), "asdf"));
    }
}
