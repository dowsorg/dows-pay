package org.dows.sdk.weixin.bak.miniprogram.management.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/basic-info-management/getFetchdataSetting.html
 *
 * @author lait.zhang@gmail.com
 * @description
 * @date 2023年5月29日 上午11:32:00
 */
@Data
@Schema(name = "GetFetchdataSettingRequest", title = "GetFetchdataSettingRequest")
public class GetFetchdataSettingRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "可填'get'、“ set_pre_fetch”、'set_period_fetch'")
    private String action;
    @Schema(title = "数据预拉取是否开启，action=set_pre_fetch时，必填")
    private Boolean is_pre_fetch_open;
    @Schema(title = "数据来源，0: 开发者服务器；1：云函数。action=set_pre_fetch时，必填")
    private Integer pre_fetch_type;
    @Schema(title = "数据下载地址，当pre_fetch_type=0必填。")
    private String pre_fetch_url;
    @Schema(title = "环境ID，当pre_fetch_type=1必填")
    private String pre_env;
    @Schema(title = "函数名，当pre_fetch_type=1必填")
    private String pre_function_name;
    @Schema(title = "周期性拉取数据是否开启，true开启，false关闭。action= set_period_fetch时，必填")
    private Boolean is_period_fetch_open;
    @Schema(title = "数据来源，0: 开发者服务器；1：云函数。action= set_period_fetch时，必填")
    private Integer period_fetch_type;
    @Schema(title = "数据下载地址，当period_fetch_type=0必填")
    private String period_fetch_url;
    @Schema(title = "环境ID，当period_fetch_type=1必填")
    private String period_env;
    @Schema(title = "函数名，当period_fetch_type=1必填")
    private String period_function_name;
}

