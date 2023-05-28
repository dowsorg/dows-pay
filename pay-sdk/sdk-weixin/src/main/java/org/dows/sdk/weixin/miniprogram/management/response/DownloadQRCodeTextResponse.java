package org.dows.sdk.weixin.miniprogram.management.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月28日 下午9:55:33
 */
@Data
@Schema(name = "DownloadQRCodeTextResponse", title = "DownloadQRCodeTextResponse")
public class DownloadQRCodeTextResponse {
    @Schema(title = "返回码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "文件名称")
    private String file_name;
    @Schema(title = "文件内容")
    private String file_content;
}

