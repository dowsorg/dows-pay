package org.dows.sdk.weixin.bak.cloudbase.common;

import org.dows.sdk.weixin.bak.cloudbase.common.request.*;
import org.dows.sdk.weixin.bak.cloudbase.common.response.*;

/**
 * @author lait.zhang@gmail.com
 * @description fileManagementApi
 * @date 2023年5月29日 上午11:32:00
 */
public interface FileManagementApi {

    /**
     * description: 通过本接口可以获取文件上传链接。使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/file-management/getUploadTcbFileLink.html
     * api: https://api.weixin.qq.com/tcb/uploadfile?access_token=ACCESS_TOKEN
     *
     * @param getUploadTcbFileLinkRequest
     */
    GetUploadTcbFileLinkResponse getUploadTcbFileLink(GetUploadTcbFileLinkRequest getUploadTcbFileLinkRequest);

    /**
     * description: 通过本接口可以删除文件.使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/file-management/deleteTcbCloudFile.html
     * api: https://api.weixin.qq.com/tcb/batchdeletefile?access_token=ACCESS_TOKEN
     *
     * @param deleteTcbCloudFileRequest
     */
    DeleteTcbCloudFileResponse deleteTcbCloudFile(DeleteTcbCloudFileRequest deleteTcbCloudFileRequest);

    /**
     * description: 通过本接口可以获取文件下载链接.使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/file-management/getDownloadTcbFileLink.html
     * api: https://api.weixin.qq.com/tcb/batchdownloadfile?access_token=ACCESS_TOKEN
     *
     * @param getDownloadTcbFileLinkRequest
     */
    GetDownloadTcbFileLinkResponse getDownloadTcbFileLink(GetDownloadTcbFileLinkRequest getDownloadTcbFileLinkRequest);

    /**
     * description: 通过本接口可以数据库聚合。使用过程中如遇到问题，可在发帖交流
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/file-management/aggregateDatabase.html
     * api: https://api.weixin.qq.com/tcb/databaseaggregate?access_token=ACCESS_TOKEN
     *
     * @param aggregateDatabaseRequest
     */
    AggregateDatabaseResponse aggregateDatabase(AggregateDatabaseRequest aggregateDatabaseRequest);

    /**
     * description: 通过本接口可以数据库迁移状态查询.使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/file-management/getDatabaseMigrateStatus.html
     * api: https://api.weixin.qq.com/tcb/databasemigratequeryinfo?access_token=ACCESS_TOKEN
     *
     * @param getDatabaseMigrateStatusRequest
     */
    GetDatabaseMigrateStatusResponse getDatabaseMigrateStatus(GetDatabaseMigrateStatusRequest getDatabaseMigrateStatusRequest);

    /**
     * description: 通过本接口可以数据库更新记录.使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/file-management/updateDatabaseRecord.html
     * api: https://api.weixin.qq.com/tcb/databaseupdate?access_token=ACCESS_TOKEN
     *
     * @param updateDatabaseRecordRequest
     */
    UpdateDatabaseRecordResponse updateDatabaseRecord(UpdateDatabaseRecordRequest updateDatabaseRecordRequest);
}