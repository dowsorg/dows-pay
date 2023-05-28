package org.dows.sdk.weixin.cloudbase.batch;

/**
 * @description staticstoreManagementApi
 * @author lait.zhang@gmail.com
 * @date  2023年5月28日 下午9:55:33
 */
public interface StaticstoreManagementApi{

    /**
     * 通过本接口可以查看静态网站状态，使用过程中如遇到问题，可在发帖交流。
     * https://api.weixin.qq.com/componenttcb/describestaticstore?access_token=ACCESS_TOKEN
     * 
     * @param getStaticStoreRequest
     * 
     */
    GetStaticStoreResponse getStaticStore(GetStaticStoreRequest getStaticStoreRequest);

    /**
     * 通过本接口可以开通静态网站，使用过程中如遇到问题，可在发帖交流。
     * https://api.weixin.qq.com/componenttcb/createstaticstore?access_token=ACCESS_TOKEN
     * 
     * @param createStaticStoreRequest
     * 
     */
    CreateStaticStoreResponse createStaticStore(CreateStaticStoreRequest createStaticStoreRequest);

    /**
     * 通过本接口可以获取上传静态网站文件链接，使用过程中如遇到问题，可在发帖交流。请求方法为 PUT url 为返回包的 signed_url 字段 需增加 key 为 x-cos-security-token，value 为返回包的中token字段的Header 请求体为需上传的文件内容
     * https://api.weixin.qq.com/componenttcb/staticuploadfile?access_token=ACCESS_TOKEN
     * 
     * @param getUploadStaticStoreFileRequest
     * 
     */
    GetUploadStaticStoreFileResponse getUploadStaticStoreFile(GetUploadStaticStoreFileRequest getUploadStaticStoreFileRequest);

    /**
     * 通过本接口可以配置获取静态网站文件列表，使用过程中如遇到问题，可在发帖交流。
     * https://api.weixin.qq.com/componenttcb/staticfilelist?access_token=ACCESS_TOKEN
     * 
     * @param getStaticStoreFileRequest
     * 
     */
    GetStaticStoreFileResponse getStaticStoreFile(GetStaticStoreFileRequest getStaticStoreFileRequest);
}