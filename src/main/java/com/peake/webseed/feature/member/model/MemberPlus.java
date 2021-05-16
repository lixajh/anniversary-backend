package com.peake.webseed.feature.member.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tbl_member_plus")
public class MemberPlus {
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "pk_id")
    private Long pkId;

    @Column(name = "fk_member_id")
    private Long fkMemberId;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "create_time")
    private Date createTime;

    private String language;

    /**
     * 微信普通用户个人资料填写的城市
     */
    private String city;

    /**
     * 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
     */
    private Integer sex;

    /**
     * 微信用户个人资料填写的省份
     */
    private String province;

    /**
     * 微信国家，如中国为CN
     */
    private String country;

    /**
     * 微信用户特权信息，json 数组，如微信沃卡用户为（chinaunicom）
     */
    private String privilege;

    /**
     * @return pk_id
     */
    public Long getPkId() {
        return pkId;
    }

    /**
     * @param pkId
     */
    public void setPkId(Long pkId) {
        this.pkId = pkId;
    }

    /**
     * @return fk_member_id
     */
    public Long getFkMemberId() {
        return fkMemberId;
    }

    /**
     * @param fkMemberId
     */
    public void setFkMemberId(Long fkMemberId) {
        this.fkMemberId = fkMemberId;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * @param language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * 获取微信普通用户个人资料填写的城市
     *
     * @return city - 微信普通用户个人资料填写的城市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置微信普通用户个人资料填写的城市
     *
     * @param city 微信普通用户个人资料填写的城市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
     *
     * @return sex - 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 设置用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
     *
     * @param sex 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 获取微信用户个人资料填写的省份
     *
     * @return province - 微信用户个人资料填写的省份
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置微信用户个人资料填写的省份
     *
     * @param province 微信用户个人资料填写的省份
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 获取微信国家，如中国为CN
     *
     * @return country - 微信国家，如中国为CN
     */
    public String getCountry() {
        return country;
    }

    /**
     * 设置微信国家，如中国为CN
     *
     * @param country 微信国家，如中国为CN
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * 获取微信用户特权信息，json 数组，如微信沃卡用户为（chinaunicom）
     *
     * @return privilege - 微信用户特权信息，json 数组，如微信沃卡用户为（chinaunicom）
     */
    public String getPrivilege() {
        return privilege;
    }

    /**
     * 设置微信用户特权信息，json 数组，如微信沃卡用户为（chinaunicom）
     *
     * @param privilege 微信用户特权信息，json 数组，如微信沃卡用户为（chinaunicom）
     */
    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }
}