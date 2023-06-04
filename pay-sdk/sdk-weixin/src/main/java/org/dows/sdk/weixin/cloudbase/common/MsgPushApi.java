package org.dows.sdk.weixin.cloudbase.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;

/**
* @description ���÷�ʽ�Լ�����κ�HTTPS��ͬ�����ǵ��õ�token��ͬ�ýӿ�������Ȩ�޼�idΪ��49��64�����̻������֮һȨ�޼���Ȩ�󣬿�ͨ��ʹ�ô��̼ҽ��е���
*
* @author 
* @date 
*/
public interface MsgPushApi{
    /**
     * ͨ�����ӿڿ����ϴ���Ϣ�������á�ʹ�ù��������������⣬���ڷ���������
     * @param setCallBackConfigRequest
     */
    SetCallBackConfigResponse setCallBackConfig(SetCallBackConfigRequest setCallBackConfigRequest);
    /**
     * ͨ�����ӿڿ��Ի�ȡ��Ϣ�������á�ʹ�ù��������������⣬���ڷ���������
     * @param getCallBackConfigRequest
     */
    GetCallBackConfigResponse getCallBackConfig(GetCallBackConfigRequest getCallBackConfigRequest);

}
