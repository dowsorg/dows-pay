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
 * 支付规则表 实体类。
 *
 * @author mybatis-flex-helper automatic generation
 * @since 1.0
 */
@Table(value = "pay_rule")
public class PayRuleEntity {

    /**
     * 支付规则ID
     */
    @Id(keyType = KeyType.Auto)
    private Long payRuleId;

    /**
     * 规则编号
     */
    @Column(value = "rule_no")
    private String ruleNo;

    /**
     * 规则名称
     */
    @Column(value = "rule_name")
    private String ruleName;

    /**
     * 规则码
     */
    @Column(value = "rule_code")
    private String ruleCode;

    /**
     * 提取表达式(sql://*；el://)
     */
    @Column(value = "rule_expr")
    private String ruleExpr;

    /**
     * 提取接口，业务方提供，参数为ruleExpr，根据cron表达式
     */
    @Column(value = "data_api")
    private String dataApi;

    /**
     * 通道编号(全局唯一)
     */
    @Column(value = "channel_no")
    private String channelNo;

    /**
     * 商户号
     */
    @Column(value = "merchant_no")
    private String merchantNo;

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


    public Long getPayRuleId() {
        return payRuleId;
    }

    public void setPayRuleId(Long payRuleId) {
        this.payRuleId = payRuleId;
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

    public String getRuleCode() {
        return ruleCode;
    }

    public void setRuleCode(String ruleCode) {
        this.ruleCode = ruleCode;
    }

    public String getRuleExpr() {
        return ruleExpr;
    }

    public void setRuleExpr(String ruleExpr) {
        this.ruleExpr = ruleExpr;
    }

    public String getDataApi() {
        return dataApi;
    }

    public void setDataApi(String dataApi) {
        this.dataApi = dataApi;
    }

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
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
