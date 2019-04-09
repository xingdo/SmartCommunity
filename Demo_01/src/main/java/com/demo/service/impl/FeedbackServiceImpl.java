package com.demo.service.impl;


import com.demo.base.BaseServiceImpl;
import com.demo.domain.Feedback;
import com.demo.service.IFeedbackService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class FeedbackServiceImpl extends BaseServiceImpl<Feedback> implements IFeedbackService {



}
