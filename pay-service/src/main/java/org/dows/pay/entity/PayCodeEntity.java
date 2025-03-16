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
 * 支付通道状态码表 实体类。
 *
 * @author mybatis-flex-helper automatic generation
 * @since 1.0
 */
@Table(value = "pay_code")
public class PayCodeEntity {

    /**
     * 支付通道状态码ID
     */
    @Id(keyType = KeyType.Auto)
    private Long payCodeId;

    /**
     * 统一状态码编号
     */
    @Column(value = "code_no")
    private String codeNo;

    /**
     * 接口编号
     */
    @Column(value = "api_no")
    private String apiNo;

    /**
     * 通道编号(全局唯一)
     */
    @Column(value = "channel_no")
    private String channelNo;

    /**
     * 通道名称
     */
    @Column(value = "channel_name")
    private String channelName;

    /**
     * 通道码
     */
    @Column(value = "channel_code")
    private String channelCode;

    /**
     * 通道状态码
     */
    @Column(value = "channel_state_code")
    private String channelStateCode;

    /**
     * 通过状态码描述
     */
    @Column(value = "channel_state_descr")
    private String channelStateDescr;

    /**
     * 统一状态码
     */
    @Column(value = "status_code")
    private String statusCode;

    /**
     * 统一状态码描述
     */
    @Column(value = "status_descr")
    private String statusDescr;

    /**
     * 方法编号（一个方法可能存在多个code）
     */
    @Column(value = "method_no")
    private String methodNo;

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


    public Long getPayCodeId() {
        return payCodeId;
    }

    public void setPayCodeId(Long payCodeId) {
        this.payCodeId = payCodeId;
    }

    public String getCodeNo() {
        return codeNo;
    }

    public void setCodeNo(String codeNo) {
        this.codeNo = codeNo;
    }

    public String getApiNo() {
        return apiNo;
    }

    public void setApiNo(String apiNo) {
        this.apiNo = apiNo;
    }

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public String getChannelStateCode() {
        return channelStateCode;
    }

    public void setChannelStateCode(String channelStateCode) {
        this.channelStateCode = channelStateCode;
    }

    public String getChannelStateDescr() {
        return channelStateDescr;
    }

    public void setChannelStateDescr(String channelStateDescr) {
        this.channelStateDescr = channelStateDescr;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusDescr() {
        return statusDescr;
    }

    public void setStatusDescr(String statusDescr) {
        this.statusDescr = statusDescr;
    }

    public String getMethodNo() {
        return methodNo;
    }

    public void setMethodNo(String methodNo) {
        this.methodNo = methodNo;
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
