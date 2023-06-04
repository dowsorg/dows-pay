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
public class SetCloudAccessTokenRequest{
    @Schema(title = "�ӿڵ���ƾ֤���ò���Ϊ URL �������� Body ������ʹ��")
    private String access_token;
    @Schema(title = "��ѡget����set")
    private String action;
    @Schema(title = "true��ʾ������false��ʾ�رա�ȫ�����ã�action=setʱ���")
    private Boolean open;
    @Schema(title = "api��������action=setʱ���")
    private List<String> api_whitelist;
    @Schema(title = "���� id , ������Ϊ����ά������")
    private String env;
    @Schema(title = "�汾�ţ�action=setʱ����")
    private Integer version;

}
