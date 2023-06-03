package org.dows.sdk.weixin.pay.yxgj;

import org.dows.sdk.weixin.pay.yxgj.request.*;
import org.dows.sdk.weixin.pay.yxgj.response.*;

/**
 * 代金券
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:38:52
 */
public interface DaiJinQuanApi {

    /**
     * 创建代金券批次
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter9_1_1.shtml
     * api:
     *
     * @param chuangJianDaiJinQuanPiCiRequest
     */
    ChuangJianDaiJinQuanPiCiResponse chuangJianDaiJinQuanPiCi(ChuangJianDaiJinQuanPiCiRequest chuangJianDaiJinQuanPiCiRequest);

    /**
     * 激活代金券批次
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter9_1_3.shtml
     * api:
     *
     * @param jiHuoDaiJinQuanPiCiRequest
     */
    JiHuoDaiJinQuanPiCiResponse jiHuoDaiJinQuanPiCi(JiHuoDaiJinQuanPiCiRequest jiHuoDaiJinQuanPiCiRequest);

    /**
     * 发放代金券批次
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter9_1_2.shtml
     * api:
     *
     * @param faFangDaiJinQuanPiCiRequest
     */
    FaFangDaiJinQuanPiCiResponse faFangDaiJinQuanPiCi(FaFangDaiJinQuanPiCiRequest faFangDaiJinQuanPiCiRequest);

    /**
     * 暂停代金券批次
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter9_1_13.shtml
     * api:
     *
     * @param zanTingDaiJinQuanPiCiRequest
     */
    ZanTingDaiJinQuanPiCiResponse zanTingDaiJinQuanPiCi(ZanTingDaiJinQuanPiCiRequest zanTingDaiJinQuanPiCiRequest);

    /**
     * 重启代金券批次
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter9_1_14.shtml
     * api:
     *
     * @param zhongQiDaiJinQuanPiCiRequest
     */
    ZhongQiDaiJinQuanPiCiResponse zhongQiDaiJinQuanPiCi(ZhongQiDaiJinQuanPiCiRequest zhongQiDaiJinQuanPiCiRequest);

    /**
     * 条件查询批次列表
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter9_1_4.shtml
     * api:
     *
     * @param tiaoJianChaXunPiCiLieBiaoRequest
     */
    TiaoJianChaXunPiCiLieBiaoResponse tiaoJianChaXunPiCiLieBiao(TiaoJianChaXunPiCiLieBiaoRequest tiaoJianChaXunPiCiLieBiaoRequest);

    /**
     * 查询批次详情
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter9_1_5.shtml
     * api:
     *
     * @param chaXunPiCiXiangQingRequest
     */
    ChaXunPiCiXiangQingResponse chaXunPiCiXiangQing(ChaXunPiCiXiangQingRequest chaXunPiCiXiangQingRequest);

    /**
     * 查询代金券详情
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter9_1_6.shtml
     * api:
     *
     * @param chaXunDaiJinQuanXiangQingRequest
     */
    ChaXunDaiJinQuanXiangQingResponse chaXunDaiJinQuanXiangQing(ChaXunDaiJinQuanXiangQingRequest chaXunDaiJinQuanXiangQingRequest);

    /**
     * 查询代金券可用商户
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter9_1_7.shtml
     * api:
     *
     * @param chaXunDaiJinQuanKeYongShangHuRequest
     */
    ChaXunDaiJinQuanKeYongShangHuResponse chaXunDaiJinQuanKeYongShangHu(ChaXunDaiJinQuanKeYongShangHuRequest chaXunDaiJinQuanKeYongShangHuRequest);

    /**
     * 查询代金券可用单品
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter9_1_8.shtml
     * api:
     *
     * @param chaXunDaiJinQuanKeYongDanPinRequest
     */
    ChaXunDaiJinQuanKeYongDanPinResponse chaXunDaiJinQuanKeYongDanPin(ChaXunDaiJinQuanKeYongDanPinRequest chaXunDaiJinQuanKeYongDanPinRequest);

    /**
     * 根据商户号查用户的券
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter9_1_9.shtml
     * api:
     *
     * @param genJuShangHuHaoChaYongHuDeQuanRequest
     */
    GenJuShangHuHaoChaYongHuDeQuanResponse genJuShangHuHaoChaYongHuDeQuan(GenJuShangHuHaoChaYongHuDeQuanRequest genJuShangHuHaoChaYongHuDeQuanRequest);

    /**
     * 下载批次核销明细
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter9_1_10.shtml
     * api:
     *
     * @param xiaZaiPiCiHeXiaoMingXiRequest
     */
    XiaZaiPiCiHeXiaoMingXiResponse xiaZaiPiCiHeXiaoMingXi(XiaZaiPiCiHeXiaoMingXiRequest xiaZaiPiCiHeXiaoMingXiRequest);

    /**
     * 下载批次退款明细
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter9_1_11.shtml
     * api:
     *
     * @param xiaZaiPiCiTuiKuanMingXiRequest
     */
    XiaZaiPiCiTuiKuanMingXiResponse xiaZaiPiCiTuiKuanMingXi(XiaZaiPiCiTuiKuanMingXiRequest xiaZaiPiCiTuiKuanMingXiRequest);

    /**
     * 设置消息通知地址
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter9_1_12.shtml
     * api:
     *
     * @param sheZhiXiaoXiTongZhiDiZhiRequest
     */
    SheZhiXiaoXiTongZhiDiZhiResponse sheZhiXiaoXiTongZhiDiZhi(SheZhiXiaoXiTongZhiDiZhiRequest sheZhiXiaoXiTongZhiDiZhiRequest);

    /**
     * 核销事件回调通知
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter9_1_15.shtml
     * api:
     *
     * @param heXiaoShiJianHuiDiaoTongZhiRequest
     */
    HeXiaoShiJianHuiDiaoTongZhiResponse heXiaoShiJianHuiDiaoTongZhi(HeXiaoShiJianHuiDiaoTongZhiRequest heXiaoShiJianHuiDiaoTongZhiRequest);
}