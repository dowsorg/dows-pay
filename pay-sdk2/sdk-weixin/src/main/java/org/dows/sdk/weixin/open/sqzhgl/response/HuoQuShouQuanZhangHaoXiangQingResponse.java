package org.dows.sdk.weixin.open1.sqzhgl.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;
/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/authorization-management/getAuthorizerInfo.html
 * @description 获取授权帐号详情
 * @author lait.zhang@gmail.com
 * @date 2023年6月2日 下午4:54:46
 */
@Data
@Schema(name = "获取授权帐号详情Response", title = "获取授权帐号详情Response")
public class HuoQuShouQuanZhangHaoXiangQingResponse{
    @Schema(title = "订阅号")
    private 0 ;
    @Schema(title = "由历史老帐号升级后的订阅号")
    private 1 ;
    @Schema(title = "服务号")
    private 2 ;
}

