package org.dows.sdk.weixin.bak.miniprogram.management.response;

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
@Schema(name = "ModifyServerDomainResponse", title = "ModifyServerDomainResponse")
public class ModifyServerDomainResponse {
    @Schema(title = "返回码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "request 合法域名")
    private List<String> requestdomain;
    @Schema(title = "socket 合法域名")
    private List<String> wsrequestdomain;
    @Schema(title = "uploadFile 合法域名")
    private List<String> uploaddomain;
    @Schema(title = "downloadFile 合法域名")
    private List<String> downloaddomain;
    @Schema(title = "udp 合法域名")
    private List<String> udpdomain;
    @Schema(title = "tcp 合法域名")
    private List<String> tcpdomain;
    @Schema(title = "request 不合法域名")
    private List<String> invalid_requestdomain;
    @Schema(title = "socket 不合法域名")
    private List<String> invalid_wsrequestdomain;
    @Schema(title = "uploadFile 不合法域名")
    private List<String> invalid_uploaddomain;
    @Schema(title = "downloadFile 不合法域名")
    private List<String> invalid_downloaddomain;
    @Schema(title = "udp 不合法域名")
    private List<String> invalid_udpdomain;
    @Schema(title = "tcp 不合法域名")
    private List<String> invalid_tcpdomain;
    @Schema(title = "没有经过icp备案的域名")
    private List<String> no_icp_domain;
}

