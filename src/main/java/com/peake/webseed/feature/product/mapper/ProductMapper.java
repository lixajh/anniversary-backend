package com.peake.webseed.feature.product.mapper;

import com.peake.webseed.core.Mapper;
import com.peake.webseed.feature.product.model.Product;
import org.apache.ibatis.annotations.Param;

public interface ProductMapper extends Mapper<Product> {
    void batchUpdateStatus(@Param("ids") Long ids[], @Param("status") int status);
}