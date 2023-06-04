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
public class GetUploadTcbFileLinkResponse{
    @Schema(title = "������")
    private Integer errcode;
    @Schema(title = "������Ϣ")
    private String errmsg;
    @Schema(title = "�ϴ�url")
    private String url;
    @Schema(title = "token")
    private String token;
    @Schema(title = "authorization")
    private String authorization;
    @Schema(title = "�ļ�ID")
    private String file_id;
    @Schema(title = "cos�ļ�ID")
    private String cos_file_id;

}
