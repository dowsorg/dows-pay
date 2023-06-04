package org.dows.sdk.weixin.cloudbase.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;

/**
* @description ���÷�ʽ�Լ�����κ�HTTPS��ͬ�����ǵ��õ�token��ͬ�ýӿ�������Ȩ�޼�idΪ��49��64��102�����̻������֮һȨ�޼���Ȩ�󣬿�ͨ��ʹ�ô��̼ҽ��е���
*
* @author 
* @date 
*/
public interface WechatpayApi{
    /**
     * ͨ�����ӿڿ��Բ�ѯ��Ȩ�󶨵��̻����б�ʹ�ù��������������⣬���ڷ���������˵����С��������Ȩ���ƿ���Ȩ�޼������ƿ���΢��֧��Ȩ�޼��������������������ſ��Դ�С������ô˽ӿڡ�
     * @param getWechatPayListRequest
     */
    GetWechatPayListResponse getWechatPayList(GetWechatPayListRequest getWechatPayListRequest);
    /**
     * ͨ�����ӿڿ��������̻�����Ȩ��ʹ�ù��������������⣬���ڷ���������1���ʺŰ󶨣��̻��ŵĳ�������Ա��Ҫ��΢��֧���ṩ�ġ�΢��֧���̼����֡�С������ȷ����Ȩ��2��jsapi �� api �˿�Ȩ�ޣ���Ҫǰ��΢��֧���̻�ƽ̨�ҵ���Ȩ��Ʒ�н���ȷ����Ȩ��
     * @param getWechatPayAuthRequest
     */
    GetWechatPayAuthResponse getWechatPayAuth(GetWechatPayAuthRequest getWechatPayAuthRequest);

}
