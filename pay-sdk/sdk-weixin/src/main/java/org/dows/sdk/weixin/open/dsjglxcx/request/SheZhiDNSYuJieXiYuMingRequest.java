package org.dows.sdk.weixin.open.dsjglxcx.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/domain-management/setPrefetchDomain.html
 *
 * @author lait.zhang@gmail.com
 * @description 设置DNS预解析域名
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "设置DNS预解析域名Request", title = "设置DNS预解析域名Request")
public class SheZhiDNSYuJieXiYuMingRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "预解析域名")
    private List<Object> prefetch_dns_domain;
}

