package org.dows.sdk.weixin.open.dsjglxcx.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/commit.html
 *
 * @author lait.zhang@gmail.com
 * @description 上传代码并生成体验版
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "上传代码并生成体验版Request", title = "上传代码并生成体验版Request")
public class ShangChuanDaiMaBingShengChengTiYanBanRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "代码库中的代码模板 ID，可通过getTemplateList接口获取代码模板template_id。注意，如果该模板id为标准模板库的模板id，则ext_json可支持的参数为：{'extAppid':' ', 'ext': {}, 'window': {}}")
    private Integer template_id;
    @Schema(title = "为了方便第三方平台的开发者引入 extAppid 的开发调试工作，引入")
    private String ext_json;
    @Schema(title = "代码版本号，开发者可自定义（长度不要超过 64 个字符）")
    private String user_version;
    @Schema(title = "代码描述，开发者可自定义")
    private String user_desc;
}

