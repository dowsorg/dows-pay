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
 * 支付通道实例表 实体类。
 *
 * @author mybatis-flex-helper automatic generation
 * @since 1.0
 */
@Table(value = "pay_instance")
public class PayInstanceEntity {

    /**
     * 支付通道实例ID
     */
    @Id(keyType = KeyType.Auto)
    private Long payInstanceId;

    /**
     * 支付通道实例编号
     */
    @Column(value = "instance_no")
    private String instanceNo;

    /**
     * 通道编号(全局唯一)
     */
    @Column(value = "channel_no")
    private String channelNo;

    /**
     * 通道码（alipay|weixin|......）
     */
    @Column(value = "channel_code")
    private String channelCode;

    /**
     * 通道应用ID
     */
    @Column(value = "channel_app_id")
    private String channelAppId;

    /**
     * 网关URL
     */
    @Column(value = "service_url")
    private String serviceUrl;

    /**
     * 消息推送URL
     */
    @Column(value = "msg_url")
    private String msgUrl;

    /**
     * 字符集
     */
    @Column(value = "charset")
    private String charset;

    /**
     * 格式
     */
    @Column(value = "format")
    private String format;

    /**
     * 签名类型(RSA/RSA2/....)
     */
    @Column(value = "sign_type")
    private String signType;

    /**
     * 验证模式(公钥模式：psk:0,证书模式：crt:1)
     */
    @Column(value = "cert_model")
    private String certModel;

    /**
     * 私钥
     */
    @Column(value = "private_key")
    private String privateKey;

    /**
     * 公钥
     */
    @Column(value = "pay_public_key")
    private String payPublicKey;

    /**
     * 应用公钥证书路径
     */
    @Column(value = "app_cert_path")
    private String appCertPath;

    /**
     * 公钥证书文件路径
     */
    @Column(value = "pay_cert_path")
    private String payCertPath;

    /**
     * CA根证书文件路径
     */
    @Column(value = "pay_root_cert_path")
    private String payRootCertPath;

    /**
     * 加密签名密钥
     */
    @Column(value = "secret_key")
    private String secretKey;

    /**
     * 环境（dev|test|ped|....)
     */
    @Column(value = "env")
    private String env;

    /**
     * 平台商户号
     */
    @Column(value = "merchant_no")
    private String merchantNo;

    /**
     * 账号
     */
    @Column(value = "account_no")
    private String accountNo;

    /**
     * 应用ID
     */
    @Column(value = "app_id")
    private String appId;

    /**
     * 租户号
     */
    @Column(value = "tenant_id")
    private String tenantId;

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


    public Long getPayInstanceId() {
        return payInstanceId;
    }

    public void setPayInstanceId(Long payInstanceId) {
        this.payInstanceId = payInstanceId;
    }

    public String getInstanceNo() {
        return instanceNo;
    }

    public void setInstanceNo(String instanceNo) {
        this.instanceNo = instanceNo;
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

    public String getChannelAppId() {
        return channelAppId;
    }

    public void setChannelAppId(String channelAppId) {
        this.channelAppId = channelAppId;
    }

    public String getServiceUrl() {
        return serviceUrl;
    }

    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }

    public String getMsgUrl() {
        return msgUrl;
    }

    public void setMsgUrl(String msgUrl) {
        this.msgUrl = msgUrl;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getCertModel() {
        return certModel;
    }

    public void setCertModel(String certModel) {
        this.certModel = certModel;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getPayPublicKey() {
        return payPublicKey;
    }

    public void setPayPublicKey(String payPublicKey) {
        this.payPublicKey = payPublicKey;
    }

    public String getAppCertPath() {
        return appCertPath;
    }

    public void setAppCertPath(String appCertPath) {
        this.appCertPath = appCertPath;
    }

    public String getPayCertPath() {
        return payCertPath;
    }

    public void setPayCertPath(String payCertPath) {
        this.payCertPath = payCertPath;
    }

    public String getPayRootCertPath() {
        return payRootCertPath;
    }

    public void setPayRootCertPath(String payRootCertPath) {
        this.payRootCertPath = payRootCertPath;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
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

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
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
