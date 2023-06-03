package org.dows.sdk.weixin.open.wxytg.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudrun-batch/cloudenv-mgnt/createCloudbaseEnv.html
 *
 * @author lait.zhang@gmail.com
 * @description 创建云托管环境
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "创建云托管环境Request", title = "创建云托管环境Request")
public class ChuangJianYunTuoGuanHuanJingRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "环境别名，要以a-z开头，不能包含 a-z,0-9,- 以外的字符")
    private String alias;
    @Schema(title = "私有网络Id")
    private String vpc_id;
    @Schema(title = "子网列表")
    private List<String> sub_net_ids;
}

