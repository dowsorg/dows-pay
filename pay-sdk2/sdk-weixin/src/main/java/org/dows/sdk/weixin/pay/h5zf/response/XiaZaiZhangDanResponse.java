package org.dows.sdk.weixin.pay.h5zf.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;
/**
 * https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_3_8.shtml
 * @description 
 * @author lait.zhang@gmail.com
 * @date 2023年6月2日 下午5:32:38
 */
@Data
@Schema(name = "下载账单Response", title = "下载账单Response")
public class XiaZaiZhangDanResponse{
    @Schema(title = "商户系统内部的商家批次单号，在商户系统内部唯一。需要电子回单的批次单号")
    private String out_batch_no;
    @Schema(title = "电子回单申请单号，申请单据的唯一标识")
    private String signature_no;
    @Schema(title = "枚举值：")
    private String signature_status;
    @Schema(title = "电子回单文件的hash方法，回单状态为：FINISHED时返回。")
    private String hash_type;
    @Schema(title = "电子回单文件的hash值，用于下载之后验证文件的完整、正确性，回单状态为：FINISHED时返回。")
    private String hash_value;
    @Schema(title = "电子回单文件的下载地址，回单状态为：FINISHED时返回。URL有效时长为10分钟，10分钟后需要重新去获取下载地址")
    private String download_url;
    @Schema(title = "电子签章单创建时间，遵循")
    private String create_time;
    @Schema(title = "电子签章单最近一次状态变更的时间，遵循")
    private String update_time;
}

