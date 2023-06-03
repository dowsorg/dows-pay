package org.dows.sdk.weixin.bak.miniprogram.management.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/domain-management/modifyServerDomain.html
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月29日 上午11:32:00
 */
@Data
@Schema(name = "ModifyServerDomainRequest", title = "ModifyServerDomainRequest")
public class ModifyServerDomainRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "操作类型")
    private String action;
    @Schema(title = "request 合法域名；当 action 是 get 时不需要此字段")
    private List<String> requestdomain;
    @Schema(title = "socket 合法域名；当 action 是 get 时不需要此字段")
    private List<String> wsrequestdomain;
    @Schema(title = "uploadFile 合法域名；当 action 是 get 时不需要此字段")
    private List<String> uploaddomain;
    @Schema(title = "downloadFile 合法域名；当 action 是 get 时不需要此字段")
    private List<String> downloaddomain;
    @Schema(title = "udp 合法域名；当 action 是 get 时不需要此字段")
    private List<String> udpdomain;
    @Schema(title = "tcp 合法域名；当 action 是 get 时不需要此字段")
    private List<String> tcpdomain;
}

