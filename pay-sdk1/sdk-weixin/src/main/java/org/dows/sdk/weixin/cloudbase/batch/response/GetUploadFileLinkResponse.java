package org.dows.sdk.weixin.cloudbase.batch.response;

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
public class GetUploadFileLinkResponse{
    @Schema(title = "错误码")
    private Integer errcode;
    @Schema(title = "错误信息")
    private String errmsg;
    @Schema(title = "上传url")
    private String url;
    @Schema(title = "token")
    private String token;
    @Schema(title = "authorization")
    private String authorization;
    @Schema(title = "文件ID")
    private String file_id;
}

