package org.dows.sdk.weixin.pay.zjyy;

import org.dows.sdk.weixin.pay.zjyy.request.*;
import org.dows.sdk.weixin.pay.zjyy.response.*;

/**
 * 分账
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:38:53
 */
public interface FenZhangApi {

    /**
     * 请求分账
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter8_1_1.shtml
     * api:
     *
     * @param qingQiuFenZhangRequest
     */
    QingQiuFenZhangResponse qingQiuFenZhang(QingQiuFenZhangRequest qingQiuFenZhangRequest);

    /**
     * 查询分账结果
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter8_1_2.shtml
     * api:
     *
     * @param chaXunFenZhangJieGuoRequest
     */
    ChaXunFenZhangJieGuoResponse chaXunFenZhangJieGuo(ChaXunFenZhangJieGuoRequest chaXunFenZhangJieGuoRequest);

    /**
     * 请求分账回退
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter8_1_3.shtml
     * api:
     *
     * @param qingQiuFenZhangHuiTuiRequest
     */
    QingQiuFenZhangHuiTuiResponse qingQiuFenZhangHuiTui(QingQiuFenZhangHuiTuiRequest qingQiuFenZhangHuiTuiRequest);

    /**
     * 查询分账回退结果
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter8_1_4.shtml
     * api:
     *
     * @param chaXunFenZhangHuiTuiJieGuoRequest
     */
    ChaXunFenZhangHuiTuiJieGuoResponse chaXunFenZhangHuiTuiJieGuo(ChaXunFenZhangHuiTuiJieGuoRequest chaXunFenZhangHuiTuiJieGuoRequest);

    /**
     * 解冻剩余资金
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter8_1_5.shtml
     * api:
     *
     * @param jieDongShengYuZiJinRequest
     */
    JieDongShengYuZiJinResponse jieDongShengYuZiJin(JieDongShengYuZiJinRequest jieDongShengYuZiJinRequest);

    /**
     * 查询剩余待分金额
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter8_1_6.shtml
     * api:
     *
     * @param chaXunShengYuDaiFenJinERequest
     */
    ChaXunShengYuDaiFenJinEResponse chaXunShengYuDaiFenJinE(ChaXunShengYuDaiFenJinERequest chaXunShengYuDaiFenJinERequest);

    /**
     * 查询最大分账比例
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter8_1_7.shtml
     * api:
     *
     * @param chaXunZuiDaFenZhangBiLiRequest
     */
    ChaXunZuiDaFenZhangBiLiResponse chaXunZuiDaFenZhangBiLi(ChaXunZuiDaFenZhangBiLiRequest chaXunZuiDaFenZhangBiLiRequest);

    /**
     * 添加分账接收方
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter8_1_8.shtml
     * api:
     *
     * @param tianJiaFenZhangJieShouFangRequest
     */
    TianJiaFenZhangJieShouFangResponse tianJiaFenZhangJieShouFang(TianJiaFenZhangJieShouFangRequest tianJiaFenZhangJieShouFangRequest);

    /**
     * 删除分账接收方
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter8_1_9.shtml
     * api:
     *
     * @param shanChuFenZhangJieShouFangRequest
     */
    ShanChuFenZhangJieShouFangResponse shanChuFenZhangJieShouFang(ShanChuFenZhangJieShouFangRequest shanChuFenZhangJieShouFangRequest);

    /**
     * 分账动账通知
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter8_1_10.shtml
     * api:
     *
     * @param fenZhangDongZhangTongZhiRequest
     */
    FenZhangDongZhangTongZhiResponse fenZhangDongZhangTongZhi(FenZhangDongZhangTongZhiRequest fenZhangDongZhangTongZhiRequest);

    /**
     * 申请分账账单
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter8_1_11.shtml
     * api:
     *
     * @param shenQingFenZhangZhangDanRequest
     */
    ShenQingFenZhangZhangDanResponse shenQingFenZhangZhangDan(ShenQingFenZhangZhangDanRequest shenQingFenZhangZhangDanRequest);

    /**
     * 下载账单
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter8_1_12.shtml
     * api:
     *
     * @param xiaZaiZhangDanRequest
     */
    XiaZaiZhangDanResponse xiaZaiZhangDan(XiaZaiZhangDanRequest xiaZaiZhangDanRequest);
}