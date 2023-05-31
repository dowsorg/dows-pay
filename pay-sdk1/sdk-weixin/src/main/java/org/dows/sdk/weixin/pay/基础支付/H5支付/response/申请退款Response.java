package org.dows.sdk.weixin.pay.基础支付.H5支付.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;
/**
 * https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_3_9.shtml
 * @description 
 * @author lait.zhang@gmail.com
 * @date 2023年5月31日 下午9:40:07
 */
@Data
@Schema(name = "申请退款Response", title = "申请退款Response")
public class 申请退款Response{
    @Schema(title = "电子回单受理类型：")
    private String[1,32] 受理类型;
    @Schema(title = "需要电子回单的批量转账明细单所在的转账批次单号，该单号为商户申请转账时生成的商户单号。受理类型为BATCH_TRANSFER时该单号必填，否则该单号留空。")
    private String[5, 32] 商家转账批次单号;
    @Schema(title = "该单号为商户申请转账时生成的商家转账明细单号。")
    private String[5, 32] 商家转账明细单号;
    @Schema(title = "电子回单受理单号，受理单据的唯一标识")
    private String[3, 256] 电子回单受理单号;
    @Schema(title = "枚举值：")
    private String[1, 10] 电子回单状态;
    @Schema(title = "电子回单文件的hash方法，回单状态为：FINISHED时返回")
    private String[1, 20] 电子回单文件的hash方法;
    @Schema(title = "电子回单文件的hash值，用于下载之后验证文件的完整、正确性，回单状态为：FINISHED时返回")
    private String[3, 1000] 电子回单文件的hash值;
    @Schema(title = "电子回单文件的下载地址，回单状态为：FINISHED时返回。URL有效时长为10分钟，10分钟后需要重新去获取下载地址（但不需要走受理）")
    private String[10, 3000] 电子回单文件的下载地址;
}

