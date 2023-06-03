package org.dows.sdk.weixin.open.xcxllzdyy;

import org.dows.sdk.weixin.open.xcxllzdyy.request.JianCeShiFouNengKaiTongLiuLiangZhuRequest;
import org.dows.sdk.weixin.open.xcxllzdyy.request.KaiTongLiuLiangZhuRequest;
import org.dows.sdk.weixin.open.xcxllzdyy.response.JianCeShiFouNengKaiTongLiuLiangZhuResponse;
import org.dows.sdk.weixin.open.xcxllzdyy.response.KaiTongLiuLiangZhuResponse;

/**
 * 开通流量主
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:27:31
 */
public interface KaiTongLiuLiangZhuApi {

    /**
     * 检测是否能开通流量主
     * descr: 该 API 用于服务商检测小程序是否达到开通流量主门槛。使用过程中如遇到问题，可在,发帖交流。,其中access_token为
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ams/open/AgencyCheckCanOpenPublisher.html
     * api: https://api.weixin.qq.com/wxa/operationams?action=agency_check_can_open_publisher&access_token=xxxxxxxxxxxxxxx
     *
     * @param jianCeShiFouNengKaiTongLiuLiangZhuRequest
     */
    JianCeShiFouNengKaiTongLiuLiangZhuResponse jianCeShiFouNengKaiTongLiuLiangZhu(JianCeShiFouNengKaiTongLiuLiangZhuRequest jianCeShiFouNengKaiTongLiuLiangZhuRequest);

    /**
     * 开通流量主
     * descr: 该 API 用于为小程序开通流量主。使用过程中如遇到问题，可在,发帖交流。,其中access_token为
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ams/open/AgencyCreatePublisher.html
     * api: https://api.weixin.qq.com/wxa/operationams?action=agency_create_publisher&access_token=xxxxxxxxxxxxxxx
     *
     * @param kaiTongLiuLiangZhuRequest
     */
    KaiTongLiuLiangZhuResponse kaiTongLiuLiangZhu(KaiTongLiuLiangZhuRequest kaiTongLiuLiangZhuRequest);
}