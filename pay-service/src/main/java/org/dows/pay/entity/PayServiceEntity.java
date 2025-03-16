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
 * 支付接入服务表 实体类。
 *
 * @author mybatis-flex-helper automatic generation
 * @since 1.0
 */
@Table(value = "pay_service")
public class PayServiceEntity {

    /**
     * 支付接入服务
     */
    @Id(keyType = KeyType.Auto)
    private Long payServiceId;

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
     * 对业务方的回调接口
     */
    @Column(value = "callback_api")
    private String callbackApi;

    /**
     * 指令编号或ID
     */
    @Column(value = "directive_no")
    private String directiveNo;

    /**
     * 指令类型
     */
    @Column(value = "directive_typ")
    private Integer directiveTyp;

    /**
     * 规则编号或ID
     */
    @Column(value = "rule_no")
    private String ruleNo;

    /**
     * 规则名称
     */
    @Column(value = "rule_name")
    private String ruleName;

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
    @Column(value = "ts")
    private Date ts;


    public Long getPayServiceId() {
        return payServiceId;
    }

    public void setPayServiceId(Long payServiceId) {
        this.payServiceId = payServiceId;
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

    public String getCallbackApi() {
        return callbackApi;
    }

    public void setCallbackApi(String callbackApi) {
        this.callbackApi = callbackApi;
    }

    public String getDirectiveNo() {
        return directiveNo;
    }

    public void setDirectiveNo(String directiveNo) {
        this.directiveNo = directiveNo;
    }

    public Integer getDirectiveTyp() {
        return directiveTyp;
    }

    public void setDirectiveTyp(Integer directiveTyp) {
        this.directiveTyp = directiveTyp;
    }

    public String getRuleNo() {
        return ruleNo;
    }

    public void setRuleNo(String ruleNo) {
        this.ruleNo = ruleNo;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
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

    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }
}
