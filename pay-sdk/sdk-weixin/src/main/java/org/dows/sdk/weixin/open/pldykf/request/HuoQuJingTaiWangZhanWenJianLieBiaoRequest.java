package org.dows.sdk.weixin.open.pldykf.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/staticstore-management/getStaticStoreFile.html
 *
 * @author lait.zhang@gmail.com
 * @description 获取静态网站文件列表
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "获取静态网站文件列表Request", title = "获取静态网站文件列表Request")
public class HuoQuJingTaiWangZhanWenJianLieBiaoRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "环境ID")
    private String env;
    @Schema(title = "前缀匹配，用来规定返回的文件前缀地址")
    private String prefix;
    @Schema(title = "定界符为一个符号，如果有 Prefix，则将 Prefix 到 delimiter 之间的相同路径归为一类，定义为 Common Prefix，然后列出所有 Common Prefix。如果没有 Prefix，则从路径起点开始")
    private String delimiter;
    @Schema(title = "默认以 UTF-8 二进制顺序列出条目，所有列出条目从marker开始")
    private String marker;
}

