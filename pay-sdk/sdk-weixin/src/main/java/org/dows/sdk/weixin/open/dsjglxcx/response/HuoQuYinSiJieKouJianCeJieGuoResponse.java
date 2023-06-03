package org.dows.sdk.weixin.open.dsjglxcx.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/getCodePrivacyInfo.html
 *
 * @author lait.zhang@gmail.com
 * @description 获取隐私接口检测结果
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "获取隐私接口检测结果Response", title = "获取隐私接口检测结果Response")
public class HuoQuYinSiJieKouJianCeJieGuoResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "没权限的隐私接口的api英文名")
    private List<String> without_auth_list;
    @Schema(title = "没配置的隐私接口的api英文名")
    private List<String> without_conf_list;
}

