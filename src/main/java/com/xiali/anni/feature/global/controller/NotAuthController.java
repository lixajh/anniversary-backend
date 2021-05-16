package com.xiali.anni.feature.global.controller;

import com.xiali.anni.core.AbstractController;
import com.xiali.anni.core.Result;
import com.xiali.anni.core.ResultGenerator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by CodeGenerator on 2018/08/29.
 */
@RestController
@RequestMapping("/notAuth")
public class NotAuthController extends AbstractController {


    @RequestMapping("/a")
    public Result notAuth() {
        return ResultGenerator.genNotAuthResult();
    }


}
