package org.dows.sdk.weixin.pay.xyfa;

import org.dows.sdk.weixin.pay.xyfa.request.ChaXunDianShangPingTaiZhangHuRiZhongYuERequest;
import org.dows.sdk.weixin.pay.xyfa.request.ChaXunDianShangPingTaiZhangHuShiShiYuERequest;
import org.dows.sdk.weixin.pay.xyfa.request.ChaXunErJiShangHuZhangHuRiZhongYuERequest;
import org.dows.sdk.weixin.pay.xyfa.request.ChaXunErJiShangHuZhangHuShiShiYuERequest;
import org.dows.sdk.weixin.pay.xyfa.response.ChaXunDianShangPingTaiZhangHuRiZhongYuEResponse;
import org.dows.sdk.weixin.pay.xyfa.response.ChaXunDianShangPingTaiZhangHuShiShiYuEResponse;
import org.dows.sdk.weixin.pay.xyfa.response.ChaXunErJiShangHuZhangHuRiZhongYuEResponse;
import org.dows.sdk.weixin.pay.xyfa.response.ChaXunErJiShangHuZhangHuShiShiYuEResponse;

/**
 * 电商收付通（余额查询）
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:38:51
 */
public interface DianShangShouFuTongYuEChaXunApi {

    /**
     * 查询二级商户账户实时余额
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter7_7_1.shtml
     * api:
     *
     * @param chaXunErJiShangHuZhangHuShiShiYuERequest
     */
    ChaXunErJiShangHuZhangHuShiShiYuEResponse chaXunErJiShangHuZhangHuShiShiYuE(ChaXunErJiShangHuZhangHuShiShiYuERequest chaXunErJiShangHuZhangHuShiShiYuERequest);

    /**
     * 查询二级商户账户日终余额
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter7_7_2.shtml
     * api:
     *
     * @param chaXunErJiShangHuZhangHuRiZhongYuERequest
     */
    ChaXunErJiShangHuZhangHuRiZhongYuEResponse chaXunErJiShangHuZhangHuRiZhongYuE(ChaXunErJiShangHuZhangHuRiZhongYuERequest chaXunErJiShangHuZhangHuRiZhongYuERequest);

    /**
     * 查询电商平台账户实时余额
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter7_7_3.shtml
     * api:
     *
     * @param chaXunDianShangPingTaiZhangHuShiShiYuERequest
     */
    ChaXunDianShangPingTaiZhangHuShiShiYuEResponse chaXunDianShangPingTaiZhangHuShiShiYuE(ChaXunDianShangPingTaiZhangHuShiShiYuERequest chaXunDianShangPingTaiZhangHuShiShiYuERequest);

    /**
     * 查询电商平台账户日终余额
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter7_7_4.shtml
     * api:
     *
     * @param chaXunDianShangPingTaiZhangHuRiZhongYuERequest
     */
    ChaXunDianShangPingTaiZhangHuRiZhongYuEResponse chaXunDianShangPingTaiZhangHuRiZhongYuE(ChaXunDianShangPingTaiZhangHuRiZhongYuERequest chaXunDianShangPingTaiZhangHuRiZhongYuERequest);
}