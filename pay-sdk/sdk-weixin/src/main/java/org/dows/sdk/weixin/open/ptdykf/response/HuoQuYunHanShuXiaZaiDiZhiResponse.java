package org.dows.sdk.weixin.open.ptdykf.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/scf-management/getFuntionLink.html
 *
 * @author lait.zhang@gmail.com
 * @description 获取云函数下载地址
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "获取云函数下载地址Response", title = "获取云函数下载地址Response")
public class HuoQuYunHanShuXiaZaiDiZhiResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "下载地址")
    private String url;
    @Schema(title = "函数的SHA256编码")
    private String checksum;
}

