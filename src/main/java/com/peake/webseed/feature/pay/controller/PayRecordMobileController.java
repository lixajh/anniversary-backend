package com.peake.webseed.feature.pay.controller;

import com.github.pagehelper.PageInfo;
import com.peake.webseed.core.AbstractController;
import com.peake.webseed.core.Result;
import com.peake.webseed.core.ResultGenerator;
import com.peake.webseed.feature.order.model.Order;
import com.peake.webseed.feature.pay.enums.EnumPayWay;
import com.peake.webseed.feature.pay.model.PayRecord;
import com.peake.webseed.feature.pay.service.PayRecordService;
import com.peake.webseed.utils.VerifyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
* Created by CodeGenerator on 2018/10/07.
*/
@RestController
@RequestMapping("mobile/pay")
public class PayRecordMobileController extends AbstractController  {

    Logger logger = LoggerFactory.getLogger(PayRecordMobileController.class);

    @Resource
    private PayRecordService payRecordService;

    @PostMapping("/getPayInfo")
    public Result getPayInfo(Order order) {
        VerifyUtils.verifyAllParamsNotNull(order.getFkDeviceId(),order.getFkProductId());
        return payRecordService.getPayInfo(order, EnumPayWay.alipay);
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Long id) {
        payRecordService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(PayRecord payRecord) {
        payRecordService.update(payRecord);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Long id) {
        PayRecord payRecord = payRecordService.findById(id);
        return ResultGenerator.genSuccessResult(payRecord);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, PayRecord payRecord) {
       PageInfo pageInfo = payRecordService.findbyPage(page,size,"createTime",payRecord);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
