package org.dows.sdk.weixin.ams.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;

/**
 *
 * @description 
 * @author @author lait.zhang@gmail.com
 * @date 2023年5月28日 下午9:55:33
 */
@Data
@Schema(name = "SetCoverAdposStatusRequest", title = "SetCoverAdposStatusRequest")
public class SetCoverAdposStatusRequest{
    @Schema(title = "开关状态：1开启，4关闭")
    private Integer status;
}

