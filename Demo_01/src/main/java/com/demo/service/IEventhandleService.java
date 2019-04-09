package com.demo.service;

import com.demo.base.IBaseService;
import com.demo.domain.Eventhandle;

import java.util.List;

public interface IEventhandleService extends IBaseService<Eventhandle> {

    /*
     * 查找所有历史任务
     * */
    List<Eventhandle> queryAll(Long id);

    /*
     * 查询需要完成的任务
     * */
    List<Eventhandle> queryNow(Long id);
    /*
     * 正在执行的任务，按照时间最新的来选
     * */
    Eventhandle eventNow(Long id);
}
