package org.dows.sdk.weixin.miniprogram.management;

import org.dows.sdk.weixin.miniprogram.management.request.*;
import org.dows.sdk.weixin.miniprogram.management.response.*;

/**
 * @author
 * @description 调用方式以及出入参和HTTPS相同，仅是调用的token不同该接口所属的权限集id为：18服务商获得其中之一权限集授权后，可通过使用代商家进行调用https://developers.weixin.qq.com/community/develop/doc/000a02f2c5026891650e7f40351c01
 * @date
 */
public interface CodeManagementApi {
    /**
     * 补充说明：特殊字段说明：
     *
     * @param commitRequest
     */
    CommitResponse commit(CommitRequest commitRequest);

    /**
     * 通过本接口可以获取由commit接口上传代码的页面列表；使用过程中如遇到问题，可在发帖交流。
     *
     * @param getCodePageRequest
     */
    GetCodePageResponse getCodePage(GetCodePageRequest getCodePageRequest);

    /**
     * 调用本接口可以获取小程序的体验版二维码。使用过程中如遇到问题，可在发帖交流。请求正常的情况下，开发者可以直接将返回的二进制结果（response body）保存成图片。返回的 HTTP 头如下：
     *
     * @param getTrialQRCodeRequest
     */
    GetTrialQRCodeResponse getTrialQRCode(GetTrialQRCodeRequest getTrialQRCodeRequest);

    /**
     * 当小程序有审核结果后，微信服务器会向第三方平台方的消息与事件接收 URL（创建第三方平台时填写）以的方式推送相关通知接收请求后，只需直接返回字符串。为了加强安全性，postdata 中的 xml 将使用服务申请时的加解密 key 来进行加密，具体请见, 在收到推送后需进行解密（详细请见）,除了消息通知之外，第三方平台也可通过接口、
     *
     * @param submitAuditRequest
     */
    SubmitAuditResponse submitAudit(SubmitAuditRequest submitAuditRequest);

    /**
     * 通过接口提交审核后，调用本接口可以查询指定发布审核单的审核状态。使用过程中如遇到问题，可在发帖交流。
     *
     * @param getAuditStatusRequest
     */
    GetAuditStatusResponse getAuditStatus(GetAuditStatusRequest getAuditStatusRequest);

    /**
     * 调用本接口可以撤回当前的代码审核单。使用过程中如遇到问题，可在发帖交流。
     *
     * @param undoAuditRequest
     */
    UndoAuditResponse undoAudit(UndoAuditRequest undoAuditRequest);

    /**
     * 调用本接口可以发布最后一个审核通过的小程序代码版本。使用过程中如遇到问题，可在发帖交流。
     *
     * @param releaseRequest
     */
    ReleaseResponse release(ReleaseRequest releaseRequest);

    /**
     * 调用本接口可以将小程序的线上版本进行回退。使用过程中如遇到问题，可在发帖交流。
     *
     * @param revertCodeReleaseRequest
     */
    RevertCodeReleaseResponse revertCodeRelease(RevertCodeReleaseRequest revertCodeReleaseRequest);

    /**
     * @param grayReleaseRequest
     */
    GrayReleaseResponse grayRelease(GrayReleaseRequest grayReleaseRequest);

    /**
     * 该接口用于查询当前分阶段发布详情
     *
     * @param getGrayReleasePlanRequest
     */
    GetGrayReleasePlanResponse getGrayReleasePlan(GetGrayReleasePlanRequest getGrayReleasePlanRequest);

    /**
     * @param setVisitStatusRequest
     */
    SetVisitStatusResponse setVisitStatus(SetVisitStatusRequest setVisitStatusRequest);

    /**
     * @param revertGrayReleaseRequest
     */
    RevertGrayReleaseResponse revertGrayRelease(RevertGrayReleaseRequest revertGrayReleaseRequest);

    /**
     * @param getVisitStatusRequest
     */
    GetVisitStatusResponse getVisitStatus(GetVisitStatusRequest getVisitStatusRequest);

    /**
     * 调用本接口可以查询小程序当前设置的最低基础库版本，以及小程序在各个基础库版本的用户占比。使用过程中如遇到问题，可在发帖交流。
     *
     * @param getSupportVersionRequest
     */
    GetSupportVersionResponse getSupportVersion(GetSupportVersionRequest getSupportVersionRequest);

    /**
     * @param setSupportVersionRequest
     */
    SetSupportVersionResponse setSupportVersion(SetSupportVersionRequest setSupportVersionRequest);

    /**
     * 服务商可以调用该接口，查询当月平台分配的提审限额和剩余可提审次数，以及当月分配的审核加急次数和剩余加急次数。（所有旗下小程序共用该额度） 使用过程中如遇到问题，可在发帖交流。
     *
     * @param setCodeAuditQuotaRequest
     */
    SetCodeAuditQuotaResponse setCodeAuditQuota(SetCodeAuditQuotaRequest setCodeAuditQuotaRequest);

    /**
     * 有加急次数的第三方可以通过该接口，对已经提审的小程序进行加急操作，加急后的小程序预计2-12小时内审完。但是若代码中包含较复杂逻辑或其他特殊情况，可能会导致审核时间延长。使用过程中如遇到问题，可在发帖交流。
     *
     * @param speedupCodeAuditRequest
     */
    SpeedupCodeAuditResponse speedupCodeAudit(SpeedupCodeAuditRequest speedupCodeAuditRequest);

    /**
     * @param getVersionInfoRequest
     */
    GetVersionInfoResponse getVersionInfo(GetVersionInfoRequest getVersionInfoRequest);

    /**
     * 调用本接口可以查询最新一次提审单的审核状态。使用过程中如遇到问题，可在发帖交流
     *
     * @param getLatestAuditStatusRequest
     */
    GetLatestAuditStatusResponse getLatestAuditStatus(GetLatestAuditStatusRequest getLatestAuditStatusRequest);

    /**
     * 调用本接口可将小程序页面截图和操作录屏上传，提审时带上相关参数，可以帮助审核人员判断
     *
     * @param uploadMediaToCodeAuditRequest
     */
    UploadMediaToCodeAuditResponse uploadMediaToCodeAudit(UploadMediaToCodeAuditRequest uploadMediaToCodeAuditRequest);

    /**
     * @param getCodePrivacyInfoRequest
     */
    GetCodePrivacyInfoResponse getCodePrivacyInfo(GetCodePrivacyInfoRequest getCodePrivacyInfoRequest);

}
