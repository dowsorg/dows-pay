package org.dows.sdk.weixin.open.dsfptgl.request;

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
@Schema(name = "将草稿添加到模板库Request", title = "将草稿添加到模板库Request")
public class JiangCaoGaoTianJiaDaoMoBanKuRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "草稿 ID")
    private Integer draft_id;
    @Schema(title = "默认值是0，对应普通模板；可选1，对应标准模板库，关于标准模板库和普通模板库的区别可以查看")
    private Integer template_type;
}

