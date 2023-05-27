package org.dows.sdk.weixin.register.management;

import org.dows.sdk.weixin.register.management.request.RegisterMiniprogramRequest;
import org.dows.sdk.weixin.register.management.response.RegisterMiniprogramResponse;

/**
 * @author
 * @description
 * @date
 */
public interface FastRegistrationEntApi {
    /**
     * 关于快速注册小程序的详细介绍以及使用步骤、常见问题等请查看，本文为快速注册小程序的接口文档。审核结果会向授权事件接收 URL 推送相关通知。
     *
     * @param registerMiniprogramRequest
     */
    RegisterMiniprogramResponse registerMiniprogram(RegisterMiniprogramRequest registerMiniprogramRequest);

}
