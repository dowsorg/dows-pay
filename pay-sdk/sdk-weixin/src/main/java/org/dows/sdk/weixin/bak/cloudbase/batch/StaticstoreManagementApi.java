package org.dows.sdk.weixin.bak.cloudbase.batch;

import org.dows.sdk.weixin.bak.cloudbase.batch.request.CreateStaticStoreRequest;
import org.dows.sdk.weixin.bak.cloudbase.batch.request.GetStaticStoreFileRequest;
import org.dows.sdk.weixin.bak.cloudbase.batch.request.GetStaticStoreRequest;
import org.dows.sdk.weixin.bak.cloudbase.batch.request.GetUploadStaticStoreFileRequest;
import org.dows.sdk.weixin.bak.cloudbase.batch.response.CreateStaticStoreResponse;
import org.dows.sdk.weixin.bak.cloudbase.batch.response.GetStaticStoreFileResponse;
import org.dows.sdk.weixin.bak.cloudbase.batch.response.GetStaticStoreResponse;
import org.dows.sdk.weixin.bak.cloudbase.batch.response.GetUploadStaticStoreFileResponse;

/**
 * @author lait.zhang@gmail.com
 * @description staticstoreManagementApi
 * @date 2023年5月29日 上午11:32:00
 */
public interface StaticstoreManagementApi {

    /**
     * description: 通过本接口可以查看静态网站状态，使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/staticstore-management/getStaticStore.html
     * api: https://api.weixin.qq.com/componenttcb/describestaticstore?access_token=ACCESS_TOKEN
     *
     * @param getStaticStoreRequest
     */
    GetStaticStoreResponse getStaticStore(GetStaticStoreRequest getStaticStoreRequest);

    /**
     * description: 通过本接口可以开通静态网站，使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/staticstore-management/createStaticStore.html
     * api: https://api.weixin.qq.com/componenttcb/createstaticstore?access_token=ACCESS_TOKEN
     *
     * @param createStaticStoreRequest
     */
    CreateStaticStoreResponse createStaticStore(CreateStaticStoreRequest createStaticStoreRequest);

    /**
     * description: 通过本接口可以获取上传静态网站文件链接，使用过程中如遇到问题，可在发帖交流。请求方法为 PUT url 为返回包的 signed_url 字段 需增加 key 为 x-cos-security-token，value 为返回包的中token字段的Header 请求体为需上传的文件内容
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/staticstore-management/getUploadStaticStoreFile.html
     * api: https://api.weixin.qq.com/componenttcb/staticuploadfile?access_token=ACCESS_TOKEN
     *
     * @param getUploadStaticStoreFileRequest
     */
    GetUploadStaticStoreFileResponse getUploadStaticStoreFile(GetUploadStaticStoreFileRequest getUploadStaticStoreFileRequest);

    /**
     * description: 通过本接口可以配置获取静态网站文件列表，使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/staticstore-management/getStaticStoreFile.html
     * api: https://api.weixin.qq.com/componenttcb/staticfilelist?access_token=ACCESS_TOKEN
     *
     * @param getStaticStoreFileRequest
     */
    GetStaticStoreFileResponse getStaticStoreFile(GetStaticStoreFileRequest getStaticStoreFileRequest);
}