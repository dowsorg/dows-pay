package org.dows.sdk.weixin.pay.yxgj;

import org.dows.sdk.weixin.pay.yxgj.request.*;
import org.dows.sdk.weixin.pay.yxgj.response.*;

/**
 * 商家券
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:38:52
 */
public interface ShangJiaQuanApi {

    /**
     * 创建商家券
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter9_2_1.shtml
     * api:
     *
     * @param chuangJianShangJiaQuanRequest
     */
    ChuangJianShangJiaQuanResponse chuangJianShangJiaQuan(ChuangJianShangJiaQuanRequest chuangJianShangJiaQuanRequest);

    /**
     * 查询商家券详情
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter9_2_2.shtml
     * api:
     *
     * @param chaXunShangJiaQuanXiangQingRequest
     */
    ChaXunShangJiaQuanXiangQingResponse chaXunShangJiaQuanXiangQing(ChaXunShangJiaQuanXiangQingRequest chaXunShangJiaQuanXiangQingRequest);

    /**
     * 核销用户券
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter9_2_3.shtml
     * api:
     *
     * @param heXiaoYongHuQuanRequest
     */
    HeXiaoYongHuQuanResponse heXiaoYongHuQuan(HeXiaoYongHuQuanRequest heXiaoYongHuQuanRequest);

    /**
     * 根据过滤条件查询用户券
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter9_2_4.shtml
     * api:
     *
     * @param genJuGuoLvTiaoJianChaXunYongHuQuanRequest
     */
    GenJuGuoLvTiaoJianChaXunYongHuQuanResponse genJuGuoLvTiaoJianChaXunYongHuQuan(GenJuGuoLvTiaoJianChaXunYongHuQuanRequest genJuGuoLvTiaoJianChaXunYongHuQuanRequest);

    /**
     * 查询用户单张券详情
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter9_2_5.shtml
     * api:
     *
     * @param chaXunYongHuDanZhangQuanXiangQingRequest
     */
    ChaXunYongHuDanZhangQuanXiangQingResponse chaXunYongHuDanZhangQuanXiangQing(ChaXunYongHuDanZhangQuanXiangQingRequest chaXunYongHuDanZhangQuanXiangQingRequest);

    /**
     * 上传预存code
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter9_2_6.shtml
     * api:
     *
     * @param shangChuanYuCuncodeRequest
     */
    ShangChuanYuCuncodeResponse shangChuanYuCuncode(ShangChuanYuCuncodeRequest shangChuanYuCuncodeRequest);

    /**
     * 设置商家券事件通知地址
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter9_2_7.shtml
     * api:
     *
     * @param sheZhiShangJiaQuanShiJianTongZhiDiZhiRequest
     */
    SheZhiShangJiaQuanShiJianTongZhiDiZhiResponse sheZhiShangJiaQuanShiJianTongZhiDiZhi(SheZhiShangJiaQuanShiJianTongZhiDiZhiRequest sheZhiShangJiaQuanShiJianTongZhiDiZhiRequest);

    /**
     * 查询商家券事件通知地址
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter9_2_8.shtml
     * api:
     *
     * @param chaXunShangJiaQuanShiJianTongZhiDiZhiRequest
     */
    ChaXunShangJiaQuanShiJianTongZhiDiZhiResponse chaXunShangJiaQuanShiJianTongZhiDiZhi(ChaXunShangJiaQuanShiJianTongZhiDiZhiRequest chaXunShangJiaQuanShiJianTongZhiDiZhiRequest);

    /**
     * 关联订单信息
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter9_2_9.shtml
     * api:
     *
     * @param guanLianDingDanXinXiRequest
     */
    GuanLianDingDanXinXiResponse guanLianDingDanXinXi(GuanLianDingDanXinXiRequest guanLianDingDanXinXiRequest);

    /**
     * 取消关联订单信息
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter9_2_10.shtml
     * api:
     *
     * @param quXiaoGuanLianDingDanXinXiRequest
     */
    QuXiaoGuanLianDingDanXinXiResponse quXiaoGuanLianDingDanXinXi(QuXiaoGuanLianDingDanXinXiRequest quXiaoGuanLianDingDanXinXiRequest);

    /**
     * 修改批次预算
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter9_2_11.shtml
     * api:
     *
     * @param xiuGaiPiCiYuSuanRequest
     */
    XiuGaiPiCiYuSuanResponse xiuGaiPiCiYuSuan(XiuGaiPiCiYuSuanRequest xiuGaiPiCiYuSuanRequest);

    /**
     * 修改商家券基本信息
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter9_2_12.shtml
     * api:
     *
     * @param xiuGaiShangJiaQuanJiBenXinXiRequest
     */
    XiuGaiShangJiaQuanJiBenXinXiResponse xiuGaiShangJiaQuanJiBenXinXi(XiuGaiShangJiaQuanJiBenXinXiRequest xiuGaiShangJiaQuanJiBenXinXiRequest);

    /**
     * 申请退券
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter9_2_13.shtml
     * api:
     *
     * @param shenQingTuiQuanRequest
     */
    ShenQingTuiQuanResponse shenQingTuiQuan(ShenQingTuiQuanRequest shenQingTuiQuanRequest);

    /**
     * 使券失效
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter9_2_14.shtml
     * api:
     *
     * @param shiQuanShiXiaoRequest
     */
    ShiQuanShiXiaoResponse shiQuanShiXiao(ShiQuanShiXiaoRequest shiQuanShiXiaoRequest);

    /**
     * 营销补差付款
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter9_2_16.shtml
     * api:
     *
     * @param yingXiaoBuChaFuKuanRequest
     */
    YingXiaoBuChaFuKuanResponse yingXiaoBuChaFuKuan(YingXiaoBuChaFuKuanRequest yingXiaoBuChaFuKuanRequest);

    /**
     * 查询营销补差付款单详情
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter9_2_18.shtml
     * api:
     *
     * @param chaXunYingXiaoBuChaFuKuanDanXiangQingRequest
     */
    ChaXunYingXiaoBuChaFuKuanDanXiangQingResponse chaXunYingXiaoBuChaFuKuanDanXiangQing(ChaXunYingXiaoBuChaFuKuanDanXiangQingRequest chaXunYingXiaoBuChaFuKuanDanXiangQingRequest);

    /**
     * 领券事件回调通知
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter9_2_15.shtml
     * api:
     *
     * @param lingQuanShiJianHuiDiaoTongZhiRequest
     */
    LingQuanShiJianHuiDiaoTongZhiResponse lingQuanShiJianHuiDiaoTongZhi(LingQuanShiJianHuiDiaoTongZhiRequest lingQuanShiJianHuiDiaoTongZhiRequest);
}