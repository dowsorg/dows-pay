package org.dows.sdk.weixin.open.dsjglxcx;

import org.dows.sdk.weixin.open.dsjglxcx.request.XiaoChengXuDengLuRequest;
import org.dows.sdk.weixin.open.dsjglxcx.response.XiaoChengXuDengLuResponse;

/**
 * 小程序登录
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:27:31
 */
public interface XiaoChengXuDengLuApi {

    /**
     * 小程序登录
     * descr:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/login/thirdpartyCode2Session.html
     * api: https://api.weixin.qq.com/sns/component/jscode2session?component_access_token=ACCESS_TOKEN
     *
     * @param xiaoChengXuDengLuRequest
     */
    XiaoChengXuDengLuResponse xiaoChengXuDengLu(XiaoChengXuDengLuRequest xiaoChengXuDengLuRequest);
}