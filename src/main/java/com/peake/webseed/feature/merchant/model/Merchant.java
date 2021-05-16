package com.peake.webseed.feature.merchant.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "tbl_merchant")
public class Merchant {
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "pk_id")
    private Long pkId;

    /**
     * 商家名称
     */
    private String name;

    /**
     * -1：删除，0：未上架，1：上架
     */
    @Column(name = "data_status")
    private Integer dataStatus;

    /**
     * 商家地址
     */
    private String address;

    /**
     * 联系人
     */
    private String contact;

    /**
     * 电话
     */
    private String phone;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 设备数量
     */
    @Column(name = "device_count")
    private Integer deviceCount;

    /**
     * 提成计算方式
     */
    @Column(name = "bonus_cal_type")
    private Integer bonusCalType;

    /**
     * 提成系数
     */
    @Column(name = "bonus_ratio")
    private Double bonusRatio;

    /**
     * 备注
     */
    private String remark;

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
     * 获取商家名称
     *
     * @return name - 商家名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置商家名称
     *
     * @param name 商家名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取-1：删除，0：未上架，1：上架
     *
     * @return data_status - -1：删除，0：未上架，1：上架
     */
    public Integer getDataStatus() {
        return dataStatus;
    }

    /**
     * 设置-1：删除，0：未上架，1：上架
     *
     * @param dataStatus -1：删除，0：未上架，1：上架
     */
    public void setDataStatus(Integer dataStatus) {
        this.dataStatus = dataStatus;
    }

    /**
     * 获取商家地址
     *
     * @return address - 商家地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置商家地址
     *
     * @param address 商家地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取联系人
     *
     * @return contact - 联系人
     */
    public String getContact() {
        return contact;
    }

    /**
     * 设置联系人
     *
     * @param contact 联系人
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * 获取电话
     *
     * @return phone - 电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置电话
     *
     * @param phone 电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
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
     * 获取设备数量
     *
     * @return device_count - 设备数量
     */
    public Integer getDeviceCount() {
        return deviceCount;
    }

    /**
     * 设置设备数量
     *
     * @param deviceCount 设备数量
     */
    public void setDeviceCount(Integer deviceCount) {
        this.deviceCount = deviceCount;
    }

    /**
     * 获取提成计算方式
     *
     * @return bonus_cal_type - 提成计算方式
     */
    public Integer getBonusCalType() {
        return bonusCalType;
    }

    /**
     * 设置提成计算方式
     *
     * @param bonusCalType 提成计算方式
     */
    public void setBonusCalType(Integer bonusCalType) {
        this.bonusCalType = bonusCalType;
    }

    /**
     * 获取提成系数
     *
     * @return bonus_ratio - 提成系数
     */
    public Double getBonusRatio() {
        return bonusRatio;
    }

    /**
     * 设置提成系数
     *
     * @param bonusRatio 提成系数
     */
    public void setBonusRatio(Double bonusRatio) {
        this.bonusRatio = bonusRatio;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}