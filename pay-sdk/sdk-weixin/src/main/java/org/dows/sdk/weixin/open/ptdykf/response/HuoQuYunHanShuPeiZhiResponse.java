package org.dows.sdk.weixin.open.ptdykf.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/scf-management/getFuntionConfig.html
 *
 * @author lait.zhang@gmail.com
 * @description 获取云函数配置
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "获取云函数配置Response", title = "获取云函数配置Response")
public class HuoQuYunHanShuPeiZhiResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "配置的json字符串")
    private String config;
}

