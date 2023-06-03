package org.dows.sdk.weixin.open.sqzhgl.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/authorization-management/getAuthorizerOptionInfo.html
 *
 * @author lait.zhang@gmail.com
 * @description 获取授权方选项信息
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "获取授权方选项信息Response", title = "获取授权方选项信息Response")
public class HuoQuShouQuanFangXuanXiangXinXiResponse {
    @Schema(title = "选项名称")
    private String option_name;
    @Schema(title = "选项值")
    private String option_value;
}

