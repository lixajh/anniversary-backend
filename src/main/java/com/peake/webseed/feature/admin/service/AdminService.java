package com.peake.webseed.feature.admin.service;

import com.peake.webseed.core.Result;
import com.peake.webseed.core.Service;
import com.peake.webseed.feature.admin.model.Admin;


/**
 * Created by CodeGenerator on 2018/08/29.
 */
public interface AdminService extends Service<Admin> {
    Result login(String username, String password);



    Result edit(Admin admin);

    Result changePwd(String newPwd, String oldPwd);

    Result deleteByIds(Long[] ids);
}
