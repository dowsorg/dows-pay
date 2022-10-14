package org.dows.pay.bo;

import lombok.Data;
import org.dows.pay.api.ChannelBizModel;
import org.dows.pay.api.annotation.AlipayApiField;
import org.dows.pay.api.annotation.WeixinApiField;

/**
 * 分账关系绑定业务对象
 */
@Data
public class RelationBingBo implements ChannelBizModel {

    /**
     * 支付宝特有：分账接收方方类型。userId：表示是支付宝账号对应的支付宝唯一用户号；loginName：表示是支付宝登录号
     */
    @AlipayApiField(name = "type")
    private String type;

    /**
     * 分账接收账号（支付宝|微信等第三方通道账号[账号ID,支付宝账接收方方类型，userId：表示是支付宝账号对应的支付宝唯一用户号；]）
     */
    @WeixinApiField(name = "")
    @AlipayApiField(name = "account")
    private String channelAccountNo;

    /**
     * 分账接收账号名称（第三方通道账号，如支付宝loginName：表示是支付宝登录号名|微信）
     */
    @WeixinApiField(name = "")
    @AlipayApiField(name = "loginName")
    private String channelAccountName;

    @AlipayApiField(name = "name")
    private String name;

    @AlipayApiField(name = "memo")
    private String memo;
}
