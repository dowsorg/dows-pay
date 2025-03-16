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
 * 支付方法表 实体类。
 *
 * @author mybatis-flex-helper automatic generation
 * @since 1.0
 */
@Table(value = "pay_method")
public class PayMethodEntity {

    /**
     * 支付方法ID
     */
    @Id(keyType = KeyType.Auto)
    private Long payMethodId;

    /**
     * 方法编号
     */
    @Column(value = "method_no")
    private String methodNo;

    /**
     * 方法名称
     */
    @Column(value = "method_name")
    private String methodName;

    /**
     * 方法名称空间
     */
    @Column(value = "method_namespace")
    private String methodNamespace;

    /**
     * 方法参数
     */
    @Column(value = "method_params")
    private String methodParams;

    /**
     * 方法URI
     */
    @Column(value = "method_uri")
    private String methodUri;

    /**
     * 重定向URL
     */
    @Column(value = "redirect_url")
    private String redirectUrl;

    /**
     * 通知URL
     */
    @Column(value = "notify_url")
    private String notifyUrl;

    /**
     * 支付业务类型(......)
     */
    @Column(value = "pay_typ")
    private String payTyp;

    /**
     * 环境（dev|test|ped|....)
     */
    @Column(value = "env")
    private String env;

    /**
     * 业务组名称
     */
    @Column(value = "biz_group")
    private String bizGroup;

    /**
     * 描述
     */
    @Column(value = "descr")
    private String descr;

    /**
     * 时间戳
     */
    @Column(value = "dt")
    private Date dt;

    /**
     * 逻辑删除
     */
    @Column(value = "deleted")
    private Integer deleted;


    public Long getPayMethodId() {
        return payMethodId;
    }

    public void setPayMethodId(Long payMethodId) {
        this.payMethodId = payMethodId;
    }

    public String getMethodNo() {
        return methodNo;
    }

    public void setMethodNo(String methodNo) {
        this.methodNo = methodNo;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getMethodNamespace() {
        return methodNamespace;
    }

    public void setMethodNamespace(String methodNamespace) {
        this.methodNamespace = methodNamespace;
    }

    public String getMethodParams() {
        return methodParams;
    }

    public void setMethodParams(String methodParams) {
        this.methodParams = methodParams;
    }

    public String getMethodUri() {
        return methodUri;
    }

    public void setMethodUri(String methodUri) {
        this.methodUri = methodUri;
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

    public String getPayTyp() {
        return payTyp;
    }

    public void setPayTyp(String payTyp) {
        this.payTyp = payTyp;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public String getBizGroup() {
        return bizGroup;
    }

    public void setBizGroup(String bizGroup) {
        this.bizGroup = bizGroup;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public Date getDt() {
        return dt;
    }

    public void setDt(Date dt) {
        this.dt = dt;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
}
