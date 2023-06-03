package org.dows.sdk.weixin.open.dsjzcxcx;

import org.dows.sdk.weixin.open.dsjzcxcx.request.FuYongGongZhongHaoZhuTiKuaiSuZhuCeXiaoChengXuRequest;
import org.dows.sdk.weixin.open.dsjzcxcx.response.FuYongGongZhongHaoZhuTiKuaiSuZhuCeXiaoChengXuResponse;

/**
 * 复用公众号注册小程序
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:27:31
 */
public interface FuYongGongZhongHaoZhuCeXiaoChengXuApi {

    /**
     * 复用公众号主体快速注册小程序
     * descr:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/register-management/fast-registration-officalaccount/registerMiniprogramByOffiaccount.html
     * api: https://api.weixin.qq.com/cgi-bin/account/fastregister?access_token=ACCESS_TOKEN
     *
     * @param fuYongGongZhongHaoZhuTiKuaiSuZhuCeXiaoChengXuRequest
     */
    FuYongGongZhongHaoZhuTiKuaiSuZhuCeXiaoChengXuResponse fuYongGongZhongHaoZhuTiKuaiSuZhuCeXiaoChengXu(FuYongGongZhongHaoZhuTiKuaiSuZhuCeXiaoChengXuRequest fuYongGongZhongHaoZhuTiKuaiSuZhuCeXiaoChengXuRequest);
}