package org.dows.sdk.weixin.pay.基础支付.H5支付.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;
/**
 * https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_3_5.shtml
 * @description 
 * @author lait.zhang@gmail.com
 * @date 2023年5月31日 上午11:18:23
 */
@Data
@Schema(name = "支付通知Response", title = "支付通知Response")
public class 支付通知Response{
    @Schema(title = "转账批次单基本信息")
    private Object ;
    @Schema(title = "微信支付分配的商户号")
    private String[1,32] 商户号;
    @Schema(title = "商户系统内部的商家批次单号，在商户系统内部唯一")
    private String[1,32] 商家批次单号;
    @Schema(title = "微信批次单号，微信商家转账系统返回的唯一标识")
    private String[1,64] 微信批次单号;
    @Schema(title = "申请商户号的appid或商户号绑定的appid（企业号corpid即为此appid）")
    private String[1,32] 直连商户的appid;
    @Schema(title = "枚举值：")
    private String[1,32] 批次状态;
    @Schema(title = "枚举值：")
    private String[1,32] 批次类型;
    @Schema(title = "该笔批量转账的名称")
    private String[1,32] 批次名称;
    @Schema(title = "转账说明，UTF8编码，最多允许32个字符")
    private String[1,32] 批次备注;
    @Schema(title = "如果批次单状态为“CLOSED”（已关闭），则有关闭原因")
    private String[1,64] 批次关闭原因;
    @Schema(title = "转账金额单位为分")
    private Int 转账总金额;
    @Schema(title = "一个转账批次单最多发起三千笔转账")
    private Int 转账总笔数;
    @Schema(title = "批次受理成功时返回，遵循")
    private String[1,32] 批次创建时间;
    @Schema(title = "批次最近一次状态变更的时间，遵循")
    private String[1,32] 批次更新时间;
    @Schema(title = "转账成功的金额，单位为分。当批次状态为“PROCESSING”（转账中）时，转账成功金额随时可能变化")
    private Int 转账成功金额;
    @Schema(title = "转账成功的笔数。当批次状态为“PROCESSING”（转账中）时，转账成功笔数随时可能变化")
    private Int 转账成功笔数;
    @Schema(title = "转账失败的金额，单位为分")
    private Int 转账失败金额;
    @Schema(title = "转账失败的笔数")
    private Int 转账失败笔数;
    @Schema(title = "当批次状态为“FINISHED”（已完成），且成功查询到转账明细单时返回。包括微信明细单号、明细状态信息")
    private Array ;
    @Schema(title = "微信支付系统内部区分转账批次单下不同转账明细单的唯一标识")
    private String[1,64] 微信明细单号;
    @Schema(title = "商户系统内部区分转账批次单下不同转账明细单的唯一标识")
    private String[1,32] 商家明细单号;
    @Schema(title = "枚举值：")
    private String[1,32] 明细状态;
    @Schema(title = "")
    private Int 请求资源起始位置;
    @Schema(title = "")
    private Int 最大资源条数;
}

