package com.demo.service.impl;


import com.demo.base.BaseServiceImpl;
import com.demo.domain.Managetype;
import com.demo.service.IManagetypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class ManagetypeServiceImpl extends BaseServiceImpl<Managetype> implements IManagetypeService {



}
