package org.dows.sdk.weixin.pay.基础支付.H5支付.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;
/**
 * https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_3_6.shtml
 * @description 
 * @author lait.zhang@gmail.com
 * @date 2023年5月31日 上午11:18:23
 */
@Data
@Schema(name = "申请交易账单Response", title = "申请交易账单Response")
public class 申请交易账单Response{
    @Schema(title = "商户系统内部的商家批次单号，在商户系统内部唯一")
    private String[1,32] 商家批次单号;
    @Schema(title = "微信批次单号，微信商家转账系统返回的唯一标识")
    private String[1,64] 微信批次单号;
    @Schema(title = "申请商户号的appid或商户号绑定的appid（企业号corpid即为此appid）")
    private String[1,32] 直连商户的appid;
    @Schema(title = "商户系统内部区分转账批次单下不同转账明细单的唯一标识")
    private String[1,32] 商家明细单号;
    @Schema(title = "微信支付系统内部区分转账批次单下不同转账明细单的唯一标识")
    private String[1,64] 微信明细单号;
    @Schema(title = "枚举值：")
    private String[1,32] 明细状态;
    @Schema(title = "转账金额单位为分")
    private Int 转账金额;
    @Schema(title = "单条转账备注（微信用户会收到该备注），UTF8编码，最多允许32个字符")
    private String[1,32] 转账备注;
    @Schema(title = "如果转账失败则有失败原因")
    private String[1,64] 明细失败原因;
    @Schema(title = "用户在直连商户appid下的唯一标识")
    private String[1,128] 用户在直连商户应用下的用户标示;
    @Schema(title = "1、商户转账时传入了收款用户姓名、查询时会返回收款用户姓名；")
    private String[1,1024] 收款用户姓名;
    @Schema(title = "转账发起的时间，遵循")
    private String[1,32] 转账发起时间;
    @Schema(title = "明细最后一次状态变更的时间，遵循")
    private String[1,32] 明细更新时间;
}

