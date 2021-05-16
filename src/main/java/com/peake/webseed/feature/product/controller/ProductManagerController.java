package com.peake.webseed.feature.product.controller;

import com.github.pagehelper.PageInfo;
import com.peake.webseed.core.AbstractController;
import com.peake.webseed.core.EnumErrorCode;
import com.peake.webseed.core.Result;
import com.peake.webseed.core.ResultGenerator;
import com.peake.webseed.feature.product.enums.EnumProductDataStatus;
import com.peake.webseed.feature.product.model.Product;
import com.peake.webseed.feature.product.model.ProductSnapshot;
import com.peake.webseed.feature.product.service.ProductService;
import com.peake.webseed.feature.product.service.ProductSnapshotService;
import com.peake.webseed.utils.DateUtils;
import com.peake.webseed.utils.StringUtils;
import com.peake.webseed.utils.VerifyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by CodeGenerator on 2018/09/12.
 */
@RestController

@RequestMapping("/manager/product")
public class ProductManagerController extends AbstractController {

    Logger logger = LoggerFactory.getLogger(ProductManagerController.class);

    @Value("${file.accessPath}")
    private String accessPath;

    @Resource
    private ProductService productService;
    @Resource
    private ProductSnapshotService productSnapshotService;

    @PostMapping("/add")
    public Result add(Product product) {
        if (!VerifyUtils.verifyAllParamsNotNull(product.getTitle(), product.getName(), product.getPrice())) {
            return ResultGenerator.genFailResult(EnumErrorCode.PARAM_ERROR);
        }
        productService.add(product);

        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Long[] ids) {
        productService.updateStatusByIds(ids, EnumProductDataStatus.del.getValue());
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/startSell")
    public Result startSell(@RequestParam Long[] ids) {
        productService.updateStatusByIds(ids, EnumProductDataStatus.saling.getValue());
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/stopSell")
    public Result stopSell(@RequestParam Long[] ids) {
        productService.updateStatusByIds(ids, EnumProductDataStatus.not_sale.getValue());
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(Product product) {
        product.setUpdateTime(DateUtils.now());
        productService.update(product);
        Product newProduct = productService.findById(product.getPkId());
        String a = newProduct.calMd5();
        System.out.println(a);
        if (!newProduct.calMd5().equals(newProduct.getMd5())) {
            //如果新旧的md5不同，更新md5并增加快照
            newProduct.setMd5(newProduct.calMd5());
            productService.update(newProduct);
            productSnapshotService.save(new ProductSnapshot(newProduct));
        }

        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Long id) {
        Product product = productService.findById(id);
        if (StringUtils.isNotBlank(product.getPicUrl())){
            product.setPicFullUrl(accessPath + product.getPicUrl());
        }

        return ResultGenerator.genSuccessResult(product);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Product product) {
        PageInfo pageInfo = productService.findbyCustomPage(page, size, product);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
