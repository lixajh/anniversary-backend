package com.peake.webseed.feature.merchant.mapper;

import com.peake.webseed.core.Mapper;
import com.peake.webseed.feature.merchant.model.Merchant;

import java.util.Date;
import java.util.List;

public interface MerchantMapper extends Mapper<Merchant> {

    void batchDelete(Long ids[]);

    List<Merchant> findMerchantCreatedBefore(Date date);
}