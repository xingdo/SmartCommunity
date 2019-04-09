package com.demo.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 *  生成密码的工具类
 *
 */
public class MD5Utils {
    //(String algorithmName, Object source, Object salt, int hashIterations)
    //加密算法名称
    public static final String algorithmName = "MD5";
    //散列的次数 加密次数
    public static final int  hashIterations = 10;

    //产生一个密码的工具类
    public static String createMD5Str(String password){
        //盐值
        ByteSource salt = ByteSource.Util.bytes("Smart");
        //加密加盐
        SimpleHash simpleHash = new SimpleHash(algorithmName, password, salt, hashIterations);

        return simpleHash.toString();
    }
    public static void main(String[] args){
        System.out.println(createMD5Str("admin"));
    }


}
