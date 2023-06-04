package org.dows.sdk.weixin.pay.fxhg;

import org.dows.sdk.weixin.pay.fxhg.request.*;
import org.dows.sdk.weixin.pay.fxhg.response.*;

/**
 * 消费者投诉2.0
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:38:53
 */
public interface XiaoFeiZheTouSu20Api {

    /**
     * 查询投诉单列表
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter10_2_11.shtml
     * api:
     *
     * @param chaXunTouSuDanLieBiaoRequest
     */
    ChaXunTouSuDanLieBiaoResponse chaXunTouSuDanLieBiao(ChaXunTouSuDanLieBiaoRequest chaXunTouSuDanLieBiaoRequest);

    /**
     * 查询投诉单详情
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter10_2_13.shtml
     * api:
     *
     * @param chaXunTouSuDanXiangQingRequest
     */
    ChaXunTouSuDanXiangQingResponse chaXunTouSuDanXiangQing(ChaXunTouSuDanXiangQingRequest chaXunTouSuDanXiangQingRequest);

    /**
     * 查询投诉协商历史
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter10_2_12.shtml
     * api:
     *
     * @param chaXunTouSuXieShangLiShiRequest
     */
    ChaXunTouSuXieShangLiShiResponse chaXunTouSuXieShangLiShi(ChaXunTouSuXieShangLiShiRequest chaXunTouSuXieShangLiShiRequest);

    /**
     * 投诉通知回调
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter10_2_16.shtml
     * api:
     *
     * @param touSuTongZhiHuiDiaoRequest
     */
    TouSuTongZhiHuiDiaoResponse touSuTongZhiHuiDiao(TouSuTongZhiHuiDiaoRequest touSuTongZhiHuiDiaoRequest);

    /**
     * 创建投诉通知回调地址
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter10_2_2.shtml
     * api:
     *
     * @param chuangJianTouSuTongZhiHuiDiaoDiZhiRequest
     */
    ChuangJianTouSuTongZhiHuiDiaoDiZhiResponse chuangJianTouSuTongZhiHuiDiaoDiZhi(ChuangJianTouSuTongZhiHuiDiaoDiZhiRequest chuangJianTouSuTongZhiHuiDiaoDiZhiRequest);

    /**
     * 查询投诉通知回调地址
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter10_2_3.shtml
     * api:
     *
     * @param chaXunTouSuTongZhiHuiDiaoDiZhiRequest
     */
    ChaXunTouSuTongZhiHuiDiaoDiZhiResponse chaXunTouSuTongZhiHuiDiaoDiZhi(ChaXunTouSuTongZhiHuiDiaoDiZhiRequest chaXunTouSuTongZhiHuiDiaoDiZhiRequest);

    /**
     * 更新投诉通知回调地址
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter10_2_4.shtml
     * api:
     *
     * @param gengXinTouSuTongZhiHuiDiaoDiZhiRequest
     */
    GengXinTouSuTongZhiHuiDiaoDiZhiResponse gengXinTouSuTongZhiHuiDiaoDiZhi(GengXinTouSuTongZhiHuiDiaoDiZhiRequest gengXinTouSuTongZhiHuiDiaoDiZhiRequest);

    /**
     * 删除投诉通知回调地址
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter10_2_5.shtml
     * api:
     *
     * @param shanChuTouSuTongZhiHuiDiaoDiZhiRequest
     */
    ShanChuTouSuTongZhiHuiDiaoDiZhiResponse shanChuTouSuTongZhiHuiDiaoDiZhi(ShanChuTouSuTongZhiHuiDiaoDiZhiRequest shanChuTouSuTongZhiHuiDiaoDiZhiRequest);

    /**
     * 回复用户
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter10_2_14.shtml
     * api:
     *
     * @param huiFuYongHuRequest
     */
    HuiFuYongHuResponse huiFuYongHu(HuiFuYongHuRequest huiFuYongHuRequest);

    /**
     * 反馈处理完成
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter10_2_15.shtml
     * api:
     *
     * @param fanKuiChuLiWanChengRequest
     */
    FanKuiChuLiWanChengResponse fanKuiChuLiWanCheng(FanKuiChuLiWanChengRequest fanKuiChuLiWanChengRequest);

    /**
     * 更新退款审批结果
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter10_2_19.shtml
     * api:
     *
     * @param gengXinTuiKuanShenPiJieGuoRequest
     */
    GengXinTuiKuanShenPiJieGuoResponse gengXinTuiKuanShenPiJieGuo(GengXinTuiKuanShenPiJieGuoRequest gengXinTuiKuanShenPiJieGuoRequest);

    /**
     * 商户上传反馈图片
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter10_2_10.shtml
     * api:
     *
     * @param shangHuShangChuanFanKuiTuPianRequest
     */
    ShangHuShangChuanFanKuiTuPianResponse shangHuShangChuanFanKuiTuPian(ShangHuShangChuanFanKuiTuPianRequest shangHuShangChuanFanKuiTuPianRequest);

    /**
     * 图片下载
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter10_2_18.shtml
     * api:
     *
     * @param tuPianXiaZaiRequest
     */
    TuPianXiaZaiResponse tuPianXiaZai(TuPianXiaZaiRequest tuPianXiaZaiRequest);
}