package org.dows.sdk.weixin.cloudbase.batch;

/**
 * @description scfMgntApi
 * @author lait.zhang@gmail.com
 * @date  2023年5月28日 下午9:55:33
 */
public interface ScfMgntApi{

    /**
     * 通过本接口可以批量创建云函数，使用过程中如遇到问题，可在发帖交流。
     * https://api.weixin.qq.com/componenttcb/batchuploadscf?access_token=ACCESS_TOKEN
     * 
     * @param batchuUloadCloudFunctionRequest
     * 
     */
    BatchuUloadCloudFunctionResponse batchuUloadCloudFunction(BatchuUloadCloudFunctionRequest batchuUloadCloudFunctionRequest);

    /**
     * 通过本接口可以更新云函数配置，使用过程中如遇到问题，可在发帖交流。
     * https://api.weixin.qq.com/componenttcb/updatescfconfig?access_token=ACCESS_TOKEN
     * 
     * @param uploadCloudFunctionConfigRequest
     * 
     */
    UploadCloudFunctionConfigResponse uploadCloudFunctionConfig(UploadCloudFunctionConfigRequest uploadCloudFunctionConfigRequest);

    /**
     * 通过本接口可以删除云函数，使用过程中如遇到问题，可在发帖交流。
     * https://api.weixin.qq.com/componenttcb/deletescf?access_token=ACCESS_TOKEN
     * 
     * @param deleteCloudFunctionRequest
     * 
     */
    DeleteCloudFunctionResponse deleteCloudFunction(DeleteCloudFunctionRequest deleteCloudFunctionRequest);

    /**
     * 通过本接口可以获取云函数列表，使用过程中如遇到问题，可在发帖交流。
     * https://api.weixin.qq.com/componenttcb/getscflist?access_token=ACCESS_TOKEN
     * 
     * @param getCloudFunctionListRequest
     * 
     */
    GetCloudFunctionListResponse getCloudFunctionList(GetCloudFunctionListRequest getCloudFunctionListRequest);

    /**
     * 通过本接口可以获取触发器，使用过程中如遇到问题，可在发帖交流。
     * https://api.weixin.qq.com/componenttcb/gettriggers?access_token=ACCESS_TOKEN
     * 
     * @param getTriggersRequest
     * 
     */
    GetTriggersResponse getTriggers(GetTriggersRequest getTriggersRequest);

    /**
     * 通过本接口可以批量更新触发器，使用过程中如遇到问题，可在发帖交流。
     * https://api.weixin.qq.com/componenttcb/batchupdatetriggers?access_token=ACCESS_TOKEN
     * 
     * @param updateTriggersRequest
     * 
     */
    UpdateTriggersResponse updateTriggers(UpdateTriggersRequest updateTriggersRequest);

    /**
     * 通过本接口可以触发云函数。 使用过程中如遇到问题，可在发帖交流
     * New https://api.weixin.qq.com/tcb/invokecloudfunction?access_token=ACCESS_TOKEN
     * 
     * @param invokeCloudFunctionRequest
     * 
     */
    InvokeCloudFunctionResponse invokeCloudFunction(InvokeCloudFunctionRequest invokeCloudFunctionRequest);

    /**
     * 通过本接口可以批量更新云函数代码
     * https://api.weixin.qq.com/componenttcb/batchuploadscfcode?access_token=ACCESS_TOKEN
     * 
     * @param uploadCloudFunctionCodeRequest
     * 
     */
    UploadCloudFunctionCodeResponse uploadCloudFunctionCode(UploadCloudFunctionCodeRequest uploadCloudFunctionCodeRequest);
}