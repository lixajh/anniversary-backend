package com.peake.webseed.feature.merchant.service;
import com.peake.webseed.core.Result;
import com.peake.webseed.feature.merchant.model.Merchant;
import com.peake.webseed.core.Service;

import java.util.Date;
import java.util.List;


/**
 * Created by CodeGenerator on 2018/09/30.
 */
public interface MerchantService extends Service<Merchant> {
    Result deleteByIds(Long[] ids);

    /**
     * 查找所有商家
     * @return
     */
    Result getAllMerchants();

    /**
     * 查找所有在指定日期之前创建的商家
     * @param date
     * @return
     */
    List<Merchant> findMerchantCreatedBefore(Date date);
}
