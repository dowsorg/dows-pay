package org.dows.sdk.weixin.open.dsjglxcx.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/domain-management/getJumpDomainConfirmFile.html
 *
 * @author lait.zhang@gmail.com
 * @description 获取业务域名校验文件
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "获取业务域名校验文件Response", title = "获取业务域名校验文件Response")
public class HuoQuYeWuYuMingXiaoYanWenJianResponse {
    @Schema(title = "返回码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "文件名")
    private String file_name;
    @Schema(title = "文件内容")
    private String file_content;
}

