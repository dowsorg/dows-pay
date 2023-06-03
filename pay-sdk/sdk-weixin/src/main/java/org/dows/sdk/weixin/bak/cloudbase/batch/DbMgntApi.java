package org.dows.sdk.weixin.bak.cloudbase.batch;

import org.dows.sdk.weixin.bak.cloudbase.batch.request.*;
import org.dows.sdk.weixin.bak.cloudbase.batch.response.*;

/**
 * @author lait.zhang@gmail.com
 * @description dbMgntApi
 * @date 2023年5月29日 上午11:32:00
 */
public interface DbMgntApi {

    /**
     * description: 通过本接口可以数据库导入，使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/db-mgnt/dbImport.html
     * api: https://api.weixin.qq.com/componenttcb/dbimport?access_token=ACCESS_TOKEN
     *
     * @param dbImportRequest
     */
    DbImportResponse dbImport(DbImportRequest dbImportRequest);

    /**
     * description: 通过本接口可以数据库导出，使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/db-mgnt/dbExport.html
     * api: https://api.weixin.qq.com/componenttcb/dbexport?access_token=ACCESS_TOKEN
     *
     * @param dbExportRequest
     */
    DbExportResponse dbExport(DbExportRequest dbExportRequest);

    /**
     * description: 通过本接口可以数据库导入/导出状态查询，使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/db-mgnt/getMigrationState.html
     * api: https://api.weixin.qq.com/componenttcb/dbmigrationstate?access_token=ACCESS_TOKEN
     *
     * @param getMigrationStateRequest
     */
    GetMigrationStateResponse getMigrationState(GetMigrationStateRequest getMigrationStateRequest);

    /**
     * description: 通过本接口可以数据库聚合，使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/db-mgnt/dbAggregate.html
     * api: https://api.weixin.qq.com/componenttcb/dbaggregate?access_token=ACCESS_TOKEN
     *
     * @param dbAggregateRequest
     */
    DbAggregateResponse dbAggregate(DbAggregateRequest dbAggregateRequest);

    /**
     * description: 通过本接口可以获取数据库操作权限，使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/db-mgnt/getPermission.html
     * api: https://api.weixin.qq.com/componenttcb/dbgetacl?access_token=ACCESS_TOKEN
     *
     * @param getPermissionRequest
     */
    GetPermissionResponse getPermission(GetPermissionRequest getPermissionRequest);

    /**
     * description: 通过本接口可以修改数据库操作权限，使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/db-mgnt/setPermission.html
     * api: https://api.weixin.qq.com/componenttcb/dbmodifyacl?access_token=ACCESS_TOKEN
     *
     * @param setPermissionRequest
     */
    SetPermissionResponse setPermission(SetPermissionRequest setPermissionRequest);

    /**
     * description: 该接口可用于对数据库记录进行管理，包含插入记录、删除记录、更新记录、查询记录等功能。返回的 JSON 数据包返回的 JSON 数据包返回的 JSON 数据包返回的 JSON 数据包
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/db-mgnt/dbrecordManage.html
     * api: https://api.weixin.qq.com/componenttcb/dbrecord?access_token=ACCESS_TOKEN
     *
     * @param dbrecordManageRequest
     */
    DbrecordManageResponse dbrecordManage(DbrecordManageRequest dbrecordManageRequest);

    /**
     * description: 该接口用于创建索引和删除索引返回的 JSON 数据包返回的 JSON 数据包
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-batch/db-mgnt/dbindexManage.html
     * api: https://api.weixin.qq.com/componenttcb/dbindex?access_token=ACCESS_TOKEN
     *
     * @param dbindexManageRequest
     */
    DbindexManageResponse dbindexManage(DbindexManageRequest dbindexManageRequest);
}