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
 * 支付交易表 实体类。
 *
 * @author mybatis-flex-helper automatic generation
 * @since 1.0
 */
@Table(value = "pay_transaction")
public class PayTransactionEntity {

    /**
     * 支付交易ID
     */
    @Id(keyType = KeyType.Auto)
    private Long payTransactionId;

    /**
     * 交易号
     */
    @Column(value = "transaction_no")
    private String transactionNo;

    /**
     * 交易名称
     */
    @Column(value = "transaction_name")
    private String transactionName;

    /**
     * 支付通道
     */
    @Column(value = "pay_channel")
    private String payChannel;

    /**
     * 订单号
     */
    @Column(value = "order_id")
    private String orderId;

    /**
     * 订单标题
     */
    @Column(value = "order_title")
    private String orderTitle;

    /**
     * 商户号
     */
    @Column(value = "merchant_no")
    private String merchantNo;

    /**
     * 商户名称
     */
    @Column(value = "merchant_name")
    private String merchantName;

    /**
     * 交易form方(accountNO)
     */
    @Column(value = "deal_form")
    private String dealForm;

    /**
     * 交易to方(accountNo)
     */
    @Column(value = "deal_to")
    private String dealTo;

    /**
     * 交易金额
     */
    @Column(value = "amount")
    private BigDecimal amount;

    /**
     * 备注
     */
    @Column(value = "remark")
    private String remark;

    /**
     * 应用id
     */
    @Column(value = "app_id")
    private String appId;

    /**
     * 交易状态
     */
    @Column(value = "state")
    private Integer state;

    /**
     * 交易时间
     */
    @Column(value = "transaction_time")
    private Date transactionTime;

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


    public Long getPayTransactionId() {
        return payTransactionId;
    }

    public void setPayTransactionId(Long payTransactionId) {
        this.payTransactionId = payTransactionId;
    }

    public String getTransactionNo() {
        return transactionNo;
    }

    public void setTransactionNo(String transactionNo) {
        this.transactionNo = transactionNo;
    }

    public String getTransactionName() {
        return transactionName;
    }

    public void setTransactionName(String transactionName) {
        this.transactionName = transactionName;
    }

    public String getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(String payChannel) {
        this.payChannel = payChannel;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderTitle() {
        return orderTitle;
    }

    public void setOrderTitle(String orderTitle) {
        this.orderTitle = orderTitle;
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getDealForm() {
        return dealForm;
    }

    public void setDealForm(String dealForm) {
        this.dealForm = dealForm;
    }

    public String getDealTo() {
        return dealTo;
    }

    public void setDealTo(String dealTo) {
        this.dealTo = dealTo;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(Date transactionTime) {
        this.transactionTime = transactionTime;
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
