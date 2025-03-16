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
 * 支付通道接口表 实体类。
 *
 * @author mybatis-flex-helper automatic generation
 * @since 1.0
 */
@Table(value = "pay_api")
public class PayApiEntity {

    /**
     * 支付通道接口ID
     */
    @Id(keyType = KeyType.Auto)
    private Long payApiId;

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
     * 通道码
     */
    @Column(value = "channel_code")
    private String channelCode;

    /**
     * 接口名称
     */
    @Column(value = "api_name")
    private String apiName;

    /**
     * 接口namespace
     */
    @Column(value = "api_code")
    private String apiCode;

    /**
     * 接口参数
     */
    @Column(value = "api_params")
    private String apiParams;

    /**
     * 接口URI
     */
    @Column(value = "api_uri")
    private String apiUri;

    /**
     * 接口重定向URL
     */
    @Column(value = "redirect_url")
    private String redirectUrl;

    /**
     * 接口通知地址
     */
    @Column(value = "notify_url")
    private String notifyUrl;

    /**
     * 环境（dev|test|ped|....)
     */
    @Column(value = "env")
    private String env;

    /**
     * 描述
     */
    @Column(value = "description")
    private String description;

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


    public Long getPayApiId() {
        return payApiId;
    }

    public void setPayApiId(Long payApiId) {
        this.payApiId = payApiId;
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

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public String getApiCode() {
        return apiCode;
    }

    public void setApiCode(String apiCode) {
        this.apiCode = apiCode;
    }

    public String getApiParams() {
        return apiParams;
    }

    public void setApiParams(String apiParams) {
        this.apiParams = apiParams;
    }

    public String getApiUri() {
        return apiUri;
    }

    public void setApiUri(String apiUri) {
        this.apiUri = apiUri;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
