//package org.dows.pay.alipay.util;
//
//import com.alibaba.fastjson.JSONObject;
//import com.alipay.api.AlipayApiException;
//import com.alipay.api.AlipayRequest;
//import com.alipay.api.AlipayResponse;
//import com.alipay.api.domain.*;
//import com.alipay.api.request.*;
//import com.alipay.api.response.*;
//import com.google.common.collect.Maps;
//import lombok.extern.slf4j.Slf4j;
//import org.dows.pay.alipay.request.*;
//
//import java.io.UnsupportedEncodingException;
//import java.net.URLEncoder;
//import java.util.Map;
//
///**
// * @Description：
// * @Author：sacher
// * @Create：2021/6/10 7:30 PM
// **/
//@Slf4j
//public class AlipayUtil {
//    /**
//     * 应用授权 URL 拼装
//     * https://opendocs.alipay.com/isv/03l3f3
//     *
//     * @param appId       应用编号
//     * @param redirectUri 回调 URI
//     * @return 应用授权 URL
//     * @throws UnsupportedEncodingException 编码异常
//     */
//    public static String getOauth2Url(String appId, String redirectUri) throws UnsupportedEncodingException {
//        return "https://openauth.alipay.com/oauth2/appToAppAuth.htm?app_id=" + appId + "&redirect_uri=" + URLEncoder.encode(redirectUri, "UTF-8");
//    }
//
//    /**
//     * 使用 app_auth_code 换取 app_auth_token
//     * https://opendocs.alipay.com/isv/03l9c0
//     *
//     * @param model {@link AlipayOpenAuthTokenAppModel}
//     * @return {@link AlipayOpenAuthTokenAppResponse}
//     * @throws AlipayApiException 支付宝 Api 异常
//     */
//    public static AlipayOpenAuthTokenAppResponse openAuthTokenAppToResponse(AlipayOpenAuthTokenAppModel model, String appId) throws AlipayApiException {
//        AlipayOpenAuthTokenAppRequest request = new AlipayOpenAuthTokenAppRequest();
//        request.setBizModel(model);
//        return doExecute(request, appId);
//    }
//
//
//    /**
//     * isv服务商代商户创建小程序
//     * https://opendocs.alipay.com/mini/03l21u
//     *
//     * @return
//     */
//    public static AlipayOpenMiniIsvCreateResponse openMiniIsvCreate(String appId, OpenMiniIsvCreateRequest openMiniIsvCreateRequest) throws AlipayApiException {
//        AlipayOpenMiniIsvCreateRequest request = new AlipayOpenMiniIsvCreateRequest();
//        Map<String, Object> map = Maps.newHashMap();
//        map.put("create_mini_request", openMiniIsvCreateRequest);
//        request.setBizContent(JSONObject.toJSONString(map));
//        return doExecute(request, appId);
//    }
//
//    /**
//     * 代商家发起当面付签约申请接口﻿
//     * 通过 alipay.open.agent.create（开启代商户签约、创建应用事务）接口创建应用事务，返回生成 batch_no。
//     * 通过 alipay.open.agent.facetoface.sign（协助商家申请签约当面付产品）接口代替商家签约当面付收单产品，传入第一步生成的 batch_no 参数。
//     * 通过 alipay.open.agent.confirm （提交代商户签约、创建应用事务）接口提交事务，同样需要传入第一步生成的 batch_no 参数。
//     * 通过 alipay.open.agent.order.query（查询申请单状态）查询代签约的结果，审核时间通常是在 1 个工作日左右。
//     * <p>
//     * 1、开启代商户签约、创建应用事务
//     * https://opendocs.alipay.com/isv/02s1f9
//     *
//     * @param appId
//     * @return
//     * @throws AlipayApiException
//     */
//    public static AlipayOpenAgentCreateResponse openAgentCreate(String appId, OpenAgentCreateRequest openAgentCreateRequest) throws AlipayApiException {
//        AlipayOpenAgentCreateRequest request = new AlipayOpenAgentCreateRequest();
//        request.setBizContent(JSONObject.toJSONString(openAgentCreateRequest));
//        return doExecute(request, appId);
//    }
//
//    /**
//     * 代商家发起当面付签约申请接口﻿
//     * 通过 alipay.open.agent.create（开启代商户签约、创建应用事务）接口创建应用事务，返回生成 batch_no。
//     * 通过 alipay.open.agent.facetoface.sign（协助商家申请签约当面付产品）接口代替商家签约当面付收单产品，传入第一步生成的 batch_no 参数。
//     * 通过 alipay.open.agent.confirm （提交代商户签约、创建应用事务）接口提交事务，同样需要传入第一步生成的 batch_no 参数。
//     * 通过 alipay.open.agent.order.query（查询申请单状态）查询代签约的结果，审核时间通常是在 1 个工作日左右。
//     * <p>
//     * 2、代签约当面付产品
//     * https://opendocs.alipay.com/isv/02s29h
//     * 三方应用代理签约当面付产品，需要配合开启事务接口使用
//     *
//     * @param appId
//     * @return
//     * @throws AlipayApiException
//     */
//    public static AlipayOpenAgentFacetofaceSignResponse openAgentFacetofaceSign(String appId, AlipayOpenAgentFacetofaceSignRequest request) throws AlipayApiException {
//        return doExecute(request, appId);
//    }
//
//    /**
//     * 代商家发起当面付签约申请接口﻿
//     * 通过 alipay.open.agent.create（开启代商户签约、创建应用事务）接口创建应用事务，返回生成 batch_no。
//     * 通过 alipay.open.agent.facetoface.sign（协助商家申请签约当面付产品）接口代替商家签约当面付收单产品，传入第一步生成的 batch_no 参数。
//     * 通过 alipay.open.agent.confirm （提交代商户签约、创建应用事务）接口提交事务，同样需要传入第一步生成的 batch_no 参数。
//     * 通过 alipay.open.agent.order.query（查询申请单状态）查询代签约的结果，审核时间通常是在 1 个工作日左右。
//     * <p>
//     * 3、提交代商户签约、创建应用事务
//     * https://opendocs.alipay.com/isv/02s5qa
//     * 提交事务。只允许提交init状态的事务，submit|cancel|timeout 状态的都是终态，
//     * 不允许提交，且不允许提交空事务，需要先调用代创建小程序、代签约当面付等业务接口，
//     * 再提交事务。服务市场订购及授权，使用订单授权凭证order_ticket开启的事务，提交后会有应用授权令牌返回。
//     *
//     * @param appId
//     * @param batchNo ISV 代商户操作事务编号，通过调用alipay.open.agent.create(开启代商户签约、创建应用事务)接口返回，
//     *                详见 https://opendocs.alipay.com/apis/api_50/alipay.open.agent.create/ 。
//     * @return AlipayOpenAgentConfirmResponse
//     * @throws AlipayApiException
//     */
//    public static AlipayOpenAgentConfirmResponse openAgentConfirm(String appId, String batchNo) throws AlipayApiException {
//        AlipayOpenAgentConfirmRequest request = new AlipayOpenAgentConfirmRequest();
//        Map<String, Object> map = Maps.newHashMap();
//        map.put("batch_no", batchNo);
//        request.setBizContent(JSONObject.toJSONString(map));
//        return doExecute(request, appId);
//    }
//
//    /**
//     * 代商家发起当面付签约申请接口﻿
//     * 通过 alipay.open.agent.create（开启代商户签约、创建应用事务）接口创建应用事务，返回生成 batch_no。
//     * 通过 alipay.open.agent.facetoface.sign（协助商家申请签约当面付产品）接口代替商家签约当面付收单产品，传入第一步生成的 batch_no 参数。
//     * 通过 alipay.open.agent.confirm （提交代商户签约、创建应用事务）接口提交事务，同样需要传入第一步生成的 batch_no 参数。
//     * 通过 alipay.open.agent.order.query（查询申请单状态）查询代签约的结果，审核时间通常是在 1 个工作日左右。
//     * <p>
//     * 4、查询申请单状态
//     * https://opendocs.alipay.com/isv/02s5q9
//     *
//     * @return AlipayOpenAgentConfirmResponse
//     * @throws AlipayApiException
//     */
//    public static AlipayOpenAgentOrderQueryResponse openAgentOrderQuery(String appId, String batchNo) throws AlipayApiException {
//        AlipayOpenAgentOrderQueryRequest request = new AlipayOpenAgentOrderQueryRequest();
//        Map<String, Object> map = Maps.newHashMap();
//        map.put("batch_no", batchNo);
//        request.setBizContent(JSONObject.toJSONString(map));
//        return doExecute(request, appId);
//    }
//
//    /**
//     * 代签约产品通用接口
//     * https://opendocs.alipay.com/isv/02s1f8
//     * 商家分账功能签约
//     *
//     * @param appId
//     * @param alipayOpenAgentCommonSignRequest
//     * @return
//     * @throws AlipayApiException
//     */
//    public static AlipayOpenAgentCommonSignResponse openCommonSign(String appId, AlipayOpenAgentCommonSignRequest alipayOpenAgentCommonSignRequest) throws AlipayApiException {
//        AlipayOpenAgentCommonSignRequest request = new AlipayOpenAgentCommonSignRequest();
//        return doExecute(request, appId);
//    }
//
//
//    /**
//     * 换取授权访问令牌
//     * https://opendocs.alipay.com/apis/api_9/alipay.system.oauth.token
//     * 创建支付 支付宝用户ID获取来源
//     *
//     * @param appId
//     * @param code
//     * @return
//     * @throws AlipayApiException
//     */
//    public static AlipaySystemOauthTokenResponse systemOauthToken(String appId, String code) throws AlipayApiException {
//        AlipaySystemOauthTokenRequest request = new AlipaySystemOauthTokenRequest();
//        request.setGrantType("authorization_code");
//        request.setCode(code);
//        return doExecute(request, appId);
//    }
//
//
//    /**
//     * 统一收单交易创建接口
//     * https://opendocs.alipay.com/open/02ekfj
//     * 小程序支付时用
//     *
//     * @param appId
//     * @param request
//     * @return
//     * @throws AlipayApiException
//     */
//    public static AlipayTradeCreateResponse tradeCreate(String appId, AliPayRequest request) throws AlipayApiException {
//        AlipayTradeCreateRequest alipayTradeCreateRequest = new AlipayTradeCreateRequest();
//        alipayTradeCreateRequest.setNotifyUrl("");
//        alipayTradeCreateRequest.setBizContent(JSONObject.toJSONString(request));
//        return doExecute(alipayTradeCreateRequest, appId);
//    }
//
//
//    /**
//     * 统一收单线下交易查询
//     * https://opendocs.alipay.com/open/02ekfh?scene=23
//     * 小程序支付时用
//     * 该接口提供所有支付宝支付订单的查询，
//     * 商户可以通过该接口主动查询订单状态，完成下一步的业务逻辑。
//     * 需要调用查询接口的情况： 当商户后台、网络、服务器等出现异常，
//     * 商户系统最终未接收到支付通知； 调用支付接口后，返回系统错误或未知交易状态情况；
//     * 调用alipay.trade.pay，返回INPROCESS的状态； 调用alipay.trade.cancel之前，需确认支付状态
//     *
//     * @param appId
//     * @param
//     * @return
//     * @throws AlipayApiException
//     */
//    public static AlipayTradeQueryResponse tradeQuery(String appId, String orderNo) throws AlipayApiException {
//        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
//        Map<String, Object> map = Maps.newHashMap();
//        map.put("out_trade_no", orderNo);
//        request.setBizContent(JSONObject.toJSONString(map));
//        return doExecute(request, appId);
//    }
//
//    /**
//     * 统一收单交易退款接口
//     * https://opendocs.alipay.com/open/02ekfk
//     *
//     * @param appId
//     * @return
//     * @throws AlipayApiException
//     */
//    public static AlipayTradeRefundResponse tradeRefund(String appId, TradeRefundRequest tradeRefundRequest) throws AlipayApiException {
//        AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
//        request.setBizContent(JSONObject.toJSONString(tradeRefundRequest));
//        return doExecute(request, appId);
//    }
//
//
//    /**
//     * 分账关系绑定
//     * https://opendocs.alipay.com/open/02c7hq?ref=api
//     *
//     * @param model {@link AlipayTradeRoyaltyRelationBindModel}
//     * @return {@link AlipayTradeRoyaltyRelationBindResponse}
//     * @throws AlipayApiException 支付宝 Api 异常
//     */
//    public static AlipayTradeRoyaltyRelationBindResponse tradeRoyaltyRelationBind(AlipayTradeRoyaltyRelationBindModel model, String appId) throws AlipayApiException {
//        AlipayTradeRoyaltyRelationBindRequest request = new AlipayTradeRoyaltyRelationBindRequest();
//        request.setBizModel(model);
//        return doExecute(request, appId);
//    }
//
//    /**
//     * 分账关系查询
//     * https://opendocs.alipay.com/open/02c7hs?ref=api
//     *
//     * @param model {@link AlipayTradeRoyaltyRelationBatchqueryModel}
//     * @return {@link AlipayTradeRoyaltyRelationBatchqueryResponse}
//     * @throws AlipayApiException 支付宝 Api 异常
//     */
//    public static AlipayTradeRoyaltyRelationBatchqueryResponse tradeRoyaltyRelationBatchQuery(AlipayTradeRoyaltyRelationBatchqueryModel model, String appId) throws AlipayApiException {
//        AlipayTradeRoyaltyRelationBatchqueryRequest request = new AlipayTradeRoyaltyRelationBatchqueryRequest();
//        request.setBizModel(model);
//        return doExecute(request, appId);
//    }
//
//    /**
//     * 分账关系解绑
//     * https://opendocs.alipay.com/open/02c7hr?ref=api
//     *
//     * @param model {@link AlipayTradeRoyaltyRelationUnbindModel}
//     * @return {@link AlipayTradeRoyaltyRelationUnbindResponse}
//     * @throws AlipayApiException 支付宝 Api 异常
//     */
//    public static AlipayTradeRoyaltyRelationUnbindResponse tradeRoyaltyRelationUnBind(AlipayTradeRoyaltyRelationUnbindModel model, String appId) throws AlipayApiException {
//        AlipayTradeRoyaltyRelationUnbindRequest request = new AlipayTradeRoyaltyRelationUnbindRequest();
//        request.setBizModel(model);
//        return doExecute(request, appId);
//    }
//
//
//    /**
//     * 统一收单交易结算接口
//     * https://opendocs.alipay.com/open/02j2bt
//     * 用于在卖家交易成功之后，基于交易订单，进行卖家与第三方（如供应商或平台商）的资金再分配。接口调用要求：
//     * （1）建议支付成功后间隔 30s 再发起该接口请求
//     * （2）单个商户请求频率最高 30 qps
//     * （3）基于同一笔交易订单，该接口多次调用请求建议间隔 3s。
//     *
//     * @param model {@link AlipayTradeOrderSettleModel}
//     * @return {@link AlipayTradeOrderSettleResponse}
//     * @throws AlipayApiException 支付宝 Api 异常
//     */
//    public static AlipayTradeOrderSettleResponse tradeOrderSettle(AlipayTradeOrderSettleModel model, String appId) throws AlipayApiException {
//        AlipayTradeOrderSettleRequest request = new AlipayTradeOrderSettleRequest();
//        request.setBizModel(model);
//        return doExecute(request, appId);
//    }
//
//
//    /**
//     * 小程序基于模板上传版本
//     * https://opendocs.alipay.com/mini/03l8bz
//     *
//     * @param
//     * @param appId
//     * @return
//     * @throws AlipayApiException
//     */
//    public static AlipayOpenMiniVersionUploadResponse openMiniVersionUpload(OpenMiniVersionUploadRequest openMiniVersionUploadRequest, String appId) throws AlipayApiException {
//        AlipayOpenMiniVersionUploadRequest request = new AlipayOpenMiniVersionUploadRequest();
//        request.setBizContent(JSONObject.toJSONString(openMiniVersionUploadRequest));
//        return doExecute(request, appId);
//    }
//
//    /**
//     * 小程序提交审核
//     * https://opendocs.alipay.com/mini/03l9bq
//     *
//     * @param
//     * @param appId
//     * @return
//     * @throws AlipayApiException
//     */
//    public static AlipayOpenMiniVersionAuditApplyResponse openMiniVersionUpload(AlipayOpenMiniVersionAuditApplyRequest request, String appId) throws AlipayApiException {
//        return doExecute(request, appId);
//    }
//
//    /**
//     * 小程序撤销审核
//     * https://opendocs.alipay.com/mini/03l9br
//     *
//     * @param appId
//     * @param appVersion 商家小程序版本号，需为审核通过状态或灰度中版本。
//     * @param bundleId   小程序投放的端参数，例如投放到支付宝钱包是支付宝端。默认支付宝端。支持：
//     *                   com.alipay.alipaywallet:支付宝端；
//     *                   com.alipay.iot.xpaas：支付宝IoT端。
//     * @return
//     * @throws AlipayApiException
//     */
//    public static AlipayOpenMiniVersionAuditCancelResponse oenMiniVersionAuditCancel(String appId, String appVersion, String bundleId) throws AlipayApiException {
//        AlipayOpenMiniVersionAuditCancelRequest request = new AlipayOpenMiniVersionAuditCancelRequest();
//        Map<String, Object> map = Maps.newHashMap();
//        map.put("app_version", appVersion);
//        map.put("bundle_id", bundleId);
//        request.setBizContent(JSONObject.toJSONString(map));
//        return doExecute(request, appId);
//    }
//
//
//    /**
//     * 小程序上架
//     * https://opendocs.alipay.com/mini/03l21p
//     *
//     * @param appId
//     * @param appVersion 商家小程序版本号，需为审核通过状态或灰度中版本。
//     * @param bundleId   小程序投放的端参数，例如投放到支付宝钱包是支付宝端。默认支付宝端。支持：
//     *                   com.alipay.alipaywallet:支付宝端；
//     *                   com.alipay.iot.xpaas：支付宝IoT端。
//     * @return
//     * @throws AlipayApiException
//     */
//    public static AlipayOpenMiniVersionOnlineResponse openMiniVersionUpload(String appId, String appVersion, String bundleId) throws AlipayApiException {
//        AlipayOpenMiniVersionOnlineRequest request = new AlipayOpenMiniVersionOnlineRequest();
//        Map<String, Object> map = Maps.newHashMap();
//        map.put("app_version", appVersion);
//        map.put("bundle_id", bundleId);
//        request.setBizContent(JSONObject.toJSONString(map));
//        return doExecute(request, appId);
//    }
//
//    /**
//     * 小程序下架
//     * https://opendocs.alipay.com/mini/03l8c0
//     *
//     * @param appId
//     * @param appVersion 商家小程序版本号，需为审核通过状态或灰度中版本。
//     * @param bundleId   小程序投放的端参数，例如投放到支付宝钱包是支付宝端。默认支付宝端。支持：
//     *                   com.alipay.alipaywallet:支付宝端；
//     *                   com.alipay.iot.xpaas：支付宝IoT端。
//     * @return
//     * @throws AlipayApiException
//     */
//    public static AlipayOpenMiniVersionOfflineResponse openMiniVersionOffline(String appId, String appVersion, String bundleId) throws AlipayApiException {
//        AlipayOpenMiniVersionOfflineRequest request = new AlipayOpenMiniVersionOfflineRequest();
//        Map<String, Object> map = Maps.newHashMap();
//        map.put("app_version", appVersion);
//        map.put("bundle_id", bundleId);
//        request.setBizContent(JSONObject.toJSONString(map));
//        return doExecute(request, appId);
//    }
//
//    /**
//     * 小程序回滚
//     * https://opendocs.alipay.com/mini/03l21q
//     *
//     * @param appId
//     * @param appVersion 商家小程序版本号，需为审核通过状态或灰度中版本。
//     * @param bundleId   小程序投放的端参数，例如投放到支付宝钱包是支付宝端。默认支付宝端。支持：
//     *                   com.alipay.alipaywallet:支付宝端；
//     *                   com.alipay.iot.xpaas：支付宝IoT端。
//     * @return
//     * @throws AlipayApiException
//     */
//    public static AlipayOpenMiniVersionRollbackResponse openMiniVersionRollback(String appId, String appVersion, String bundleId) throws AlipayApiException {
//        AlipayOpenMiniVersionRollbackRequest request = new AlipayOpenMiniVersionRollbackRequest();
//        Map<String, Object> map = Maps.newHashMap();
//        map.put("app_version", appVersion);
//        map.put("bundle_id", bundleId);
//        request.setBizContent(JSONObject.toJSONString(map));
//        return doExecute(request, appId);
//    }
//
//    /**
//     * 小程序生成体验版
//     * https://opendocs.alipay.com/mini/03l9bw
//     *
//     * @param appId
//     * @param appVersion 商家小程序版本号，需为审核通过状态或灰度中版本。
//     * @param bundleId   小程序投放的端参数，例如投放到支付宝钱包是支付宝端。默认支付宝端。支持：
//     *                   com.alipay.alipaywallet:支付宝端；
//     *                   com.alipay.iot.xpaas：支付宝IoT端。
//     * @return
//     * @throws AlipayApiException
//     */
//    public static AlipayOpenMiniExperienceCreateResponse openMiniExperienceCreate(String appId, String appVersion, String bundleId) throws AlipayApiException {
//        AlipayOpenMiniExperienceCreateRequest request = new AlipayOpenMiniExperienceCreateRequest();
//        Map<String, Object> map = Maps.newHashMap();
//        map.put("app_version", appVersion);
//        map.put("bundle_id", bundleId);
//        request.setBizContent(JSONObject.toJSONString(map));
//        return doExecute(request, appId);
//    }
//
//    /**
//     * 小程序取消体验版
//     * https://opendocs.alipay.com/mini/03l9bw
//     *
//     * @param appId
//     * @param appVersion 商家小程序版本号，需为审核通过状态或灰度中版本。
//     * @param bundleId   小程序投放的端参数，例如投放到支付宝钱包是支付宝端。默认支付宝端。支持：
//     *                   com.alipay.alipaywallet:支付宝端；
//     *                   com.alipay.iot.xpaas：支付宝IoT端。
//     * @return
//     * @throws AlipayApiException
//     */
//    public static AlipayOpenMiniExperienceCancelResponse openMiniExperienceCancel(String appId, String appVersion, String bundleId) throws AlipayApiException {
//        AlipayOpenMiniExperienceCancelRequest request = new AlipayOpenMiniExperienceCancelRequest();
//        Map<String, Object> map = Maps.newHashMap();
//        map.put("app_version", appVersion);
//        map.put("bundle_id", bundleId);
//        request.setBizContent(JSONObject.toJSONString(map));
//        return doExecute(request, appId);
//    }
//
//
//    /**
//     * 应用添加成员
//     * https://opendocs.alipay.com/mini/03l21t
//     *
//     * @param appId
//     * @param logonId 支付宝登录账号。
//     * @param role    为成员添加的角色类型，支持：
//     *                DEVELOPER-开发者；
//     *                EXPERIENCER-体验者。
//     * @return
//     * @throws AlipayApiException
//     */
//    public static AlipayOpenAppMembersCreateResponse openAppMembersCreate(String appId, String logonId, String role) throws AlipayApiException {
//        AlipayOpenAppMembersCreateRequest request = new AlipayOpenAppMembersCreateRequest();
//        Map<String, Object> map = Maps.newHashMap();
//        map.put("logon_id", logonId);
//        map.put("role", role);
//        request.setBizContent(JSONObject.toJSONString(map));
//        return doExecute(request, appId);
//    }
//
//    /**
//     * 应用删除成员
//     * https://opendocs.alipay.com/mini/03l3ex
//     *
//     * @param appId
//     * @param logonId 支付宝登录账号。
//     * @param role    为成员添加的角色类型，支持：
//     *                DEVELOPER-开发者；
//     *                EXPERIENCER-体验者。
//     * @return
//     * @throws AlipayApiException
//     */
//    public static AlipayOpenAppMembersDeleteResponse openAppMembersDelete(String appId, String logonId, String role) throws AlipayApiException {
//        AlipayOpenAppMembersDeleteRequest request = new AlipayOpenAppMembersDeleteRequest();
//        Map<String, Object> map = Maps.newHashMap();
//        map.put("logon_id", logonId);
//        map.put("role", role);
//        request.setBizContent(JSONObject.toJSONString(map));
//        return doExecute(request, appId);
//    }
//
//
//    public static <T extends AlipayResponse> T doExecute(AlipayRequest<T> request, String appId) throws AlipayApiException {
//        if (AliPayApiConfigKit.getApiConfig(appId).isCertModel()) {
//            return executeCer(request, appId);
//        } else {
//            return execute(request, appId);
//        }
//    }
//
//    /**
//     * 设置app auth token
//     * https://opendocs.alipay.com/support/01rglv
//     *
//     * @param request
//     * @param appId
//     * @param <T>
//     * @return
//     * @throws AlipayApiException
//     */
//    public static <T extends AlipayResponse> T execute(AlipayRequest<T> request, String appId) throws AlipayApiException {
//        return AliPayApiConfigKit.getApiConfig(appId).getAliPayClient().execute(request, null, "app_auth_token");
//    }
//
//    /**
//     * 设置app auth token
//     * https://opendocs.alipay.com/support/01rglv
//     *
//     * @param request
//     * @param appId
//     * @param <T>
//     * @return
//     * @throws AlipayApiException
//     */
//    public static <T extends AlipayResponse> T executeCer(AlipayRequest<T> request, String appId) throws AlipayApiException {
//        return AliPayApiConfigKit.getApiConfig(appId).getAliPayClient().certificateExecute(request, null, "app_auth_token");
//    }
//}
