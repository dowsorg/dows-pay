package org.dows.sdk.weixin.cloudbase.common;

/**
 * 
 */
public interface msgPush{

    /**
     * 通过本接口可以上传消息推送配置。使用过程中如遇到问题，可在发帖交流。
     * https://api.weixin.qq.com/tcb/setcallbackconfig?access_token=ACCESS_TOKEN
     * 
     * @param setCallBackConfigRequest
     * 
     */
    SetCallBackConfigResponse setCallBackConfig(SetCallBackConfigRequest setCallBackConfigRequest);

    /**
     * 通过本接口可以获取消息推送配置。使用过程中如遇到问题，可在发帖交流。
     * https://api.weixin.qq.com/tcb/getcallbackconfig?access_token=ACCESS_TOKEN
     * 
     * @param getCallBackConfigRequest
     * 
     */
    GetCallBackConfigResponse getCallBackConfig(GetCallBackConfigRequest getCallBackConfigRequest);
}