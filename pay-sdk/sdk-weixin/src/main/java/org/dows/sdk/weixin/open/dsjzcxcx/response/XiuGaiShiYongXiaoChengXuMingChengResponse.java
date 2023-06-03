package org.dows.sdk.weixin.open.dsjzcxcx.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/register-management/fast-regist-beta/modifyBetaMiniprogramNickName.html
 *
 * @author lait.zhang@gmail.com
 * @description 修改试用小程序名称
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "修改试用小程序名称Response", title = "修改试用小程序名称Response")
public class XiuGaiShiYongXiaoChengXuMingChengResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
}

