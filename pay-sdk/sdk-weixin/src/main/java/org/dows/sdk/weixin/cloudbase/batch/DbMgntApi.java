package org.dows.sdk.weixin.cloudbase.batch;

import org.dows.sdk.weixin.cloudbase.batch.request.*;
import org.dows.sdk.weixin.cloudbase.batch.response.*;

/**
 * @author
 * @description
 * @date
 */
public interface DbMgntApi {
    /**
     * 通过本接口可以数据库导入，使用过程中如遇到问题，可在发帖交流。
     *
     * @param dbImportRequest
     */
    DbImportResponse dbImport(DbImportRequest dbImportRequest);

    /**
     * 通过本接口可以数据库导出，使用过程中如遇到问题，可在发帖交流。
     *
     * @param dbExportRequest
     */
    DbExportResponse dbExport(DbExportRequest dbExportRequest);

    /**
     * 通过本接口可以数据库导入/导出状态查询，使用过程中如遇到问题，可在发帖交流。
     *
     * @param getMigrationStateRequest
     */
    GetMigrationStateResponse getMigrationState(GetMigrationStateRequest getMigrationStateRequest);

    /**
     * 通过本接口可以数据库聚合，使用过程中如遇到问题，可在发帖交流。
     *
     * @param dbAggregateRequest
     */
    DbAggregateResponse dbAggregate(DbAggregateRequest dbAggregateRequest);

    /**
     * 通过本接口可以获取数据库操作权限，使用过程中如遇到问题，可在发帖交流。
     *
     * @param getPermissionRequest
     */
    GetPermissionResponse getPermission(GetPermissionRequest getPermissionRequest);

    /**
     * 通过本接口可以修改数据库操作权限，使用过程中如遇到问题，可在发帖交流。
     *
     * @param setPermissionRequest
     */
    SetPermissionResponse setPermission(SetPermissionRequest setPermissionRequest);

    /**
     * 该接口可用于对数据库记录进行管理，包含插入记录、删除记录、更新记录、查询记录等功能。返回的 JSON 数据包返回的 JSON 数据包返回的 JSON 数据包返回的 JSON 数据包
     *
     * @param dbrecordManageRequest
     */
    DbrecordManageResponse dbrecordManage(DbrecordManageRequest dbrecordManageRequest);

    /**
     * 该接口用于创建索引和删除索引返回的 JSON 数据包返回的 JSON 数据包
     *
     * @param dbindexManageRequest
     */
    DbindexManageResponse dbindexManage(DbindexManageRequest dbindexManageRequest);

}
