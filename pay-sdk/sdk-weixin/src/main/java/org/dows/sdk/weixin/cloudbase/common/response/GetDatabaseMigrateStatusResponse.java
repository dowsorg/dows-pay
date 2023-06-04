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
public class GetDatabaseMigrateStatusResponse{
    @Schema(title = "������")
    private Integer errcode;
    @Schema(title = "������Ϣ")
    private String errmsg;
    @Schema(title = "����״̬")
    private String status;
    @Schema(title = "�����ɹ���¼��")
    private Integer record_success;
    @Schema(title = "����ʧ�ܼ�¼��")
    private Integer record_fail;
    @Schema(title = "����������Ϣ")
    private String error_msg;
    @Schema(title = "�����ļ����ص�ַ")
    private String file_url;

}
