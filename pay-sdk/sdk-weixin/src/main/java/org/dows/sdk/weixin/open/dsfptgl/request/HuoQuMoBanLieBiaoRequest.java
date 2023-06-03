package org.dows.sdk.weixin.open.dsfptgl.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/thirdparty-management/template-management/getTemplateList.html
 *
 * @author lait.zhang@gmail.com
 * @description 获取模板列表
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "获取模板列表Request", title = "获取模板列表Request")
public class HuoQuMoBanLieBiaoRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "可选是0（对应普通模板）和1（对应标准模板），如果不填，则返回全部的。关于标准模板和普通模板的区别可查看")
    private Integer template_type;
}

