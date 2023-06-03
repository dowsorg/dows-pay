package org.dows.sdk.weixin.open1.fygzhzcxcx;

/**
 * 复用公众号注册小程序Api
 * @descr 
 * @author lait.zhang@gmail.com
 * @date  2023年6月2日 下午4:54:46
 */
public interface FuYongGongZhongHaoZhuCeXiaoChengXuApi{

    /**
     * 复用公众号主体快速注册小程序
     * descr: 
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/register-management/fast-registration-officalaccount/registerMiniprogramByOffiaccount.html
     * api: https://api.weixin.qq.com/cgi-bin/account/fastregister?access_token=ACCESS_TOKEN
     * 
     * @param fuYongGongZhongHaoZhuTiKuaiSuZhuCeXiaoChengXuRequest
     * 
     */
    FuYongGongZhongHaoZhuTiKuaiSuZhuCeXiaoChengXuResponse fuYongGongZhongHaoZhuTiKuaiSuZhuCeXiaoChengXu(FuYongGongZhongHaoZhuTiKuaiSuZhuCeXiaoChengXuRequest fuYongGongZhongHaoZhuTiKuaiSuZhuCeXiaoChengXuRequest);
}