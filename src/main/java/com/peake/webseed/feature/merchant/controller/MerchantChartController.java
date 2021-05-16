package com.peake.webseed.feature.merchant.controller;
import com.github.pagehelper.PageInfo;
import com.peake.webseed.core.AbstractController;
import com.peake.webseed.core.Result;
import com.peake.webseed.core.ResultGenerator;
import com.peake.webseed.feature.merchant.model.MerchantChart;
import com.peake.webseed.feature.merchant.service.MerchantChartService;
import com.peake.webseed.utils.RequestParamsUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.HashMap;

/**
* Created by CodeGenerator on 2018/10/11.
*/
@RestController
@RequestMapping("manager/merchantChart")
public class MerchantChartController extends AbstractController  {

    Logger logger = LoggerFactory.getLogger(MerchantChartController.class);

    @Resource
    private MerchantChartService merchantChartService;

    @RequestMapping("/gen")
    public Result add(MerchantChart merchantChart) {
        merchantChartService.genMonthCharts(LocalDate.now().minusMonths(1));
        return ResultGenerator.genSuccessResult();
    }

//    @PostMapping("/delete")
//    public Result delete(@RequestParam Long id) {
//        merchantChartService.deleteById(id);
//        return ResultGenerator.genSuccessResult();
//    }

    @PostMapping("/update")
    public Result update(MerchantChart merchantChart) {
        merchantChartService.update(merchantChart);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Long id) {
        MerchantChart merchantChart = merchantChartService.findById(id);
        return ResultGenerator.genSuccessResult(merchantChart);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, HttpServletRequest request) {
        HashMap<String, Object> order = RequestParamsUtils.getParamsMap(request);
        PageInfo pageInfo = merchantChartService.findMapByCustomPage(page, size, order);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
