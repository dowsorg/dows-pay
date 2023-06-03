package org.dows.sdk.weixin.open.dsjglgzh.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/officalaccount-management/link-miniprogram/linkMiniprogram.html
 *
 * @author lait.zhang@gmail.com
 * @description 公众号关联小程序
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "公众号关联小程序Request", title = "公众号关联小程序Request")
public class GongZhongHaoGuanLianXiaoChengXuRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "小程序 appid")
    private String appid;
    @Schema(title = "是否发送模板消息通知公众号粉丝。1表示是，0表示否。")
    private Integer notify_users;
    @Schema(title = "是否展示公众号主页中。1表示是，0表示否。")
    private Integer show_profile;
}

