package com.peake.webseed.feature.product.controller;

import com.peake.webseed.core.AbstractController;
import com.peake.webseed.core.Result;
import com.peake.webseed.core.ResultGenerator;
import com.peake.webseed.feature.product.enums.EnumProductDataStatus;
import com.peake.webseed.feature.product.model.Product;
import com.peake.webseed.feature.product.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by CodeGenerator on 2018/09/12.
 */
@RestController

@RequestMapping("/mobile/product")
public class ProductMobileController extends AbstractController  {

    Logger logger = LoggerFactory.getLogger(ProductMobileController.class);

    @Resource
    private ProductService productService;

    @PostMapping("/detail")
    public Result detail(@RequestParam Long id) {
        Product product = productService.findById(id);
        return ResultGenerator.genSuccessResult(product);
    }

    @PostMapping("/list")
    public Result list(Product product) {

        product.setDataStatus(EnumProductDataStatus.saling.getValue());
        List<Product> products = productService.findByCustomCondition(product);
        return ResultGenerator.genSuccessResult(products);
    }
}
