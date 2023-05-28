package org.dows.sdk.weixin.cloudbase.common;

import org.dows.sdk.weixin.cloudbase.common.request.ChangeTcbEnvRequest;
import org.dows.sdk.weixin.cloudbase.common.request.CreateEnvRequest;
import org.dows.sdk.weixin.cloudbase.common.request.GetEnvInfoRequest;
import org.dows.sdk.weixin.cloudbase.common.request.ShareEnvRequest;
import org.dows.sdk.weixin.cloudbase.common.response.ChangeTcbEnvResponse;
import org.dows.sdk.weixin.cloudbase.common.response.CreateEnvResponse;
import org.dows.sdk.weixin.cloudbase.common.response.GetEnvInfoResponse;
import org.dows.sdk.weixin.cloudbase.common.response.ShareEnvResponse;

/**
 * @author lait.zhang@gmail.com
 * @Date 2023年5月28日 下午9:25:34
 * @description envManagementApi
 */
public interface EnvManagementApi {

    /**
     * 通过本接口可以将腾讯云控制台创建的环境变更为微信小程序的环境。使用过程中如遇到问题，可在发帖交流
     * https://api.weixin.qq.com/tcb/modifyenv?access_token=ACCESS_TOKEN
     *
     * @param changeTcbEnvRequest
     */
    ChangeTcbEnvResponse changeTcbEnv(ChangeTcbEnvRequest changeTcbEnvRequest);

    /**
     * 通过本接口可以创建云环境。使用过程中如遇到问题，可在发帖交流。请注意，旧版调整至当前接口，请开发者逐步进行接口切换。
     * https://api.weixin.qq.com/tcb/createenvandresource?access_token=ACCESS_TOKEN
     *
     * @param createEnvRequest
     */
    CreateEnvResponse createEnv(CreateEnvRequest createEnvRequest);

    /**
     * 通过本接口可以获取已有的云环境信息。使用过程中如遇到问题，可在发帖交流。
     * https://api.weixin.qq.com/tcb/getenvinfo?access_token=ACCESS_TOKEN
     *
     * @param getEnvInfoRequest
     */
    GetEnvInfoResponse getEnvInfo(GetEnvInfoRequest getEnvInfoRequest);

    /**
     * 通过本接口可以环境共享。使用过程中如遇到问题，可在发帖交流。
     * https://api.weixin.qq.com/tcb/shareenv?access_token=ACCESS_TOKEN
     *
     * @param shareEnvRequest
     */
    ShareEnvResponse shareEnv(ShareEnvRequest shareEnvRequest);
}