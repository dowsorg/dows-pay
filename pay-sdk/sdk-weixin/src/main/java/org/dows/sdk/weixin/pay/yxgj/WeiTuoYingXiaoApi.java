package org.dows.sdk.weixin.pay.yxgj;

import org.dows.sdk.weixin.pay.yxgj.request.ChaXunHeZuoGuanXiLieBiaoRequest;
import org.dows.sdk.weixin.pay.yxgj.request.JianLiHeZuoGuanXiRequest;
import org.dows.sdk.weixin.pay.yxgj.response.ChaXunHeZuoGuanXiLieBiaoResponse;
import org.dows.sdk.weixin.pay.yxgj.response.JianLiHeZuoGuanXiResponse;

/**
 * 委托营销
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:38:52
 */
public interface WeiTuoYingXiaoApi {

    /**
     * 建立合作关系
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter9_5_1.shtml
     * api:
     *
     * @param jianLiHeZuoGuanXiRequest
     */
    JianLiHeZuoGuanXiResponse jianLiHeZuoGuanXi(JianLiHeZuoGuanXiRequest jianLiHeZuoGuanXiRequest);

    /**
     * 查询合作关系列表
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter9_5_3.shtml
     * api:
     *
     * @param chaXunHeZuoGuanXiLieBiaoRequest
     */
    ChaXunHeZuoGuanXiLieBiaoResponse chaXunHeZuoGuanXiLieBiao(ChaXunHeZuoGuanXiLieBiaoRequest chaXunHeZuoGuanXiLieBiaoRequest);
}