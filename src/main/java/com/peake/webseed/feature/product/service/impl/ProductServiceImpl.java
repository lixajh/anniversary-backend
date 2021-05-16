package com.peake.webseed.feature.product.service.impl;

import com.peake.webseed.common.enums.EnumDataStatus;
import com.peake.webseed.core.AbstractService;
import com.peake.webseed.core.Result;
import com.peake.webseed.core.ResultGenerator;
import com.peake.webseed.feature.product.mapper.ProductMapper;
import com.peake.webseed.feature.product.model.Product;
import com.peake.webseed.feature.product.model.ProductSnapshot;
import com.peake.webseed.feature.product.service.ProductService;
import com.peake.webseed.feature.product.service.ProductSnapshotService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/09/12.
 */
@Service
@Transactional
public class ProductServiceImpl extends AbstractService<Product> implements ProductService {

    Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Resource
    private ProductMapper productMapper;

    @Resource
    private ProductSnapshotService productSnapshotService;


    @Override
    public Result add(Product product) {
//        if (device.getCode())
        product.setCreateTime(now());
        product.setUpdateTime(now());
        product.setDataStatus(EnumDataStatus.normal.getValue());
        product.setMd5(product.calMd5());
        save(product);
        productSnapshotService.save(new ProductSnapshot(product));
        return ResultGenerator.genSuccessResult();
    }

    @Override
    public Result updateStatusByIds(Long[] ids, int status) {
        productMapper.batchUpdateStatus(ids,status);
        return ResultGenerator.genSuccessResult();
    }



}
