package org.dows.sdk.weixin.pay.基础支付.H5支付.response;

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
 * @date 2023年5月31日 下午9:40:07
 */
@Data
@Schema(name = "下载账单Response", title = "下载账单Response")
public class 下载账单Response{
    @Schema(title = "商户系统内部的商家批次单号，在商户系统内部唯一。需要电子回单的批次单号")
    private String[5,32] 商家批次单号;
    @Schema(title = "电子回单申请单号，申请单据的唯一标识")
    private String[3,45] 电子回单申请单号;
    @Schema(title = "枚举值：")
    private String[1,10] 电子回单状态;
    @Schema(title = "电子回单文件的hash方法，回单状态为：FINISHED时返回。")
    private String[1,20] 电子回单文件的hash方法;
    @Schema(title = "电子回单文件的hash值，用于下载之后验证文件的完整、正确性，回单状态为：FINISHED时返回。")
    private String[3,1000] 电子回单文件的hash值;
    @Schema(title = "电子回单文件的下载地址，回单状态为：FINISHED时返回。URL有效时长为10分钟，10分钟后需要重新去获取下载地址")
    private String[10,3000] 电子回单文件的下载地址;
    @Schema(title = "电子签章单创建时间，遵循")
    private String[1, 32] 创建时间;
    @Schema(title = "电子签章单最近一次状态变更的时间，遵循")
    private String[1, 32] 更新时间;
}

