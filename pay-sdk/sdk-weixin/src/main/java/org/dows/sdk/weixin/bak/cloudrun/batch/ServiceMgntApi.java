package org.dows.sdk.weixin.bak.cloudrun.batch;

import org.dows.sdk.weixin.bak.cloudrun.batch.request.*;
import org.dows.sdk.weixin.bak.cloudrun.batch.response.*;

/**
 * @author lait.zhang@gmail.com
 * @description serviceMgntApi
 * @date 2023年5月29日 上午11:32:00
 */
public interface ServiceMgntApi {

    /**
     * description: 通过本接口可以创建云应用服务，使用过程中如遇到问题，可在发帖交流
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudrun-batch/service-mgnt/createCloudbaseService.html
     * api: https://api.weixin.qq.com/componenttcb/establishcloudbaserunserver?access_token=ACCESS_TOKEN
     *
     * @param createCloudbaseServiceRequest
     */
    CreateCloudbaseServiceResponse createCloudbaseService(CreateCloudbaseServiceRequest createCloudbaseServiceRequest);

    /**
     * description: 通过本接口可以创建服务版本，使用过程中如遇到问题，可在发帖交流。返回的 JSON 数据包
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudrun-batch/service-mgnt/createCloudbaseServiceVersion.html
     * api: https://api.weixin.qq.com/componenttcb/createcloudbaserunserverversion?access_token=ACCESS_TOKEN
     *
     * @param createCloudbaseServiceVersionRequest
     */
    CreateCloudbaseServiceVersionResponse createCloudbaseServiceVersion(CreateCloudbaseServiceVersionRequest createCloudbaseServiceVersionRequest);

    /**
     * description: 通过本接口可以滚动更新服务版本，使用过程中如遇到问题，可在发帖交流。返回的 JSON 数据包
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudrun-batch/service-mgnt/updateCloudbaseServiceVersion.html
     * api: https://api.weixin.qq.com/componenttcb/rollupdatecloudbaserunserverversion?access_token=ACCESS_TOKEN
     *
     * @param updateCloudbaseServiceVersionRequest
     */
    UpdateCloudbaseServiceVersionResponse updateCloudbaseServiceVersion(UpdateCloudbaseServiceVersionRequest updateCloudbaseServiceVersionRequest);

    /**
     * description: 通过本接口可以删除服务版本，使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudrun-batch/service-mgnt/deleteCloudbaseServiceVersion.html
     * api: https://api.weixin.qq.com/componenttcb/deletecloudbaserunserverversion?access_token=ACCESS_TOKEN
     *
     * @param deleteCloudbaseServiceVersionRequest
     */
    DeleteCloudbaseServiceVersionResponse deleteCloudbaseServiceVersion(DeleteCloudbaseServiceVersionRequest deleteCloudbaseServiceVersionRequest);

    /**
     * description: 通过本接口可以全量发布版本，使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudrun-batch/service-mgnt/releaseCloudbaseServiceVersion.html
     * api: https://api.weixin.qq.com/componenttcb/releasecloudbaserunversion?access_token=ACCESS_TOKEN
     *
     * @param releaseCloudbaseServiceVersionRequest
     */
    ReleaseCloudbaseServiceVersionResponse releaseCloudbaseServiceVersion(ReleaseCloudbaseServiceVersionRequest releaseCloudbaseServiceVersionRequest);
}