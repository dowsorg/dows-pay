package org.dows.sdk.weixin.cloudbase.common.request;

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
public class DbcollectionManageRequest{
    @Schema(title = "")
    private String access_token;
    @Schema(title = "��'get'")
    private String action;
    @Schema(title = "����ID")
    private String env;
    @Schema(title = "�������ݳ���")
    private Integer limit;
    @Schema(title = "����ƫ����")
    private Integer offset;

}
