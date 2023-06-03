package org.dows.sdk.weixin.bak.cloudbase.common;

import org.dows.sdk.weixin.bak.cloudbase.common.request.*;
import org.dows.sdk.weixin.bak.cloudbase.common.response.*;

/**
 * @author lait.zhang@gmail.com
 * @description scfManagementApi
 * @date 2023年5月29日 上午11:32:00
 */
public interface ScfManagementApi {

    /**
     * description: 通过本接口可以触发云函数。 使用过程中如遇到问题，可在发帖交流
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/scf-management/invokeCloudFunction.html
     * api: New https://api.weixin.qq.com/tcb/invokecloudfunction?access_token=ACCESS_TOKEN
     *
     * @param invokeCloudFunctionRequest
     */
    InvokeCloudFunctionResponse invokeCloudFunction(InvokeCloudFunctionRequest invokeCloudFunctionRequest);

    /**
     * description: 通过本接口可以创建云函数。使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/scf-management/createFunction.html
     * api: https://api.weixin.qq.com/tcb/createfunction?access_token=ACCESS_TOKEN
     *
     * @param createFunctionRequest
     */
    CreateFunctionResponse createFunction(CreateFunctionRequest createFunctionRequest);

    /**
     * description: 通过本接口可以获取代码保护密钥。使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/scf-management/getCodeSecret.html
     * api: https://api.weixin.qq.com/tcb/getcodesecret?access_token=ACCESS_TOKEN
     *
     * @param getCodeSecretRequest
     */
    GetCodeSecretResponse getCodeSecret(GetCodeSecretRequest getCodeSecretRequest);

    /**
     * description: 通过本接口可以获取上传云函数签名header 。使用过程中如遇到问题，可在发帖交流。hashed_payload是请求POST数据的签名，具体参数参考的请求参数。签名过程参考如下JavaScript代码片段：
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/scf-management/getYploadSignature.html
     * api: https://api.weixin.qq.com/tcb/getuploadsignature?access_token=ACCESS_TOKEN
     *
     * @param getYploadSignatureRequest
     */
    GetYploadSignatureResponse getYploadSignature(GetYploadSignatureRequest getYploadSignatureRequest);

    /**
     * description: 通过本接口可以获取云函数列表。使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/scf-management/getFuntionList.html
     * api: https://api.weixin.qq.com/tcb/listfunctions?access_token=ACCESS_TOKEN
     *
     * @param getFuntionListRequest
     */
    GetFuntionListResponse getFuntionList(GetFuntionListRequest getFuntionListRequest);

    /**
     * description: 通过本接口可以获取云函数下载地址。使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/scf-management/getFuntionLink.html
     * api: https://api.weixin.qq.com/tcb/downloadfunction?access_token=ACCESS_TOKEN
     *
     * @param getFuntionLinkRequest
     */
    GetFuntionLinkResponse getFuntionLink(GetFuntionLinkRequest getFuntionLinkRequest);

    /**
     * description: 通过本接口可以上传云函数配置。使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/scf-management/getUploadFuntionConfig.html
     * api: https://api.weixin.qq.com/tcb/uploadfuncconfig?access_token=ACCESS_TOKEN
     *
     * @param getUploadFuntionConfigRequest
     */
    GetUploadFuntionConfigResponse getUploadFuntionConfig(GetUploadFuntionConfigRequest getUploadFuntionConfigRequest);

    /**
     * description: 通过本接口可以获取云函数配置。使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/scf-management/getFuntionConfig.html
     * api: https://api.weixin.qq.com/tcb/getfuncconfig?access_token=ACCESS_TOKEN
     *
     * @param getFuntionConfigRequest
     */
    GetFuntionConfigResponse getFuntionConfig(GetFuntionConfigRequest getFuntionConfigRequest);
}