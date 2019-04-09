package com.demo.service.impl;


import com.demo.base.BaseServiceImpl;
import com.demo.domain.Eventhandle;
import com.demo.mapper.EventhandleMapper;
import com.demo.service.IEventhandleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class EventhandleServiceImpl extends BaseServiceImpl<Eventhandle> implements IEventhandleService {

    @Resource
    private EventhandleMapper eventhandleMapper;
    /*
    * 查找所有历史任务根据用户id*/
    @Override
    public List<Eventhandle> queryAll(Long id) {
        return eventhandleMapper.queryAll(id);
    }

    @Override
    public List<Eventhandle> queryNow(Long id) {
        return eventhandleMapper.queryNow(id);
    }

    @Override
    public Eventhandle eventNow(Long id) {
        return eventhandleMapper.eventNow(id);
    }
}
