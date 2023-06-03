package org.dows.sdk.weixin.open.sqzhgl.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/authorization-management/getAuthorizerList.html
 *
 * @author lait.zhang@gmail.com
 * @description 拉取已授权的帐号信息
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "拉取已授权的帐号信息Request", title = "拉取已授权的帐号信息Request")
public class LaQuYiShouQuanDeZhangHaoXinXiRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "第三方平台 APPID")
    private String component_appid;
    @Schema(title = "偏移位置/起始位置")
    private Integer offset;
    @Schema(title = "拉取数量，最大为 500")
    private Integer count;
}

