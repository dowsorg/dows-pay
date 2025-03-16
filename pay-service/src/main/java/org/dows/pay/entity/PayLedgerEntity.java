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
 * 支付账本表 实体类。
 *
 * @author mybatis-flex-helper automatic generation
 * @since 1.0
 */
@Table(value = "pay_ledger")
public class PayLedgerEntity {

    /**
     * 支付账本ID
     */
    @Id(keyType = KeyType.Auto)
    private Long payLedgerId;

    /**
     * 支付通道实例编号
     */
    @Column(value = "instance_no")
    private String instanceNo;

    /**
     * 商户号
     */
    @Column(value = "merchant_no")
    private String merchantNo;

    /**
     * 应用ID
     */
    @Column(value = "app_id")
    private String appId;

    /**
     * 请求编号
     */
    @Column(value = "request_no")
    private String requestNo;

    /**
     * 分账接收者ID(统一账号ID)
     */
    @Column(value = "account_id")
    private String accountId;

    /**
     * 接收者账号别名
     */
    @Column(value = "account_name")
    private String accountName;

    /**
     * 用户真实名
     */
    @Column(value = "user_name")
    private String userName;

    /**
     * 通道ID
     */
    @Column(value = "channel_id")
    private String channelId;

    /**
     * 服务商code
     */
    @Column(value = "channel_code")
    private String channelCode;

    /**
     * 通道应用ID
     */
    @Column(value = "channel_app_id")
    private String channelAppId;

    /**
     * 分账接收账号（支付宝|微信等第三方通道账号[账号ID,支付宝账接收方方类型，userId：表示是支付宝账号对应的支付宝唯一用户号；]）
     */
    @Column(value = "channel_account_no")
    private String channelAccountNo;

    /**
     * 分账接收账号名称（第三方通道账号，如支付宝loginName：表示是支付宝登录号名|微信）
     */
    @Column(value = "channel_account_name")
    private String channelAccountName;

    /**
     * 分账接收账号类型: 0-个人(对私) 1-商户(对公)
     */
    @Column(value = "channel_account_type")
    private Integer channelAccountType;

    /**
     * 分账状态（本系统状态，并不调用上游关联关系）: 1-正常分账, 0-暂停分账
     */
    @Column(value = "state")
    private Integer state;

    /**
     * 分账比例
     */
    @Column(value = "allocation_profit")
    private BigDecimal allocationProfit;

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


    public Long getPayLedgerId() {
        return payLedgerId;
    }

    public void setPayLedgerId(Long payLedgerId) {
        this.payLedgerId = payLedgerId;
    }

    public String getInstanceNo() {
        return instanceNo;
    }

    public void setInstanceNo(String instanceNo) {
        this.instanceNo = instanceNo;
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

    public String getRequestNo() {
        return requestNo;
    }

    public void setRequestNo(String requestNo) {
        this.requestNo = requestNo;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public String getChannelAppId() {
        return channelAppId;
    }

    public void setChannelAppId(String channelAppId) {
        this.channelAppId = channelAppId;
    }

    public String getChannelAccountNo() {
        return channelAccountNo;
    }

    public void setChannelAccountNo(String channelAccountNo) {
        this.channelAccountNo = channelAccountNo;
    }

    public String getChannelAccountName() {
        return channelAccountName;
    }

    public void setChannelAccountName(String channelAccountName) {
        this.channelAccountName = channelAccountName;
    }

    public Integer getChannelAccountType() {
        return channelAccountType;
    }

    public void setChannelAccountType(Integer channelAccountType) {
        this.channelAccountType = channelAccountType;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public BigDecimal getAllocationProfit() {
        return allocationProfit;
    }

    public void setAllocationProfit(BigDecimal allocationProfit) {
        this.allocationProfit = allocationProfit;
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
