package org.dows.pay.entity;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;

import java.lang.Long;
import java.util.Date;
import java.lang.String;
import java.lang.Integer;

/**
 * 支付商户表 实体类。
 *
 * @author mybatis-flex-helper automatic generation
 * @since 1.0
 */
@Table(value = "pay_merchant")
public class PayMerchantEntity {

    /**
     * 支付商户ID
     */
    @Id(keyType = KeyType.Auto)
    private Long payMerchantId;

    /**
     * 平台商户号
     */
    @Column(value = "merchant_no")
    private String merchantNo;

    /**
     * 内部支付账号
     */
    @Column(value = "pay_account")
    private String payAccount;

    /**
     * 内部支付密码
     */
    @Column(value = "pay_pwd")
    private String payPwd;

    /**
     * 内部账号名
     */
    @Column(value = "account_name")
    private String accountName;

    /**
     * 内部账号
     */
    @Column(value = "account_no")
    private String accountNo;

    /**
     * 应用id
     */
    @Column(value = "app_id")
    private String appId;

    /**
     * 租户号
     */
    @Column(value = "tentant_no")
    private String tentantNo;

    /**
     * 状态
     */
    @Column(value = "state")
    private Integer state;

    /**
     * 逻辑删除
     */
    @Column(value = "deleted")
    private Integer deleted;

    /**
     * 时间戳
     */
    @Column(value = "ts")
    private Date ts;


    public Long getPayMerchantId() {
        return payMerchantId;
    }

    public void setPayMerchantId(Long payMerchantId) {
        this.payMerchantId = payMerchantId;
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    public String getPayAccount() {
        return payAccount;
    }

    public void setPayAccount(String payAccount) {
        this.payAccount = payAccount;
    }

    public String getPayPwd() {
        return payPwd;
    }

    public void setPayPwd(String payPwd) {
        this.payPwd = payPwd;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getTentantNo() {
        return tentantNo;
    }

    public void setTentantNo(String tentantNo) {
        this.tentantNo = tentantNo;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }
}
