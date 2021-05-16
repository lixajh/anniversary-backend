package com.peake.webseed.utils;


import com.peake.webseed.common.dto.UserDTO;
import com.peake.webseed.common.enums.EnumUserType;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class ShiroUtils {
    @Autowired
    private static SessionDAO sessionDAO;

    public static Subject getSubjct() {
        return SecurityUtils.getSubject();
    }

    public static Long getUserId() {
        Subject currentUser = getSubjct();
        if (null == currentUser) {
            return null;
        }
        UserDTO user = (UserDTO) currentUser.getPrincipal();
        if (user.getId() != null) {
            return user.getId();
        }
        return null;
    }

    public static EnumUserType getUserType(){

            UserDTO user = (UserDTO) getSubjct().getPrincipal();
            return user.getUserType();
    }

    public static void logout() {
        getSubjct().logout();
    }


}
