package org.dows.sdk.weixin.ams;

/**
 * 
 */
public interface open{

    /**
     * 该 API 用于服务商检测小程序是否达到开通流量主门槛。使用过程中如遇到问题，可在发帖交流。其中access_token为
     * https://api.weixin.qq.com/wxa/operationams?action=agency_check_can_open_publisher&access_token=xxxxxxxxxxxxxxx
     * 
     * @param AgencyCheckCanOpenPublisherRequest
     * 
     */
    AgencyCheckCanOpenPublisherResponse AgencyCheckCanOpenPublisher(AgencyCheckCanOpenPublisherRequest AgencyCheckCanOpenPublisherRequest);

    /**
     * 该 API 用于为小程序开通流量主。使用过程中如遇到问题，可在发帖交流。其中access_token为
     * https://api.weixin.qq.com/wxa/operationams?action=agency_create_publisher&access_token=xxxxxxxxxxxxxxx
     * 
     * @param AgencyCreatePublisherRequest
     * 
     */
    AgencyCreatePublisherResponse AgencyCreatePublisher(AgencyCreatePublisherRequest AgencyCreatePublisherRequest);
}