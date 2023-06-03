package org.dows.sdk.weixin.pay.xyfa;

import org.dows.sdk.weixin.pay.xyfa.request.*;
import org.dows.sdk.weixin.pay.xyfa.response.*;

/**
 * 电商收付通（退款）
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:38:51
 */
public interface DianShangShouFuTongTuiKuanApi {

    /**
     * 申请退款
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter7_6_1.shtml
     * api:
     *
     * @param shenQingTuiKuanRequest
     */
    ShenQingTuiKuanResponse shenQingTuiKuan(ShenQingTuiKuanRequest shenQingTuiKuanRequest);

    /**
     * 查询退款
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter7_6_2.shtml
     * api:
     *
     * @param chaXunTuiKuanRequest
     */
    ChaXunTuiKuanResponse chaXunTuiKuan(ChaXunTuiKuanRequest chaXunTuiKuanRequest);

    /**
     * 退款结果通知
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter7_6_3.shtml
     * api:
     *
     * @param tuiKuanJieGuoTongZhiRequest
     */
    TuiKuanJieGuoTongZhiResponse tuiKuanJieGuoTongZhi(TuiKuanJieGuoTongZhiRequest tuiKuanJieGuoTongZhiRequest);

    /**
     * 垫付退款回补
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter7_6_4.shtml
     * api:
     *
     * @param dianFuTuiKuanHuiBuRequest
     */
    DianFuTuiKuanHuiBuResponse dianFuTuiKuanHuiBu(DianFuTuiKuanHuiBuRequest dianFuTuiKuanHuiBuRequest);

    /**
     * 查询垫付回补结果
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter7_6_5.shtml
     * api:
     *
     * @param chaXunDianFuHuiBuJieGuoRequest
     */
    ChaXunDianFuHuiBuJieGuoResponse chaXunDianFuHuiBuJieGuo(ChaXunDianFuHuiBuJieGuoRequest chaXunDianFuHuiBuJieGuoRequest);
}