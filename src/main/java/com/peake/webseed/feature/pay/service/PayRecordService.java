package com.peake.webseed.feature.pay.service;
import com.peake.webseed.core.Result;
import com.peake.webseed.feature.order.model.Order;
import com.peake.webseed.feature.pay.enums.EnumPayWay;
import com.peake.webseed.feature.pay.model.PayRecord;
import com.peake.webseed.core.Service;


/**
 * Created by CodeGenerator on 2018/10/07.
 */
public interface PayRecordService extends Service<PayRecord> {
    Result getPayInfo(Order order, EnumPayWay payWay);

    boolean paySuccess(String out_trade_no, String trade_no);
}
