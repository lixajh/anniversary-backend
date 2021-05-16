package com.peake.webseed.feature.pay.controller;

import com.github.pagehelper.PageInfo;
import com.peake.webseed.core.AbstractController;
import com.peake.webseed.core.Result;
import com.peake.webseed.core.ResultGenerator;
import com.peake.webseed.feature.pay.model.PayRecord;
import com.peake.webseed.feature.pay.service.PayRecordService;
import com.peake.webseed.utils.RequestParamsUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
* Created by CodeGenerator on 2018/10/07.
*/
@RestController
@RequestMapping("manager/pay")
public class PayRecordManagerController extends AbstractController  {

    Logger logger = LoggerFactory.getLogger(PayRecordManagerController.class);

    @Resource
    private PayRecordService payRecordService;

//    @PostMapping("/getPayInfo")
//    public Result getPayInfo(PayRecord payRecord) {
//        payRecordService.save(payRecord);
//        return ResultGenerator.genSuccessResult();
//    }

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

    @RequestMapping(value = "/alipay/notify")
    public String alipayNotify(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, Object> map = RequestParamsUtils.getParamsMap(request);

        // 内部订单号
        String out_trade_no = (String) map.get("out_trade_no");
        // 阿里订单号
        String trade_no = (String) map.get("trade_no");
        String trade_status = (String) map.get("trade_status");

        if (trade_status.equals("TRADE_FINISHED") || trade_status.equals("TRADE_SUCCESS")) {
            // 支付成功
            // 处理订单
            boolean flag = payRecordService.paySuccess(out_trade_no, trade_no);

            if (flag) {
                // 给支付宝返回响应消息,必须,否则支付宝会持续通知
                response.getWriter().println("success"); // 请不要修改或删除
            } else {
                // 验证失败
                response.getWriter().println("fail"); // 请不要修改或删除
            }
        }

        return null;

    }
}
