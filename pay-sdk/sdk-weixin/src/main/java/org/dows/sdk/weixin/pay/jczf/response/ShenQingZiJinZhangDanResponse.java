package org.dows.sdk.weixin.pay.jczf.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter5_1_18.shtml
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年6月3日 上午10:38:51
 */
@Data
@Schema(name = "申请资金账单Response", title = "申请资金账单Response")
public class ShenQingZiJinZhangDanResponse {
    @Schema(title = "枚举值：")
    private String hash_type;
    @Schema(title = "原始账单（gzip需要解压缩）的摘要值，用于校验文件的完整性。")
    private String hash_value;
    @Schema(title = "供下一步请求账单文件的下载地址，该地址30s内有效。")
    private String download_url;
}

