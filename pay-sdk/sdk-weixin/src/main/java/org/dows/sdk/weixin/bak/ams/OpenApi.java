package org.dows.sdk.weixin.bak.ams;

import org.dows.sdk.weixin.bak.ams.request.AgencyCheckCanOpenPublisherRequest;
import org.dows.sdk.weixin.bak.ams.request.AgencyCreatePublisherRequest;
import org.dows.sdk.weixin.bak.ams.response.AgencyCheckCanOpenPublisherResponse;
import org.dows.sdk.weixin.bak.ams.response.AgencyCreatePublisherResponse;

/**
 * @author lait.zhang@gmail.com
 * @description openApi
 * @date 2023年5月29日 上午11:32:00
 */
public interface OpenApi {

    /**
     * description: 该 API 用于服务商检测小程序是否达到开通流量主门槛。使用过程中如遇到问题，可在发帖交流。其中access_token为
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ams/open/AgencyCheckCanOpenPublisher.html
     * api: https://api.weixin.qq.com/wxa/operationams?action=agency_check_can_open_publisher&access_token=ACCESS_TOKEN
     *
     * @param agencyCheckCanOpenPublisherRequest
     */
    AgencyCheckCanOpenPublisherResponse agencyCheckCanOpenPublisher(AgencyCheckCanOpenPublisherRequest agencyCheckCanOpenPublisherRequest);

    /**
     * description: 该 API 用于为小程序开通流量主。使用过程中如遇到问题，可在发帖交流。其中access_token为
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ams/open/AgencyCreatePublisher.html
     * api: https://api.weixin.qq.com/wxa/operationams?action=agency_create_publisher&access_token=ACCESS_TOKEN
     *
     * @param agencyCreatePublisherRequest
     */
    AgencyCreatePublisherResponse agencyCreatePublisher(AgencyCreatePublisherRequest agencyCreatePublisherRequest);
}