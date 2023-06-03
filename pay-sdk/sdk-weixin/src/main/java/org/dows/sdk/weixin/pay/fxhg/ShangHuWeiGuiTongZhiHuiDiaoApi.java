package org.dows.sdk.weixin.pay.fxhg;

import org.dows.sdk.weixin.pay.fxhg.request.*;
import org.dows.sdk.weixin.pay.fxhg.response.*;

/**
 * 商户违规通知回调
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:38:53
 */
public interface ShangHuWeiGuiTongZhiHuiDiaoApi {

    /**
     * 创建商户违规通知回调地址
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter10_3_1.shtml
     * api:
     *
     * @param chuangJianShangHuWeiGuiTongZhiHuiDiaoDiZhiRequest
     */
    ChuangJianShangHuWeiGuiTongZhiHuiDiaoDiZhiResponse chuangJianShangHuWeiGuiTongZhiHuiDiaoDiZhi(ChuangJianShangHuWeiGuiTongZhiHuiDiaoDiZhiRequest chuangJianShangHuWeiGuiTongZhiHuiDiaoDiZhiRequest);

    /**
     * 查询商户违规通知回调地址
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter10_3_2.shtml
     * api:
     *
     * @param chaXunShangHuWeiGuiTongZhiHuiDiaoDiZhiRequest
     */
    ChaXunShangHuWeiGuiTongZhiHuiDiaoDiZhiResponse chaXunShangHuWeiGuiTongZhiHuiDiaoDiZhi(ChaXunShangHuWeiGuiTongZhiHuiDiaoDiZhiRequest chaXunShangHuWeiGuiTongZhiHuiDiaoDiZhiRequest);

    /**
     * 修改商户违规通知回调地址
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter10_3_3.shtml
     * api:
     *
     * @param xiuGaiShangHuWeiGuiTongZhiHuiDiaoDiZhiRequest
     */
    XiuGaiShangHuWeiGuiTongZhiHuiDiaoDiZhiResponse xiuGaiShangHuWeiGuiTongZhiHuiDiaoDiZhi(XiuGaiShangHuWeiGuiTongZhiHuiDiaoDiZhiRequest xiuGaiShangHuWeiGuiTongZhiHuiDiaoDiZhiRequest);

    /**
     * 删除商户违规通知回调地址
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter10_3_4.shtml
     * api:
     *
     * @param shanChuShangHuWeiGuiTongZhiHuiDiaoDiZhiRequest
     */
    ShanChuShangHuWeiGuiTongZhiHuiDiaoDiZhiResponse shanChuShangHuWeiGuiTongZhiHuiDiaoDiZhi(ShanChuShangHuWeiGuiTongZhiHuiDiaoDiZhiRequest shanChuShangHuWeiGuiTongZhiHuiDiaoDiZhiRequest);

    /**
     * 商户平台处置记录回调通知
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter10_3_5.shtml
     * api:
     *
     * @param shangHuPingTaiChuZhiJiLuHuiDiaoTongZhiRequest
     */
    ShangHuPingTaiChuZhiJiLuHuiDiaoTongZhiResponse shangHuPingTaiChuZhiJiLuHuiDiaoTongZhi(ShangHuPingTaiChuZhiJiLuHuiDiaoTongZhiRequest shangHuPingTaiChuZhiJiLuHuiDiaoTongZhiRequest);
}