package org.dows.sdk.weixin.cloudbase.common;

import org.dows.sdk.weixin.cloudbase.common.request.GetCallBackConfigRequest;
import org.dows.sdk.weixin.cloudbase.common.request.SetCallBackConfigRequest;
import org.dows.sdk.weixin.cloudbase.common.response.GetCallBackConfigResponse;
import org.dows.sdk.weixin.cloudbase.common.response.SetCallBackConfigResponse;

/**
 * @author
 * @description 调用方式以及出入参和HTTPS相同，仅是调用的token不同该接口所属的权限集id为：49、64服务商获得其中之一权限集授权后，可通过使用代商家进行调用
 * @date
 */
public interface MsgPushApi {
    /**
     * 通过本接口可以上传消息推送配置。使用过程中如遇到问题，可在发帖交流。
     *
     * @param setCallBackConfigRequest
     */
    SetCallBackConfigResponse setCallBackConfig(SetCallBackConfigRequest setCallBackConfigRequest);

    /**
     * 通过本接口可以获取消息推送配置。使用过程中如遇到问题，可在发帖交流。
     *
     * @param getCallBackConfigRequest
     */
    GetCallBackConfigResponse getCallBackConfig(GetCallBackConfigRequest getCallBackConfigRequest);


}
