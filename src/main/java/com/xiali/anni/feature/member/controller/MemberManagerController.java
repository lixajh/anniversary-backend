package com.xiali.anni.feature.member.controller;

import com.github.pagehelper.PageInfo;
import com.xiali.anni.core.AbstractController;
import com.xiali.anni.core.Result;
import com.xiali.anni.core.ResultGenerator;
import com.xiali.anni.feature.member.model.Member;
import com.xiali.anni.feature.member.model.MemberDetailDTO;
import com.xiali.anni.feature.member.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by CodeGenerator on 2018/08/30.
 */
@RestController
@RequestMapping("/manager/member")
public class MemberManagerController extends AbstractController {

    Logger logger = LoggerFactory.getLogger(MemberManagerController.class);

    @Resource
    private MemberService memberService;

    @PostMapping("/update")
    public Result update(Member member) {
        memberService.update(member);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Long id) {
        MemberDetailDTO member = memberService.detail(id);
        return ResultGenerator.genSuccessResult(member);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Member member) {
        PageInfo pageInfo = memberService.findbyPage(page,size,"username",member);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
