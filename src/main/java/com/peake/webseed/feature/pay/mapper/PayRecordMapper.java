package com.peake.webseed.feature.pay.mapper;

import com.peake.webseed.core.Mapper;
import com.peake.webseed.feature.device.model.Device;
import com.peake.webseed.feature.pay.model.PayRecord;

public interface PayRecordMapper extends Mapper<PayRecord> {
    PayRecord findByOutTradeNo(String outTradeNo);
}