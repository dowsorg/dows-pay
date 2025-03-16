package org.dows.pay.entity;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;

import java.math.BigDecimal;
import java.lang.Long;
import java.util.Date;
import java.lang.String;
import java.lang.Integer;

/**
 * 支付申请表 实体类。
 *
 * @author mybatis-flex-helper automatic generation
 * @since 1.0
 */
@Table(value = "pay_apply")
public class PayApplyEntity {

    /**
     * 支付申请ID
     */
    @Id(keyType = KeyType.Auto)
    private Long payApplyId;

    /**
     * 申请编号
     */
    @Column(value = "apply_no")
    private String applyNo;

    /**
     * 商户号
     */
    @Column(value = "merchant_no")
    private String merchantNo;

    /**
     * 全局唯一应用ID
     */
    @Column(value = "app_id")
    private String appId;

    /**
     * 应用链接
     */
    @Column(value = "app_url")
    private String appUrl;

    /**
     * 价格
     */
    @Column(value = "price")
    private BigDecimal price;

    /**
     * 业务编号
     */
    @Column(value = "biz_no")
    private String bizNo;

    /**
     * 业务名称|业务组名称
     */
    @Column(value = "biz_name")
    private String bizName;

    /**
     * 审核是否通过（0:否，1：是）
     */
    @Column(value = "checked")
    private Integer checked;

    /**
     * 逻辑删除
     */
    @Column(value = "deleted")
    private Integer deleted;

    /**
     * 时间戳
     */
    @Column(value = "dt")
    private Date dt;


    public Long getPayApplyId() {
        return payApplyId;
    }

    public void setPayApplyId(Long payApplyId) {
        this.payApplyId = payApplyId;
    }

    public String getApplyNo() {
        return applyNo;
    }

    public void setApplyNo(String applyNo) {
        this.applyNo = applyNo;
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getBizNo() {
        return bizNo;
    }

    public void setBizNo(String bizNo) {
        this.bizNo = bizNo;
    }

    public String getBizName() {
        return bizName;
    }

    public void setBizName(String bizName) {
        this.bizName = bizName;
    }

    public Integer getChecked() {
        return checked;
    }

    public void setChecked(Integer checked) {
        this.checked = checked;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Date getDt() {
        return dt;
    }

    public void setDt(Date dt) {
        this.dt = dt;
    }
}
