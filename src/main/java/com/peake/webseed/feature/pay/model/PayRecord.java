package com.peake.webseed.feature.pay.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "tbl_pay_record")
public class PayRecord {
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "pk_id")
    private Long pkId;

    /**
     * 商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|* 且在同一个商户号下唯一。
     */
    @Column(name = "out_trade_no")
    private String outTradeNo;

    /**
     * 第三方支付号
     */
    @Column(name = "transaction_no")
    private String transactionNo;

    @Column(name = "total_fee")
    private BigDecimal totalFee;

    /**
     * 0为微信支付，1为支付宝支付
     */
    @Column(name = "pay_way")
    private Integer payWay;

    /**
     * 0:待支付，1支付成功，2支付失败，3支付超时，4支付取消,5交易不存在 ，6交易关闭
     */
    @Column(name = "pay_status")
    private Integer payStatus;

    @Column(name = "pay_time")
    private Date payTime;

    private String attach;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "data_status")
    private Integer dataStatus;

    /**
     * 订单id
     */
    @Column(name = "fk_order_id")
    private Long fkOrderId;

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
     * 获取商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|* 且在同一个商户号下唯一。
     *
     * @return out_trade_no - 商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|* 且在同一个商户号下唯一。
     */
    public String getOutTradeNo() {
        return outTradeNo;
    }

    /**
     * 设置商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|* 且在同一个商户号下唯一。
     *
     * @param outTradeNo 商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|* 且在同一个商户号下唯一。
     */
    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    /**
     * 获取第三方支付号
     *
     * @return transaction_no - 第三方支付号
     */
    public String getTransactionNo() {
        return transactionNo;
    }

    /**
     * 设置第三方支付号
     *
     * @param transactionNo 第三方支付号
     */
    public void setTransactionNo(String transactionNo) {
        this.transactionNo = transactionNo;
    }

    /**
     * @return total_fee
     */
    public BigDecimal getTotalFee() {
        return totalFee;
    }

    /**
     * @param totalFee
     */
    public void setTotalFee(BigDecimal totalFee) {
        this.totalFee = totalFee;
    }

    /**
     * 获取0为微信支付，1为支付宝支付
     *
     * @return pay_way - 0为微信支付，1为支付宝支付
     */
    public Integer getPayWay() {
        return payWay;
    }

    /**
     * 设置0为微信支付，1为支付宝支付
     *
     * @param payWay 0为微信支付，1为支付宝支付
     */
    public void setPayWay(Integer payWay) {
        this.payWay = payWay;
    }

    /**
     * 获取0:待支付，1支付成功，2支付失败，3支付超时，4支付取消,5交易不存在 ，6交易关闭
     *
     * @return pay_status - 0:待支付，1支付成功，2支付失败，3支付超时，4支付取消,5交易不存在 ，6交易关闭
     */
    public Integer getPayStatus() {
        return payStatus;
    }

    /**
     * 设置0:待支付，1支付成功，2支付失败，3支付超时，4支付取消,5交易不存在 ，6交易关闭
     *
     * @param payStatus 0:待支付，1支付成功，2支付失败，3支付超时，4支付取消,5交易不存在 ，6交易关闭
     */
    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    /**
     * @return pay_time
     */
    public Date getPayTime() {
        return payTime;
    }

    /**
     * @param payTime
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    /**
     * @return attach
     */
    public String getAttach() {
        return attach;
    }

    /**
     * @param attach
     */
    public void setAttach(String attach) {
        this.attach = attach;
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
     * 获取订单id
     *
     * @return fk_order_id - 订单id
     */
    public Long getFkOrderId() {
        return fkOrderId;
    }

    /**
     * 设置订单id
     *
     * @param fkOrderId 订单id
     */
    public void setFkOrderId(Long fkOrderId) {
        this.fkOrderId = fkOrderId;
    }
}