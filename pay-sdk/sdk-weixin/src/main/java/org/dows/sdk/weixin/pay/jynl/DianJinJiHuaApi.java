package org.dows.sdk.weixin.pay.jynl;

import org.dows.sdk.weixin.pay.jynl.request.*;
import org.dows.sdk.weixin.pay.jynl.response.*;

/**
 * 点金计划
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:38:51
 */
public interface DianJinJiHuaApi {

    /**
     * 点金计划管理
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter8_5_1.shtml
     * api:
     *
     * @param dianJinJiHuaGuanLiRequest
     */
    DianJinJiHuaGuanLiResponse dianJinJiHuaGuanLi(DianJinJiHuaGuanLiRequest dianJinJiHuaGuanLiRequest);

    /**
     * 商家小票管理
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter8_5_2.shtml
     * api:
     *
     * @param shangJiaXiaoPiaoGuanLiRequest
     */
    ShangJiaXiaoPiaoGuanLiResponse shangJiaXiaoPiaoGuanLi(ShangJiaXiaoPiaoGuanLiRequest shangJiaXiaoPiaoGuanLiRequest);

    /**
     * 同业过滤标签管理
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter8_5_3.shtml
     * api:
     *
     * @param tongYeGuoLvBiaoQianGuanLiRequest
     */
    TongYeGuoLvBiaoQianGuanLiResponse tongYeGuoLvBiaoQianGuanLi(TongYeGuoLvBiaoQianGuanLiRequest tongYeGuoLvBiaoQianGuanLiRequest);

    /**
     * 开通广告展示
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter8_5_4.shtml
     * api:
     *
     * @param kaiTongGuangGaoZhanShiRequest
     */
    KaiTongGuangGaoZhanShiResponse kaiTongGuangGaoZhanShi(KaiTongGuangGaoZhanShiRequest kaiTongGuangGaoZhanShiRequest);

    /**
     * 关闭广告展示
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter8_5_5.shtml
     * api:
     *
     * @param guanBiGuangGaoZhanShiRequest
     */
    GuanBiGuangGaoZhanShiResponse guanBiGuangGaoZhanShi(GuanBiGuangGaoZhanShiRequest guanBiGuangGaoZhanShiRequest);
}