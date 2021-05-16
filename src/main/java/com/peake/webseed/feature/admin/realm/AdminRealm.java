package com.peake.webseed.feature.admin.realm;


import com.peake.webseed.common.dto.UserDTO;
import com.peake.webseed.common.enums.EnumDataStatus;
import com.peake.webseed.common.enums.EnumUserType;
import com.peake.webseed.common.shiro.ThirdPartyLoginToken;
import com.peake.webseed.feature.admin.model.Admin;
import com.peake.webseed.feature.admin.service.AdminService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 管理后台用户的Realm
 */
public class AdminRealm extends AuthorizingRealm {
    /*	@Autowired
        UserDao userMapper;
        @Autowired
        MenuService menuService;*/
    @Autowired
    AdminService adminService;

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
            throw new UnknownAccountException("不是后台账号");
        }
        String username = (String) token.getPrincipal();

        String password = new String((char[]) token.getCredentials());

        Admin admin = adminService.findBy("username", username);

        // 账号不存在
		if (admin == null) {
			throw new UnknownAccountException("账号或密码不正确");
		}

		// 账号锁定
		if (admin.getDataStatus() == EnumDataStatus.freeze.getValue()) {
			throw new LockedAccountException("账号已被锁定,请联系管理员");
		}

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                new UserDTO(admin.getPkId(),EnumUserType.manager), admin.getPassword(), //密码
                ByteSource.Util.bytes(admin.getSalt()), //
                getName() //realm name
        );
        return authenticationInfo;
    }

}
