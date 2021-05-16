package com.peake.webseed.feature.member.realm;


import com.peake.webseed.common.dto.UserDTO;
import com.peake.webseed.common.enums.EnumUserType;
import com.peake.webseed.common.shiro.ThirdPartyLoginToken;
import com.peake.webseed.feature.member.model.Member;
import com.peake.webseed.feature.member.service.MemberService;
import com.peake.webseed.utils.PasswordUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

//import com.peake.webseed.feature.admin.model.Admin;
//import com.peake.webseed.feature.admin.service.AdminService;

public class ThirdPartyLoginRealm extends AuthorizingRealm {

    @Autowired
    MemberService memberService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
//		Long userId = ShiroUtils.getUserId();
//		MenuService menuService = ApplicationContextRegister.getBean(MenuService.class);
//		Set<String> perms = menuService.listPerms(userId);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//		info.setStringPermissions(perms);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        if (token instanceof ThirdPartyLoginToken){

        }else{
            throw new UnknownAccountException("不是第三方登录");
        }
        String openId = (String) token.getPrincipal();

        int userType = ((ThirdPartyLoginToken) token).getUserType();

        Member member = memberService.findBy("openId", openId);

        // 账号不存在
		if (member == null) {
			throw new UnknownAccountException("账号或密码不正确");
		}

		// 账号锁定
//		if (member.getDataStatus() == EnumDataStatus.freeze.getValue()) {
//			throw new LockedAccountException("账号已被锁定,请联系管理员");
//		}

        return new SimpleAuthenticationInfo(
                new UserDTO(member.getPkId(),EnumUserType.member), //身份 User类型
                PasswordUtils.generatePassword(PasswordUtils.DEFAULT_PASSWORD,PasswordUtils.DEFAULT_SALT),   //凭据
                ByteSource.Util.bytes(PasswordUtils.DEFAULT_SALT), //
                getName() //Realm Name
        );


//        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
//                new UserDTO(admin.getPkId(),EnumUserType.manager), admin.getPassword(), //密码
//                ByteSource.Util.bytes(admin.getSalt()), //
//                getName() //realm name
//        );
//        return authenticationInfo;
    }

}
