package org.dows.sdk.weixin.cloudbase.common;

/**
 * @description fileManagementApi
 * @author lait.zhang@gmail.com
 * @date  2023年5月28日 下午9:55:33
 */
public interface FileManagementApi{

    /**
     * 通过本接口可以获取文件上传链接。使用过程中如遇到问题，可在发帖交流。
     * https://api.weixin.qq.com/tcb/uploadfile?access_token=ACCESS_TOKEN
     * 
     * @param getUploadTcbFileLinkRequest
     * 
     */
    GetUploadTcbFileLinkResponse getUploadTcbFileLink(GetUploadTcbFileLinkRequest getUploadTcbFileLinkRequest);

    /**
     * 通过本接口可以删除文件.使用过程中如遇到问题，可在发帖交流。
     * https://api.weixin.qq.com/tcb/batchdeletefile?access_token=ACCESS_TOKEN
     * 
     * @param deleteTcbCloudFileRequest
     * 
     */
    DeleteTcbCloudFileResponse deleteTcbCloudFile(DeleteTcbCloudFileRequest deleteTcbCloudFileRequest);

    /**
     * 通过本接口可以获取文件下载链接.使用过程中如遇到问题，可在发帖交流。
     * https://api.weixin.qq.com/tcb/batchdownloadfile?access_token=ACCESS_TOKEN
     * 
     * @param getDownloadTcbFileLinkRequest
     * 
     */
    GetDownloadTcbFileLinkResponse getDownloadTcbFileLink(GetDownloadTcbFileLinkRequest getDownloadTcbFileLinkRequest);

    /**
     * 通过本接口可以数据库聚合。使用过程中如遇到问题，可在发帖交流
     * https://api.weixin.qq.com/tcb/databaseaggregate?access_token=ACCESS_TOKEN
     * 
     * @param aggregateDatabaseRequest
     * 
     */
    AggregateDatabaseResponse aggregateDatabase(AggregateDatabaseRequest aggregateDatabaseRequest);

    /**
     * 通过本接口可以数据库迁移状态查询.使用过程中如遇到问题，可在发帖交流。
     * https://api.weixin.qq.com/tcb/databasemigratequeryinfo?access_token=ACCESS_TOKEN
     * 
     * @param getDatabaseMigrateStatusRequest
     * 
     */
    GetDatabaseMigrateStatusResponse getDatabaseMigrateStatus(GetDatabaseMigrateStatusRequest getDatabaseMigrateStatusRequest);

    /**
     * 通过本接口可以数据库更新记录.使用过程中如遇到问题，可在发帖交流。
     * https://api.weixin.qq.com/tcb/databaseupdate?access_token=ACCESS_TOKEN
     * 
     * @param updateDatabaseRecordRequest
     * 
     */
    UpdateDatabaseRecordResponse updateDatabaseRecord(UpdateDatabaseRecordRequest updateDatabaseRecordRequest);
}