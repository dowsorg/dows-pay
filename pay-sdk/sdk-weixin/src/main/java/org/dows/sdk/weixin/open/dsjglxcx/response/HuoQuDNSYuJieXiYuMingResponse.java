package org.dows.sdk.weixin.open.dsjglxcx.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/domain-management/getPrefetchDomain.html
 *
 * @author lait.zhang@gmail.com
 * @description 获取DNS预解析域名
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "获取DNS预解析域名Response", title = "获取DNS预解析域名Response")
public class HuoQuDNSYuJieXiYuMingResponse {
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "预解析dns域名")
    private List<Object> prefetch_dns_domain;
    @Schema(title = "总共可配置域名个数")
    private Integer size_limit;
}

