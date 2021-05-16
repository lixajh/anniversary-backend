package com.peake.webseed.feature.merchant.service.impl;

import com.peake.webseed.common.enums.EnumDataStatus;
import com.peake.webseed.core.AbstractService;
import com.peake.webseed.core.Result;
import com.peake.webseed.core.ResultGenerator;
import com.peake.webseed.feature.merchant.mapper.MerchantMapper;
import com.peake.webseed.feature.merchant.model.Merchant;
import com.peake.webseed.feature.merchant.service.MerchantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


/**
 * Created by CodeGenerator on 2018/09/30.
 */
@Service
@Transactional
public class MerchantServiceImpl extends AbstractService<Merchant> implements MerchantService {

    Logger logger = LoggerFactory.getLogger(MerchantServiceImpl.class);

    @Resource
    private MerchantMapper merchantMapper;

    @Override
    public Result add(Merchant merchant) {
        merchant.setCreateTime(now());
        merchant.setUpdateTime(now());
        merchant.setDataStatus(EnumDataStatus.normal.getValue());
        save(merchant);
        return ResultGenerator.genSuccessResult();
    }

    @Override
    public Result deleteByIds(Long[] ids) {
        merchantMapper.batchDelete(ids);
        return ResultGenerator.genSuccessResult();
    }

    @Override
    public Result getAllMerchants() {
        Example example = new Example(Merchant.class);
        example.createCriteria().andNotEqualTo("dataStatus", -1);
        example.orderBy("name");
        List<Merchant> list = findByExample(example);
        return ResultGenerator.genSuccessResult(list);
    }

    @Override
    public List<Merchant> findMerchantCreatedBefore(Date date) {
        return merchantMapper.findMerchantCreatedBefore(date);
    }
}
