package org.dows.sdk.weixin.cloudbase.common;

import org.dows.sdk.weixin.cloudbase.common.request.*;
import org.dows.sdk.weixin.cloudbase.common.response.*;

/**
 * @author
 * @description 调用方式以及出入参和HTTPS相同，仅是调用的token不同该接口所属的权限集id为：49、64服务商获得其中之一权限集授权后，可通过使用代商家进行调用
 * @date
 */
public interface FileManagementApi {
    /**
     * 通过本接口可以获取文件上传链接。使用过程中如遇到问题，可在发帖交流。
     *
     * @param getUploadTcbFileLinkRequest
     */
    GetUploadTcbFileLinkResponse getUploadTcbFileLink(GetUploadTcbFileLinkRequest getUploadTcbFileLinkRequest);

    /**
     * 通过本接口可以删除文件.使用过程中如遇到问题，可在发帖交流。
     *
     * @param deleteTcbCloudFileRequest
     */
    DeleteTcbCloudFileResponse deleteTcbCloudFile(DeleteTcbCloudFileRequest deleteTcbCloudFileRequest);

    /**
     * 通过本接口可以获取文件下载链接.使用过程中如遇到问题，可在发帖交流。
     *
     * @param getDownloadTcbFileLinkRequest
     */
    GetDownloadTcbFileLinkResponse getDownloadTcbFileLink(GetDownloadTcbFileLinkRequest getDownloadTcbFileLinkRequest);

    /**
     * 通过本接口可以数据库聚合。使用过程中如遇到问题，可在发帖交流
     *
     * @param aggregateDatabaseRequest
     */
    AggregateDatabaseResponse aggregateDatabase(AggregateDatabaseRequest aggregateDatabaseRequest);

    /**
     * 通过本接口可以数据库迁移状态查询.使用过程中如遇到问题，可在发帖交流。
     *
     * @param getDatabaseMigrateStatusRequest
     */
    GetDatabaseMigrateStatusResponse getDatabaseMigrateStatus(GetDatabaseMigrateStatusRequest getDatabaseMigrateStatusRequest);

    /**
     * 通过本接口可以数据库更新记录.使用过程中如遇到问题，可在发帖交流。
     *
     * @param updateDatabaseRecordRequest
     */
    UpdateDatabaseRecordResponse updateDatabaseRecord(UpdateDatabaseRecordRequest updateDatabaseRecordRequest);

}
