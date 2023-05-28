package org.dows.sdk.weixin.officalaccount.management.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月28日 下午9:55:33
 */
@Data
@Schema(name = "LinkMiniprogramRequest", title = "LinkMiniprogramRequest")
public class LinkMiniprogramRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "小程序 appid")
    private String appid;
    @Schema(title = "是否发送模板消息通知公众号粉丝。1表示是，0表示否。")
    private Integer notify_users;
    @Schema(title = "是否展示公众号主页中。1表示是，0表示否。")
    private Integer show_profile;
}

