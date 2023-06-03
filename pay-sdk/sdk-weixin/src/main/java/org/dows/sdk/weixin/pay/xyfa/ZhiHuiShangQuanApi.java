package org.dows.sdk.weixin.pay.xyfa;

import org.dows.sdk.weixin.pay.xyfa.request.*;
import org.dows.sdk.weixin.pay.xyfa.response.*;

/**
 * 智慧商圈
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:38:52
 */
public interface ZhiHuiShangQuanApi {

    /**
     * 商圈会员积分服务授权结果通知
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter8_6_6.shtml
     * api:
     *
     * @param shangQuanHuiYuanJiFenFuWuShouQuanJieGuoTongZhiRequest
     */
    ShangQuanHuiYuanJiFenFuWuShouQuanJieGuoTongZhiResponse shangQuanHuiYuanJiFenFuWuShouQuanJieGuoTongZhi(ShangQuanHuiYuanJiFenFuWuShouQuanJieGuoTongZhiRequest shangQuanHuiYuanJiFenFuWuShouQuanJieGuoTongZhiRequest);

    /**
     * 商圈会员场内支付结果通知
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter8_6_1.shtml
     * api:
     *
     * @param shangQuanHuiYuanChangNeiZhiFuJieGuoTongZhiRequest
     */
    ShangQuanHuiYuanChangNeiZhiFuJieGuoTongZhiResponse shangQuanHuiYuanChangNeiZhiFuJieGuoTongZhi(ShangQuanHuiYuanChangNeiZhiFuJieGuoTongZhiRequest shangQuanHuiYuanChangNeiZhiFuJieGuoTongZhiRequest);

    /**
     * 商圈会员积分同步
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter8_6_2.shtml
     * api:
     *
     * @param shangQuanHuiYuanJiFenTongBuRequest
     */
    ShangQuanHuiYuanJiFenTongBuResponse shangQuanHuiYuanJiFenTongBu(ShangQuanHuiYuanJiFenTongBuRequest shangQuanHuiYuanJiFenTongBuRequest);

    /**
     * 商圈会员场内退款通知
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter8_6_3.shtml
     * api:
     *
     * @param shangQuanHuiYuanChangNeiTuiKuanTongZhiRequest
     */
    ShangQuanHuiYuanChangNeiTuiKuanTongZhiResponse shangQuanHuiYuanChangNeiTuiKuanTongZhi(ShangQuanHuiYuanChangNeiTuiKuanTongZhiRequest shangQuanHuiYuanChangNeiTuiKuanTongZhiRequest);

    /**
     * 商圈会员积分服务授权查询
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter8_6_4.shtml
     * api:
     *
     * @param shangQuanHuiYuanJiFenFuWuShouQuanChaXunRequest
     */
    ShangQuanHuiYuanJiFenFuWuShouQuanChaXunResponse shangQuanHuiYuanJiFenFuWuShouQuanChaXun(ShangQuanHuiYuanJiFenFuWuShouQuanChaXunRequest shangQuanHuiYuanJiFenFuWuShouQuanChaXunRequest);

    /**
     * 商圈会员待积分状态查询
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter8_6_7.shtml
     * api:
     *
     * @param shangQuanHuiYuanDaiJiFenZhuangTaiChaXunRequest
     */
    ShangQuanHuiYuanDaiJiFenZhuangTaiChaXunResponse shangQuanHuiYuanDaiJiFenZhuangTaiChaXun(ShangQuanHuiYuanDaiJiFenZhuangTaiChaXunRequest shangQuanHuiYuanDaiJiFenZhuangTaiChaXunRequest);

    /**
     * 商圈会员停车状态同步
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter8_6_5.shtml
     * api:
     *
     * @param shangQuanHuiYuanTingCheZhuangTaiTongBuRequest
     */
    ShangQuanHuiYuanTingCheZhuangTaiTongBuResponse shangQuanHuiYuanTingCheZhuangTaiTongBu(ShangQuanHuiYuanTingCheZhuangTaiTongBuRequest shangQuanHuiYuanTingCheZhuangTaiTongBuRequest);
}