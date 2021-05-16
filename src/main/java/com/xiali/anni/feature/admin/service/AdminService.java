package com.xiali.anni.feature.admin.service;

import com.xiali.anni.core.Result;
import com.xiali.anni.core.Service;
import com.xiali.anni.feature.admin.model.Admin;


/**
 * Created by CodeGenerator on 2018/08/29.
 */
public interface AdminService extends Service<Admin> {
    Result login(String username, String password);



    Result edit(Admin admin);

    Result changePwd(String newPwd, String oldPwd);

    Result deleteByIds(Long[] ids);
}
