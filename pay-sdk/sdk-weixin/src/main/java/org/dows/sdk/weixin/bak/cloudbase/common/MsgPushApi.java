package org.dows.sdk.weixin.bak.cloudbase.common;

import org.dows.sdk.weixin.bak.cloudbase.common.request.GetCallBackConfigRequest;
import org.dows.sdk.weixin.bak.cloudbase.common.request.SetCallBackConfigRequest;
import org.dows.sdk.weixin.bak.cloudbase.common.response.GetCallBackConfigResponse;
import org.dows.sdk.weixin.bak.cloudbase.common.response.SetCallBackConfigResponse;

/**
 * @author lait.zhang@gmail.com
 * @description msgPushApi
 * @date 2023年5月29日 上午11:32:00
 */
public interface MsgPushApi {

    /**
     * description: 通过本接口可以上传消息推送配置。使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/msg-push/setCallBackConfig.html
     * api: https://api.weixin.qq.com/tcb/setcallbackconfig?access_token=ACCESS_TOKEN
     *
     * @param setCallBackConfigRequest
     */
    SetCallBackConfigResponse setCallBackConfig(SetCallBackConfigRequest setCallBackConfigRequest);

    /**
     * description: 通过本接口可以获取消息推送配置。使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/msg-push/getCallBackConfig.html
     * api: https://api.weixin.qq.com/tcb/getcallbackconfig?access_token=ACCESS_TOKEN
     *
     * @param getCallBackConfigRequest
     */
    GetCallBackConfigResponse getCallBackConfig(GetCallBackConfigRequest getCallBackConfigRequest);
}