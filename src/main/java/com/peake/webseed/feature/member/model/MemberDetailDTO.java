package com.peake.webseed.feature.member.model;


import java.util.Date;

public class MemberDetailDTO {
    private Long pkId;

    private String username;

    private String password;

    private String salt;

    private Integer dataStatus;

    private String phone;

    private String openId;

    private String nickname;

    private Date lastLoginTime;

    private Date updateTime;

    private Date createTime;

    private String headImgUrl;

    private Long plusId;

    private String language;

    private String city;

    private Integer sex;

    private String province;

    private String country;

    private String privilege;

    private String address;

    public MemberDetailDTO() {

    }

    public MemberDetailDTO(Member member, MemberPlus memberPlus) {
        this.pkId = member.getPkId();
        this.username = member.getUsername();
        this.phone = member.getPhone();
        this.openId = member.getOpenId();
        this.nickname = member.getNickname();
        this.lastLoginTime = member.getLastLoginTime();
        this.updateTime = member.getUpdateTime();
        this.createTime = member.getCreateTime();
        this.headImgUrl = member.getHeadImgUrl();
        this.plusId = member.getPkId();
        if (memberPlus != null){
            this.language = memberPlus.getLanguage();
            this.city = memberPlus.getCity();
            this.province = memberPlus.getProvince();
            this.country = memberPlus.getCountry();
            this.sex = memberPlus.getSex();
            try {
                this.address = "" + memberPlus.getCountry() + " " + getProvince() + " " + getCity();
            }catch (Exception e){
            }
        }
    }



    public Long getPkId() {
        return pkId;
    }

    public void setPkId(Long pkId) {
        this.pkId = pkId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(Integer dataStatus) {
        this.dataStatus = dataStatus;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public Long getPlusId() {
        return plusId;
    }

    public void setPlusId(Long plusId) {
        this.plusId = plusId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
