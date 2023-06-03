package org.dows.sdk.weixin.pay.xyfa;

import org.dows.sdk.weixin.pay.xyfa.request.*;
import org.dows.sdk.weixin.pay.xyfa.response.*;

/**
 * 电商收付通（下载账单）
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:38:52
 */
public interface DianShangShouFuTongXiaZaiZhangDanApi {

    /**
     * 申请交易账单
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter7_9_1.shtml
     * api:
     *
     * @param shenQingJiaoYiZhangDanRequest
     */
    ShenQingJiaoYiZhangDanResponse shenQingJiaoYiZhangDan(ShenQingJiaoYiZhangDanRequest shenQingJiaoYiZhangDanRequest);

    /**
     * 申请资金账单
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter7_9_2.shtml
     * api:
     *
     * @param shenQingZiJinZhangDanRequest
     */
    ShenQingZiJinZhangDanResponse shenQingZiJinZhangDan(ShenQingZiJinZhangDanRequest shenQingZiJinZhangDanRequest);

    /**
     * 申请分账账单
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter7_9_6.shtml
     * api:
     *
     * @param shenQingFenZhangZhangDanRequest
     */
    ShenQingFenZhangZhangDanResponse shenQingFenZhangZhangDan(ShenQingFenZhangZhangDanRequest shenQingFenZhangZhangDanRequest);

    /**
     * 申请二级商户资金账单
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter7_9_5.shtml
     * api:
     *
     * @param shenQingErJiShangHuZiJinZhangDanRequest
     */
    ShenQingErJiShangHuZiJinZhangDanResponse shenQingErJiShangHuZiJinZhangDan(ShenQingErJiShangHuZiJinZhangDanRequest shenQingErJiShangHuZiJinZhangDanRequest);

    /**
     * 下载账单
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//wiki/doc/apiv3_partner/apis/chapter7_9_3.shtml
     * api:
     *
     * @param xiaZaiZhangDanRequest
     */
    XiaZaiZhangDanResponse xiaZaiZhangDan(XiaZaiZhangDanRequest xiaZaiZhangDanRequest);
}