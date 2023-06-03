package org.dows.sdk.weixin.open.dsfptgl.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/thirdparty-management/template-management/addToTemplate.html
 *
 * @author lait.zhang@gmail.com
 * @description 将草稿添加到模板库
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "将草稿添加到模板库Response", title = "将草稿添加到模板库Response")
public class JiangCaoGaoTianJiaDaoMoBanKuResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
}

