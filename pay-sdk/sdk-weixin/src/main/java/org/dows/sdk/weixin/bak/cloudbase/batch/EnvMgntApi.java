package org.dows.sdk.weixin.bak.cloudbase.batch;

import org.dows.sdk.weixin.bak.cloudbase.batch.request.*;
import org.dows.sdk.weixin.bak.cloudbase.batch.response.*;

/**
 * @author lait.zhang@gmail.com
 * @description envMgntApi
 * @date 2023年5月29日 上午11:32:00
 */
public interface EnvMgntApi {

    /**
     * description: 通过本接口可以将腾讯云控制台创建的环境变更为微信小程序的环境。使用过程中如遇到问题，可在发帖交流
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/env-mgnt/changeTcbEnv.html
     * api: https://api.weixin.qq.com/tcb/modifyenv?access_token=ACCESS_TOKEN
     *
     * @param changeTcbEnvRequest
     */
    ChangeTcbEnvResponse changeTcbEnv(ChangeTcbEnvRequest changeTcbEnvRequest);

    /**
     * description: 通过本接口可以开启或关闭cloudbase_access_token的使用权限，使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/env-mgnt/setCloudAccessToken.html
     * api: https://api.weixin.qq.com/tcb/usecloudaccesstoken?access_token=ACCESS_TOKEN
     *
     * @param setCloudAccessTokenRequest
     */
    SetCloudAccessTokenResponse setCloudAccessToken(SetCloudAccessTokenRequest setCloudAccessTokenRequest);

    /**
     * description: 通过本接口可以批量查询小程序被共享的环境id，使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/env-mgnt/getShareCloudbaseEnv.html
     * api: https://api.weixin.qq.com/componenttcb/batchgetenvid?access_token=ACCESS_TOKEN
     *
     * @param getShareCloudbaseEnvRequest
     */
    GetShareCloudbaseEnvResponse getShareCloudbaseEnv(GetShareCloudbaseEnvRequest getShareCloudbaseEnvRequest);

    /**
     * description: 通过本接口可以获取环境列表，使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/env-mgnt/getTcbEnvList.html
     * api: https://api.weixin.qq.com/componenttcb/describeenvs?access_token=ACCESS_TOKEN
     *
     * @param getTcbEnvListRequest
     */
    GetTcbEnvListResponse getTcbEnvList(GetTcbEnvListRequest getTcbEnvListRequest);

    /**
     * description: 通过本接口可以创建环境，使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/env-mgnt/createTcbEnv.html
     * api: https://api.weixin.qq.com/componenttcb/createenv?access_token=ACCESS_TOKEN
     *
     * @param createTcbEnvRequest
     */
    CreateTcbEnvResponse createTcbEnv(CreateTcbEnvRequest createTcbEnvRequest);

    /**
     * description: 通过本接口可以将环境共享给小程序（也称将小程序与环境绑定），使用过程中如遇到问题，可在发帖交流。服务商需将 msg_info_list 中的确认链接发送给小程序管理员，经小程序管理员确认允许绑定后，绑定正式生效。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/env-mgnt/shareCloudbaseEnv.html
     * api: https://api.weixin.qq.com/componenttcb/batchshareenv?access_token=ACCESS_TOKEN
     *
     * @param shareCloudbaseEnvRequest
     */
    ShareCloudbaseEnvResponse shareCloudbaseEnv(ShareCloudbaseEnvRequest shareCloudbaseEnvRequest);
}