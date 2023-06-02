package org.dows.sdk.weixin.open.sqzhgl.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;
/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/authorization-management/getAuthorizerOptionInfo.html
 * @description 获取授权方选项信息
 * @author lait.zhang@gmail.com
 * @date 2023年6月2日 下午4:54:46
 */
@Data
@Schema(name = "获取授权方选项信息Response", title = "获取授权方选项信息Response")
public class HuoQuShouQuanFangXuanXiangXinXiResponse{
    @Schema(title = "选项名称")
    private String option_name;
    @Schema(title = "选项值")
    private String option_value;
}

