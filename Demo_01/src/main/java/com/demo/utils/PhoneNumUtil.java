package com.demo.utils;

import java.util.Random;
/*
    手机验证码随机生成
* */
public class PhoneNumUtil {
    public static String getRandom(){
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            stringBuilder.append(random.nextInt(10));
        }
        return stringBuilder.toString();
    }
}
