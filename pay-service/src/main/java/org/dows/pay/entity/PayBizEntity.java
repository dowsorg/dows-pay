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
 * 支付业务表 实体类。
 *
 * @author mybatis-flex-helper automatic generation
 * @since 1.0
 */
@Table(value = "pay_biz")
public class PayBizEntity {

    /**
     * 支付业务ID
     */
    @Id(keyType = KeyType.Auto)
    private Long payBizId;

    /**
     * 父ID
     */
    @Column(value = "pid")
    private Long pid;

    /**
     * 业务编号
     */
    @Column(value = "biz_no")
    private String bizNo;

    /**
     * 业务code
     */
    @Column(value = "biz_code")
    private String bizCode;

    /**
     * 业务名称|业务组名称
     */
    @Column(value = "biz_name")
    private String bizName;

    /**
     * 名称空间
     */
    @Column(value = "biz_namespace")
    private String bizNamespace;

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
     * 状态
     */
    @Column(value = "state")
    private Integer state;

    /**
     * 价格
     */
    @Column(value = "price")
    private BigDecimal price;

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


    public Long getPayBizId() {
        return payBizId;
    }

    public void setPayBizId(Long payBizId) {
        this.payBizId = payBizId;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getBizNo() {
        return bizNo;
    }

    public void setBizNo(String bizNo) {
        this.bizNo = bizNo;
    }

    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    public String getBizName() {
        return bizName;
    }

    public void setBizName(String bizName) {
        this.bizName = bizName;
    }

    public String getBizNamespace() {
        return bizNamespace;
    }

    public void setBizNamespace(String bizNamespace) {
        this.bizNamespace = bizNamespace;
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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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
