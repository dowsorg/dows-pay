package org.dows.sdk.weixin.open.dsjglxcx.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/we-analysis/weDataSetUserPerm.html
 *
 * @author lait.zhang@gmail.com
 * @description 设置用户We分析权限集
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "设置用户We分析权限集Request", title = "设置用户We分析权限集Request")
public class SheZhiYongHuWeFenXiQuanXianJiRequest {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
}

