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
 * 支付通道账号表 实体类。
 *
 * @author mybatis-flex-helper automatic generation
 * @since 1.0
 */
@Table(value = "pay_account")
public class PayAccountEntity {

    /**
     * 支付通道账号ID
     */
    @Id(keyType = KeyType.Auto)
    private Long payAccountId;

    /**
     * 父ID
     */
    @Column(value = "pid")
    private Long pid;

    /**
     * 通道编号(全局唯一)
     */
    @Column(value = "channel_no")
    private String channelNo;

    /**
     * 通道码
     */
    @Column(value = "channel_code")
    private String channelCode;

    /**
     * 通道账号
     */
    @Column(value = "channel_account")
    private String channelAccount;

    /**
     * 通道商户号
     */
    @Column(value = "channel_merchant_no")
    private String channelMerchantNo;

    /**
     * 商户号
     */
    @Column(value = "merchant_no")
    private String merchantNo;

    /**
     * 账号
     */
    @Column(value = "account_no")
    private String accountNo;

    /**
     * 通道账号类型（0：个人账号，1：商户账号，11：商户子账号....）
     */
    @Column(value = "cat")
    private Integer cat;

    /**
     * 状态
     */
    @Column(value = "state")
    private Integer state;

    /**
     * 时间戳
     */
    @Column(value = "ts")
    private Date ts;

    /**
     * 逻辑删除
     */
    @Column(value = "deleted")
    private Integer deleted;


    public Long getPayAccountId() {
        return payAccountId;
    }

    public void setPayAccountId(Long payAccountId) {
        this.payAccountId = payAccountId;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public String getChannelAccount() {
        return channelAccount;
    }

    public void setChannelAccount(String channelAccount) {
        this.channelAccount = channelAccount;
    }

    public String getChannelMerchantNo() {
        return channelMerchantNo;
    }

    public void setChannelMerchantNo(String channelMerchantNo) {
        this.channelMerchantNo = channelMerchantNo;
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public Integer getCat() {
        return cat;
    }

    public void setCat(Integer cat) {
        this.cat = cat;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
}
