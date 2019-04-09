package com.demo.base;



import com.demo.utils.PageList;

import java.util.List;


public interface IBaseService<T> {

    void insert(T t);

    void delete(Long id);

    void update(T t);

    T selectOne(Long id);

    List<T> selectAll();

    /**根据分页条件返回查询结果
     */
    PageList<T> queryPage(BaseQuery query);
}


