package org.dows.sdk.weixin.register.management;

import org.dows.sdk.weixin.register.management.request.FastRegisterPersonalMpRequest;
import org.dows.sdk.weixin.register.management.response.FastRegisterPersonalMpResponse;

/**
 * @author
 * @description
 * @date
 */
public interface FastRegistrationIndApi {
    /**
     * 关于快速注册小程序的详细介绍以及使用步骤等请查看，本文为快速注册小程序的接口文档。注册成功失败的结果会向授权事件接收 URL 推送相关通知。
     *
     * @param fastRegisterPersonalMpRequest
     */
    FastRegisterPersonalMpResponse fastRegisterPersonalMp(FastRegisterPersonalMpRequest fastRegisterPersonalMpRequest);


}
