package com.peake.webseed.feature.product.controller;
import com.github.pagehelper.PageInfo;
import com.peake.webseed.core.AbstractController;
import com.peake.webseed.core.Result;
import com.peake.webseed.core.ResultGenerator;
import com.peake.webseed.feature.product.model.ProductSnapshot;
import com.peake.webseed.feature.product.service.ProductSnapshotService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
* Created by CodeGenerator on 2018/10/16.
*/
@RestController
@RequestMapping("/product/snapshot")
public class ProductSnapshotController extends AbstractController  {

    Logger logger = LoggerFactory.getLogger(ProductSnapshotController.class);

    @Resource
    private ProductSnapshotService productSnapshotService;

    @PostMapping("/add")
    public Result add(ProductSnapshot productSnapshot) {
        productSnapshotService.save(productSnapshot);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Long id) {
        productSnapshotService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(ProductSnapshot productSnapshot) {
        productSnapshotService.update(productSnapshot);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Long id) {
        ProductSnapshot productSnapshot = productSnapshotService.findById(id);
        return ResultGenerator.genSuccessResult(productSnapshot);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, ProductSnapshot productSnapshot) {
       PageInfo pageInfo = productSnapshotService.findbyPage(page,size,"createTime",productSnapshot);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
