package org.dows.sdk.weixin.pay.nativezf.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;
/**
 * https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter4_4_6.shtml
 * @description 
 * @author lait.zhang@gmail.com
 * @date 2023年6月2日 下午5:32:39
 */
@Data
@Schema(name = "申请交易账单Response", title = "申请交易账单Response")
public class ShenQingJiaoYiZhangDanResponse{
    @Schema(title = "枚举值：")
    private String hash_type;
    @Schema(title = "原始账单（gzip需要解压缩）的摘要值，用于校验文件的完整性。")
    private String hash_value;
    @Schema(title = "供下一步请求账单文件的下载地址，该地址30s内有效。")
    private String download_url;
}

