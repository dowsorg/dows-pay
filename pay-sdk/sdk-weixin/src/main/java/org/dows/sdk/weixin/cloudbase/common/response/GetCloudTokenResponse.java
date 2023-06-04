package org.dows.sdk.weixin.cloudbase.common.response;

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
@NoArgsConstructor
public class GetCloudTokenResponse{
    @Schema(title = "������")
    private Integer errcode;
    @Schema(title = "������Ϣ")
    private String errmsg;
    @Schema(title = "secretid")
    private String secretid;
    @Schema(title = "secretkey")
    private String secretkey;
    @Schema(title = "token")
    private String token;
    @Schema(title = "����ʱ���")
    private Integer expired_time;

}
