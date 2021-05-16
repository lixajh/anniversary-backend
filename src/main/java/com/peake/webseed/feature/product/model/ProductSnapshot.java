package com.peake.webseed.feature.product.model;

import com.peake.webseed.utils.DateUtils;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "tbl_product_snapshot")
public class ProductSnapshot {
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "pk_id")
    private Long pkId;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品标题
     */
    private String title;

    /**
     * 价格（元）
     */
    private BigDecimal price;

    /**
     * -1：删除，0：未上架，1：上架
     */
    @Column(name = "data_status")
    private Integer dataStatus;

    /**
     * 商品描述
     */
    @Column(name = "item_desc")
    private String itemDesc;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 商品图片链接
     */
    @Column(name = "pic_url")
    private String picUrl;

    /**
     * 商品id
     */
    @Column(name = "fk_product_id")
    private Long fkProductId;

    private String md5;

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
     * 获取商品名称
     *
     * @return name - 商品名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置商品名称
     *
     * @param name 商品名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取商品标题
     *
     * @return title - 商品标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置商品标题
     *
     * @param title 商品标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取价格（元）
     *
     * @return price - 价格（元）
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置价格（元）
     *
     * @param price 价格（元）
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
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
     * 获取商品描述
     *
     * @return item_desc - 商品描述
     */
    public String getItemDesc() {
        return itemDesc;
    }

    /**
     * 设置商品描述
     *
     * @param itemDesc 商品描述
     */
    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
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
     * 获取商品图片链接
     *
     * @return pic_url - 商品图片链接
     */
    public String getPicUrl() {
        return picUrl;
    }

    /**
     * 设置商品图片链接
     *
     * @param picUrl 商品图片链接
     */
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
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
     * @return md5
     */
    public String getMd5() {
        return md5;
    }

    /**
     * @param md5
     */
    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public ProductSnapshot() {

    }
    public ProductSnapshot(Product product) {
       this.createTime = product.getCreateTime();
//       this.dataStatus = product.getDataStatus();
       this.fkProductId = product.getPkId();
       this.itemDesc = product.getItemDesc();
       this.md5 = product.getMd5();
       this.name = product.getName();
       this.picUrl = product.getPicUrl();
       this.price = product.getPrice();
//       this.remark = product.getRemark();
       this.title = product.getTitle();
       this.updateTime = DateUtils.now();;
    }
}