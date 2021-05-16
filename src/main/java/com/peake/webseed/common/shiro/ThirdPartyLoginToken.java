package com.peake.webseed.common.shiro;

import com.peake.webseed.utils.PasswordUtils;
import org.apache.shiro.authc.UsernamePasswordToken;

public class ThirdPartyLoginToken extends UsernamePasswordToken {
    private int userType;

    public ThirdPartyLoginToken(final String openId, int userType){
        super(openId,PasswordUtils.md5(PasswordUtils.DEFAULT_PASSWORD));
        this.userType = userType;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }
}
