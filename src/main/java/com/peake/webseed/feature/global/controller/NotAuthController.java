package com.peake.webseed.feature.global.controller;

import com.peake.webseed.core.AbstractController;
import com.peake.webseed.core.Result;
import com.peake.webseed.core.ResultGenerator;
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
