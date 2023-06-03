package org.dows.sdk.weixin.pay.yxgj;

import org.dows.sdk.weixin.pay.yxgj.request.*;
import org.dows.sdk.weixin.pay.yxgj.response.*;

/**
 * 支付有礼
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:38:52
 */
public interface ZhiFuYouLiApi {

    /**
     * 创建全场满额送活动
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter9_7_2.shtml
     * api:
     *
     * @param chuangJianQuanChangManESongHuoDongRequest
     */
    ChuangJianQuanChangManESongHuoDongResponse chuangJianQuanChangManESongHuoDong(ChuangJianQuanChangManESongHuoDongRequest chuangJianQuanChangManESongHuoDongRequest);

    /**
     * 查询活动详情接口
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter9_7_4.shtml
     * api:
     *
     * @param chaXunHuoDongXiangQingJieKouRequest
     */
    ChaXunHuoDongXiangQingJieKouResponse chaXunHuoDongXiangQingJieKou(ChaXunHuoDongXiangQingJieKouRequest chaXunHuoDongXiangQingJieKouRequest);

    /**
     * 查询活动发券商户号
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter9_7_5.shtml
     * api:
     *
     * @param chaXunHuoDongFaQuanShangHuHaoRequest
     */
    ChaXunHuoDongFaQuanShangHuHaoResponse chaXunHuoDongFaQuanShangHuHao(ChaXunHuoDongFaQuanShangHuHaoRequest chaXunHuoDongFaQuanShangHuHaoRequest);

    /**
     * 查询活动指定商品列表
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter9_7_6.shtml
     * api:
     *
     * @param chaXunHuoDongZhiDingShangPinLieBiaoRequest
     */
    ChaXunHuoDongZhiDingShangPinLieBiaoResponse chaXunHuoDongZhiDingShangPinLieBiao(ChaXunHuoDongZhiDingShangPinLieBiaoRequest chaXunHuoDongZhiDingShangPinLieBiaoRequest);

    /**
     * 终止活动
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter9_7_7.shtml
     * api:
     *
     * @param zhongZhiHuoDongRequest
     */
    ZhongZhiHuoDongResponse zhongZhiHuoDong(ZhongZhiHuoDongRequest zhongZhiHuoDongRequest);

    /**
     * 新增活动发券商户号
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter9_7_8.shtml
     * api:
     *
     * @param xinZengHuoDongFaQuanShangHuHaoRequest
     */
    XinZengHuoDongFaQuanShangHuHaoResponse xinZengHuoDongFaQuanShangHuHao(XinZengHuoDongFaQuanShangHuHaoRequest xinZengHuoDongFaQuanShangHuHaoRequest);

    /**
     * 获取支付有礼活动列表
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter9_7_9.shtml
     * api:
     *
     * @param huoQuZhiFuYouLiHuoDongLieBiaoRequest
     */
    HuoQuZhiFuYouLiHuoDongLieBiaoResponse huoQuZhiFuYouLiHuoDongLieBiao(HuoQuZhiFuYouLiHuoDongLieBiaoRequest huoQuZhiFuYouLiHuoDongLieBiaoRequest);

    /**
     * 删除活动发券商户号
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter9_7_10.shtml
     * api:
     *
     * @param shanChuHuoDongFaQuanShangHuHaoRequest
     */
    ShanChuHuoDongFaQuanShangHuHaoResponse shanChuHuoDongFaQuanShangHuHao(ShanChuHuoDongFaQuanShangHuHaoRequest shanChuHuoDongFaQuanShangHuHaoRequest);

    /**
     * 小程序发券插件
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter9_3_1.shtml
     * api:
     *
     * @param xiaoChengXuFaQuanChaJianRequest
     */
    XiaoChengXuFaQuanChaJianResponse xiaoChengXuFaQuanChaJian(XiaoChengXuFaQuanChaJianRequest xiaoChengXuFaQuanChaJianRequest);

    /**
     * H5发券
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter9_4_1.shtml
     * api:
     *
     * @param h5FaQuanRequest
     */
    H5FaQuanResponse h5FaQuan(H5FaQuanRequest h5FaQuanRequest);

    /**
     * 图片上传(营销专用)
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter9_0_1.shtml
     * api:
     *
     * @param tuPianShangChuanYingXiaoZhuanYongRequest
     */
    TuPianShangChuanYingXiaoZhuanYongResponse tuPianShangChuanYingXiaoZhuanYong(TuPianShangChuanYingXiaoZhuanYongRequest tuPianShangChuanYingXiaoZhuanYongRequest);

    /**
     * 现金红包
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/index.shtml#menu00
     * api:
     *
     * @param xianJinHongBaoRequest
     */
    XianJinHongBaoResponse xianJinHongBao(XianJinHongBaoRequest xianJinHongBaoRequest);
}