package com.xiali.anni.common.redis;


import com.xiali.anni.feature.admin.model.Admin;
import com.xiali.anni.feature.member.model.Member;

/**
 * Created by Administrator on 2017/3/1 14:57.
 */
public interface CacheService extends  RedisService{

    Admin getAdminInfo();
    Member getMemberInfo();

}
