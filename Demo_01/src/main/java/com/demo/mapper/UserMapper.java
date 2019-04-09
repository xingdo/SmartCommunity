package com.demo.mapper;

import com.demo.base.BaseMapper;
import com.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    User queryOne(String username);

}