package org.dows.sdk.weixin.pay.xyfa;

import org.dows.sdk.weixin.pay.xyfa.request.*;
import org.dows.sdk.weixin.pay.xyfa.response.*;

/**
 * 电商收付通（分账）
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:38:51
 */
public interface DianShangShouFuTongFenZhangApi {

    /**
     * 请求分账
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter7_4_1.shtml
     * api:
     *
     * @param qingQiuFenZhangRequest
     */
    QingQiuFenZhangResponse qingQiuFenZhang(QingQiuFenZhangRequest qingQiuFenZhangRequest);

    /**
     * 查询分账结果
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter7_4_2.shtml
     * api:
     *
     * @param chaXunFenZhangJieGuoRequest
     */
    ChaXunFenZhangJieGuoResponse chaXunFenZhangJieGuo(ChaXunFenZhangJieGuoRequest chaXunFenZhangJieGuoRequest);

    /**
     * 请求分账回退
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter7_4_3.shtml
     * api:
     *
     * @param qingQiuFenZhangHuiTuiRequest
     */
    QingQiuFenZhangHuiTuiResponse qingQiuFenZhangHuiTui(QingQiuFenZhangHuiTuiRequest qingQiuFenZhangHuiTuiRequest);

    /**
     * 查询分账回退结果
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter7_4_4.shtml
     * api:
     *
     * @param chaXunFenZhangHuiTuiJieGuoRequest
     */
    ChaXunFenZhangHuiTuiJieGuoResponse chaXunFenZhangHuiTuiJieGuo(ChaXunFenZhangHuiTuiJieGuoRequest chaXunFenZhangHuiTuiJieGuoRequest);

    /**
     * 完结分账
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter7_4_5.shtml
     * api:
     *
     * @param wanJieFenZhangRequest
     */
    WanJieFenZhangResponse wanJieFenZhang(WanJieFenZhangRequest wanJieFenZhangRequest);

    /**
     * 查询订单剩余待分金额
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter7_4_9.shtml
     * api:
     *
     * @param chaXunDingDanShengYuDaiFenJinERequest
     */
    ChaXunDingDanShengYuDaiFenJinEResponse chaXunDingDanShengYuDaiFenJinE(ChaXunDingDanShengYuDaiFenJinERequest chaXunDingDanShengYuDaiFenJinERequest);

    /**
     * 添加分账接收方
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter7_4_7.shtml
     * api:
     *
     * @param tianJiaFenZhangJieShouFangRequest
     */
    TianJiaFenZhangJieShouFangResponse tianJiaFenZhangJieShouFang(TianJiaFenZhangJieShouFangRequest tianJiaFenZhangJieShouFangRequest);

    /**
     * 删除分账接收方
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter7_4_8.shtml
     * api:
     *
     * @param shanChuFenZhangJieShouFangRequest
     */
    ShanChuFenZhangJieShouFangResponse shanChuFenZhangJieShouFang(ShanChuFenZhangJieShouFangRequest shanChuFenZhangJieShouFangRequest);

    /**
     * 分账动账通知
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter7_4_6.shtml
     * api:
     *
     * @param fenZhangDongZhangTongZhiRequest
     */
    FenZhangDongZhangTongZhiResponse fenZhangDongZhangTongZhi(FenZhangDongZhangTongZhiRequest fenZhangDongZhangTongZhiRequest);
}