package org.dows.sdk.weixin.miniprogram.management.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * @author
 * @description
 * @date 2023年5月28日 下午9:25:34
 * @date
 */
@Data
public class ModifyJumpDomainDirectlyResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "业务域名")
    private List<String> webviewdomain;
}

