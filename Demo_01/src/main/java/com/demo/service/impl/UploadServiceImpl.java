package com.demo.service.impl;

import com.demo.base.BaseServiceImpl;
import com.demo.domain.Upload;
import com.demo.mapper.UploadMapper;
import com.demo.service.IUploadSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class UploadServiceImpl extends BaseServiceImpl<Upload> implements IUploadSerivce {

}
