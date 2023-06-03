package org.dows.sdk.weixin.open1.sqzhgl.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;
/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/authorization-management/getAuthorizerList.html
 * @description 拉取已授权的帐号信息
 * @author lait.zhang@gmail.com
 * @date 2023年6月2日 下午4:54:46
 */
@Data
@Schema(name = "拉取已授权的帐号信息Request", title = "拉取已授权的帐号信息Request")
public class LaQuYiShouQuanDeZhangHaoXinXiRequest{
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "第三方平台 APPID")
    private String component_appid;
    @Schema(title = "偏移位置/起始位置")
    private Integer offset;
    @Schema(title = "拉取数量，最大为 500")
    private Integer count;
}

