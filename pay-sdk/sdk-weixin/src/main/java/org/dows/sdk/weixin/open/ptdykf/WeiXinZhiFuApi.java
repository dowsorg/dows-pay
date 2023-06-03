package org.dows.sdk.weixin.open.ptdykf;

import org.dows.sdk.weixin.open.ptdykf.request.HuoQuShouQuanBangDingDeShangHuHaoLieBiaoRequest;
import org.dows.sdk.weixin.open.ptdykf.request.ShenQingShangHuHaoShouQuanRequest;
import org.dows.sdk.weixin.open.ptdykf.response.HuoQuShouQuanBangDingDeShangHuHaoLieBiaoResponse;
import org.dows.sdk.weixin.open.ptdykf.response.ShenQingShangHuHaoShouQuanResponse;

/**
 * 微信支付
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:27:31
 */
public interface WeiXinZhiFuApi {

    /**
     * 获取授权绑定的商户号列表
     * descr: 通过本接口可以查询授权绑定的商户号列表，使用过程中如遇到问题，可在,发帖交流。,说明：小程序需授权【云开发权限集】或【云开发微信支付权限集】给第三方，第三方才可以代小程序调用此接口。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/wechatpay/getWechatPayList.html
     * api: https://api.weixin.qq.com/tcb/wxpaylist?access_token=ACCESS_TOKEN
     *
     * @param huoQuShouQuanBangDingDeShangHuHaoLieBiaoRequest
     */
    HuoQuShouQuanBangDingDeShangHuHaoLieBiaoResponse huoQuShouQuanBangDingDeShangHuHaoLieBiao(HuoQuShouQuanBangDingDeShangHuHaoLieBiaoRequest huoQuShouQuanBangDingDeShangHuHaoLieBiaoRequest);

    /**
     * 申请商户号授权
     * descr: 通过本接口可以申请商户号授权，使用过程中如遇到问题，可在,发帖交流。,1）帐号绑定：商户号的超级管理员需要在微信支付提供的【微信支付商家助手】小程序上确认授权。,2）jsapi 和 api 退款权限，需要前往微信支付商户平台我的授权产品中进行确认授权。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/wechatpay/getWechatPayAuth.html
     * api: https://api.weixin.qq.com/tcb/wxpayopenauth?access_token=ACCESS_TOKEN
     *
     * @param shenQingShangHuHaoShouQuanRequest
     */
    ShenQingShangHuHaoShouQuanResponse shenQingShangHuHaoShouQuan(ShenQingShangHuHaoShouQuanRequest shenQingShangHuHaoShouQuanRequest);
}