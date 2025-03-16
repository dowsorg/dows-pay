package org.dows.pay.entity;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;

import java.math.BigDecimal;
import java.lang.Long;
import java.lang.String;
import java.lang.Integer;

/**
 * 支付分账表 实体类。
 *
 * @author mybatis-flex-helper automatic generation
 * @since 1.0
 */
@Table(value = "pay_allocation")
public class PayAllocationEntity {

    /**
     * 支付分账ID
     */
    @Id(keyType = KeyType.Auto)
    private Long payAllocationId;

    /**
     * 实际分得金额（订单实际分账金额, 单位：分（订单金额 - 商户手续费 - 已退款金额））
     */
    @Column(value = "alloted_amount")
    private BigDecimal allotedAmount;

    /**
     * 应分金额（计算该接收方的分账金额,单位分）
     */
    @Column(value = "allot_amount")
    private BigDecimal allotAmount;

    /**
     * 订单金额,单位分
     */
    @Column(value = "pay_order_amount")
    private BigDecimal payOrderAmount;

    /**
     * 系统支付订单号
     */
    @Column(value = "pay_order_id")
    private String payOrderId;

    /**
     * 分账记录ID
     */
    @Column(value = "allot_id")
    private String allotId;

    /**
     * 商户名称
     */
    @Column(value = "merchant_name")
    private String merchantName;

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
     * 分账接收者ID(统一账号ID)快照
     */
    @Column(value = "account_id")
    private String accountId;

    /**
     * 接收者账号别名快照
     */
    @Column(value = "account_name")
    private String accountName;

    /**
     * 接收者姓名快照
     */
    @Column(value = "user_name")
    private String userName;

    /**
     * 系统分账批次号
     */
    @Column(value = "batch_order_id")
    private String batchOrderId;

    /**
     * 服务商编码
     */
    @Column(value = "channel_code")
    private String channelCode;

    /**
     * 通道应用ID
     */
    @Column(value = "channel_app_id")
    private String channelAppId;

    /**
     * 支付订单渠道支付订单号
     */
    @Column(value = "channel_order_no")
    private String channelOrderNo;

    /**
     * 分账接收账号快照
     */
    @Column(value = "channel_account_no")
    private String channelAccountNo;

    /**
     * 分账接收账号名称快照
     */
    @Column(value = "channel_account_name")
    private String channelAccountName;

    /**
     * 上游分账批次号
     */
    @Column(value = "channel_batch_order_id")
    private String channelBatchOrderId;

    /**
     * 类型: 1-普通商户, 2-特约商户(服务商模式)
     */
    @Column(value = "merchant_type")
    private Integer merchantType;

    /**
     * 分账接收账号类型: 0-个人(对私) 1-商户(对公)快照
     */
    @Column(value = "channel_account_type")
    private Integer channelAccountType;

    /**
     * 状态: 0-待分账 1-分账成功, 2-分账失败
     */
    @Column(value = "state")
    private Integer state;

    /**
     * 分账比例快照> 配置的实际分账比例
     */
    @Column(value = "allocation_profit")
    private BigDecimal allocationProfit;

    /**
     * 逻辑删除
     */
    @Column(value = "deleted")
    private Integer deleted;


    public Long getPayAllocationId() {
        return payAllocationId;
    }

    public void setPayAllocationId(Long payAllocationId) {
        this.payAllocationId = payAllocationId;
    }

    public BigDecimal getAllotedAmount() {
        return allotedAmount;
    }

    public void setAllotedAmount(BigDecimal allotedAmount) {
        this.allotedAmount = allotedAmount;
    }

    public BigDecimal getAllotAmount() {
        return allotAmount;
    }

    public void setAllotAmount(BigDecimal allotAmount) {
        this.allotAmount = allotAmount;
    }

    public BigDecimal getPayOrderAmount() {
        return payOrderAmount;
    }

    public void setPayOrderAmount(BigDecimal payOrderAmount) {
        this.payOrderAmount = payOrderAmount;
    }

    public String getPayOrderId() {
        return payOrderId;
    }

    public void setPayOrderId(String payOrderId) {
        this.payOrderId = payOrderId;
    }

    public String getAllotId() {
        return allotId;
    }

    public void setAllotId(String allotId) {
        this.allotId = allotId;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
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

    public String getBatchOrderId() {
        return batchOrderId;
    }

    public void setBatchOrderId(String batchOrderId) {
        this.batchOrderId = batchOrderId;
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

    public String getChannelOrderNo() {
        return channelOrderNo;
    }

    public void setChannelOrderNo(String channelOrderNo) {
        this.channelOrderNo = channelOrderNo;
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

    public String getChannelBatchOrderId() {
        return channelBatchOrderId;
    }

    public void setChannelBatchOrderId(String channelBatchOrderId) {
        this.channelBatchOrderId = channelBatchOrderId;
    }

    public Integer getMerchantType() {
        return merchantType;
    }

    public void setMerchantType(Integer merchantType) {
        this.merchantType = merchantType;
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
}
