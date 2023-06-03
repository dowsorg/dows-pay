package org.dows.sdk.weixin.open.dsjglxcx.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/we-analysis/weDataSetLoginConfig.html
 *
 * @author lait.zhang@gmail.com
 * @description 设置登录配置
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "设置登录配置Request", title = "设置登录配置Request")
public class SheZhiDengLuPeiZhiRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "1: 配置反查地址 ; 2:配置关联appid")
    private Integer set_type;
    @Schema(title = "反查地址，set_type =1时生效，若为空表示删除")
    private String recheck_url;
    @Schema(title = "关联appid，set_type=2时生效，若为空表示删除")
    private List<String> associate_appid;
}

