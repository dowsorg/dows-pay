package org.dows.sdk.weixin.pay.xyfa;

import org.dows.sdk.weixin.pay.xyfa.request.*;
import org.dows.sdk.weixin.pay.xyfa.response.*;

/**
 * 电商收付通（合单支付）
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:38:51
 */
public interface DianShangShouFuTongHeDanZhiFuApi {

    /**
     * 合单APP下单
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter7_3_1.shtml
     * api:
     *
     * @param heDanAPPXiaDanRequest
     */
    HeDanAPPXiaDanResponse heDanAPPXiaDan(HeDanAPPXiaDanRequest heDanAPPXiaDanRequest);

    /**
     * 合单H5下单
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter7_3_2.shtml
     * api:
     *
     * @param heDanH5XiaDanRequest
     */
    HeDanH5XiaDanResponse heDanH5XiaDan(HeDanH5XiaDanRequest heDanH5XiaDanRequest);

    /**
     * 合单JSAPI下单
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter7_3_3.shtml
     * api:
     *
     * @param heDanJSAPIXiaDanRequest
     */
    HeDanJSAPIXiaDanResponse heDanJSAPIXiaDan(HeDanJSAPIXiaDanRequest heDanJSAPIXiaDanRequest);

    /**
     * 合单小程序下单
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter7_3_4.shtml
     * api:
     *
     * @param heDanXiaoChengXuXiaDanRequest
     */
    HeDanXiaoChengXuXiaDanResponse heDanXiaoChengXuXiaDan(HeDanXiaoChengXuXiaDanRequest heDanXiaoChengXuXiaDanRequest);

    /**
     * 合单Native下单
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter7_3_5.shtml
     * api:
     *
     * @param heDanNativeXiaDanRequest
     */
    HeDanNativeXiaDanResponse heDanNativeXiaDan(HeDanNativeXiaDanRequest heDanNativeXiaDanRequest);

    /**
     * APP调起支付
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter7_3_6.shtml
     * api:
     *
     * @param aPPDiaoQiZhiFuRequest
     */
    APPDiaoQiZhiFuResponse aPPDiaoQiZhiFu(APPDiaoQiZhiFuRequest aPPDiaoQiZhiFuRequest);

    /**
     * H5调起支付
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter7_3_7.shtml
     * api:
     *
     * @param h5DiaoQiZhiFuRequest
     */
    H5DiaoQiZhiFuResponse h5DiaoQiZhiFu(H5DiaoQiZhiFuRequest h5DiaoQiZhiFuRequest);

    /**
     * JSAPI调起支付
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter7_3_8.shtml
     * api:
     *
     * @param jSAPIDiaoQiZhiFuRequest
     */
    JSAPIDiaoQiZhiFuResponse jSAPIDiaoQiZhiFu(JSAPIDiaoQiZhiFuRequest jSAPIDiaoQiZhiFuRequest);

    /**
     * 小程序调起支付
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter7_3_9.shtml
     * api:
     *
     * @param xiaoChengXuDiaoQiZhiFuRequest
     */
    XiaoChengXuDiaoQiZhiFuResponse xiaoChengXuDiaoQiZhiFu(XiaoChengXuDiaoQiZhiFuRequest xiaoChengXuDiaoQiZhiFuRequest);

    /**
     * Native调起支付
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter7_3_10.shtml
     * api:
     *
     * @param nativeDiaoQiZhiFuRequest
     */
    NativeDiaoQiZhiFuResponse nativeDiaoQiZhiFu(NativeDiaoQiZhiFuRequest nativeDiaoQiZhiFuRequest);

    /**
     * 合单查询订单
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter7_3_11.shtml
     * api:
     *
     * @param heDanChaXunDingDanRequest
     */
    HeDanChaXunDingDanResponse heDanChaXunDingDan(HeDanChaXunDingDanRequest heDanChaXunDingDanRequest);

    /**
     * 合单关闭订单
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter7_3_12.shtml
     * api:
     *
     * @param heDanGuanBiDingDanRequest
     */
    HeDanGuanBiDingDanResponse heDanGuanBiDingDan(HeDanGuanBiDingDanRequest heDanGuanBiDingDanRequest);

    /**
     * 支付通知
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter7_3_13.shtml
     * api:
     *
     * @param zhiFuTongZhiRequest
     */
    ZhiFuTongZhiResponse zhiFuTongZhi(ZhiFuTongZhiRequest zhiFuTongZhiRequest);
}