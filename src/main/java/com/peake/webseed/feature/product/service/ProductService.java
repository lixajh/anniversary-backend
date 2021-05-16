package com.peake.webseed.feature.product.service;

import com.peake.webseed.core.Result;
import com.peake.webseed.core.Service;
import com.peake.webseed.feature.product.model.Product;




/**
 * Created by CodeGenerator on 2018/09/12.
 */
public interface ProductService extends Service<Product> {
//    Result deleteByIds(Long[] ids);
    Result updateStatusByIds(Long[] ids, int status);
}
