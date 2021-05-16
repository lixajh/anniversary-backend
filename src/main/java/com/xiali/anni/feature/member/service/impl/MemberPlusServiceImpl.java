package com.xiali.anni.feature.member.service.impl;

import com.xiali.anni.feature.member.mapper.MemberPlusMapper;
import com.xiali.anni.feature.member.model.MemberPlus;
import com.xiali.anni.feature.member.service.MemberPlusService;
import com.xiali.anni.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/08/30.
 */
@Service
@Transactional
public class MemberPlusServiceImpl extends AbstractService<MemberPlus> implements MemberPlusService {

    Logger logger = LoggerFactory.getLogger(MemberPlusServiceImpl.class);

    @Resource
    private MemberPlusMapper MemberPlusMapper;

}
