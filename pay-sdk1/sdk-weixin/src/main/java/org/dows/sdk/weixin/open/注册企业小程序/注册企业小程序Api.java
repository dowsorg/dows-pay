package org.dows.sdk.weixin.open1.注册企业小程序;

/**
 * @description 
 * @author lait.zhang@gmail.com
 * @date  2023年6月2日 下午3:34:20
 */
public interface 注册企业小程序Api{

    /**
     * description: 关于快速注册小程序的详细介绍以及使用步骤、常见问题等请查看,，本文为快速注册小程序的接口文档。,审核结果会向授权事件接收 URL 推送相关通知。
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//doc/oplatform/openApi/OpenApiDoc/register-management/fast-registration-ent/registerMiniprogram.html
     * api: https://api.weixin.qq.com/cgi-bin/component/fastregisterweapp?action=create&component_access_token=TOKEN,POST https://api.weixin.qq.com/cgi-bin/component/fastregisterweapp?action=search&component_access_token=TOKEN,{ "errcode":0, // 状态码，0成功，其他失败 "errmsg":"OK" // 错误信息 }
     * 
     * @param 快速注册企业小程序Request
     * 
     */
    快速注册企业小程序Response 快速注册企业小程序(快速注册企业小程序Request 快速注册企业小程序Request);
}