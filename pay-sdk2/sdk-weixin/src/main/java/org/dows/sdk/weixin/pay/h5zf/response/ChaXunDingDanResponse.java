package org.dows.sdk.weixin.pay.h5zf.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;
/**
 * https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_3_2.shtml
 * @description 
 * @author lait.zhang@gmail.com
 * @date 2023年6月2日 下午5:32:38
 */
@Data
@Schema(name = "查询订单Response", title = "查询订单Response")
public class ChaXunDingDanResponse{
    @Schema(title = "转账批次单基本信息")
    private Object transfer_batch;
    @Schema(title = "微信支付分配的商户号")
    private String mchid;
    @Schema(title = "商户系统内部的商家批次单号，在商户系统内部唯一")
    private String out_batch_no;
    @Schema(title = "微信批次单号，微信商家转账系统返回的唯一标识")
    private String batch_id;
    @Schema(title = "申请商户号的appid或商户号绑定的appid（企业号corpid即为此appid）")
    private String appid;
    @Schema(title = "枚举值：")
    private String batch_status;
    @Schema(title = "枚举值：")
    private String batch_type;
    @Schema(title = "该笔批量转账的名称")
    private String batch_name;
    @Schema(title = "转账说明，UTF8编码，最多允许32个字符")
    private String batch_remark;
    @Schema(title = "如果批次单状态为“CLOSED”（已关闭），则有关闭原因")
    private String close_reason;
    @Schema(title = "转账金额单位为分")
    private Int total_amount;
    @Schema(title = "一个转账批次单最多发起三千笔转账")
    private Int total_num;
    @Schema(title = "批次受理成功时返回，遵循")
    private String create_time;
    @Schema(title = "批次最近一次状态变更的时间，遵循")
    private String update_time;
    @Schema(title = "转账成功的金额，单位为分。当批次状态为“PROCESSING”（转账中）时，转账成功金额随时可能变化")
    private Int success_amount;
    @Schema(title = "转账成功的笔数。当批次状态为“PROCESSING”（转账中）时，转账成功笔数随时可能变化")
    private Int success_num;
    @Schema(title = "转账失败的金额，单位为分")
    private Int fail_amount;
    @Schema(title = "转账失败的笔数")
    private Int fail_num;
    @Schema(title = "当批次状态为“FINISHED”（已完成），且成功查询到转账明细单时返回。包括微信明细单号、明细状态信息")
    private Array transfer_detail_list;
    @Schema(title = "微信支付系统内部区分转账批次单下不同转账明细单的唯一标识")
    private String detail_id;
    @Schema(title = "商户系统内部区分转账批次单下不同转账明细单的唯一标识")
    private String out_detail_no;
    @Schema(title = "枚举值：")
    private String detail_status;
}

