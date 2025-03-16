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
 * 支付指令集表 实体类。
 *
 * @author mybatis-flex-helper automatic generation
 * @since 1.0
 */
@Table(value = "pay_directive")
public class PayDirectiveEntity {

    /**
     * 支付指令集ID
     */
    @Id(keyType = KeyType.Auto)
    private Long payDirectiveId;

    /**
     * 指令编号
     */
    @Column(value = "directive_no")
    private String directiveNo;

    /**
     * 方法编号
     */
    @Column(value = "method_no")
    private String methodNo;

    /**
     * 接口编号
     */
    @Column(value = "api_no")
    private String apiNo;

    /**
     * 方法名称空间（bizNamespace）
     */
    @Column(value = "method_namespace")
    private String methodNamespace;

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
     * 业务编号
     */
    @Column(value = "biz_no")
    private String bizNo;

    /**
     * 业务名称
     */
    @Column(value = "biz_name")
    private String bizName;

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


    public Long getPayDirectiveId() {
        return payDirectiveId;
    }

    public void setPayDirectiveId(Long payDirectiveId) {
        this.payDirectiveId = payDirectiveId;
    }

    public String getDirectiveNo() {
        return directiveNo;
    }

    public void setDirectiveNo(String directiveNo) {
        this.directiveNo = directiveNo;
    }

    public String getMethodNo() {
        return methodNo;
    }

    public void setMethodNo(String methodNo) {
        this.methodNo = methodNo;
    }

    public String getApiNo() {
        return apiNo;
    }

    public void setApiNo(String apiNo) {
        this.apiNo = apiNo;
    }

    public String getMethodNamespace() {
        return methodNamespace;
    }

    public void setMethodNamespace(String methodNamespace) {
        this.methodNamespace = methodNamespace;
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

    public String getBizNo() {
        return bizNo;
    }

    public void setBizNo(String bizNo) {
        this.bizNo = bizNo;
    }

    public String getBizName() {
        return bizName;
    }

    public void setBizName(String bizName) {
        this.bizName = bizName;
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
