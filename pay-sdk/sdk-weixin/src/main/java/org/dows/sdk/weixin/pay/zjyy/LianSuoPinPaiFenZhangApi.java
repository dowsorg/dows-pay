package org.dows.sdk.weixin.pay.zjyy;

import org.dows.sdk.weixin.pay.zjyy.request.*;
import org.dows.sdk.weixin.pay.zjyy.response.*;

/**
 * 连锁品牌分账
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:38:53
 */
public interface LianSuoPinPaiFenZhangApi {

    /**
     * 请求分账
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter8_7_1.shtml
     * api:
     *
     * @param qingQiuFenZhangRequest
     */
    QingQiuFenZhangResponse qingQiuFenZhang(QingQiuFenZhangRequest qingQiuFenZhangRequest);

    /**
     * 查询分账结果
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter8_7_2.shtml
     * api:
     *
     * @param chaXunFenZhangJieGuoRequest
     */
    ChaXunFenZhangJieGuoResponse chaXunFenZhangJieGuo(ChaXunFenZhangJieGuoRequest chaXunFenZhangJieGuoRequest);

    /**
     * 请求分账回退
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter8_7_3.shtml
     * api:
     *
     * @param qingQiuFenZhangHuiTuiRequest
     */
    QingQiuFenZhangHuiTuiResponse qingQiuFenZhangHuiTui(QingQiuFenZhangHuiTuiRequest qingQiuFenZhangHuiTuiRequest);

    /**
     * 查询分账回退结果
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter8_7_4.shtml
     * api:
     *
     * @param chaXunFenZhangHuiTuiJieGuoRequest
     */
    ChaXunFenZhangHuiTuiJieGuoResponse chaXunFenZhangHuiTuiJieGuo(ChaXunFenZhangHuiTuiJieGuoRequest chaXunFenZhangHuiTuiJieGuoRequest);

    /**
     * 完结分账
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter8_7_5.shtml
     * api:
     *
     * @param wanJieFenZhangRequest
     */
    WanJieFenZhangResponse wanJieFenZhang(WanJieFenZhangRequest wanJieFenZhangRequest);

    /**
     * 查询订单剩余待分账金额
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter8_7_9.shtml
     * api:
     *
     * @param chaXunDingDanShengYuDaiFenZhangJinERequest
     */
    ChaXunDingDanShengYuDaiFenZhangJinEResponse chaXunDingDanShengYuDaiFenZhangJinE(ChaXunDingDanShengYuDaiFenZhangJinERequest chaXunDingDanShengYuDaiFenZhangJinERequest);

    /**
     * 查询最大分账比例
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter8_7_10.shtml
     * api:
     *
     * @param chaXunZuiDaFenZhangBiLiRequest
     */
    ChaXunZuiDaFenZhangBiLiResponse chaXunZuiDaFenZhangBiLi(ChaXunZuiDaFenZhangBiLiRequest chaXunZuiDaFenZhangBiLiRequest);

    /**
     * 添加分账接收方
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter8_7_7.shtml
     * api:
     *
     * @param tianJiaFenZhangJieShouFangRequest
     */
    TianJiaFenZhangJieShouFangResponse tianJiaFenZhangJieShouFang(TianJiaFenZhangJieShouFangRequest tianJiaFenZhangJieShouFangRequest);

    /**
     * 删除分账接收方
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter8_7_8.shtml
     * api:
     *
     * @param shanChuFenZhangJieShouFangRequest
     */
    ShanChuFenZhangJieShouFangResponse shanChuFenZhangJieShouFang(ShanChuFenZhangJieShouFangRequest shanChuFenZhangJieShouFangRequest);

    /**
     * 分账动账通知
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter8_7_6.shtml
     * api:
     *
     * @param fenZhangDongZhangTongZhiRequest
     */
    FenZhangDongZhangTongZhiResponse fenZhangDongZhangTongZhi(FenZhangDongZhangTongZhiRequest fenZhangDongZhangTongZhiRequest);

    /**
     * 申请分账账单
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter8_7_11.shtml
     * api:
     *
     * @param shenQingFenZhangZhangDanRequest
     */
    ShenQingFenZhangZhangDanResponse shenQingFenZhangZhangDan(ShenQingFenZhangZhangDanRequest shenQingFenZhangZhangDanRequest);

    /**
     * 下载账单
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter8_7_12.shtml
     * api:
     *
     * @param xiaZaiZhangDanRequest
     */
    XiaZaiZhangDanResponse xiaZaiZhangDan(XiaZaiZhangDanRequest xiaZaiZhangDanRequest);
}