package com.demo.service.impl;


import com.demo.base.BaseServiceImpl;
import com.demo.domain.Location;
import com.demo.service.ILocationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class LocationServiceImpl extends BaseServiceImpl<Location> implements ILocationService {



}
