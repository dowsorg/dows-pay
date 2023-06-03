package org.dows.sdk.weixin.open.dsjglxcx.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/jumpqrcode-config/downloadQRCodeText.html
 *
 * @author lait.zhang@gmail.com
 * @description 获取校验文件名称及内容
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "获取校验文件名称及内容Response", title = "获取校验文件名称及内容Response")
public class HuoQuXiaoYanWenJianMingChengJiNeiRongResponse {
    @Schema(title = "返回码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "文件名称")
    private String file_name;
    @Schema(title = "文件内容")
    private String file_content;
}

