package org.dows.sdk.weixin.open.dsjglxcx.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/basic-info-management/getFetchdataSetting.html
 *
 * @author lait.zhang@gmail.com
 * @description 数据预拉取和数据周期性更新
 * @date 2023年6月3日 上午10:27:31
 */
@Data
@Schema(name = "数据预拉取和数据周期性更新Response", title = "数据预拉取和数据周期性更新Response")
public class ShuJuYuLaQuHeShuJuZhouQiXingGengXinResponse {
    @Schema(title = "返回码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "数据预拉取是否开启")
    private Boolean is_pre_fetch_open;
    @Schema(title = "数据来源，0: 开发者服务器；1：云函数")
    private Integer pre_fetch_type;
    @Schema(title = "数据下载地址，当pre_fetch_type=0有效")
    private String pre_fetch_url;
    @Schema(title = "环境ID，当pre_fetch_type=1有效")
    private String pre_env;
    @Schema(title = "函数名，当pre_fetch_type=1有效")
    private String pre_function_name;
    @Schema(title = "数据周期性更新是否开启")
    private Boolean is_period_fetch_open;
    @Schema(title = "0: 开发者服务器；1：云函数")
    private Integer period_fetch_type;
    @Schema(title = "数据下载地址当period_fetch_type=0有效")
    private String period_fetch_url;
    @Schema(title = "环境ID，当period_fetch_type=1有效")
    private String period_env;
    @Schema(title = "函数名，当period_fetch_type=1有效")
    private String period_function_name;
}

