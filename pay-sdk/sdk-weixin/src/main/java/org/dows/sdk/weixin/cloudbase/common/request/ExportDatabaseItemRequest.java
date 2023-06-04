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
public class ExportDatabaseItemRequest{
    @Schema(title = "�ӿڵ���ƾ֤���ò���Ϊ URL �������� Body ������ʹ��")
    private String access_token;
    @Schema(title = "�ƻ���ID")
    private String env;
    @Schema(title = "�����ļ�·�����ļ��ᵼ�����������ƴ洢�У���ʹ��getDownloadTcbFileLink�ӿڻ�ȡ�������ӣ�")
    private String file_path;
    @Schema(title = "�����ļ����ͣ��ļ���ʽ�ο�importDatabaseItem�ӿڵ��ļ���ʽ����")
    private Integer file_type;
    @Schema(title = "��������")
    private String query;

}
