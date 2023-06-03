package org.dows.sdk.weixin.open.dsjzcxcx.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/register-management/fast-regist-beta/registerBetaMiniprogram.html
 *
 * @author lait.zhang@gmail.com
 * @description 注册试用小程序
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "注册试用小程序Request", title = "注册试用小程序Request")
public class ZhuCeShiYongXiaoChengXuRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "小程序名称，昵称半自动设定，强制后缀“的体验小程序”。且该参数会进行关键字检查，如果命中品牌关键字则会报错。 如遇到品牌大客户要用试用小程序，建议用户先换个名字，认证后再修改成品牌名。 只支持4-30个字符")
    private String name;
    @Schema(title = "微信用户的openid（不是微信号），试用小程序创建成功后会默认将该用户设置为小程序管理员。")
    private String openid;
}

