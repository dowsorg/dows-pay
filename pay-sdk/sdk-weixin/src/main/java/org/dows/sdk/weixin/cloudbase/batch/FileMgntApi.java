package org.dows.sdk.weixin.cloudbase.batch;

import org.dows.sdk.weixin.cloudbase.batch.request.DeleteTcbFileRequest;
import org.dows.sdk.weixin.cloudbase.batch.request.GetDownloadFileLinkRequest;
import org.dows.sdk.weixin.cloudbase.batch.request.GetTcbFileRequest;
import org.dows.sdk.weixin.cloudbase.batch.request.GetUploadFileLinkRequest;
import org.dows.sdk.weixin.cloudbase.batch.response.DeleteTcbFileResponse;
import org.dows.sdk.weixin.cloudbase.batch.response.GetDownloadFileLinkResponse;
import org.dows.sdk.weixin.cloudbase.batch.response.GetTcbFileResponse;
import org.dows.sdk.weixin.cloudbase.batch.response.GetUploadFileLinkResponse;

/**
 * @author lait.zhang@gmail.com
 * @description fileMgntApi
 * @date 2023年5月28日 下午9:55:33
 */
public interface FileMgntApi {

    /**
     * 通过本接口可以获取上传文件链接，使用过程中如遇到问题，可在发帖交流。用户获取到返回数据后，需拼装一个 HTTP POST 请求，其中 url 为返回包的 url 字段，Body 部分格式为 multipart/form-data，具体内容如下：
     * https://api.weixin.qq.com/componenttcb/uploadfile?access_token=ACCESS_TOKEN
     *
     * @param getUploadFileLinkRequest
     */
    GetUploadFileLinkResponse getUploadFileLink(GetUploadFileLinkRequest getUploadFileLinkRequest);

    /**
     * 通过本接口可以删除文件，使用过程中如遇到问题，可在发帖交流。
     * https://api.weixin.qq.com/componenttcb/batchdeletefile?access_token=ACCESS_TOKEN
     *
     * @param deleteTcbFileRequest
     */
    DeleteTcbFileResponse deleteTcbFile(DeleteTcbFileRequest deleteTcbFileRequest);

    /**
     * 通过本接口可以查看文件列表，使用过程中如遇到问题，可在发帖交流。
     * https://api.weixin.qq.com/componenttcb/getbucket?access_token=ACCESS_TOKEN
     *
     * @param getTcbFileRequest
     */
    GetTcbFileResponse getTcbFile(GetTcbFileRequest getTcbFileRequest);

    /**
     * 通过本接口可以获取下载文件链接，使用过程中如遇到问题，可在发帖交流。
     * https://api.weixin.qq.com/componenttcb/batchdownloadfile?access_token=ACCESS_TOKEN
     *
     * @param getDownloadFileLinkRequest
     */
    GetDownloadFileLinkResponse getDownloadFileLink(GetDownloadFileLinkRequest getDownloadFileLinkRequest);
}