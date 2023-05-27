package org.dows.sdk.weixin.cloudbase.common;

import org.dows.sdk.weixin.cloudbase.common.request.*;
import org.dows.sdk.weixin.cloudbase.common.response.*;

/**
 * @author
 * @description 调用方式以及出入参和HTTPS相同，仅是调用的token不同该接口所属的权限集id为：49、64服务商获得其中之一权限集授权后，可通过使用代商家进行调用
 * @date
 */
public interface ScfManagementApi {
    /**
     * 通过本接口可以触发云函数。 使用过程中如遇到问题，可在发帖交流
     *
     * @param invokeCloudFunctionRequest
     */
    InvokeCloudFunctionResponse invokeCloudFunction(InvokeCloudFunctionRequest invokeCloudFunctionRequest);

    /**
     * 通过本接口可以创建云函数。使用过程中如遇到问题，可在发帖交流。
     *
     * @param createFunctionRequest
     */
    CreateFunctionResponse createFunction(CreateFunctionRequest createFunctionRequest);

    /**
     * 通过本接口可以获取代码保护密钥。使用过程中如遇到问题，可在发帖交流。
     *
     * @param getCodeSecretRequest
     */
    GetCodeSecretResponse getCodeSecret(GetCodeSecretRequest getCodeSecretRequest);

    /**
     * 通过本接口可以获取上传云函数签名header 。使用过程中如遇到问题，可在发帖交流。hashed_payload是请求POST数据的签名，具体参数参考的请求参数。签名过程参考如下JavaScript代码片段：
     *
     * @param getYploadSignatureRequest
     */
    GetYploadSignatureResponse getYploadSignature(GetYploadSignatureRequest getYploadSignatureRequest);

    /**
     * 通过本接口可以获取云函数列表。使用过程中如遇到问题，可在发帖交流。
     *
     * @param getFuntionListRequest
     */
    GetFuntionListResponse getFuntionList(GetFuntionListRequest getFuntionListRequest);

    /**
     * 通过本接口可以获取云函数下载地址。使用过程中如遇到问题，可在发帖交流。
     *
     * @param getFuntionLinkRequest
     */
    GetFuntionLinkResponse getFuntionLink(GetFuntionLinkRequest getFuntionLinkRequest);

    /**
     * 通过本接口可以上传云函数配置。使用过程中如遇到问题，可在发帖交流。
     *
     * @param getUploadFuntionConfigRequest
     */
    GetUploadFuntionConfigResponse getUploadFuntionConfig(GetUploadFuntionConfigRequest getUploadFuntionConfigRequest);

    /**
     * 通过本接口可以获取云函数配置。使用过程中如遇到问题，可在发帖交流。
     *
     * @param getFuntionConfigRequest
     */
    GetFuntionConfigResponse getFuntionConfig(GetFuntionConfigRequest getFuntionConfigRequest);


}
