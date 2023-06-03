package org.dows.sdk.weixin.pay.xyfa;

import org.dows.sdk.weixin.pay.xyfa.request.ShangHuTiXianShenQingDanHaoChaXunTiXianShenQingDanZhuangTaiRequest;
import org.dows.sdk.weixin.pay.xyfa.request.TiJiaoYiZhuXiaoShangHuHaoKeYongYuETiXianShenQingDanRequest;
import org.dows.sdk.weixin.pay.xyfa.request.WeiXinZhiFuTiXianShenQingDanHaoChaXunTiXianShenQingDanZhuangTaiRequest;
import org.dows.sdk.weixin.pay.xyfa.response.ShangHuTiXianShenQingDanHaoChaXunTiXianShenQingDanZhuangTaiResponse;
import org.dows.sdk.weixin.pay.xyfa.response.TiJiaoYiZhuXiaoShangHuHaoKeYongYuETiXianShenQingDanResponse;
import org.dows.sdk.weixin.pay.xyfa.response.WeiXinZhiFuTiXianShenQingDanHaoChaXunTiXianShenQingDanZhuangTaiResponse;

/**
 * 电商收付通（注销后提现）
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:38:51
 */
public interface DianShangShouFuTongZhuXiaoHouTiXianApi {

    /**
     * 商户提现申请单号查询提现申请单状态
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter7_8_7.shtml
     * api:
     *
     * @param shangHuTiXianShenQingDanHaoChaXunTiXianShenQingDanZhuangTaiRequest
     */
    ShangHuTiXianShenQingDanHaoChaXunTiXianShenQingDanZhuangTaiResponse shangHuTiXianShenQingDanHaoChaXunTiXianShenQingDanZhuangTai(ShangHuTiXianShenQingDanHaoChaXunTiXianShenQingDanZhuangTaiRequest shangHuTiXianShenQingDanHaoChaXunTiXianShenQingDanZhuangTaiRequest);

    /**
     * 微信支付提现申请单号查询提现申请单状态
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter7_8_8.shtml
     * api:
     *
     * @param weiXinZhiFuTiXianShenQingDanHaoChaXunTiXianShenQingDanZhuangTaiRequest
     */
    WeiXinZhiFuTiXianShenQingDanHaoChaXunTiXianShenQingDanZhuangTaiResponse weiXinZhiFuTiXianShenQingDanHaoChaXunTiXianShenQingDanZhuangTai(WeiXinZhiFuTiXianShenQingDanHaoChaXunTiXianShenQingDanZhuangTaiRequest weiXinZhiFuTiXianShenQingDanHaoChaXunTiXianShenQingDanZhuangTaiRequest);

    /**
     * 提交已注销商户号可用余额提现申请单
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter7_8_9.shtml
     * api:
     *
     * @param tiJiaoYiZhuXiaoShangHuHaoKeYongYuETiXianShenQingDanRequest
     */
    TiJiaoYiZhuXiaoShangHuHaoKeYongYuETiXianShenQingDanResponse tiJiaoYiZhuXiaoShangHuHaoKeYongYuETiXianShenQingDan(TiJiaoYiZhuXiaoShangHuHaoKeYongYuETiXianShenQingDanRequest tiJiaoYiZhuXiaoShangHuHaoKeYongYuETiXianShenQingDanRequest);
}