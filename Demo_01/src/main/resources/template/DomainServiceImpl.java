package com.demo.service.impl;


import com.demo.base.BaseServiceImpl;
import com.demo.domain.${Domain};
import com.demo.service.I${Domain}Service;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class ${Domain}ServiceImpl extends BaseServiceImpl<${Domain}> implements I${Domain}Service {



}
