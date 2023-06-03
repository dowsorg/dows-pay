package org.dows.sdk.weixin.pay.xyfa;

import org.dows.sdk.weixin.pay.xyfa.request.ChaXunZhuXiaoDanZhuangTaiRequest;
import org.dows.sdk.weixin.pay.xyfa.request.TiJiaoZhuXiaoShenQingDanRequest;
import org.dows.sdk.weixin.pay.xyfa.request.TuPianShangChuanRequest;
import org.dows.sdk.weixin.pay.xyfa.response.ChaXunZhuXiaoDanZhuangTaiResponse;
import org.dows.sdk.weixin.pay.xyfa.response.TiJiaoZhuXiaoShenQingDanResponse;
import org.dows.sdk.weixin.pay.xyfa.response.TuPianShangChuanResponse;

/**
 * 电商收付通（注销申请）
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:38:51
 */
public interface DianShangShouFuTongZhuXiaoShenQingApi {

    /**
     * 提交注销申请单
     * descr:
     * doc: https://pay.weixin.qq.com/docs/partner/apis/ecommerce-cancel/cancel-applications/create-cancel-application.html
     * api:
     *
     * @param tiJiaoZhuXiaoShenQingDanRequest
     */
    TiJiaoZhuXiaoShenQingDanResponse tiJiaoZhuXiaoShenQingDan(TiJiaoZhuXiaoShenQingDanRequest tiJiaoZhuXiaoShenQingDanRequest);

    /**
     * 查询注销单状态
     * descr:
     * doc: https://pay.weixin.qq.com/docs/partner/apis/ecommerce-cancel/cancel-applications/get-cancel-application.html
     * api:
     *
     * @param chaXunZhuXiaoDanZhuangTaiRequest
     */
    ChaXunZhuXiaoDanZhuangTaiResponse chaXunZhuXiaoDanZhuangTai(ChaXunZhuXiaoDanZhuangTaiRequest chaXunZhuXiaoDanZhuangTaiRequest);

    /**
     * 图片上传
     * descr:
     * doc: https://pay.weixin.qq.com/docs/partner/apis/ecommerce-cancel/media/upload-media.html
     * api:
     *
     * @param tuPianShangChuanRequest
     */
    TuPianShangChuanResponse tuPianShangChuan(TuPianShangChuanRequest tuPianShangChuanRequest);
}