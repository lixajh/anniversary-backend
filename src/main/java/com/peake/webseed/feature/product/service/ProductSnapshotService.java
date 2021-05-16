package com.peake.webseed.feature.product.service;
import com.peake.webseed.feature.product.model.ProductSnapshot;
import com.peake.webseed.core.Service;


/**
 * Created by CodeGenerator on 2018/10/16.
 */
public interface ProductSnapshotService extends Service<ProductSnapshot> {
    ProductSnapshot getSnapshotByProductId(long productId);
}
