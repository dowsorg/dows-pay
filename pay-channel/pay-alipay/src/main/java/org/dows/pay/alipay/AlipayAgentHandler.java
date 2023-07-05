//package org.dows.pay.alipay;
//
//import com.alipay.api.AlipayApiException;
//import com.alipay.api.domain.AlipayOpenAgentConfirmModel;
//import com.alipay.api.domain.AlipayOpenAgentCreateModel;
//import com.alipay.api.domain.AlipayOpenAgentOrderQueryModel;
//import com.alipay.api.request.*;
//import com.alipay.api.response.*;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.dows.pay.api.PayRequest;
//import org.dows.pay.api.annotation.PayMapping;
//import org.dows.pay.api.enums.PayMethods;
//import org.springframework.stereotype.Service;
//
///**
// * 小程序相关业务功能
// * <p>
// * 构建小程序版本
// * <p>
// * 上传版本
// * <p>
// * alipay.open.mini.version.upload
// * <p>
// * 小程序版本上传成功即完成小程序版本构建。
// * <p>
// * 可代调用如下接口管理构建的小程序：
// * <p>
// * alipay.open.mini.version.build.query 查询小程序版本构建状态
// * alipay.open.mini.version.delete 删除商家小程序版本
// * alipay.open.mini.experience.create 生成商家小程序体验版
// * alipay.open.mini.experience.query 查询商家小程序体验版状态
// * alipay.open.app.members.create 添加开发者或体验者
// * alipay.open.mini.experience.cancel 取消商家小程序体验版
// * <p>
// * 查询小程序信息：alipay.open.mini.baseinfo.query
// * 修改小程序信息：alipay.open.mini.baseinfo.modify
// */
//@Slf4j
//@RequiredArgsConstructor
//@Service
//public class AlipayAgentHandler extends AbstractAlipayHandler {
//
//
//    /**
//     * 开启代商户签约、创建应用事务
//     * https://opendocs.alipay.com/isv/02s1f9
//     * 通过 alipay.open.agent.create（开启代商户签约、创建应用事务）接口创建应用事务，返回生成 batch_no。
//     */
//    @PayMapping(method = PayMethods.AGENT_CREATE)
//    public String createAgent(PayRequest payRequest) {
//        AlipayOpenAgentCreateModel alipayOpenAgentCreateModel = new AlipayOpenAgentCreateModel();
//        AlipayOpenAgentCreateRequest request = new AlipayOpenAgentCreateRequest();
//        request.setBizModel(alipayOpenAgentCreateModel);
//        AlipayOpenAgentCreateResponse response;
//        try {
//            response = getAlipayClient(payRequest.getAppId()).execute(request);
//        } catch (AlipayApiException e) {
//            throw new RuntimeException(e);
//        }
//        if (response.isSuccess()) {
//            System.out.println("调用成功");
//            return response.getBatchNo();
//        } else {
//            throw new RuntimeException("调用失败");
//        }
//
//    }
//
//    /**
//     * 开启代商户签约、创建应用事务
//     * https://opendocs.alipay.com/isv/02s1f9
//     * 通过 alipay.open.agent.create（开启代商户签约、创建应用事务）接口创建应用事务，返回生成 batch_no。
//     * 回调获取app auth token
//     */
//    @PayMapping(method = PayMethods.AGENT_FACETOFACE)
//    public void facetofaceAgent(PayRequest payRequest) {
//        AlipayOpenAgentFacetofaceSignRequest request = new AlipayOpenAgentFacetofaceSignRequest();
//        AlipayOpenAgentFacetofaceSignResponse response;
//        try {
//            response = getAlipayClient(payRequest.getAppId()).execute(request);
//        } catch (AlipayApiException e) {
//            throw new RuntimeException(e);
//        }
//        if (response.isSuccess()) {
//            System.out.println("调用成功");
//        } else {
//            //todo 失败逻辑
//            throw new RuntimeException("调用失败");
//        }
//
//    }
//
//    /**
//     * 开启代商户签约、创建应用事务
//     * https://opendocs.alipay.com/isv/02s1f9
//     * 通过 alipay.open.agent.create（开启代商户签约、创建应用事务）接口创建应用事务，返回生成 batch_no。
//     */
//    @PayMapping(method = PayMethods.AGENT_COMMON)
//    public void commonAgent(PayRequest payRequest) {
//        AlipayOpenAgentCommonSignRequest request = new AlipayOpenAgentCommonSignRequest();
//        AlipayOpenAgentCommonSignResponse response;
//        try {
//            response = getAlipayClient(payRequest.getAppId()).execute(request);
//        } catch (AlipayApiException e) {
//            throw new RuntimeException(e);
//        }
//        if (response.isSuccess()) {
//            System.out.println("调用成功");
//        } else {
//            //todo 失败逻辑
//            throw new RuntimeException("调用失败");
//        }
//
//    }
//
//    /**
//     * 开启代商户签约、创建应用事务
//     * https://opendocs.alipay.com/isv/02s1f9
//     * 通过 alipay.open.agent.create（开启代商户签约、创建应用事务）接口创建应用事务，返回生成 batch_no。
//     */
//    @PayMapping(method = PayMethods.AGENT_CONFIRM)
//    public void confirmAgent(PayRequest payRequest) {
//        AlipayOpenAgentConfirmModel alipayOpenAgentConfirmModel = new AlipayOpenAgentConfirmModel();
//        AlipayOpenAgentConfirmRequest request = new AlipayOpenAgentConfirmRequest();
//        request.setBizModel(alipayOpenAgentConfirmModel);
//        AlipayOpenAgentConfirmResponse response;
//        try {
//            response = getAlipayClient(payRequest.getAppId()).execute(request);
//        } catch (AlipayApiException e) {
//            throw new RuntimeException(e);
//        }
//        if (response.isSuccess()) {
//            System.out.println("调用成功");
//        } else {
//            //todo 失败逻辑
//            throw new RuntimeException("调用失败");
//        }
//
//    }
//
//    /**
//     * 开启代商户签约、创建应用事务
//     * https://opendocs.alipay.com/isv/02s1f9
//     * 通过 alipay.open.agent.create（开启代商户签约、创建应用事务）接口创建应用事务，返回生成 batch_no。
//     */
//    @PayMapping(method = PayMethods.AGENT_QUERY)
//    public AlipayOpenAgentOrderQueryResponse queryAgent(PayRequest payRequest) {
//        AlipayOpenAgentOrderQueryModel alipayOpenAgentOrderQueryModel = new AlipayOpenAgentOrderQueryModel();
//        AlipayOpenAgentOrderQueryRequest request = new AlipayOpenAgentOrderQueryRequest();
//        request.setBizModel(alipayOpenAgentOrderQueryModel);
//        AlipayOpenAgentOrderQueryResponse response;
//        try {
//            response = getAlipayClient(payRequest.getAppId()).execute(request);
//        } catch (AlipayApiException e) {
//            throw new RuntimeException(e);
//        }
//        if (response.isSuccess()) {
//            System.out.println("调用成功");
//            return response;
//        } else {
//            //todo 失败逻辑
//            throw new RuntimeException("调用失败");
//        }
//
//    }
//
//
//}
