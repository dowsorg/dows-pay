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
public class ImportDatabaseItemRequest{
    @Schema(title = "�ӿڵ���ƾ֤���ò���Ϊ URL �������� Body ������ʹ��")
    private String access_token;
    @Schema(title = "�ƻ���ID")
    private String env;
    @Schema(title = "���� collection ��")
    private String collection_name;
    @Schema(title = "�����ļ�·��(�����ļ������ϴ���ͬ�����Ĵ洢�У���ʹ�ÿ����߹��߻� getUploadTcbFileLink�ӿ��ϴ���")
    private String file_path;
    @Schema(title = "�����ļ����͡�1��ʾJSON��2��ʾCSV")
    private Integer file_type;
    @Schema(title = "�Ƿ�����������ʱֹͣ����")
    private Boolean stop_on_error;
    @Schema(title = "��ͻ����ģʽ��1��ʾINSERT��2��ʾUPSERT��")
    private Integer conflict_mode;

}
