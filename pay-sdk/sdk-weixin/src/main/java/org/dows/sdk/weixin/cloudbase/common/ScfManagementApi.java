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
public interface ScfManagementApi{
    /**
     * ͨ�����ӿڿ��Դ����ƺ����� ʹ�ù��������������⣬���ڷ�������
     * @param invokeCloudFunctionRequest
     */
    InvokeCloudFunctionResponse invokeCloudFunction(InvokeCloudFunctionRequest invokeCloudFunctionRequest);
    /**
     * ͨ�����ӿڿ��Դ����ƺ�����ʹ�ù��������������⣬���ڷ���������
     * @param createFunctionRequest
     */
    CreateFunctionResponse createFunction(CreateFunctionRequest createFunctionRequest);
    /**
     * ͨ�����ӿڿ��Ի�ȡ���뱣����Կ��ʹ�ù��������������⣬���ڷ���������
     * @param getCodeSecretRequest
     */
    GetCodeSecretResponse getCodeSecret(GetCodeSecretRequest getCodeSecretRequest);
    /**
     * ͨ�����ӿڿ��Ի�ȡ�ϴ��ƺ���ǩ��header ��ʹ�ù��������������⣬���ڷ���������hashed_payload������POST���ݵ�ǩ������������ο������������ǩ�����̲ο�����JavaScript����Ƭ�Σ�
     * @param getYploadSignatureRequest
     */
    GetYploadSignatureResponse getYploadSignature(GetYploadSignatureRequest getYploadSignatureRequest);
    /**
     * ͨ�����ӿڿ��Ի�ȡ�ƺ����б�ʹ�ù��������������⣬���ڷ���������
     * @param getFuntionListRequest
     */
    GetFuntionListResponse getFuntionList(GetFuntionListRequest getFuntionListRequest);
    /**
     * ͨ�����ӿڿ��Ի�ȡ�ƺ������ص�ַ��ʹ�ù��������������⣬���ڷ���������
     * @param getFuntionLinkRequest
     */
    GetFuntionLinkResponse getFuntionLink(GetFuntionLinkRequest getFuntionLinkRequest);
    /**
     * ͨ�����ӿڿ����ϴ��ƺ������á�ʹ�ù��������������⣬���ڷ���������
     * @param getUploadFuntionConfigRequest
     */
    GetUploadFuntionConfigResponse getUploadFuntionConfig(GetUploadFuntionConfigRequest getUploadFuntionConfigRequest);
    /**
     * ͨ�����ӿڿ��Ի�ȡ�ƺ������á�ʹ�ù��������������⣬���ڷ���������
     * @param getFuntionConfigRequest
     */
    GetFuntionConfigResponse getFuntionConfig(GetFuntionConfigRequest getFuntionConfigRequest);

}
