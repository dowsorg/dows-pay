package org.dows.sdk.weixin.open.sqzhgl.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/authorization-management/setAuthorizerOptionInfo.html
 *
 * @author lait.zhang@gmail.com
 * @description 设置授权方选项信息
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "设置授权方选项信息Request", title = "设置授权方选项信息Request")
public class SheZhiShouQuanFangXuanXiangXinXiRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "选项名称")
    private String option_name;
    @Schema(title = "设置的选项值")
    private String option_value;
}

