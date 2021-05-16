package com.peake.webseed.feature.product.mapper;

import com.peake.webseed.core.Mapper;
import com.peake.webseed.feature.product.model.ProductSnapshot;

public interface ProductSnapshotMapper extends Mapper<ProductSnapshot> {
    ProductSnapshot getSnapshotByProductId(long productId);
}