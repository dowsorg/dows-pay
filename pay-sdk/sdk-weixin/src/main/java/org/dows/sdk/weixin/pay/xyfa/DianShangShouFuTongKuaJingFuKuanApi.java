package org.dows.sdk.weixin.pay.xyfa;

import org.dows.sdk.weixin.pay.xyfa.request.ChaXunChuJingJieGuoRequest;
import org.dows.sdk.weixin.pay.xyfa.request.ChaXunDingDanShengYuKeChuJingYuERequest;
import org.dows.sdk.weixin.pay.xyfa.request.HuoQuGouFuHuiZhangDanWenJianXiaZaiLianJieRequest;
import org.dows.sdk.weixin.pay.xyfa.request.ShenQingZiJinChuJingRequest;
import org.dows.sdk.weixin.pay.xyfa.response.ChaXunChuJingJieGuoResponse;
import org.dows.sdk.weixin.pay.xyfa.response.ChaXunDingDanShengYuKeChuJingYuEResponse;
import org.dows.sdk.weixin.pay.xyfa.response.HuoQuGouFuHuiZhangDanWenJianXiaZaiLianJieResponse;
import org.dows.sdk.weixin.pay.xyfa.response.ShenQingZiJinChuJingResponse;

/**
 * 电商收付通（跨境付款）
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:38:51
 */
public interface DianShangShouFuTongKuaJingFuKuanApi {

    /**
     * 查询订单剩余可出境余额
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter7_10_1.shtml
     * api:
     *
     * @param chaXunDingDanShengYuKeChuJingYuERequest
     */
    ChaXunDingDanShengYuKeChuJingYuEResponse chaXunDingDanShengYuKeChuJingYuE(ChaXunDingDanShengYuKeChuJingYuERequest chaXunDingDanShengYuKeChuJingYuERequest);

    /**
     * 申请资金出境
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter7_10_2.shtml
     * api:
     *
     * @param shenQingZiJinChuJingRequest
     */
    ShenQingZiJinChuJingResponse shenQingZiJinChuJing(ShenQingZiJinChuJingRequest shenQingZiJinChuJingRequest);

    /**
     * 查询出境结果
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter7_10_3.shtml
     * api:
     *
     * @param chaXunChuJingJieGuoRequest
     */
    ChaXunChuJingJieGuoResponse chaXunChuJingJieGuo(ChaXunChuJingJieGuoRequest chaXunChuJingJieGuoRequest);

    /**
     * 获取购付汇账单文件下载链接
     * descr:
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter7_10_4.shtml
     * api:
     *
     * @param huoQuGouFuHuiZhangDanWenJianXiaZaiLianJieRequest
     */
    HuoQuGouFuHuiZhangDanWenJianXiaZaiLianJieResponse huoQuGouFuHuiZhangDanWenJianXiaZaiLianJie(HuoQuGouFuHuiZhangDanWenJianXiaZaiLianJieRequest huoQuGouFuHuiZhangDanWenJianXiaZaiLianJieRequest);
}