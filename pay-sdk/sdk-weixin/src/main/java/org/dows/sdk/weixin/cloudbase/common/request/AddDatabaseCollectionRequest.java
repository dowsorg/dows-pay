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
public class AddDatabaseCollectionRequest{
    @Schema(title = "�ӿڵ���ƾ֤���ò���Ϊ URL �������� Body ������ʹ��")
    private String access_token;
    @Schema(title = "�ƻ���ID")
    private String env;
    @Schema(title = "��������")
    private String collection_name;

}
