package org.dows.sdk.weixin.pay.qtnl;

import org.dows.sdk.weixin.pay.qtnl.request.HuoQuPingTaiZhengShuLieBiaoRequest;
import org.dows.sdk.weixin.pay.qtnl.response.HuoQuPingTaiZhengShuLieBiaoResponse;

/**
 * 微信支付平台证书
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:38:53
 */
public interface WeiXinZhiFuPingTaiZhengShuApi {

    /**
     * 获取平台证书列表
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/wechatpay/wechatpay5_1.shtml
     * api:
     *
     * @param huoQuPingTaiZhengShuLieBiaoRequest
     */
    HuoQuPingTaiZhengShuLieBiaoResponse huoQuPingTaiZhengShuLieBiao(HuoQuPingTaiZhengShuLieBiaoRequest huoQuPingTaiZhengShuLieBiaoRequest);
}