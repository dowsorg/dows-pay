package org.dows.sdk.weixin.cloudbase.common;

import org.dows.sdk.weixin.cloudbase.common.request.*;
import org.dows.sdk.weixin.cloudbase.common.response.*;

/**
 * @author
 * @description
 * @date
 */
public interface DbManagementApi {
    /**
     * 数据库集合管理返回的 JSON 数据包返回的 JSON 数据包返回的 JSON 数据包
     *
     * @param dbcollectionManageRequest
     */
    DbcollectionManageResponse dbcollectionManage(DbcollectionManageRequest dbcollectionManageRequest);

    /**
     * 通过本接口可以数据库插入记录。使用过程中如遇到问题，可在发帖交流。
     *
     * @param addDatabaseItemRequest
     */
    AddDatabaseItemResponse addDatabaseItem(AddDatabaseItemRequest addDatabaseItemRequest);

    /**
     * 通过本接口可以新增集合.使用过程中如遇到问题，可在发帖交流。
     *
     * @param addDatabaseCollectionRequest
     */
    AddDatabaseCollectionResponse addDatabaseCollection(AddDatabaseCollectionRequest addDatabaseCollectionRequest);

    /**
     * 通过本接口可以删除集合.使用过程中如遇到问题，可在发帖交流。
     *
     * @param deleteDatabaseCollectionRequest
     */
    DeleteDatabaseCollectionResponse deleteDatabaseCollection(DeleteDatabaseCollectionRequest deleteDatabaseCollectionRequest);

    /**
     * 通过本接口可以获取特定云环境下集合信息。使用过程中如遇到问题，可在发帖交流。
     *
     * @param getDatabaseCollectionRequest
     */
    GetDatabaseCollectionResponse getDatabaseCollection(GetDatabaseCollectionRequest getDatabaseCollectionRequest);

    /**
     * 通过本接口可以统计集合记录数或统计查询语句对应的结果记录数。使用过程中如遇到问题，可在发帖交流。
     *
     * @param getDatabaseCountRequest
     */
    GetDatabaseCountResponse getDatabaseCount(GetDatabaseCountRequest getDatabaseCountRequest);

    /**
     * 通过本接口可以数据库删除记录.使用过程中如遇到问题，可在发帖交流。数据库操作语句说明 数据库操作语句语法与数据库 API相同
     *
     * @param deleteDatabaseItemRequest
     */
    DeleteDatabaseItemResponse deleteDatabaseItem(DeleteDatabaseItemRequest deleteDatabaseItemRequest);

    /**
     * 通过本接口可以进行数据库导出.使用过程中如遇到问题，可在发帖交流。
     *
     * @param exportDatabaseItemRequest
     */
    ExportDatabaseItemResponse exportDatabaseItem(ExportDatabaseItemRequest exportDatabaseItemRequest);

    /**
     * 通过本接口可以进行数据库导入.使用过程中如遇到问题，可在发帖交流。
     *
     * @param importDatabaseItemRequest
     */
    ImportDatabaseItemResponse importDatabaseItem(ImportDatabaseItemRequest importDatabaseItemRequest);

    /**
     * 通过本接口可以数据库查询记录.使用过程中如遇到问题，可在发帖交流。Tips query中应使用limit()限制单次拉取的数量，默认10条。
     *
     * @param getDatabaseRecordRequest
     */
    GetDatabaseRecordResponse getDatabaseRecord(GetDatabaseRecordRequest getDatabaseRecordRequest);

    /**
     * 通过本接口可以变更数据库索引.使用过程中如遇到问题，可在发帖交流。
     *
     * @param updateDatabaseIndexRequest
     */
    UpdateDatabaseIndexResponse updateDatabaseIndex(UpdateDatabaseIndexRequest updateDatabaseIndexRequest);


}
