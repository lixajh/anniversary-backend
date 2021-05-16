package com.peake.webseed.feature.product.service.impl;

import com.peake.webseed.feature.product.mapper.ProductSnapshotMapper;
import com.peake.webseed.feature.product.model.ProductSnapshot;
import com.peake.webseed.feature.product.service.ProductSnapshotService;
import com.peake.webseed.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/10/16.
 */
@Service
@Transactional
public class ProductSnapshotServiceImpl extends AbstractService<ProductSnapshot> implements ProductSnapshotService {

    Logger logger = LoggerFactory.getLogger(ProductSnapshotServiceImpl.class);

    @Resource
    private ProductSnapshotMapper productSnapshotMapper;

    @Override
    public ProductSnapshot getSnapshotByProductId(long productId) {
        return productSnapshotMapper.getSnapshotByProductId(productId);
    }
}
