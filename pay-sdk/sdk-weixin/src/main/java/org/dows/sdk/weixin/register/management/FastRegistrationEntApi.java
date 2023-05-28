package org.dows.sdk.weixin.register.management;

import org.dows.sdk.weixin.register.management.request.RegisterMiniprogramRequest;
import org.dows.sdk.weixin.register.management.response.RegisterMiniprogramResponse;

/**
 * @author lait.zhang@gmail.com
 * @Date 2023年5月28日 下午9:25:34
 * @description fastRegistrationEntApi
 */
public interface FastRegistrationEntApi {

    /**
     * 关于快速注册小程序的详细介绍以及使用步骤、常见问题等请查看，本文为快速注册小程序的接口文档。审核结果会向授权事件接收 URL 推送相关通知。
     * https://api.weixin.qq.com/cgi-bin/component/fastregisterweapp?action=create&component_access_token=TOKENPOST https://api.weixin.qq.com/cgi-bin/component/fastregisterweapp?action=search&component_access_token=TOKEN{ "errcode":0, // 状态码，0成功，其他失败 "errmsg":"OK" // 错误信息 }
     *
     * @param registerMiniprogramRequest
     */
    RegisterMiniprogramResponse registerMiniprogram(RegisterMiniprogramRequest registerMiniprogramRequest);
}