package org.dows.sdk.weixin.pay.xyfa;

import org.dows.sdk.weixin.pay.xyfa.request.*;
import org.dows.sdk.weixin.pay.xyfa.response.*;

/**
 * 电商收付通（商户提现）
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:38:51
 */
public interface DianShangShouFuTongShangHuTiXianApi {

    /**
     * 二级商户预约提现
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter7_8_2.shtml
     * api:
     *
     * @param erJiShangHuYuYueTiXianRequest
     */
    ErJiShangHuYuYueTiXianResponse erJiShangHuYuYueTiXian(ErJiShangHuYuYueTiXianRequest erJiShangHuYuYueTiXianRequest);

    /**
     * 二级商户查询预约提现状态
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter7_8_3.shtml
     * api:
     *
     * @param erJiShangHuChaXunYuYueTiXianZhuangTaiRequest
     */
    ErJiShangHuChaXunYuYueTiXianZhuangTaiResponse erJiShangHuChaXunYuYueTiXianZhuangTai(ErJiShangHuChaXunYuYueTiXianZhuangTaiRequest erJiShangHuChaXunYuYueTiXianZhuangTaiRequest);

    /**
     * 电商平台预约提现
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter7_8_5.shtml
     * api:
     *
     * @param dianShangPingTaiYuYueTiXianRequest
     */
    DianShangPingTaiYuYueTiXianResponse dianShangPingTaiYuYueTiXian(DianShangPingTaiYuYueTiXianRequest dianShangPingTaiYuYueTiXianRequest);

    /**
     * 电商平台查询预约提现状态
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter7_8_6.shtml
     * api:
     *
     * @param dianShangPingTaiChaXunYuYueTiXianZhuangTaiRequest
     */
    DianShangPingTaiChaXunYuYueTiXianZhuangTaiResponse dianShangPingTaiChaXunYuYueTiXianZhuangTai(DianShangPingTaiChaXunYuYueTiXianZhuangTaiRequest dianShangPingTaiChaXunYuYueTiXianZhuangTaiRequest);

    /**
     * 按日下载提现异常文件
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter7_8_4.shtml
     * api:
     *
     * @param anRiXiaZaiTiXianYiChangWenJianRequest
     */
    AnRiXiaZaiTiXianYiChangWenJianResponse anRiXiaZaiTiXianYiChangWenJian(AnRiXiaZaiTiXianYiChangWenJianRequest anRiXiaZaiTiXianYiChangWenJianRequest);
}