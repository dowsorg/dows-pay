package org.dows.sdk.weixin.open.dsjglxcx;

import org.dows.sdk.weixin.open.dsjglxcx.request.HuoQuDiLiWeiZhiJieKouLieBiaoRequest;
import org.dows.sdk.weixin.open.dsjglxcx.request.ShenQingDiLiWeiZhiJieKouRequest;
import org.dows.sdk.weixin.open.dsjglxcx.response.HuoQuDiLiWeiZhiJieKouLieBiaoResponse;
import org.dows.sdk.weixin.open.dsjglxcx.response.ShenQingDiLiWeiZhiJieKouResponse;

/**
 * 地理位置接口申请
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:27:31
 */
public interface DiLiWeiZhiJieKouShenQingApi {

    /**
     * 申请地理位置接口
     * descr:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/privacy-api-management/applyPrivacyInterface.html
     * api: https://api.weixin.qq.com/wxa/security/apply_privacy_interface?access_token=ACCESS_TOKEN
     *
     * @param shenQingDiLiWeiZhiJieKouRequest
     */
    ShenQingDiLiWeiZhiJieKouResponse shenQingDiLiWeiZhiJieKou(ShenQingDiLiWeiZhiJieKouRequest shenQingDiLiWeiZhiJieKouRequest);

    /**
     * 获取地理位置接口列表
     * descr:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/privacy-api-management/getPrivacyInterface.html
     * api: https://api.weixin.qq.com/wxa/security/get_privacy_interface?access_token=ACCESS_TOKEN
     *
     * @param huoQuDiLiWeiZhiJieKouLieBiaoRequest
     */
    HuoQuDiLiWeiZhiJieKouLieBiaoResponse huoQuDiLiWeiZhiJieKouLieBiao(HuoQuDiLiWeiZhiJieKouLieBiaoRequest huoQuDiLiWeiZhiJieKouLieBiaoRequest);
}