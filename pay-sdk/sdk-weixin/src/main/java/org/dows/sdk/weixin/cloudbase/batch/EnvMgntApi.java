package org.dows.sdk.weixin.cloudbase.batch;

import org.dows.sdk.weixin.cloudbase.batch.request.CreateTcbEnvRequest;
import org.dows.sdk.weixin.cloudbase.batch.request.GetTcbEnvListRequest;
import org.dows.sdk.weixin.cloudbase.batch.response.CreateTcbEnvResponse;
import org.dows.sdk.weixin.cloudbase.batch.response.GetTcbEnvListResponse;

/**
 * @author
 * @description 调用方式以及出入参和HTTPS相同，仅是调用的token不同该接口所属的权限集id为：49、64服务商获得其中之一权限集授权后，可通过使用代商家进行调用
 * @date
 */
public interface EnvMgntApi {
    /**
     * 通过本接口可以将腾讯云控制台创建的环境变更为微信小程序的环境。使用过程中如遇到问题，可在发帖交流
     *
     * @param changeTcbEnvRequest
     */
    ChangeTcbEnvResponse changeTcbEnv(ChangeTcbEnvRequest changeTcbEnvRequest);

    /**
     * 通过本接口可以开启或关闭cloudbase_access_token的使用权限，使用过程中如遇到问题，可在发帖交流。
     *
     * @param setCloudAccessTokenRequest
     */
    SetCloudAccessTokenResponse setCloudAccessToken(SetCloudAccessTokenRequest setCloudAccessTokenRequest);

    /**
     * 通过本接口可以批量查询小程序被共享的环境id，使用过程中如遇到问题，可在发帖交流。
     *
     * @param getShareCloudbaseEnvRequest
     */
    GetShareCloudbaseEnvResponse getShareCloudbaseEnv(GetShareCloudbaseEnvRequest getShareCloudbaseEnvRequest);

    /**
     * 通过本接口可以获取环境列表，使用过程中如遇到问题，可在发帖交流。
     *
     * @param getTcbEnvListRequest
     */
    GetTcbEnvListResponse getTcbEnvList(GetTcbEnvListRequest getTcbEnvListRequest);

    /**
     * 通过本接口可以创建环境，使用过程中如遇到问题，可在发帖交流。
     *
     * @param createTcbEnvRequest
     */
    CreateTcbEnvResponse createTcbEnv(CreateTcbEnvRequest createTcbEnvRequest);

    /**
     * 通过本接口可以将环境共享给小程序（也称将小程序与环境绑定），使用过程中如遇到问题，可在发帖交流。服务商需将 msg_info_list 中的确认链接发送给小程序管理员，经小程序管理员确认允许绑定后，绑定正式生效。
     *
     * @param shareCloudbaseEnvRequest
     */
    ShareCloudbaseEnvResponse shareCloudbaseEnv(ShareCloudbaseEnvRequest shareCloudbaseEnvRequest);

}
