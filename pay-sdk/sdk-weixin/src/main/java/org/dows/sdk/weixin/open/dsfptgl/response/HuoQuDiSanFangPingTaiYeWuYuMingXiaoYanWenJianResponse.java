package org.dows.sdk.weixin.open.dsfptgl.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/thirdparty-management/domain-mgnt/getThirdpartyJumpDomainConfirmFile.html
 *
 * @author lait.zhang@gmail.com
 * @description 获取第三方平台业务域名校验文件
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "获取第三方平台业务域名校验文件Response", title = "获取第三方平台业务域名校验文件Response")
public class HuoQuDiSanFangPingTaiYeWuYuMingXiaoYanWenJianResponse {
    @Schema(title = "返回码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "文件名")
    private String file_name;
    @Schema(title = "文件内容")
    private String file_content;
}

