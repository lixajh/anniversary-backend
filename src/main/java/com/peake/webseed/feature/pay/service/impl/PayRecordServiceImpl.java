package com.peake.webseed.feature.pay.service.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeCreateRequest;
import com.alipay.api.response.AlipayTradeCreateResponse;
import com.peake.webseed.common.enums.EnumDataStatus;
import com.peake.webseed.common.redis.CacheService;
import com.peake.webseed.core.AbstractService;
import com.peake.webseed.core.Result;
import com.peake.webseed.core.ResultGenerator;
import com.peake.webseed.feature.device.model.Device;
import com.peake.webseed.feature.device.service.DeviceService;
import com.peake.webseed.feature.merchant.service.MerchantService;
import com.peake.webseed.feature.order.enums.EnumOrderStatus;
import com.peake.webseed.feature.order.model.Order;
import com.peake.webseed.feature.order.service.OrderService;
import com.peake.webseed.feature.pay.enums.EnumPayStatus;
import com.peake.webseed.feature.pay.enums.EnumPayWay;
import com.peake.webseed.feature.pay.mapper.PayRecordMapper;
import com.peake.webseed.feature.pay.model.PayRecord;
import com.peake.webseed.feature.pay.service.PayRecordService;
import com.peake.webseed.feature.product.enums.EnumProductDataStatus;
import com.peake.webseed.feature.product.model.Product;
import com.peake.webseed.feature.product.model.ProductSnapshot;
import com.peake.webseed.feature.product.service.ProductService;
import com.peake.webseed.feature.product.service.ProductSnapshotService;
import com.peake.webseed.mqtt.MqttPushClient;
import com.peake.webseed.utils.CodeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/10/07.
 */
@Service
@Transactional
public class PayRecordServiceImpl extends AbstractService<PayRecord> implements PayRecordService {

    Logger logger = LoggerFactory.getLogger(PayRecordServiceImpl.class);

    @Value("${alipay.appid}")
    private String alipayAppid;
    @Value("${alipay.sandbox}")
    private boolean alipaySandbox;
    @Value("${alipay.private_key}")
    private String alipayPrivateKey;
    @Value("${alipay.public_key}")
    private String alipayPublicKey;

    @Value("${domain}")
    private String domain;

    @Resource
    private OrderService orderService;
    @Resource
    private CacheService cacheService;
    @Resource
    private MerchantService merchantService;
    @Resource
    private ProductService productService;
    @Resource
    private DeviceService deviceService;
    @Resource
    private PayRecordMapper PayRecordMapper;
    @Resource
    private ProductSnapshotService productSnapshotService;

    @Override
    public Result getPayInfo(Order order, EnumPayWay payWay) {
        Device device = deviceService.findById(order.getFkDeviceId());
        if (device == null || device.getDataStatus() == EnumDataStatus.del.getValue()){
            return ResultGenerator.genFailResult("非法设备号，请重新扫描设备二维码");
        }
        order.setFkMerchantId(device.getFkMerchantId());

        Product product = productService.findById(order.getFkProductId());
        if (product == null || product.getDataStatus() == EnumProductDataStatus.del.getValue()){
            return ResultGenerator.genFailResult("非法商品,请刷新页面重试");
        }
        if (product.getDataStatus() == EnumProductDataStatus.not_sale.getValue()){
            return ResultGenerator.genFailResult("该商品已被下架，请刷新页面或重新扫码进入");
        }
        order.setTotalFee(product.getPrice());
        order.setPayFee(product.getPrice());
        ProductSnapshot productSnapshot = productSnapshotService.getSnapshotByProductId(product.getPkId());
        order.setFkProductSnapshotId(productSnapshot.getPkId());

        order.setFkMemberId(cacheService.getMemberInfo().getPkId());

        order.setCreateTime(now());
        order.setDataStatus(EnumDataStatus.normal.getValue());
        order.setOrderNo(CodeUtils.genOutTradeNo());
        order.setOrderStatus(EnumOrderStatus.to_pay.getValue());
        order.setUpdateTime(now());

       orderService.save(order);
        try {
            PayRecord payRecord = createPayInfo(order, payWay);
            if (payRecord == null){
                return ResultGenerator.genFailResult("支付信息获取失败");
            }else{
                return ResultGenerator.genSuccessResult(payRecord);
            }

        } catch (AlipayApiException e) {
            e.printStackTrace();
            return ResultGenerator.genFailResult("支付信息获取失败,msg:" + e.getErrMsg());
        }
    }

    private PayRecord createPayInfo(Order order,EnumPayWay payWay) throws AlipayApiException {

        PayRecord payRecord = new PayRecord();
        payRecord.setAttach("");
        payRecord.setCreateTime(now());
        payRecord.setDataStatus(EnumDataStatus.normal.getValue());
        payRecord.setFkOrderId(order.getPkId());
        payRecord.setPayStatus(EnumPayStatus.to_pay.getValue());
        payRecord.setPayWay(payWay.getValue());
        payRecord.setTotalFee(order.getPayFee());
        payRecord.setOutTradeNo(order.getOrderNo());
        payRecord.setUpdateTime(now());

        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", alipayAppid, alipayPrivateKey, "json", "GBK", alipayPublicKey, "RSA2");
        AlipayTradeCreateRequest request = new AlipayTradeCreateRequest();

//        request.setReturnUrl(alipayConfig.getReturn_url());
        request.setNotifyUrl(domain+"server/manager/pay/alipay/notify");// 在公共参数中设置回跳和通知地址

        request.setBizContent("{" +
                "\"out_trade_no\":\""+payRecord.getOutTradeNo()+"\"," +
//                "\"seller_id\":\""+payRecord.get()+"\"," +
                "\"total_amount\":"+payRecord.getTotalFee() + "," +
//                "\"discountable_amount\":8.88," +
                "\"subject\":\""+"测试订单" +"\"," +
//                "\"body\":\"Iphone6 16G\"," +
                "\"buyer_id\":\""+ cacheService.getMemberInfo().getOpenId()+"\"" +
//                "      \"goods_detail\":[{" +
//                "        \"goods_id\":\"apple-01\"," +
//                "\"goods_name\":\"ipad\"," +
//                "\"quantity\":1," +
//                "\"price\":2000," +
//                "\"goods_category\":\"34543238\"," +
//                "\"body\":\"特价手机\"," +
//                "\"show_url\":\"http://www.alipay.com/xxx.jpg\"" +
//                "        }]," +
//                "\"operator_id\":\"Yx_001\"," +
//                "\"store_id\":\"NJ_001\"," +
//                "\"terminal_id\":\"NJ_T_001\"," +
//                "\"extend_params\":{" +
//                "\"sys_service_provider_id\":\"2088511833207846\"," +
//                "\"industry_reflux_info\":\"{\\\\\\\"scene_code\\\\\\\":\\\\\\\"metro_tradeorder\\\\\\\",\\\\\\\"channel\\\\\\\":\\\\\\\"xxxx\\\\\\\",\\\\\\\"scene_data\\\\\\\":{\\\\\\\"asset_name\\\\\\\":\\\\\\\"ALIPAY\\\\\\\"}}\"," +
//                "\"card_type\":\"S0JP0000\"" +
//                "    }," +
//                "\"timeout_express\":\"90m\"," +
//                "\"settle_info\":{" +
//                "        \"settle_detail_infos\":[{" +
//                "          \"trans_in_type\":\"cardSerialNo\"," +
//                "\"trans_in\":\"A0001\"," +
//                "\"summary_dimension\":\"A0001\"," +
//                "\"settle_entity_id\":\"2088xxxxx;ST_0001\"," +
//                "\"settle_entity_type\":\"SecondMerchant、Store\"," +
//                "\"amount\":0.1" +
//                "          }]" +
//                "    }," +
//                "\"business_params\":\"{\\\"data\\\":\\\"123\\\"}\"," +
//                "\"receiver_address_info\":{" +
//                "\"name\":\"张三\"," +
//                "\"address\":\"上海市浦东新区陆家嘴银城中路501号\"," +
//                "\"mobile\":\"13120180615\"," +
//                "\"zip\":\"200120\"," +
//                "\"division_code\":\"310115\"" +
//                "    }," +
//                "\"logistics_detail\":{" +
//                "\"logistics_type\":\"EXPRESS\"" +
//                "    }" +
                "  }");
        AlipayTradeCreateResponse response = alipayClient.execute(request);
        if (response.isSuccess()) {
//            response.getOutTradeNo();
//            response.getTradeNo();
            payRecord.setTransactionNo(response.getTradeNo());
            save(payRecord);
            return payRecord;
//            System.out.println("调用成功");
        } else {
//            System.out.println("调用失败");
            return null;
        }
    }

    @Override
    public boolean paySuccess(String out_trade_no, String trade_no) {
        PayRecord record = PayRecordMapper.findByOutTradeNo(out_trade_no);
        if (record == null){
            return false;
        }
        switch (EnumPayStatus.setValue(record.getPayStatus())) {
            case to_pay:
                record.setTransactionNo(trade_no);// 支付宝流水号
                record.setPayStatus(EnumPayStatus.pay_up.getValue());// 已支付
                if(record.getPayTime() == null){
                    record.setPayTime(now());// 支付时间
                }

                record.setUpdateTime(now());// 最后更新时间
                update(record);
                Order order = orderService.findById(record.getFkOrderId());
                if (order != null){
                    order.setUpdateTime(now());
                    order.setOrderStatus(EnumOrderStatus.pay_up.getValue());
                    orderService.update(order);
                }
                //todo 通知设备已支付
                Device device = deviceService.findById(order.getFkDeviceId());

                logger.info("订单（" + order.getOrderNo()+")支付成功，将通知设备"+  device.getCode());
                MqttPushClient.getInstance().publish("tokudu/yzq124","code：" + device.getCode());


                break;
            case pay_up:
                break;
            default:
                return false;
        }
        return true;
    }

}
