package org.dows.sdk.weixin.cloudrun.batch;

import org.dows.sdk.weixin.cloudrun.batch.request.CreateCloudbaseEnvRequest;
import org.dows.sdk.weixin.cloudrun.batch.request.GetWxCloudBaseRunEnvsRequest;
import org.dows.sdk.weixin.cloudrun.batch.request.UnshareCloudbaseEnvRequest;
import org.dows.sdk.weixin.cloudrun.batch.response.CreateCloudbaseEnvResponse;
import org.dows.sdk.weixin.cloudrun.batch.response.GetWxCloudBaseRunEnvsResponse;
import org.dows.sdk.weixin.cloudrun.batch.response.UnshareCloudbaseEnvResponse;

/**
 * @author
 * @description
 * @date
 */
public interface CloudenvMgntApi {
    /**
     * 通过本接口可以批量查询小程序被共享的环境id，使用过程中如遇到问题，可在发帖交流。
     *
     * @param getShareCloudbaseEnvRequest
     */
    GetShareCloudbaseEnvResponse getShareCloudbaseEnv(GetShareCloudbaseEnvRequest getShareCloudbaseEnvRequest);

    /**
     * 通过本接口可以将环境共享给小程序（也称将小程序与环境绑定），使用过程中如遇到问题，可在发帖交流。服务商需将 msg_info_list 中的确认链接发送给小程序管理员，经小程序管理员确认允许绑定后，绑定正式生效。
     *
     * @param shareCloudbaseEnvRequest
     */
    ShareCloudbaseEnvResponse shareCloudbaseEnv(ShareCloudbaseEnvRequest shareCloudbaseEnvRequest);

    /**
     * 通过本接口可以查询微信云托管环境信息，使用过程中如遇到问题，可在发帖交流。
     *
     * @param getWxCloudBaseRunEnvsRequest
     */
    GetWxCloudBaseRunEnvsResponse getWxCloudBaseRunEnvs(GetWxCloudBaseRunEnvsRequest getWxCloudBaseRunEnvsRequest);

    /**
     * 通过本接口可以创建微信云托管环境，使用过程中如遇到问题，可在发帖交流。
     *
     * @param createCloudbaseEnvRequest
     */
    CreateCloudbaseEnvResponse createCloudbaseEnv(CreateCloudbaseEnvRequest createCloudbaseEnvRequest);

    /**
     * 通过本接口可以解除和对应小程序环境共享关联关系（也称将小程序解除环境绑定），使用过程中如遇到问题，可在发帖交流。
     *
     * @param unshareCloudbaseEnvRequest
     */
    UnshareCloudbaseEnvResponse unshareCloudbaseEnv(UnshareCloudbaseEnvRequest unshareCloudbaseEnvRequest);

}
