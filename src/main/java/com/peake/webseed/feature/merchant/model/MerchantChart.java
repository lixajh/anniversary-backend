package com.peake.webseed.feature.merchant.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "tbl_merchant_chart")
public class MerchantChart {
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "pk_id")
    private Long pkId;

    /**
     * 报表名称 xx年xx月xx商家销售报表
     */
    private String name;

    @Column(name = "data_status")
    private Integer dataStatus;

    /**
     * 报表统计开始日期
     */
    @Column(name = "start_date")
    private Date startDate;

    /**
     * 报表统计结束时间
     */
    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 订单数量
     */
    @Column(name = "order_count")
    private Integer orderCount;

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
     * 总交易额
     */
    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    /**
     * 实际支付总额
     */
    @Column(name = "pay_amount")
    private BigDecimal payAmount;

    /**
     * 计算提成
     */
    @Column(name = "cal_bonus")
    private BigDecimal calBonus;

    /**
     * 实际提成
     */
    @Column(name = "real_bonus")
    private BigDecimal realBonus;

    /**
     * 备注
     */
    private String remark;

    /**
     * 商家id
     */
    @Column(name = "fk_merchant_id")
    private Long fkMerchantId;

    /**
     * 年
     */
    private String year;

    /**
     * 月
     */
    private String month;

    /**
     * 报表类型 1:月报表
     */
    private Integer type;

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
     * 获取报表名称 xx年xx月xx商家销售报表
     *
     * @return name - 报表名称 xx年xx月xx商家销售报表
     */
    public String getName() {
        return name;
    }

    /**
     * 设置报表名称 xx年xx月xx商家销售报表
     *
     * @param name 报表名称 xx年xx月xx商家销售报表
     */
    public void setName(String name) {
        this.name = name;
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
     * 获取报表统计开始日期
     *
     * @return start_date - 报表统计开始日期
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * 设置报表统计开始日期
     *
     * @param startDate 报表统计开始日期
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * 获取报表统计结束时间
     *
     * @return end_date - 报表统计结束时间
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * 设置报表统计结束时间
     *
     * @param endDate 报表统计结束时间
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
     * 获取订单数量
     *
     * @return order_count - 订单数量
     */
    public Integer getOrderCount() {
        return orderCount;
    }

    /**
     * 设置订单数量
     *
     * @param orderCount 订单数量
     */
    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
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
     * 获取总交易额
     *
     * @return total_amount - 总交易额
     */
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    /**
     * 设置总交易额
     *
     * @param totalAmount 总交易额
     */
    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * 获取实际支付总额
     *
     * @return pay_amount - 实际支付总额
     */
    public BigDecimal getPayAmount() {
        return payAmount;
    }

    /**
     * 设置实际支付总额
     *
     * @param payAmount 实际支付总额
     */
    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    /**
     * 获取计算提成
     *
     * @return cal_bonus - 计算提成
     */
    public BigDecimal getCalBonus() {
        return calBonus;
    }

    /**
     * 设置计算提成
     *
     * @param calBonus 计算提成
     */
    public void setCalBonus(BigDecimal calBonus) {
        this.calBonus = calBonus;
    }

    /**
     * 获取实际提成
     *
     * @return real_bonus - 实际提成
     */
    public BigDecimal getRealBonus() {
        return realBonus;
    }

    /**
     * 设置实际提成
     *
     * @param realBonus 实际提成
     */
    public void setRealBonus(BigDecimal realBonus) {
        this.realBonus = realBonus;
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
     * 获取年
     *
     * @return year - 年
     */
    public String getYear() {
        return year;
    }

    /**
     * 设置年
     *
     * @param year 年
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * 获取月
     *
     * @return month - 月
     */
    public String getMonth() {
        return month;
    }

    /**
     * 设置月
     *
     * @param month 月
     */
    public void setMonth(String month) {
        this.month = month;
    }

    /**
     * 获取报表类型 1:月报表
     *
     * @return type - 报表类型 1:月报表
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置报表类型 1:月报表
     *
     * @param type 报表类型 1:月报表
     */
    public void setType(Integer type) {
        this.type = type;
    }
}