package org.dows.sdk.weixin.cloudbase.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;

/**
* @description ���÷�ʽ�Լ�����κ�HTTPS��ͬ�����ǵ��õ�token��ͬ�ýӿ�������Ȩ�޼�idΪ��49��64�����̻������֮һȨ�޼���Ȩ�󣬿�ͨ��ʹ�ô��̼ҽ��е���
*
* @author 
* @date 
*/
public interface FileManagementApi{
    /**
     * ͨ�����ӿڿ��Ի�ȡ�ļ��ϴ����ӡ�ʹ�ù��������������⣬���ڷ���������
     * @param getUploadTcbFileLinkRequest
     */
    GetUploadTcbFileLinkResponse getUploadTcbFileLink(GetUploadTcbFileLinkRequest getUploadTcbFileLinkRequest);
    /**
     * ͨ�����ӿڿ���ɾ���ļ�.ʹ�ù��������������⣬���ڷ���������
     * @param deleteTcbCloudFileRequest
     */
    DeleteTcbCloudFileResponse deleteTcbCloudFile(DeleteTcbCloudFileRequest deleteTcbCloudFileRequest);
    /**
     * ͨ�����ӿڿ��Ի�ȡ�ļ���������.ʹ�ù��������������⣬���ڷ���������
     * @param getDownloadTcbFileLinkRequest
     */
    GetDownloadTcbFileLinkResponse getDownloadTcbFileLink(GetDownloadTcbFileLinkRequest getDownloadTcbFileLinkRequest);
    /**
     * ͨ�����ӿڿ������ݿ�ۺϡ�ʹ�ù��������������⣬���ڷ�������
     * @param aggregateDatabaseRequest
     */
    AggregateDatabaseResponse aggregateDatabase(AggregateDatabaseRequest aggregateDatabaseRequest);
    /**
     * ͨ�����ӿڿ������ݿ�Ǩ��״̬��ѯ.ʹ�ù��������������⣬���ڷ���������
     * @param getDatabaseMigrateStatusRequest
     */
    GetDatabaseMigrateStatusResponse getDatabaseMigrateStatus(GetDatabaseMigrateStatusRequest getDatabaseMigrateStatusRequest);
    /**
     * ͨ�����ӿڿ������ݿ���¼�¼.ʹ�ù��������������⣬���ڷ���������
     * @param updateDatabaseRecordRequest
     */
    UpdateDatabaseRecordResponse updateDatabaseRecord(UpdateDatabaseRecordRequest updateDatabaseRecordRequest);

}
