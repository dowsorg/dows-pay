package org.dows.sdk.weixin.pay.基础支付.合单支付.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;
/**
 * https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_17.shtml
 * @description 
 * @author lait.zhang@gmail.com
 * @date 2023年5月31日 上午11:18:23
 */
@Data
@Schema(name = "申请交易账单Response", title = "申请交易账单Response")
public class 申请交易账单Response{
    @Schema(title = "枚举值：")
    private String[1,32] 哈希类型;
    @Schema(title = "原始账单（gzip需要解压缩）的摘要值，用于校验文件的完整性。")
    private String[1,1024] 哈希值;
    @Schema(title = "供下一步请求账单文件的下载地址，该地址30s内有效。")
    private String[1,2048] 账单下载地址;
}

