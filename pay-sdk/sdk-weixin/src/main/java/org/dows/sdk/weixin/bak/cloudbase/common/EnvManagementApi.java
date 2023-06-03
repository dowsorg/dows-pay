package org.dows.sdk.weixin.bak.cloudbase.common;

import org.dows.sdk.weixin.bak.cloudbase.common.request.ChangeTcbEnvRequest;
import org.dows.sdk.weixin.bak.cloudbase.common.request.CreateEnvRequest;
import org.dows.sdk.weixin.bak.cloudbase.common.request.GetEnvInfoRequest;
import org.dows.sdk.weixin.bak.cloudbase.common.request.ShareEnvRequest;
import org.dows.sdk.weixin.bak.cloudbase.common.response.ChangeTcbEnvResponse;
import org.dows.sdk.weixin.bak.cloudbase.common.response.CreateEnvResponse;
import org.dows.sdk.weixin.bak.cloudbase.common.response.GetEnvInfoResponse;
import org.dows.sdk.weixin.bak.cloudbase.common.response.ShareEnvResponse;

/**
 * @author lait.zhang@gmail.com
 * @description envManagementApi
 * @date 2023年5月29日 上午11:32:00
 */
public interface EnvManagementApi {

    /**
     * description: 通过本接口可以将腾讯云控制台创建的环境变更为微信小程序的环境。使用过程中如遇到问题，可在发帖交流
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/env-management/changeTcbEnv.html
     * api: https://api.weixin.qq.com/tcb/modifyenv?access_token=ACCESS_TOKEN
     *
     * @param changeTcbEnvRequest
     */
    ChangeTcbEnvResponse changeTcbEnv(ChangeTcbEnvRequest changeTcbEnvRequest);

    /**
     * description: 通过本接口可以创建云环境。使用过程中如遇到问题，可在发帖交流。请注意，旧版调整至当前接口，请开发者逐步进行接口切换。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/env-management/createEnv.html
     * api: https://api.weixin.qq.com/tcb/createenvandresource?access_token=ACCESS_TOKEN
     *
     * @param createEnvRequest
     */
    CreateEnvResponse createEnv(CreateEnvRequest createEnvRequest);

    /**
     * description: 通过本接口可以获取已有的云环境信息。使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/env-management/getEnvInfo.html
     * api: https://api.weixin.qq.com/tcb/getenvinfo?access_token=ACCESS_TOKEN
     *
     * @param getEnvInfoRequest
     */
    GetEnvInfoResponse getEnvInfo(GetEnvInfoRequest getEnvInfoRequest);

    /**
     * description: 通过本接口可以环境共享。使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/env-management/shareEnv.html
     * api: https://api.weixin.qq.com/tcb/shareenv?access_token=ACCESS_TOKEN
     *
     * @param shareEnvRequest
     */
    ShareEnvResponse shareEnv(ShareEnvRequest shareEnvRequest);
}