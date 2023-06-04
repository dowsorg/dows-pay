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
public class SetCloudAccessTokenResponse{
    @Schema(title = "������")
    private Integer errcode;
    @Schema(title = "������Ϣ")
    private String errmsg;
    @Schema(title = "����/�رգ�action=getʱ����")
    private Boolean open;
    @Schema(title = "api��������action=getʱ����")
    private List<String> api_whitelist;
    @Schema(title = "�汾�ţ�action=getʱ����")
    private Integer version;

}
