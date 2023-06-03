package org.dows.sdk.weixin.bak.miniprogram.management;

import org.dows.sdk.weixin.bak.miniprogram.management.request.*;
import org.dows.sdk.weixin.bak.miniprogram.management.response.*;

/**
 * @author lait.zhang@gmail.com
 * @description codeManagementApi
 * @date 2023年5月29日 上午11:32:00
 */
public interface CodeManagementApi {

    /**
     * description: 补充说明：特殊字段说明：
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/commit.html
     * api: https://api.weixin.qq.com/wxa/commit?access_token=ACCESS_TOKEN
     *
     * @param commitRequest
     */
    CommitResponse commit(CommitRequest commitRequest);

    /**
     * description: 通过本接口可以获取由commit接口上传代码的页面列表；使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/getCodePage.html
     * api: https://api.weixin.qq.com/wxa/get_page?access_token=ACCESS_TOKEN
     *
     * @param getCodePageRequest
     */
    GetCodePageResponse getCodePage(GetCodePageRequest getCodePageRequest);

    /**
     * description: 调用本接口可以获取小程序的体验版二维码。使用过程中如遇到问题，可在发帖交流。请求正常的情况下，开发者可以直接将返回的二进制结果（response body）保存成图片。返回的 HTTP 头如下：
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/getTrialQRCode.html
     * api: https://api.weixin.qq.com/wxa/get_qrcode?access_token=ACCESS_TOKENHTTP/1.1 200 OK Connection: close Content-Type: image/jpeg Content-disposition: attachment; filename="QRCode.jpg" Date: Sun, 06 Jan 2013 10:20:18 GMT Cache-Control: no-cache, must-revalidate Content-Length: 339721
     *
     * @param getTrialQRCodeRequest
     */
    GetTrialQRCodeResponse getTrialQRCode(GetTrialQRCodeRequest getTrialQRCodeRequest);

    /**
     * description: 当小程序有审核结果后，微信服务器会向第三方平台方的消息与事件接收 URL（创建第三方平台时填写）以的方式推送相关通知接收请求后，只需直接返回字符串。为了加强安全性，postdata 中的 xml 将使用服务申请时的加解密 key 来进行加密，具体请见, 在收到推送后需进行解密（详细请见）,除了消息通知之外，第三方平台也可通过接口、
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/submitAudit.html
     * api: https://api.weixin.qq.com/wxa/submit_audit?access_token=ACCESS_TOKEN
     *
     * @param submitAuditRequest
     */
    SubmitAuditResponse submitAudit(SubmitAuditRequest submitAuditRequest);

    /**
     * description: 通过接口提交审核后，调用本接口可以查询指定发布审核单的审核状态。使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/getAuditStatus.html
     * api: https://api.weixin.qq.com/wxa/get_auditstatus?access_token=ACCESS_TOKEN
     *
     * @param getAuditStatusRequest
     */
    GetAuditStatusResponse getAuditStatus(GetAuditStatusRequest getAuditStatusRequest);

    /**
     * description: 调用本接口可以撤回当前的代码审核单。使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/undoAudit.html
     * api: https://api.weixin.qq.com/wxa/undocodeaudit?access_token=ACCESS_TOKEN
     *
     * @param undoAuditRequest
     */
    UndoAuditResponse undoAudit(UndoAuditRequest undoAuditRequest);

    /**
     * description: 调用本接口可以发布最后一个审核通过的小程序代码版本。使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/release.html
     * api: https://api.weixin.qq.com/wxa/release?access_token=ACCESS_TOKEN
     *
     * @param releaseRequest
     */
    ReleaseResponse release(ReleaseRequest releaseRequest);

    /**
     * description: 调用本接口可以将小程序的线上版本进行回退。使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/revertCodeRelease.html
     * api: https://api.weixin.qq.com/wxa/revertcoderelease?access_token=ACCESS_TOKEN
     *
     * @param revertCodeReleaseRequest
     */
    RevertCodeReleaseResponse revertCodeRelease(RevertCodeReleaseRequest revertCodeReleaseRequest);

    /**
     * description:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/grayRelease.html
     * api: https://api.weixin.qq.com/wxa/grayrelease?access_token=ACCESS_TOKEN
     *
     * @param grayReleaseRequest
     */
    GrayReleaseResponse grayRelease(GrayReleaseRequest grayReleaseRequest);

    /**
     * description: 该接口用于查询当前分阶段发布详情
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/getGrayReleasePlan.html
     * api: https://api.weixin.qq.com/wxa/getgrayreleaseplan?access_token=ACCESS_TOKEN
     *
     * @param getGrayReleasePlanRequest
     */
    GetGrayReleasePlanResponse getGrayReleasePlan(GetGrayReleasePlanRequest getGrayReleasePlanRequest);

    /**
     * description:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/setVisitStatus.html
     * api: https://api.weixin.qq.com/wxa/change_visitstatus?access_token=ACCESS_TOKEN
     *
     * @param setVisitStatusRequest
     */
    SetVisitStatusResponse setVisitStatus(SetVisitStatusRequest setVisitStatusRequest);

    /**
     * description:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/revertGrayRelease.html
     * api: https://api.weixin.qq.com/wxa/revertgrayrelease?access_token=ACCESS_TOKEN
     *
     * @param revertGrayReleaseRequest
     */
    RevertGrayReleaseResponse revertGrayRelease(RevertGrayReleaseRequest revertGrayReleaseRequest);

    /**
     * description:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/getVisitStatus.html
     * api: https://api.weixin.qq.com/wxa/getvisitstatus?access_token=ACCESS_TOKEN
     *
     * @param getVisitStatusRequest
     */
    GetVisitStatusResponse getVisitStatus(GetVisitStatusRequest getVisitStatusRequest);

    /**
     * description: 调用本接口可以查询小程序当前设置的最低基础库版本，以及小程序在各个基础库版本的用户占比。使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/getSupportVersion.html
     * api: https://api.weixin.qq.com/cgi-bin/wxopen/getweappsupportversion?access_token=ACCESS_TOKEN
     *
     * @param getSupportVersionRequest
     */
    GetSupportVersionResponse getSupportVersion(GetSupportVersionRequest getSupportVersionRequest);

    /**
     * description:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/setSupportVersion.html
     * api: https://api.weixin.qq.com/cgi-bin/wxopen/setweappsupportversion?access_token=ACCESS_TOKEN
     *
     * @param setSupportVersionRequest
     */
    SetSupportVersionResponse setSupportVersion(SetSupportVersionRequest setSupportVersionRequest);

    /**
     * description: 服务商可以调用该接口，查询当月平台分配的提审限额和剩余可提审次数，以及当月分配的审核加急次数和剩余加急次数。（所有旗下小程序共用该额度） 使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/setCodeAuditQuota.html
     * api: https://api.weixin.qq.com/wxa/queryquota?access_token=ACCESS_TOKEN
     *
     * @param setCodeAuditQuotaRequest
     */
    SetCodeAuditQuotaResponse setCodeAuditQuota(SetCodeAuditQuotaRequest setCodeAuditQuotaRequest);

    /**
     * description: 有加急次数的第三方可以通过该接口，对已经提审的小程序进行加急操作，加急后的小程序预计2-12小时内审完。但是若代码中包含较复杂逻辑或其他特殊情况，可能会导致审核时间延长。使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/speedupCodeAudit.html
     * api: https://api.weixin.qq.com/wxa/speedupaudit?access_token=ACCESS_TOKEN
     *
     * @param speedupCodeAuditRequest
     */
    SpeedupCodeAuditResponse speedupCodeAudit(SpeedupCodeAuditRequest speedupCodeAuditRequest);

    /**
     * description:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/getVersionInfo.html
     * api: https://api.weixin.qq.com/wxa/getversioninfo?access_token=ACCESS_TOKEN
     *
     * @param getVersionInfoRequest
     */
    GetVersionInfoResponse getVersionInfo(GetVersionInfoRequest getVersionInfoRequest);

    /**
     * description: 调用本接口可以查询最新一次提审单的审核状态。使用过程中如遇到问题，可在发帖交流
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/getLatestAuditStatus.html
     * api: https://api.weixin.qq.com/wxa/get_latest_auditstatus?access_token=ACCESS_TOKEN
     *
     * @param getLatestAuditStatusRequest
     */
    GetLatestAuditStatusResponse getLatestAuditStatus(GetLatestAuditStatusRequest getLatestAuditStatusRequest);

    /**
     * description: 调用本接口可将小程序页面截图和操作录屏上传，提审时带上相关参数，可以帮助审核人员判断
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/uploadMediaToCodeAudit.html
     * api: https://api.weixin.qq.com/wxa/uploadmedia?access_token=ACCESS_TOKEN
     *
     * @param uploadMediaToCodeAuditRequest
     */
    UploadMediaToCodeAuditResponse uploadMediaToCodeAudit(UploadMediaToCodeAuditRequest uploadMediaToCodeAuditRequest);

    /**
     * description:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/code-management/getCodePrivacyInfo.html
     * api: https://api.weixin.qq.com/wxa/security/get_code_privacy_info?access_token=ACCESS_TOKEN
     *
     * @param getCodePrivacyInfoRequest
     */
    GetCodePrivacyInfoResponse getCodePrivacyInfo(GetCodePrivacyInfoRequest getCodePrivacyInfoRequest);
}