package com.demo.service.impl;


import com.demo.base.BaseServiceImpl;
import com.demo.domain.Eventnotice;
import com.demo.service.IEventnoticeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class EventnoticeServiceImpl extends BaseServiceImpl<Eventnotice> implements IEventnoticeService {



}
