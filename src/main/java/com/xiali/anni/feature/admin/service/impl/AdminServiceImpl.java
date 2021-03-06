package com.xiali.anni.feature.admin.service.impl;

import com.xiali.anni.common.enums.EnumDataStatus;
import com.xiali.anni.core.AbstractService;
import com.xiali.anni.core.Result;
import com.xiali.anni.core.ResultGenerator;
import com.xiali.anni.feature.admin.mapper.AdminMapper;
import com.xiali.anni.feature.admin.model.Admin;
import com.xiali.anni.feature.admin.service.AdminService;
import com.xiali.anni.utils.PasswordUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/08/29.
 */
@Service
@Transactional
public class AdminServiceImpl extends AbstractService<Admin> implements AdminService {

    Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

    @Resource
    private AdminMapper adminMapper;

    @Override
    public Result login(String username, String password) {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        Subject currentUser = SecurityUtils.getSubject();
        try {
            currentUser.login(token);
        } catch (AuthenticationException e) {
            logger.error(e.getMessage());
            return ResultGenerator.genFailResult(e.getMessage());
        } catch (AuthorizationException e) {
            return ResultGenerator.genFailResult(e.getMessage());
        }
        Admin admin = getAdmin();
        admin.setLastLoginTime(now());
        admin.setUpdateTime(now());
        update(admin);
        return ResultGenerator.genSuccessResult();
    };

    @Override
    public Result add(Admin admin) {
        Admin oldAdmin = findBy("username", admin.getUsername());
        if(oldAdmin != null && oldAdmin.getDataStatus() != EnumDataStatus.del.getValue()){
            return ResultGenerator.genFailResult("????????????????????????");
        }
        admin.setSalt(PasswordUtils.getRanSalt());
        admin.setPassword(PasswordUtils.generatePassword(PasswordUtils.DEFAULT_PASSWORD,admin.getSalt()));
        admin.setCreateTime(now());
        admin.setUpdateTime(now());
        admin.setDataStatus(EnumDataStatus.normal.getValue());
        save(admin);
        return ResultGenerator.genSuccessResult();
    };

    @Override
    public Result edit(Admin admin) {
        Admin oldAdmin = findBy("username", admin.getUsername());
        if(oldAdmin != null && oldAdmin.getPkId() != admin.getPkId() && oldAdmin.getDataStatus() != EnumDataStatus.del.getValue()){
            return ResultGenerator.genFailResult("????????????????????????");
        }
        admin.setUpdateTime(now());
        update(admin);
        return ResultGenerator.genSuccessResult();
    };

    @Override
    public Result changePwd(String newPwd, String oldPwd) {
        Admin admin = getAdmin();
        if(PasswordUtils.generatePasswordWithOutMd5(oldPwd,admin.getSalt()).equals( admin.getPassword())){
            //?????????????????????
            admin.setPassword(PasswordUtils.generatePasswordWithOutMd5(newPwd,admin.getSalt()));
            update(admin);
            return ResultGenerator.genSuccessResult();
        }else{
            return  ResultGenerator.genFailResult("??????????????????????????????");
        }
    }

        @Override
    public Result deleteByIds(Long[] ids) {
        adminMapper.batchDelete(ids);
        return ResultGenerator.genSuccessResult();
    }

}
