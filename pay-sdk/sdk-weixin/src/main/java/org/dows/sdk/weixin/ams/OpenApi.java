package org.dows.sdk.weixin.ams;

import org.dows.sdk.weixin.ams.request.AgencyCheckCanOpenPublisherRequest;
import org.dows.sdk.weixin.ams.request.AgencyCreatePublisherRequest;
import org.dows.sdk.weixin.ams.response.AgencyCheckCanOpenPublisherResponse;
import org.dows.sdk.weixin.ams.response.AgencyCreatePublisherResponse;

/**
 * @author
 * @description
 * @date
 */
public interface OpenApi {
    /**
     * 该 API 用于服务商检测小程序是否达到开通流量主门槛。使用过程中如遇到问题，可在发帖交流。其中access_token为
     *
     * @param agencyCheckCanOpenPublisherRequest
     */
    AgencyCheckCanOpenPublisherResponse agencyCheckCanOpenPublisher(AgencyCheckCanOpenPublisherRequest agencyCheckCanOpenPublisherRequest);

    /**
     * 该 API 用于为小程序开通流量主。使用过程中如遇到问题，可在发帖交流。其中access_token为
     *
     * @param agencyCreatePublisherRequest
     */
    AgencyCreatePublisherResponse agencyCreatePublisher(AgencyCreatePublisherRequest agencyCreatePublisherRequest);

}
