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
public class UpdateDatabaseRecordResponse{
    @Schema(title = "������")
    private Integer errcode;
    @Schema(title = "������Ϣ")
    private String errmsg;
    @Schema(title = "��������ƥ�䵽�Ľ����")
    private Integer matched;
    @Schema(title = "�޸ĵļ�¼����ע�⣺ʹ��set�����²�������ݲ������޸���Ŀ")
    private Integer modified;
    @Schema(title = "�²����¼��id��ע�⣺ֻ��ʹ��set�����²�������ʱ����ֶλ���ֵ")
    private String id;

}
