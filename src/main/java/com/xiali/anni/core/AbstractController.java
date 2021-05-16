package com.xiali.anni.core;

import com.xiali.anni.common.redis.CacheService;
import com.xiali.anni.feature.admin.model.Admin;
import com.xiali.anni.feature.member.model.Member;
import org.springframework.beans.factory.annotation.Autowired;

public abstract  class AbstractController {
    @Autowired
    CacheService cacheService;

    protected Admin getAdmin(){
        return cacheService.getAdminInfo();
    }
    protected Member getMember(){
        return cacheService.getMemberInfo();
    }
}
