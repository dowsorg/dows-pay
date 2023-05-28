package org.dows.sdk.weixin.cloudrun.batch;

import org.dows.sdk.weixin.cloudrun.batch.request.*;
import org.dows.sdk.weixin.cloudrun.batch.response.*;

/**
 * @author lait.zhang@gmail.com
 * @Date 2023年5月28日 下午9:25:34
 * @description serviceMgntApi
 */
public interface ServiceMgntApi {

    /**
     * 通过本接口可以创建云应用服务，使用过程中如遇到问题，可在发帖交流
     * https://api.weixin.qq.com/componenttcb/establishcloudbaserunserver?access_token=ACCESS_TOKEN
     *
     * @param createCloudbaseServiceRequest
     */
    CreateCloudbaseServiceResponse createCloudbaseService(CreateCloudbaseServiceRequest createCloudbaseServiceRequest);

    /**
     * 通过本接口可以创建服务版本，使用过程中如遇到问题，可在发帖交流。返回的 JSON 数据包
     * https://api.weixin.qq.com/componenttcb/createcloudbaserunserverversion?access_token=ACCESS_TOKEN
     *
     * @param createCloudbaseServiceVersionRequest
     */
    CreateCloudbaseServiceVersionResponse createCloudbaseServiceVersion(CreateCloudbaseServiceVersionRequest createCloudbaseServiceVersionRequest);

    /**
     * 通过本接口可以滚动更新服务版本，使用过程中如遇到问题，可在发帖交流。返回的 JSON 数据包
     * https://api.weixin.qq.com/componenttcb/rollupdatecloudbaserunserverversion?access_token=ACCESS_TOKEN
     *
     * @param updateCloudbaseServiceVersionRequest
     */
    UpdateCloudbaseServiceVersionResponse updateCloudbaseServiceVersion(UpdateCloudbaseServiceVersionRequest updateCloudbaseServiceVersionRequest);

    /**
     * 通过本接口可以删除服务版本，使用过程中如遇到问题，可在发帖交流。
     * https://api.weixin.qq.com/componenttcb/deletecloudbaserunserverversion?access_token=ACCESS_TOKEN
     *
     * @param deleteCloudbaseServiceVersionRequest
     */
    DeleteCloudbaseServiceVersionResponse deleteCloudbaseServiceVersion(DeleteCloudbaseServiceVersionRequest deleteCloudbaseServiceVersionRequest);

    /**
     * 通过本接口可以全量发布版本，使用过程中如遇到问题，可在发帖交流。
     * https://api.weixin.qq.com/componenttcb/releasecloudbaserunversion?access_token=ACCESS_TOKEN
     *
     * @param releaseCloudbaseServiceVersionRequest
     */
    ReleaseCloudbaseServiceVersionResponse releaseCloudbaseServiceVersion(ReleaseCloudbaseServiceVersionRequest releaseCloudbaseServiceVersionRequest);
}