package org.dows.sdk.weixin.cloudbase.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;

/**
* @description 
*
* @author 
* @date 
*/
public interface DbManagementApi{
    /**
     * ���ݿ⼯�Ϲ����ص� JSON ���ݰ����ص� JSON ���ݰ����ص� JSON ���ݰ�
     * @param dbcollectionManageRequest
     */
    DbcollectionManageResponse dbcollectionManage(DbcollectionManageRequest dbcollectionManageRequest);
    /**
     * ͨ�����ӿڿ������ݿ�����¼��ʹ�ù��������������⣬���ڷ���������
     * @param addDatabaseItemRequest
     */
    AddDatabaseItemResponse addDatabaseItem(AddDatabaseItemRequest addDatabaseItemRequest);
    /**
     * ͨ�����ӿڿ�����������.ʹ�ù��������������⣬���ڷ���������
     * @param addDatabaseCollectionRequest
     */
    AddDatabaseCollectionResponse addDatabaseCollection(AddDatabaseCollectionRequest addDatabaseCollectionRequest);
    /**
     * ͨ�����ӿڿ���ɾ������.ʹ�ù��������������⣬���ڷ���������
     * @param deleteDatabaseCollectionRequest
     */
    DeleteDatabaseCollectionResponse deleteDatabaseCollection(DeleteDatabaseCollectionRequest deleteDatabaseCollectionRequest);
    /**
     * ͨ�����ӿڿ��Ի�ȡ�ض��ƻ����¼�����Ϣ��ʹ�ù��������������⣬���ڷ���������
     * @param getDatabaseCollectionRequest
     */
    GetDatabaseCollectionResponse getDatabaseCollection(GetDatabaseCollectionRequest getDatabaseCollectionRequest);
    /**
     * ͨ�����ӿڿ���ͳ�Ƽ��ϼ�¼����ͳ�Ʋ�ѯ����Ӧ�Ľ����¼����ʹ�ù��������������⣬���ڷ���������
     * @param getDatabaseCountRequest
     */
    GetDatabaseCountResponse getDatabaseCount(GetDatabaseCountRequest getDatabaseCountRequest);
    /**
     * ͨ�����ӿڿ������ݿ�ɾ����¼.ʹ�ù��������������⣬���ڷ������������ݿ�������˵�� ���ݿ��������﷨�����ݿ� API��ͬ
     * @param deleteDatabaseItemRequest
     */
    DeleteDatabaseItemResponse deleteDatabaseItem(DeleteDatabaseItemRequest deleteDatabaseItemRequest);
    /**
     * ͨ�����ӿڿ��Խ������ݿ⵼��.ʹ�ù��������������⣬���ڷ���������
     * @param exportDatabaseItemRequest
     */
    ExportDatabaseItemResponse exportDatabaseItem(ExportDatabaseItemRequest exportDatabaseItemRequest);
    /**
     * ͨ�����ӿڿ��Խ������ݿ⵼��.ʹ�ù��������������⣬���ڷ���������
     * @param importDatabaseItemRequest
     */
    ImportDatabaseItemResponse importDatabaseItem(ImportDatabaseItemRequest importDatabaseItemRequest);
    /**
     * ͨ�����ӿڿ������ݿ��ѯ��¼.ʹ�ù��������������⣬���ڷ���������Tips query��Ӧʹ��limit()���Ƶ�����ȡ��������Ĭ��10����
     * @param getDatabaseRecordRequest
     */
    GetDatabaseRecordResponse getDatabaseRecord(GetDatabaseRecordRequest getDatabaseRecordRequest);
    /**
     * ͨ�����ӿڿ��Ա�����ݿ�����.ʹ�ù��������������⣬���ڷ���������
     * @param updateDatabaseIndexRequest
     */
    UpdateDatabaseIndexResponse updateDatabaseIndex(UpdateDatabaseIndexRequest updateDatabaseIndexRequest);

}
