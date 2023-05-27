package org.dows.sdk.weixin.cloudbase.common.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author
 * @description
 * @date
 */
@Data
@NoArgsConstructor
public class GetFuntionLinkResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "下载地址")
    private String url;
    @Schema(title = "函数的SHA256编码")
    private String checksum;

}
