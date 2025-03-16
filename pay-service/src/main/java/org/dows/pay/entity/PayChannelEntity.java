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
 * 支付通道表 实体类。
 *
 * @author mybatis-flex-helper automatic generation
 * @since 1.0
 */
@Table(value = "pay_channel")
public class PayChannelEntity {

    /**
     * 支付通道ID
     */
    @Id(keyType = KeyType.Auto)
    private Long payChannelId;

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
     * 支付页面
     */
    @Column(value = "channel_home")
    private String channelHome;

    /**
     * 描述
     */
    @Column(value = "description")
    private String description;

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


    public Long getPayChannelId() {
        return payChannelId;
    }

    public void setPayChannelId(Long payChannelId) {
        this.payChannelId = payChannelId;
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

    public String getChannelHome() {
        return channelHome;
    }

    public void setChannelHome(String channelHome) {
        this.channelHome = channelHome;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
