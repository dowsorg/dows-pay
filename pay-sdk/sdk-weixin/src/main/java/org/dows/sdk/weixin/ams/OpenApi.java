package org.dows.sdk.weixin.ams;

import org.dows.sdk.weixin.ams.request.AgencyCheckCanOpenPublisherRequest;
import org.dows.sdk.weixin.ams.request.AgencyCreatePublisherRequest;
import org.dows.sdk.weixin.ams.response.AgencyCheckCanOpenPublisherResponse;
import org.dows.sdk.weixin.ams.response.AgencyCreatePublisherResponse;

/**
 * @author lait.zhang@gmail.com
 * @description openApi
 * @date 2023年5月28日 下午9:55:33
 */
public interface OpenApi {

    /**
     * 该 API 用于服务商检测小程序是否达到开通流量主门槛。使用过程中如遇到问题，可在发帖交流。其中access_token为
     * https://api.weixin.qq.com/wxa/operationams?action=agency_check_can_open_publisher&access_token=xxxxxxxxxxxxxxx
     *
     * @param agencyCheckCanOpenPublisherRequest
     */
    AgencyCheckCanOpenPublisherResponse agencyCheckCanOpenPublisher(AgencyCheckCanOpenPublisherRequest agencyCheckCanOpenPublisherRequest);

    /**
     * 该 API 用于为小程序开通流量主。使用过程中如遇到问题，可在发帖交流。其中access_token为
     * https://api.weixin.qq.com/wxa/operationams?action=agency_create_publisher&access_token=xxxxxxxxxxxxxxx
     *
     * @param agencyCreatePublisherRequest
     */
    AgencyCreatePublisherResponse agencyCreatePublisher(AgencyCreatePublisherRequest agencyCreatePublisherRequest);
}