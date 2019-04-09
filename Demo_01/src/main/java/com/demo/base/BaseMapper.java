package com.demo.base;

import com.demo.base.BaseQuery;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface BaseMapper<T> {

    int deleteByPrimaryKey(Long id);

    int insert(T t);

    T selectByPrimaryKey(Long id);

    List<T> selectAll();

    int updateByPrimaryKey(T t);

    //分页:分页查询
    List<T> queryPage(BaseQuery baseQuery);

}

