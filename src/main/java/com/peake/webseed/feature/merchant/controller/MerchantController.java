package com.peake.webseed.feature.merchant.controller;
import com.github.pagehelper.PageInfo;
import com.peake.webseed.core.AbstractController;
import com.peake.webseed.core.Result;
import com.peake.webseed.core.ResultGenerator;
import com.peake.webseed.feature.merchant.model.Merchant;
import com.peake.webseed.feature.merchant.service.MerchantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
* Created by CodeGenerator on 2018/09/30.
*/
@RestController
@RequestMapping("/manager/merchant")
public class MerchantController extends AbstractController  {

    Logger logger = LoggerFactory.getLogger(MerchantController.class);

    @Resource
    private MerchantService merchantService;

    @PostMapping("/add")
    public Result add(Merchant merchant) {
        merchantService.add(merchant);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Long[] id) {
        merchantService.deleteByIds(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(Merchant merchant) {
        merchantService.update(merchant);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Long id) {
        Merchant merchant = merchantService.findById(id);
        return ResultGenerator.genSuccessResult(merchant);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Merchant merchant) {
       PageInfo pageInfo = merchantService.findbyCustomPage(page,size,merchant);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
