package org.dows.sdk.weixin.bak.officalaccount.management.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/officalaccount-management/qrcode-config/addJumpQRCode.html
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月29日 上午11:32:00
 */
@Data
@Schema(name = "AddJumpQRCodeRequest", title = "AddJumpQRCodeRequest")
public class AddJumpQRCodeRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "编辑标志位，0 表示新增二维码规则，1 表示修改已有二维码规则。")
    private Integer is_edit;
    @Schema(title = "二维码规则。")
    private String prefix;
    @Schema(title = "小程序功能页面。")
    private String path;
    @Schema(title = "测试范围。")
    private Integer open_version;
    @Schema(title = "测试链接，至多 5 个用于测试的二维码完整链接，此链接必须符合已填写的二维码规则。")
    private List<String> debug_url;
    @Schema(title = "是否独占符合二维码前缀匹配规则的所有子规 1 为不占用，2 为占用。")
    private Integer permit_sub_rule;
    @Schema(title = "扫了服务号二维码之后要跳转的小程序的appid。增加或修改“扫服务号二维码打开小程序”的二维码规则才需要传这个参数。")
    private String appid;
}

