package org.dows.sdk.weixin.open.sqzhgl.response;

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
@Schema(name = "设置授权方选项信息Response", title = "设置授权方选项信息Response")
public class SheZhiShouQuanFangXuanXiangXinXiResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
}

