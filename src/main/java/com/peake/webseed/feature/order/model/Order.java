package com.peake.webseed.feature.order.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "tbl_order")
public class Order {
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "pk_id")
    private Long pkId;

    /**
     * 订单号
     */
    @Column(name = "order_no")
    private String orderNo;

    /**
     * 总金额（元）
     */
    @Column(name = "total_fee")
    private BigDecimal totalFee;

    /**
     * 实付金额（元）
     */
    @Column(name = "pay_fee")
    private BigDecimal payFee;

    @Column(name = "data_status")
    private Integer dataStatus;

    /**
     * 0:待支付，1支付成功，2支付失败,3设备工作中，4设备故障，5完成
     */
    @Column(name = "order_status")
    private Integer orderStatus;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 支付记录id
     */
    @Column(name = "fk_pay_id")
    private Long fkPayId;

    /**
     * 备注
     */
    private String remark;

    /**
     * 订单发起者id
     */
    @Column(name = "fk_member_id")
    private Long fkMemberId;

    /**
     * 商品id
     */
    @Column(name = "fk_product_id")
    private Long fkProductId;

    /**
     * 商家id
     */
    @Column(name = "fk_merchant_id")
    private Long fkMerchantId;

    /**
     * 设备id
     */
    @Column(name = "fk_device_id")
    private Long fkDeviceId;

    /**
     * 商品快照id
     */
    @Column(name = "fk_product_snapshot_id")
    private Long fkProductSnapshotId;

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
     * 获取订单号
     *
     * @return order_no - 订单号
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * 设置订单号
     *
     * @param orderNo 订单号
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * 获取总金额（元）
     *
     * @return total_fee - 总金额（元）
     */
    public BigDecimal getTotalFee() {
        return totalFee;
    }

    /**
     * 设置总金额（元）
     *
     * @param totalFee 总金额（元）
     */
    public void setTotalFee(BigDecimal totalFee) {
        this.totalFee = totalFee;
    }

    /**
     * 获取实付金额（元）
     *
     * @return pay_fee - 实付金额（元）
     */
    public BigDecimal getPayFee() {
        return payFee;
    }

    /**
     * 设置实付金额（元）
     *
     * @param payFee 实付金额（元）
     */
    public void setPayFee(BigDecimal payFee) {
        this.payFee = payFee;
    }

    /**
     * @return data_status
     */
    public Integer getDataStatus() {
        return dataStatus;
    }

    /**
     * @param dataStatus
     */
    public void setDataStatus(Integer dataStatus) {
        this.dataStatus = dataStatus;
    }

    /**
     * 获取0:待支付，1支付成功，2支付失败,3设备工作中，4设备故障，5完成
     *
     * @return order_status - 0:待支付，1支付成功，2支付失败,3设备工作中，4设备故障，5完成
     */
    public Integer getOrderStatus() {
        return orderStatus;
    }

    /**
     * 设置0:待支付，1支付成功，2支付失败,3设备工作中，4设备故障，5完成
     *
     * @param orderStatus 0:待支付，1支付成功，2支付失败,3设备工作中，4设备故障，5完成
     */
    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
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
     * 获取支付记录id
     *
     * @return fk_pay_id - 支付记录id
     */
    public Long getFkPayId() {
        return fkPayId;
    }

    /**
     * 设置支付记录id
     *
     * @param fkPayId 支付记录id
     */
    public void setFkPayId(Long fkPayId) {
        this.fkPayId = fkPayId;
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
     * 获取订单发起者id
     *
     * @return fk_member_id - 订单发起者id
     */
    public Long getFkMemberId() {
        return fkMemberId;
    }

    /**
     * 设置订单发起者id
     *
     * @param fkMemberId 订单发起者id
     */
    public void setFkMemberId(Long fkMemberId) {
        this.fkMemberId = fkMemberId;
    }

    /**
     * 获取商品id
     *
     * @return fk_product_id - 商品id
     */
    public Long getFkProductId() {
        return fkProductId;
    }

    /**
     * 设置商品id
     *
     * @param fkProductId 商品id
     */
    public void setFkProductId(Long fkProductId) {
        this.fkProductId = fkProductId;
    }

    /**
     * 获取商家id
     *
     * @return fk_merchant_id - 商家id
     */
    public Long getFkMerchantId() {
        return fkMerchantId;
    }

    /**
     * 设置商家id
     *
     * @param fkMerchantId 商家id
     */
    public void setFkMerchantId(Long fkMerchantId) {
        this.fkMerchantId = fkMerchantId;
    }

    /**
     * 获取设备id
     *
     * @return fk_device_id - 设备id
     */
    public Long getFkDeviceId() {
        return fkDeviceId;
    }

    /**
     * 设置设备id
     *
     * @param fkDeviceId 设备id
     */
    public void setFkDeviceId(Long fkDeviceId) {
        this.fkDeviceId = fkDeviceId;
    }

    /**
     * 获取商品快照id
     *
     * @return fk_product_snapshot_id - 商品快照id
     */
    public Long getFkProductSnapshotId() {
        return fkProductSnapshotId;
    }

    /**
     * 设置商品快照id
     *
     * @param fkProductSnapshotId 商品快照id
     */
    public void setFkProductSnapshotId(Long fkProductSnapshotId) {
        this.fkProductSnapshotId = fkProductSnapshotId;
    }
}