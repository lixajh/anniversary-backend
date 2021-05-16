package com.peake.webseed.feature.member.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tbl_member")
public class Member {
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "pk_id")
    private Long pkId;

    private String username;

    private String password;

    private String salt;

    /**
     * -1：删除，0：正常，1冻结
     */
    @Column(name = "data_status")
    private Integer dataStatus;

    private String phone;

    /**
     * 微信用户的唯一标识
     */
    @Column(name = "open_id")
    private String openId;

    private String nickname;

    @Column(name = "last_login_time")
    private Date lastLoginTime;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "head_img_url")
    private String headImgUrl;

    /**
     * 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。
     */
    @Column(name = "union_id")
    private String unionId;

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
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return salt
     */
    public String getSalt() {
        return salt;
    }

    /**
     * @param salt
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * 获取-1：删除，0：正常，1冻结
     *
     * @return data_status - -1：删除，0：正常，1冻结
     */
    public Integer getDataStatus() {
        return dataStatus;
    }

    /**
     * 设置-1：删除，0：正常，1冻结
     *
     * @param dataStatus -1：删除，0：正常，1冻结
     */
    public void setDataStatus(Integer dataStatus) {
        this.dataStatus = dataStatus;
    }

    /**
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取微信用户的唯一标识
     *
     * @return open_id - 微信用户的唯一标识
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * 设置微信用户的唯一标识
     *
     * @param openId 微信用户的唯一标识
     */
    public void setOpenId(String openId) {
        this.openId = openId;
    }

    /**
     * @return nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * @return last_login_time
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * @param lastLoginTime
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
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
     * @return head_img_url
     */
    public String getHeadImgUrl() {
        return headImgUrl;
    }

    /**
     * @param headImgUrl
     */
    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    /**
     * 获取只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。
     *
     * @return union_id - 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。
     */
    public String getUnionId() {
        return unionId;
    }

    /**
     * 设置只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。
     *
     * @param unionId 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。
     */
    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }
}