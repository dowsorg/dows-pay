package org.dows.sdk.weixin.cloudbase.common;

import org.dows.sdk.weixin.cloudbase.common.request.*;
import org.dows.sdk.weixin.cloudbase.common.response.*;

/**
 * @author lait.zhang@gmail.com
 * @description scfManagementApi
 * @date 2023年5月28日 下午9:55:33
 */
public interface ScfManagementApi {

    /**
     * 通过本接口可以触发云函数。 使用过程中如遇到问题，可在发帖交流
     * New https://api.weixin.qq.com/tcb/invokecloudfunction?access_token=ACCESS_TOKEN
     *
     * @param invokeCloudFunctionRequest
     */
    InvokeCloudFunctionResponse invokeCloudFunction(InvokeCloudFunctionRequest invokeCloudFunctionRequest);

    /**
     * 通过本接口可以创建云函数。使用过程中如遇到问题，可在发帖交流。
     * https://api.weixin.qq.com/tcb/createfunction?access_token=ACCESS_TOKEN
     *
     * @param createFunctionRequest
     */
    CreateFunctionResponse createFunction(CreateFunctionRequest createFunctionRequest);

    /**
     * 通过本接口可以获取代码保护密钥。使用过程中如遇到问题，可在发帖交流。
     * https://api.weixin.qq.com/tcb/getcodesecret?access_token=ACCESS_TOKEN
     *
     * @param getCodeSecretRequest
     */
    GetCodeSecretResponse getCodeSecret(GetCodeSecretRequest getCodeSecretRequest);

    /**
     * 通过本接口可以获取上传云函数签名header 。使用过程中如遇到问题，可在发帖交流。hashed_payload是请求POST数据的签名，具体参数参考的请求参数。签名过程参考如下JavaScript代码片段：
     * https://api.weixin.qq.com/tcb/getuploadsignature?access_token=ACCESS_TOKEN
     *
     * @param getYploadSignatureRequest
     */
    GetYploadSignatureResponse getYploadSignature(GetYploadSignatureRequest getYploadSignatureRequest);

    /**
     * 通过本接口可以获取云函数列表。使用过程中如遇到问题，可在发帖交流。
     * https://api.weixin.qq.com/tcb/listfunctions?access_token=ACCESS_TOKEN
     *
     * @param getFuntionListRequest
     */
    GetFuntionListResponse getFuntionList(GetFuntionListRequest getFuntionListRequest);

    /**
     * 通过本接口可以获取云函数下载地址。使用过程中如遇到问题，可在发帖交流。
     * https://api.weixin.qq.com/tcb/downloadfunction?access_token=ACCESS_TOKEN
     *
     * @param getFuntionLinkRequest
     */
    GetFuntionLinkResponse getFuntionLink(GetFuntionLinkRequest getFuntionLinkRequest);

    /**
     * 通过本接口可以上传云函数配置。使用过程中如遇到问题，可在发帖交流。
     * https://api.weixin.qq.com/tcb/uploadfuncconfig?access_token=ACCESS_TOKEN
     *
     * @param getUploadFuntionConfigRequest
     */
    GetUploadFuntionConfigResponse getUploadFuntionConfig(GetUploadFuntionConfigRequest getUploadFuntionConfigRequest);

    /**
     * 通过本接口可以获取云函数配置。使用过程中如遇到问题，可在发帖交流。
     * https://api.weixin.qq.com/tcb/getfuncconfig?access_token=ACCESS_TOKEN
     *
     * @param getFuntionConfigRequest
     */
    GetFuntionConfigResponse getFuntionConfig(GetFuntionConfigRequest getFuntionConfigRequest);
}