package com.xiali.anni.feature.member.dto;

import com.xiali.anni.feature.member.model.Member;

public class WechatLoginDTO {
    Member member;
    boolean isNew;

    public WechatLoginDTO(Member member, boolean isNew) {
        this.member = member;
        this.isNew = isNew;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }
}
