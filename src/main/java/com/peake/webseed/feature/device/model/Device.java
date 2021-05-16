package com.peake.webseed.feature.device.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "tbl_device")
public class Device {
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "pk_id")
    private Long pkId;

    private String name;

    private String code;

    /**
     * -1：删除，0：正常，1：冻结
     */
    @Column(name = "data_status")
    private Integer dataStatus;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * 0：离线，1：在线，2：故障
     */
    private Integer online;

    /**
     * 备注
     */
    private String remark;

    /**
     * 地址
     */
    private String address;

    /**
     * 所在商家名字
     */
    @Column(name = "fk_merchant_id")
    private Long fkMerchantId;

    /**
     * 设备型号
     */
    @Column(name = "fk_type_id")
    private Long fkTypeId;

    /**
     * 离线时间
     */
    @Column(name = "offline_time")
    private Date offlineTime;

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
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取-1：删除，0：正常，1：冻结
     *
     * @return data_status - -1：删除，0：正常，1：冻结
     */
    public Integer getDataStatus() {
        return dataStatus;
    }

    /**
     * 设置-1：删除，0：正常，1：冻结
     *
     * @param dataStatus -1：删除，0：正常，1：冻结
     */
    public void setDataStatus(Integer dataStatus) {
        this.dataStatus = dataStatus;
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
     * 获取0：离线，1：在线，2：故障
     *
     * @return online - 0：离线，1：在线，2：故障
     */
    public Integer getOnline() {
        return online;
    }

    /**
     * 设置0：离线，1：在线，2：故障
     *
     * @param online 0：离线，1：在线，2：故障
     */
    public void setOnline(Integer online) {
        this.online = online;
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

    /**
     * 获取地址
     *
     * @return address - 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置地址
     *
     * @param address 地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取所在商家名字
     *
     * @return fk_merchant_id - 所在商家名字
     */
    public Long getFkMerchantId() {
        return fkMerchantId;
    }

    /**
     * 设置所在商家名字
     *
     * @param fkMerchantId 所在商家名字
     */
    public void setFkMerchantId(Long fkMerchantId) {
        this.fkMerchantId = fkMerchantId;
    }

    /**
     * 获取设备型号
     *
     * @return fk_type_id - 设备型号
     */
    public Long getFkTypeId() {
        return fkTypeId;
    }

    /**
     * 设置设备型号
     *
     * @param fkTypeId 设备型号
     */
    public void setFkTypeId(Long fkTypeId) {
        this.fkTypeId = fkTypeId;
    }

    /**
     * 获取离线时间
     *
     * @return offline_time - 离线时间
     */
    public Date getOfflineTime() {
        return offlineTime;
    }

    /**
     * 设置离线时间
     *
     * @param offlineTime 离线时间
     */
    public void setOfflineTime(Date offlineTime) {
        this.offlineTime = offlineTime;
    }
}