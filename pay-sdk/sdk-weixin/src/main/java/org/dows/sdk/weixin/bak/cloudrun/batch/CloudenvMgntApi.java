package org.dows.sdk.weixin.bak.cloudrun.batch;

import org.dows.sdk.weixin.bak.cloudrun.batch.request.*;
import org.dows.sdk.weixin.bak.cloudrun.batch.response.*;

/**
 * @author lait.zhang@gmail.com
 * @description cloudenvMgntApi
 * @date 2023年5月29日 上午11:32:00
 */
public interface CloudenvMgntApi {

    /**
     * description: 通过本接口可以批量查询小程序被共享的环境id，使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudrun-batch/cloudenv-mgnt/getShareCloudbaseEnv.html
     * api: https://api.weixin.qq.com/componenttcb/batchgetenvid?access_token=ACCESS_TOKEN
     *
     * @param getShareCloudbaseEnvRequest
     */
    GetShareCloudbaseEnvResponse getShareCloudbaseEnv(GetShareCloudbaseEnvRequest getShareCloudbaseEnvRequest);

    /**
     * description: 通过本接口可以将环境共享给小程序（也称将小程序与环境绑定），使用过程中如遇到问题，可在发帖交流。服务商需将 msg_info_list 中的确认链接发送给小程序管理员，经小程序管理员确认允许绑定后，绑定正式生效。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudrun-batch/cloudenv-mgnt/shareCloudbaseEnv.html
     * api: https://api.weixin.qq.com/componenttcb/batchshareenv?access_token=ACCESS_TOKEN
     *
     * @param shareCloudbaseEnvRequest
     */
    ShareCloudbaseEnvResponse shareCloudbaseEnv(ShareCloudbaseEnvRequest shareCloudbaseEnvRequest);

    /**
     * description: 通过本接口可以查询微信云托管环境信息，使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudrun-batch/cloudenv-mgnt/getWxCloudBaseRunEnvs.html
     * api: https://api.weixin.qq.com/componenttcb/describecloudbaserunenvs?access_token=ACCESS_TOKEN
     *
     * @param getWxCloudBaseRunEnvsRequest
     */
    GetWxCloudBaseRunEnvsResponse getWxCloudBaseRunEnvs(GetWxCloudBaseRunEnvsRequest getWxCloudBaseRunEnvsRequest);

    /**
     * description: 通过本接口可以创建微信云托管环境，使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudrun-batch/cloudenv-mgnt/createCloudbaseEnv.html
     * api: https://api.weixin.qq.com/componenttcb/createcloudbaserunenv?access_token=ACCESS_TOKEN
     *
     * @param createCloudbaseEnvRequest
     */
    CreateCloudbaseEnvResponse createCloudbaseEnv(CreateCloudbaseEnvRequest createCloudbaseEnvRequest);

    /**
     * description: 通过本接口可以解除和对应小程序环境共享关联关系（也称将小程序解除环境绑定），使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudrun-batch/cloudenv-mgnt/unshareCloudbaseEnv.html
     * api: https://api.weixin.qq.com/componenttcb/batchunshareenv?access_token=ACCESS_TOKEN
     *
     * @param unshareCloudbaseEnvRequest
     */
    UnshareCloudbaseEnvResponse unshareCloudbaseEnv(UnshareCloudbaseEnvRequest unshareCloudbaseEnvRequest);
}