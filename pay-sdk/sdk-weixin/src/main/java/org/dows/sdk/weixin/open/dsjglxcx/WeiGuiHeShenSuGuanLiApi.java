package org.dows.sdk.weixin.open.dsjglxcx;

import org.dows.sdk.weixin.open.dsjglxcx.request.HuoQuXiaoChengXuShenSuJiLuRequest;
import org.dows.sdk.weixin.open.dsjglxcx.request.HuoQuXiaoChengXuWeiGuiChuFaJiLuRequest;
import org.dows.sdk.weixin.open.dsjglxcx.response.HuoQuXiaoChengXuShenSuJiLuResponse;
import org.dows.sdk.weixin.open.dsjglxcx.response.HuoQuXiaoChengXuWeiGuiChuFaJiLuResponse;

/**
 * 违规和申诉管理
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:27:31
 */
public interface WeiGuiHeShenSuGuanLiApi {

    /**
     * 获取小程序违规处罚记录
     * descr: 调用本 API 可以获取小程序的违规处罚记录。使用过程中如遇到问题，可在,发帖交流。,调用该接口，需要小程序将18、76的权限集授权给第三方平台；
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/record-management/getIllegalRecords.html
     * api: https://api.weixin.qq.com/wxa/getillegalrecords?access_token=ACCESS_TOKEN
     *
     * @param huoQuXiaoChengXuWeiGuiChuFaJiLuRequest
     */
    HuoQuXiaoChengXuWeiGuiChuFaJiLuResponse huoQuXiaoChengXuWeiGuiChuFaJiLu(HuoQuXiaoChengXuWeiGuiChuFaJiLuRequest huoQuXiaoChengXuWeiGuiChuFaJiLuRequest);

    /**
     * 获取小程序申诉记录
     * descr: 调用本 API 可以获取小程序的申诉记录。使用过程中如遇到问题，可在,发帖交流。,调用该接口，需要小程序将18、76的权限集授权给第三方平台；,当小程序发起申诉或者申诉审核状态改变后，微信服务器会向第三方平台的消息与事件接收 URL（创建时由第三方平台填写）以,的方式推送该通知。,为了加强安全性，postdata 中的 xml 将使用服务申请时的加解密 key 来进行加密，具体请见,, 在收到推送后需进行解密（详细请见,）。,除了消息通知之外，第三方平台也可通过接口查询小程序的申诉记录。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/record-management/getAppealRecords.html
     * api: https://api.weixin.qq.com/wxa/getappealrecords?access_token=ACCESS_TOKEN
     *
     * @param huoQuXiaoChengXuShenSuJiLuRequest
     */
    HuoQuXiaoChengXuShenSuJiLuResponse huoQuXiaoChengXuShenSuJiLu(HuoQuXiaoChengXuShenSuJiLuRequest huoQuXiaoChengXuShenSuJiLuRequest);
}