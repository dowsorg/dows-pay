package org.dows.sdk.weixin.miniprogram.management.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author
 * @description
 * @date
 */
@Data
@NoArgsConstructor
public class GetFetchdataSettingRequest {
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;

    @Schema(title = "可填"get"、“ set_pre_fetch”、"set_period_fetch"")
    private String action;

    @Schema(title = "数据预拉取是否开启，action=set_pre_fetch时，必填")
    private Boolean is_pre_fetch_open;

    @Schema(title = "数据来源，0: 开发者服务器；1：云函数。action=set_pre_fetch时，必填")
    private Number pre_fetch_type;

    @Schema(title = "数据下载地址，当pre_fetch_type=0必填。")
    private String pre_fetch_url;

    @Schema(title = "")
    private 说明，1、需要将域名先添加到第三方平台的业务域名；2、然后将该域名添加到小程序业务域名；才可以成功设置;

    @Schema(title = "环境ID，当pre_fetch_type=1必填")
    private String pre_env;

    @Schema(title = "函数名，当pre_fetch_type=1必填")
    private String pre_function_name;

    @Schema(title = "周期性拉取数据是否开启，true开启，false关闭。action= set_period_fetch时，必填")
    private Boolean is_period_fetch_open;

    @Schema(title = "数据来源，0: 开发者服务器；1：云函数。action= set_period_fetch时，必填")
    private Number period_fetch_type;

    @Schema(title = "数据下载地址，当period_fetch_type=0必填")
    private String period_fetch_url;

    @Schema(title = "")
    private  1、需要将域名先添加到第三方平台的业务域名；2、然后将该域名添加到小程序业务域名；才可以成功设置;

    @Schema(title = "环境ID，当period_fetch_type=1必填")
    private String period_env;

    @Schema(title = "函数名，当period_fetch_type=1必填")
    private String period_function_name;


}
