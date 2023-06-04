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
public interface EnvManagementApi{
    /**
     * ͨ�����ӿڿ��Խ���Ѷ�ƿ���̨�����Ļ������Ϊ΢��С����Ļ�����ʹ�ù��������������⣬���ڷ�������
     * @param changeTcbEnvRequest
     */
    ChangeTcbEnvResponse changeTcbEnv(ChangeTcbEnvRequest changeTcbEnvRequest);
    /**
     * ͨ�����ӿڿ��Դ����ƻ�����ʹ�ù��������������⣬���ڷ�����������ע�⣬�ɰ��������ǰ�ӿڣ��뿪�����𲽽��нӿ��л���
     * @param createEnvRequest
     */
    CreateEnvResponse createEnv(CreateEnvRequest createEnvRequest);
    /**
     * ͨ�����ӿڿ��Ի�ȡ���е��ƻ�����Ϣ��ʹ�ù��������������⣬���ڷ���������
     * @param getEnvInfoRequest
     */
    GetEnvInfoResponse getEnvInfo(GetEnvInfoRequest getEnvInfoRequest);
    /**
     * ͨ�����ӿڿ��Ի�������ʹ�ù��������������⣬���ڷ���������
     * @param shareEnvRequest
     */
    ShareEnvResponse shareEnv(ShareEnvRequest shareEnvRequest);

}
