package com.demo.mapper;

import com.demo.base.BaseMapper;
import com.demo.domain.Eventhandle;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EventhandleMapper extends BaseMapper<Eventhandle> {
    /*
    * 查找所有历史任务
    * */
    List<Eventhandle> queryAll(Long id);

    /*
    * 查询需要完成的任务
    * */
    List<Eventhandle> queryNow(Long id);

    /*
    * 任务提交,根据当前任务的id修改状态
    * */
    void submit(Long id);

    /*
    * 正在执行的任务，按照时间最新的来选
    * */
    Eventhandle eventNow(Long id);

}