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
public interface AdminManagementApi{
    /**
     * ͨ�����ӿڿ��Կ�����ر�cloudbase_access_token��ʹ��Ȩ�ޣ�ʹ�ù��������������⣬���ڷ���������
     * @param setCloudAccessTokenRequest
     */
    SetCloudAccessTokenResponse setCloudAccessToken(SetCloudAccessTokenRequest setCloudAccessTokenRequest);
    /**
     * ͨ�����ӿڿ��Կ�ͨ�ƿ�����ʹ�ù��������������⣬���ڷ���������
     * @param createCloudUserRequest
     */
    CreateCloudUserResponse createCloudUser(CreateCloudUserRequest createCloudUserRequest);
    /**
     * 1���ýӿ���Ƶ������: 10��ÿСʱ��2����Ѷ�� API ����˵��
     * @param getCloudTokenRequest
     */
    GetCloudTokenResponse getCloudToken(GetCloudTokenRequest getCloudTokenRequest);
    /**
     * ͨ�����ӿڿ��Բ�ѯС�����Ƿ�����ֻ��ţ���֧������ģ����Ϣ��С�������Ա�ռ��ֻ��š�ʹ�ù��������������⣬���ڷ���������
     * @param checkMobileConfigRequest
     */
    CheckMobileConfigResponse checkMobileConfig(CheckMobileConfigRequest checkMobileConfigRequest);

}
