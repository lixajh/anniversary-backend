package com.peake.webseed.feature.merchant.mapper;

import com.peake.webseed.core.Mapper;
import com.peake.webseed.feature.merchant.model.MerchantChart;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface MerchantChartMapper extends Mapper<MerchantChart> {

    MerchantChart getMerchantMonthAmount(@Param("merchantId") long merchantId,@Param("startTime") Date startTime,@Param("endTime") Date endTime);

    MerchantChart getMerchantChartByTime(@Param("merchantId") long merchantId,@Param("startTime") Date startTime,@Param("endTime") Date endTime);
}