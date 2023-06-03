package org.dows.sdk.weixin.bak.miniprogram.management.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/basic-info-management/setNickName.html
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月29日 上午11:32:00
 */
@Data
@Schema(name = "SetNickNameRequest", title = "SetNickNameRequest")
public class SetNickNameRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "昵称，不支持包含“小程序”关键字的昵称")
    private String nick_name;
    @Schema(title = "身份证照片 mediaid，个人号必填")
    private String id_card;
    @Schema(title = "组织机构代码证或营业执照 mediaid，组织号必填")
    private String license;
    @Schema(title = "其他证明材料 mediaid")
    private String naming_other_stuff_1;
    @Schema(title = "其他证明材料 mediaid")
    private String naming_other_stuff_2;
    @Schema(title = "其他证明材料 mediaid")
    private String naming_other_stuff_3;
    @Schema(title = "其他证明材料 mediaid")
    private String naming_other_stuff_4;
    @Schema(title = "其他证明材料 mediaid")
    private String naming_other_stuff_5;
}

