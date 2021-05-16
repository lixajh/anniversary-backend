package com.peake.webseed.feature.admin.controller;

import com.github.pagehelper.PageInfo;
import com.peake.webseed.core.AbstractController;
import com.peake.webseed.core.EnumErrorCode;
import com.peake.webseed.core.Result;
import com.peake.webseed.core.ResultGenerator;
import com.peake.webseed.feature.admin.model.Admin;
import com.peake.webseed.feature.admin.service.AdminService;
import com.peake.webseed.utils.PasswordUtils;
import com.peake.webseed.utils.ShiroUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by CodeGenerator on 2018/08/29.
 */
@RestController
@RequestMapping("/manager/admin")
public class AdminController extends AbstractController {
    @Resource
    private AdminService adminService;


    @PostMapping("/login")
    public Result login(@RequestParam String username, @RequestParam String password) {
        if (ShiroUtils.getSubjct().isAuthenticated()) {
            return ResultGenerator.genSuccessResult();
        }
        if (StringUtils.isNoneBlank(username, password)) {
            password = password.toLowerCase();
            return adminService.login(username, password);
        } else {
            return ResultGenerator.genFailResult(EnumErrorCode.PARAM_ERROR);
        }
    }

    @PostMapping("/add")
    public Result add(Admin admin) {
        if (StringUtils.isNoneBlank(admin.getUsername())) {
            return adminService.add(admin);
        } else {
            return ResultGenerator.genFailResult(EnumErrorCode.PARAM_ERROR);
        }
    }

    @PostMapping("/edit")
    public Result edit(Admin admin) {
        if (admin.getPkId() != null && StringUtils.isNoneBlank(admin.getUsername())) {
            return adminService.edit(admin);
        } else {
            return ResultGenerator.genFailResult(EnumErrorCode.PARAM_ERROR);
        }
    }

    @RequestMapping("/logout")
    public Result logout() {
        ShiroUtils.logout();
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Long[] ids) {
        adminService.deleteByIds(ids);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(Admin admin) {
        if (admin.getPkId() == null){
            return ResultGenerator.genFailResult(EnumErrorCode.PARAM_ERROR);
        }
        return adminService.edit(admin);
    }

    @PostMapping("/detail")
    public Result detail(Long id) {
        if (id == null){
            id = getAdmin().getPkId();
        }
        Admin admin = adminService.findById(id);
        admin.setPassword(null);
        admin.setSalt(null);
        return ResultGenerator.genSuccessResult(admin);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size,Admin admin) {

        PageInfo pageInfo = adminService.findbyCustomPage(page,size,admin);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @PostMapping("/changePwd")
    public Result changePwd(@RequestParam String newPwd, @RequestParam String oldPwd) {

        return adminService.changePwd(newPwd, oldPwd);
    }

    @PostMapping("/resetPwd")
    public Result resetPwd(@RequestParam Long id) {
        Admin admin = adminService.findById(id);
        admin.setPassword(PasswordUtils.generatePassword(PasswordUtils.DEFAULT_PASSWORD,admin.getSalt()));
        admin.setUpdateTime(new Date());
        adminService.update(admin);
        return ResultGenerator.genSuccessResult();
    }
}
