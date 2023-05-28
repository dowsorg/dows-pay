package org.dows.sdk.weixin.miniprogram.management.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;

/**
* @description 
*
* @author 
* @date 
*/
@Data
public class GetShowItemResponse{
    @Schema(title = "返回码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "是否可以设置 1 可以，0，不可以")
    private Integer can_open;
    @Schema(title = "是否已经设置，1 已设置，0，未设置")
    private Integer is_open;
    @Schema(title = "展示的公众号 appid")
    private String appid;
    @Schema(title = "展示的公众号 nickname")
    private String nickname;
    @Schema(title = "展示的公众号头像")
    private String headimg;
}

