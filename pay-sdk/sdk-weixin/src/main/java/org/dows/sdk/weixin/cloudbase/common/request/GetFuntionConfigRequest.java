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
public class GetFuntionConfigRequest{
    @Schema(title = "�ӿڵ���ƾ֤���ò���Ϊ URL �������� Body ������ʹ��")
    private String access_token;
    @Schema(title = "��������")
    private Integer type;
    @Schema(title = "����id")
    private String env;
    @Schema(title = "�ƺ�����")
    private String function_name;

}
