package org.dows.sdk.weixin.bak.cloudbase.common;

import org.dows.sdk.weixin.bak.cloudbase.common.request.*;
import org.dows.sdk.weixin.bak.cloudbase.common.response.*;

/**
 * @author lait.zhang@gmail.com
 * @description dbManagementApi
 * @date 2023年5月29日 上午11:32:00
 */
public interface DbManagementApi {

    /**
     * description: 数据库集合管理返回的 JSON 数据包返回的 JSON 数据包返回的 JSON 数据包
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/db-management/dbcollectionManage.html
     * api: https://api.weixin.qq.com/componenttcb/dbcollection?access_token=ACCESS_TOKEN
     *
     * @param dbcollectionManageRequest
     */
    DbcollectionManageResponse dbcollectionManage(DbcollectionManageRequest dbcollectionManageRequest);

    /**
     * description: 通过本接口可以数据库插入记录。使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/db-management/addDatabaseItem.html
     * api: https://api.weixin.qq.com/tcb/databaseadd?access_token=ACCESS_TOKEN
     *
     * @param addDatabaseItemRequest
     */
    AddDatabaseItemResponse addDatabaseItem(AddDatabaseItemRequest addDatabaseItemRequest);

    /**
     * description: 通过本接口可以新增集合.使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/db-management/addDatabaseCollection.html
     * api: https://api.weixin.qq.com/tcb/databasecollectionadd?access_token=ACCESS_TOKEN
     *
     * @param addDatabaseCollectionRequest
     */
    AddDatabaseCollectionResponse addDatabaseCollection(AddDatabaseCollectionRequest addDatabaseCollectionRequest);

    /**
     * description: 通过本接口可以删除集合.使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/db-management/deleteDatabaseCollection.html
     * api: https://api.weixin.qq.com/tcb/databasecollectiondelete?access_token=ACCESS_TOKEN
     *
     * @param deleteDatabaseCollectionRequest
     */
    DeleteDatabaseCollectionResponse deleteDatabaseCollection(DeleteDatabaseCollectionRequest deleteDatabaseCollectionRequest);

    /**
     * description: 通过本接口可以获取特定云环境下集合信息。使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/db-management/getDatabaseCollection.html
     * api: https://api.weixin.qq.com/tcb/databasecollectionget?access_token=ACCESS_TOKEN
     *
     * @param getDatabaseCollectionRequest
     */
    GetDatabaseCollectionResponse getDatabaseCollection(GetDatabaseCollectionRequest getDatabaseCollectionRequest);

    /**
     * description: 通过本接口可以统计集合记录数或统计查询语句对应的结果记录数。使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/db-management/getDatabaseCount.html
     * api: https://api.weixin.qq.com/tcb/databasecount?access_token=ACCESS_TOKEN
     *
     * @param getDatabaseCountRequest
     */
    GetDatabaseCountResponse getDatabaseCount(GetDatabaseCountRequest getDatabaseCountRequest);

    /**
     * description: 通过本接口可以数据库删除记录.使用过程中如遇到问题，可在发帖交流。数据库操作语句说明 数据库操作语句语法与数据库 API相同
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/db-management/deleteDatabaseItem.html
     * api: https://api.weixin.qq.com/tcb/databasedelete?access_token=ACCESS_TOKEN
     *
     * @param deleteDatabaseItemRequest
     */
    DeleteDatabaseItemResponse deleteDatabaseItem(DeleteDatabaseItemRequest deleteDatabaseItemRequest);

    /**
     * description: 通过本接口可以进行数据库导出.使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/db-management/exportDatabaseItem.html
     * api: https://api.weixin.qq.com/tcb/databasemigrateexport?access_token=ACCESS_TOKEN
     *
     * @param exportDatabaseItemRequest
     */
    ExportDatabaseItemResponse exportDatabaseItem(ExportDatabaseItemRequest exportDatabaseItemRequest);

    /**
     * description: 通过本接口可以进行数据库导入.使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/db-management/importDatabaseItem.html
     * api: https://api.weixin.qq.com/tcb/databasemigrateimport?access_token=ACCESS_TOKEN
     *
     * @param importDatabaseItemRequest
     */
    ImportDatabaseItemResponse importDatabaseItem(ImportDatabaseItemRequest importDatabaseItemRequest);

    /**
     * description: 通过本接口可以数据库查询记录.使用过程中如遇到问题，可在发帖交流。Tips query中应使用limit()限制单次拉取的数量，默认10条。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/db-management/getDatabaseRecord.html
     * api: https://api.weixin.qq.com/tcb/databasequery?access_token=ACCESS_TOKEN
     *
     * @param getDatabaseRecordRequest
     */
    GetDatabaseRecordResponse getDatabaseRecord(GetDatabaseRecordRequest getDatabaseRecordRequest);

    /**
     * description: 通过本接口可以变更数据库索引.使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudbase-common/db-management/updateDatabaseIndex.html
     * api: https://api.weixin.qq.com/tcb/updateindex?access_token=ACCESS_TOKEN
     *
     * @param updateDatabaseIndexRequest
     */
    UpdateDatabaseIndexResponse updateDatabaseIndex(UpdateDatabaseIndexRequest updateDatabaseIndexRequest);
}