package org.dows.sdk.weixin.pay.基础支付.H5支付.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;
/**
 * https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_3_1.shtml
 * @description 
 * @author lait.zhang@gmail.com
 * @date 2023年5月31日 上午11:18:23
 */
@Data
@Schema(name = "H5下单Request", title = "H5下单Request")
public class H5下单Request{
    @Schema(title = "")
    private String[1,32] 直连商户的appid;
    @Schema(title = "")
    private String[1,32] 商家批次单号;
    @Schema(title = "")
    private String[1,32] 批次名称;
    @Schema(title = "")
    private String[1,32] 批次备注;
    @Schema(title = "")
    private Int 转账总金额;
    @Schema(title = "")
    private Int 转账总笔数;
    @Schema(title = "")
    private Array ;
    @Schema(title = "商户系统内部区分转账批次单下不同转账明细单的唯一标识，要求此参数只能由数字、大小写字母组成")
    private String[1,32] 商家明细单号;
    @Schema(title = "转账金额单位为分")
    private Int 转账金额;
    @Schema(title = "单条转账备注（微信用户会收到该备注），UTF8编码，最多允许32个字符")
    private String[1,32] 转账备注;
    @Schema(title = "openid是微信用户在公众号appid下的唯一用户标识（appid不同，则获取到的openid就不同），可用于永久标记一个用户")
    private String[1,128] 用户在直连商户应用下的用户标示;
    @Schema(title = "1、明细转账金额 >= 2,000元，收款用户姓名必填；")
    private String[2,30] 收款用户姓名;
    @Schema(title = "该批次转账使用的转账场景，可在「商家转账到零钱 - 产品设置」中查看详情，如不填写则使用商家的默认转账场景")
    private String[4, 10] 转账场景ID;
}

