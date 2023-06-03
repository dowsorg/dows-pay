package org.dows.sdk.weixin.bak.ams;

import org.dows.sdk.weixin.bak.ams.request.GetAgencySettlementRequest;
import org.dows.sdk.weixin.bak.ams.request.GetSettlementRequest;
import org.dows.sdk.weixin.bak.ams.response.GetAgencySettlementResponse;
import org.dows.sdk.weixin.bak.ams.response.GetSettlementResponse;

/**
 * @author lait.zhang@gmail.com
 * @description settlementApi
 * @date 2023年5月29日 上午11:32:00
 */
public interface SettlementApi {

    /**
     * description: 该 API 用于获取小程序结算收入数据。使用过程中如遇到问题，可在发帖交流。其中access_token为1、返回settlement_list按照date降序排列，用户请以分页的形式获取。只要与获取数据的起止时间有重合，结算区间对应的数据都将返回。例如，请求2月11日至3月26日的数据，将会返回2月上半月、2月下半月、3月上半月、3月下半月四个结算区间的数据。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ams/settlement/GetSettlement.html
     * api: https://api.weixin.qq.com/wxa/operationams?action=agency_get_settlement&access_token=ACCESS_TOKEN
     *
     * @param getSettlementRequest
     */
    GetSettlementResponse getSettlement(GetSettlementRequest getSettlementRequest);

    /**
     * description: 该 API 用于获取服务商结算收入数据。使用过程中如遇到问题，可在发帖交流。其中access_token为1、返回settlement_list按照date降序排列，用户请以分页的形式获取。只要与获取数据的起止时间有重合，结算区间对应的数据都将返回。例如，请求2月11日至3月26日的数据，将会返回2月上半月、2月下半月、3月上半月、3月下半月四个结算区间的数据。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ams/settlement/GetAgencySettlement.html
     * api: https://api.weixin.qq.com/wxa/operationams?action=get_agency_settled_revenue&access_token=ACCESS_TOKEN
     *
     * @param getAgencySettlementRequest
     */
    GetAgencySettlementResponse getAgencySettlement(GetAgencySettlementRequest getAgencySettlementRequest);
}