package com.peake.webseed.common.dto;

import com.peake.webseed.common.enums.EnumUserType;

import java.io.Serializable;

public class UserDTO implements Serializable {
    Long id;
    EnumUserType userType;

    public UserDTO() {
    }

    public UserDTO(Long id, EnumUserType userType) {
        this.id = id;
        this.userType = userType;
    }
    public UserDTO(Long id, int userType) {
        this.id = id;
        setUserType(userType);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EnumUserType getUserType() {
        return userType;
    }

    public void setUserType(EnumUserType userType) {
        this.userType = userType;
    }
    
    public void setUserType(int userType) {
        this.userType = EnumUserType.setValue(userType);
    }
}
