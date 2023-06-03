package org.dows.sdk.weixin.pay.xyfa;

import org.dows.sdk.weixin.pay.xyfa.request.QingQiuBuChaHuiTuiRequest;
import org.dows.sdk.weixin.pay.xyfa.request.QingQiuBuChaRequest;
import org.dows.sdk.weixin.pay.xyfa.request.QuXiaoBuChaRequest;
import org.dows.sdk.weixin.pay.xyfa.response.QingQiuBuChaHuiTuiResponse;
import org.dows.sdk.weixin.pay.xyfa.response.QingQiuBuChaResponse;
import org.dows.sdk.weixin.pay.xyfa.response.QuXiaoBuChaResponse;

/**
 * 电商收付通（补差）
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:38:51
 */
public interface DianShangShouFuTongBuChaApi {

    /**
     * 请求补差
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter7_5_1.shtml
     * api:
     *
     * @param qingQiuBuChaRequest
     */
    QingQiuBuChaResponse qingQiuBuCha(QingQiuBuChaRequest qingQiuBuChaRequest);

    /**
     * 请求补差回退
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter7_5_2.shtml
     * api:
     *
     * @param qingQiuBuChaHuiTuiRequest
     */
    QingQiuBuChaHuiTuiResponse qingQiuBuChaHuiTui(QingQiuBuChaHuiTuiRequest qingQiuBuChaHuiTuiRequest);

    /**
     * 取消补差
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter7_5_3.shtml
     * api:
     *
     * @param quXiaoBuChaRequest
     */
    QuXiaoBuChaResponse quXiaoBuCha(QuXiaoBuChaRequest quXiaoBuChaRequest);
}