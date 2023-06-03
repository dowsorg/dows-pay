package org.dows.sdk.weixin.bak.cloudbase.batch;

import org.dows.sdk.weixin.bak.cloudbase.batch.request.*;
import org.dows.sdk.weixin.bak.cloudbase.batch.response.*;

/**
 * @author lait.zhang@gmail.com
 * @description scfMgntApi
 * @date 2023年5月29日 上午11:32:00
 */
public interface ScfMgntApi {

    /**
     * description: 通过本接口可以批量创建云函数，使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/scf-mgnt/batchuUloadCloudFunction.html
     * api: https://api.weixin.qq.com/componenttcb/batchuploadscf?access_token=ACCESS_TOKEN
     *
     * @param batchuUloadCloudFunctionRequest
     */
    BatchuUloadCloudFunctionResponse batchuUloadCloudFunction(BatchuUloadCloudFunctionRequest batchuUloadCloudFunctionRequest);

    /**
     * description: 通过本接口可以更新云函数配置，使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/scf-mgnt/uploadCloudFunctionConfig.html
     * api: https://api.weixin.qq.com/componenttcb/updatescfconfig?access_token=ACCESS_TOKEN
     *
     * @param uploadCloudFunctionConfigRequest
     */
    UploadCloudFunctionConfigResponse uploadCloudFunctionConfig(UploadCloudFunctionConfigRequest uploadCloudFunctionConfigRequest);

    /**
     * description: 通过本接口可以删除云函数，使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/scf-mgnt/deleteCloudFunction.html
     * api: https://api.weixin.qq.com/componenttcb/deletescf?access_token=ACCESS_TOKEN
     *
     * @param deleteCloudFunctionRequest
     */
    DeleteCloudFunctionResponse deleteCloudFunction(DeleteCloudFunctionRequest deleteCloudFunctionRequest);

    /**
     * description: 通过本接口可以获取云函数列表，使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/scf-mgnt/getCloudFunctionList.html
     * api: https://api.weixin.qq.com/componenttcb/getscflist?access_token=ACCESS_TOKEN
     *
     * @param getCloudFunctionListRequest
     */
    GetCloudFunctionListResponse getCloudFunctionList(GetCloudFunctionListRequest getCloudFunctionListRequest);

    /**
     * description: 通过本接口可以获取触发器，使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/scf-mgnt/getTriggers.html
     * api: https://api.weixin.qq.com/componenttcb/gettriggers?access_token=ACCESS_TOKEN
     *
     * @param getTriggersRequest
     */
    GetTriggersResponse getTriggers(GetTriggersRequest getTriggersRequest);

    /**
     * description: 通过本接口可以批量更新触发器，使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/scf-mgnt/updateTriggers.html
     * api: https://api.weixin.qq.com/componenttcb/batchupdatetriggers?access_token=ACCESS_TOKEN
     *
     * @param updateTriggersRequest
     */
    UpdateTriggersResponse updateTriggers(UpdateTriggersRequest updateTriggersRequest);

    /**
     * description: 通过本接口可以触发云函数。 使用过程中如遇到问题，可在发帖交流
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/scf-mgnt/invokeCloudFunction.html
     * api: New https://api.weixin.qq.com/tcb/invokecloudfunction?access_token=ACCESS_TOKEN
     *
     * @param invokeCloudFunctionRequest
     */
    InvokeCloudFunctionResponse invokeCloudFunction(InvokeCloudFunctionRequest invokeCloudFunctionRequest);

    /**
     * description: 通过本接口可以批量更新云函数代码
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/scf-mgnt/uploadCloudFunctionCode.html
     * api: https://api.weixin.qq.com/componenttcb/batchuploadscfcode?access_token=ACCESS_TOKEN
     *
     * @param uploadCloudFunctionCodeRequest
     */
    UploadCloudFunctionCodeResponse uploadCloudFunctionCode(UploadCloudFunctionCodeRequest uploadCloudFunctionCodeRequest);
}