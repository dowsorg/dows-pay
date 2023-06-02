package org.dows.sdk.weixin.pay.h5zf.response;

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
 * @date 2023年6月2日 下午5:32:38
 */
@Data
@Schema(name = "申请交易账单Response", title = "申请交易账单Response")
public class ShenQingJiaoYiZhangDanResponse{
    @Schema(title = "商户系统内部的商家批次单号，在商户系统内部唯一")
    private String out_batch_no;
    @Schema(title = "微信批次单号，微信商家转账系统返回的唯一标识")
    private String batch_id;
    @Schema(title = "申请商户号的appid或商户号绑定的appid（企业号corpid即为此appid）")
    private String appid;
    @Schema(title = "商户系统内部区分转账批次单下不同转账明细单的唯一标识")
    private String out_detail_no;
    @Schema(title = "微信支付系统内部区分转账批次单下不同转账明细单的唯一标识")
    private String detail_id;
    @Schema(title = "枚举值：")
    private String detail_status;
    @Schema(title = "转账金额单位为分")
    private Int transfer_amount;
    @Schema(title = "单条转账备注（微信用户会收到该备注），UTF8编码，最多允许32个字符")
    private String transfer_remark;
    @Schema(title = "如果转账失败则有失败原因")
    private String fail_reason;
    @Schema(title = "用户在直连商户appid下的唯一标识")
    private String openid;
    @Schema(title = "1、商户转账时传入了收款用户姓名、查询时会返回收款用户姓名；")
    private String user_name;
    @Schema(title = "转账发起的时间，遵循")
    private String initiate_time;
    @Schema(title = "明细最后一次状态变更的时间，遵循")
    private String update_time;
}

