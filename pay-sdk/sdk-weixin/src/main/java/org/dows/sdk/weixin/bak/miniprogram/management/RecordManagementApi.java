package org.dows.sdk.weixin.bak.miniprogram.management;

import org.dows.sdk.weixin.bak.miniprogram.management.request.GetAppealRecordsRequest;
import org.dows.sdk.weixin.bak.miniprogram.management.request.GetIllegalRecordsRequest;
import org.dows.sdk.weixin.bak.miniprogram.management.response.GetAppealRecordsResponse;
import org.dows.sdk.weixin.bak.miniprogram.management.response.GetIllegalRecordsResponse;

/**
 * @author lait.zhang@gmail.com
 * @description recordManagementApi
 * @date 2023年5月29日 上午11:32:00
 */
public interface RecordManagementApi {

    /**
     * description: 调用本 API 可以获取小程序的违规处罚记录。使用过程中如遇到问题，可在发帖交流。调用该接口，需要小程序将18、76的权限集授权给第三方平台；
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/record-management/getIllegalRecords.html
     * api: https://api.weixin.qq.com/wxa/getillegalrecords?access_token=ACCESS_TOKEN
     *
     * @param getIllegalRecordsRequest
     */
    GetIllegalRecordsResponse getIllegalRecords(GetIllegalRecordsRequest getIllegalRecordsRequest);

    /**
     * description: 调用本 API 可以获取小程序的申诉记录。使用过程中如遇到问题，可在发帖交流。调用该接口，需要小程序将18、76的权限集授权给第三方平台；当小程序发起申诉或者申诉审核状态改变后，微信服务器会向第三方平台的消息与事件接收 URL（创建时由第三方平台填写）以的方式推送该通知。为了加强安全性，postdata 中的 xml 将使用服务申请时的加解密 key 来进行加密，具体请见, 在收到推送后需进行解密（详细请见）。除了消息通知之外，第三方平台也可通过接口查询小程序的申诉记录。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/record-management/getAppealRecords.html
     * api: https://api.weixin.qq.com/wxa/getappealrecords?access_token=ACCESS_TOKEN
     *
     * @param getAppealRecordsRequest
     */
    GetAppealRecordsResponse getAppealRecords(GetAppealRecordsRequest getAppealRecordsRequest);
}