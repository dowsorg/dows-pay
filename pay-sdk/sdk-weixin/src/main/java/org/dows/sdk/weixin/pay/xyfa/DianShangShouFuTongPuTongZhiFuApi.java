package org.dows.sdk.weixin.pay.xyfa;

import org.dows.sdk.weixin.pay.xyfa.request.*;
import org.dows.sdk.weixin.pay.xyfa.response.*;

/**
 * 电商收付通（普通支付）
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:38:51
 */
public interface DianShangShouFuTongPuTongZhiFuApi {

    /**
     * APP下单
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter7_2_1.shtml
     * api:
     *
     * @param aPPXiaDanRequest
     */
    APPXiaDanResponse aPPXiaDan(APPXiaDanRequest aPPXiaDanRequest);

    /**
     * JSAPI下单
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter7_2_2.shtml
     * api:
     *
     * @param jSAPIXiaDanRequest
     */
    JSAPIXiaDanResponse jSAPIXiaDan(JSAPIXiaDanRequest jSAPIXiaDanRequest);

    /**
     * 小程序下单
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter7_2_3.shtml
     * api:
     *
     * @param xiaoChengXuXiaDanRequest
     */
    XiaoChengXuXiaDanResponse xiaoChengXuXiaDan(XiaoChengXuXiaDanRequest xiaoChengXuXiaDanRequest);

    /**
     * H5下单
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter7_2_4.shtml
     * api:
     *
     * @param h5XiaDanRequest
     */
    H5XiaDanResponse h5XiaDan(H5XiaDanRequest h5XiaDanRequest);

    /**
     * Native下单
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter7_2_12.shtml
     * api:
     *
     * @param nativeXiaDanRequest
     */
    NativeXiaDanResponse nativeXiaDan(NativeXiaDanRequest nativeXiaDanRequest);

    /**
     * 查询订单
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter7_2_5.shtml
     * api:
     *
     * @param chaXunDingDanRequest
     */
    ChaXunDingDanResponse chaXunDingDan(ChaXunDingDanRequest chaXunDingDanRequest);

    /**
     * 关闭订单
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter7_2_6.shtml
     * api:
     *
     * @param guanBiDingDanRequest
     */
    GuanBiDingDanResponse guanBiDingDan(GuanBiDingDanRequest guanBiDingDanRequest);

    /**
     * APP调起支付
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter7_2_7.shtml
     * api:
     *
     * @param aPPDiaoQiZhiFuRequest
     */
    APPDiaoQiZhiFuResponse aPPDiaoQiZhiFu(APPDiaoQiZhiFuRequest aPPDiaoQiZhiFuRequest);

    /**
     * JSAPI调起支付
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter7_2_8.shtml
     * api:
     *
     * @param jSAPIDiaoQiZhiFuRequest
     */
    JSAPIDiaoQiZhiFuResponse jSAPIDiaoQiZhiFu(JSAPIDiaoQiZhiFuRequest jSAPIDiaoQiZhiFuRequest);

    /**
     * 小程序调起支付
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter7_2_9.shtml
     * api:
     *
     * @param xiaoChengXuDiaoQiZhiFuRequest
     */
    XiaoChengXuDiaoQiZhiFuResponse xiaoChengXuDiaoQiZhiFu(XiaoChengXuDiaoQiZhiFuRequest xiaoChengXuDiaoQiZhiFuRequest);

    /**
     * H5调起支付
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter7_2_10.shtml
     * api:
     *
     * @param h5DiaoQiZhiFuRequest
     */
    H5DiaoQiZhiFuResponse h5DiaoQiZhiFu(H5DiaoQiZhiFuRequest h5DiaoQiZhiFuRequest);

    /**
     * Native调起支付
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter7_2_13.shtml
     * api:
     *
     * @param nativeDiaoQiZhiFuRequest
     */
    NativeDiaoQiZhiFuResponse nativeDiaoQiZhiFu(NativeDiaoQiZhiFuRequest nativeDiaoQiZhiFuRequest);

    /**
     * 支付通知
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter7_2_11.shtml
     * api:
     *
     * @param zhiFuTongZhiRequest
     */
    ZhiFuTongZhiResponse zhiFuTongZhi(ZhiFuTongZhiRequest zhiFuTongZhiRequest);
}