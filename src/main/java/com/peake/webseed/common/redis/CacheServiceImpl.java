package com.peake.webseed.common.redis;

import com.peake.webseed.common.enums.EnumUserType;
import com.peake.webseed.feature.admin.model.Admin;
import com.peake.webseed.feature.admin.service.AdminService;
import com.peake.webseed.feature.member.model.Member;
import com.peake.webseed.feature.member.service.MemberService;
import com.peake.webseed.utils.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CacheServiceImpl extends RedisServiceImpl implements CacheService {
    private static final String ADMIN_INFO_KEY = "admin_info_key:";
    private static final String MEMBER_INFO_KEY = "member_info_key:";
    private static final long EXPRIE_TIME = 3600;

    @Autowired
    AdminService adminService;
    @Autowired
    MemberService memberService;

    @Override
    public Admin getAdminInfo() {

        if (ShiroUtils.getUserType() != EnumUserType.manager) {
            return null;
        }

        Long userId = ShiroUtils.getUserId();
        if (userId == null) {
            return null;
        }
        try{
            Object o = get(ADMIN_INFO_KEY + userId);
            if (o != null) {
                Admin admin = (Admin) o;
                return admin;
            } else {
               return adminFromDb(userId);
            }
        }catch (Exception e){
            return adminFromDb(userId);
        }
    }

    @Override
    public Member getMemberInfo() {

        if (ShiroUtils.getUserType() != EnumUserType.member) {
            return null;
        }

        Long userId = ShiroUtils.getUserId();
        if (userId == null) {
            return null;
        }
        try{
            Object o = get(MEMBER_INFO_KEY + userId);
            if (o != null) {
                Member admin = (Member) o;
                return admin;
            } else {
               return memberFromDb(userId);
            }
        }catch (Exception e){
            return memberFromDb(userId);
        }
    }

    private Admin adminFromDb(Long userId){
        Admin admin1 = adminService.findById(userId);
        if (admin1 != null) {
            set(ADMIN_INFO_KEY + userId, admin1, EXPRIE_TIME);
        }
        return admin1;
    }
    private Member memberFromDb(Long userId){
        Member admin1 = memberService.findById(userId);
        if (admin1 != null) {
            set(MEMBER_INFO_KEY + userId, admin1, EXPRIE_TIME);
        }
        return admin1;
    }
}
