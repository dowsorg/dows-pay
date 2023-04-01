package org.dows.pay.alipay;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.alipay.api.AlipayApiException;
import com.alipay.api.domain.AlipayOpenMiniIsvCreateModel;
import com.alipay.api.domain.AlipayOpenMiniIsvQueryModel;
import com.alipay.api.domain.AlipayOpenMiniVersionOnlineModel;
import com.alipay.api.domain.CreateMiniRequest;
import com.alipay.api.request.AlipayOpenMiniIsvCreateRequest;
import com.alipay.api.request.AlipayOpenMiniIsvQueryRequest;
import com.alipay.api.response.AlipayOpenMiniIsvCreateResponse;
import com.alipay.api.response.AlipayOpenMiniIsvQueryResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.app.api.mini.AppApplyApi;
import org.dows.app.api.mini.request.AppApplyRequest;
import org.dows.app.biz.AppApplyBiz;
import org.dows.app.entity.AppApply;
import org.dows.framework.api.Response;
import org.dows.pay.api.*;
import org.dows.pay.api.annotation.PayMapping;
import org.dows.pay.api.enums.PayChannels;
import org.dows.pay.api.enums.PayMethods;
import org.dows.pay.api.message.AlipayMessage;
import org.dows.pay.bo.IsvCreateBo;
import org.dows.user.api.api.UserCompanyApi;
import org.dows.user.biz.UserCompanyBiz;
import org.dows.user.biz.UserCompanyRequest;
import org.dows.user.entity.UserCompany;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.util.IdGenerator;
import org.springframework.util.SimpleIdGenerator;

import java.util.UUID;

/**
 * 代理商户作业相关业务逻辑，如：代开通或代创建小程序，其他等...
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class AlipayIsvHandler extends AbstractAlipayHandler {

    private final AppApplyApi appApplyApi;

    private final UserCompanyApi userCompanyApi;
    private final IdGenerator idGenerator = new SimpleIdGenerator();

    public static void main(String[] args) {
        ValueFilter valueFilter = (o, s, o1) -> o1 == null ? "" : o1;
        System.out.println(JSON.toJSONString(new AlipayOpenMiniVersionOnlineModel(), valueFilter, SerializerFeature.PrettyFormat));
    }


    /**
     * 申请/创建小程序
     *
     * @param
     */
    @PayMapping(method = PayMethods.ISV_CREATE)
    public void createIsvMini(PayRequest payRequest) {
        UUID uuid = idGenerator.generateId();
        IsvCreateBo isvCreateBo = (IsvCreateBo)payRequest.getBizModel();
        // todo 先查询该营业执照有没有申请过，如果没有就保存，如果有直接查询比对是否是相同的申请（orderNo为空 其他字段值全部相同通道+应用名）
        AppApplyRequest appApply = AppApplyRequest.builder()
                .appName(isvCreateBo.getAppName())
                .platform(PayChannels.ALIPAY.name())
                .contactName(isvCreateBo.getContactName())
                .contactPhone(isvCreateBo.getContactPhone())
                .build();
        Response responseAppApply = appApplyApi.getOneAppApply(appApply);
        if (responseAppApply == null || responseAppApply.getData() == null || ((AppApply)responseAppApply.getData()).getPlatformOrderNo() == null) {
            // todo 保存请求
            appApply.setApplyOrderNo(uuid.toString());
            appApplyApi.saveApply(appApply);
        }else{
            appApply.setApplyOrderNo(((AppApply)responseAppApply.getData()).getApplyOrderNo());
        }

        CreateMiniRequest createMiniRequest = new CreateMiniRequest();
        createMiniRequest.setOutOrderNo(appApply.getApplyOrderNo());
        // 自动
        autoMappingValue(payRequest, createMiniRequest);
        AlipayOpenMiniIsvCreateRequest request = new AlipayOpenMiniIsvCreateRequest();
        AlipayOpenMiniIsvCreateModel model = new AlipayOpenMiniIsvCreateModel();
        model.setCreateMiniRequest(createMiniRequest);
        request.setBizModel(model);
        AlipayOpenMiniIsvCreateResponse response = null;
        try {
            response = getAlipayClient(payRequest.getAppId()).certificateExecute(request);
        } catch (AlipayApiException e) {
            throw new RuntimeException(e);
        }


        /**
         * todo 提前保存该对象 createMiniRequest 到用户实体字典域UserCompany表，留后期场景使用
         * todo 保存公司信息到用户实体字典域
         */
        UserCompanyRequest userCompanyRequest = UserCompanyRequest.builder()
                .certNo(createMiniRequest.getCertNo())
                .build();
        UserCompany responseUserCompany = userCompanyApi.getOneUserCompany(userCompanyRequest);
        if (responseUserCompany == null) {
            userCompanyRequest.setCertNo(createMiniRequest.getCertNo());
            userCompanyRequest.setCompanyName(createMiniRequest.getCertName());
            userCompanyRequest.setLegalPerson(createMiniRequest.getLegalPersonalName());
            userCompanyApi.saveUserCompany(userCompanyRequest);
        }

        if (response.isSuccess()) {
            // todo 保存订单号 及对应申请的营业执照 和联系人 信息，返回申请小程序记录表ID 后续通过ID查询
            String orderNo = response.getOrderNo();
            log.info("创建支付宝小程序成功，返回订单号为:{}", orderNo);
            /**
             * todo 建立关联关系（小程序申请对象） [小程序与营业执照的关系],通过营业执照来关联 小程序名 及对应的orderNo
             */
            AppApplyRequest appApplyUpdateRequest = AppApplyRequest.builder()
                    .applyOrderNo(appApply.getApplyOrderNo())
                    .platformOrderNo(orderNo)
                    .build();
            appApplyApi.updateApplyPlatformOrderNo(appApplyUpdateRequest);
            log.info("调用成功,响应信息:{}", JSONUtil.toJsonStr(response));
        } else {
            log.error("调用失败,响应信息:{}", JSONUtil.toJsonStr(response));
        }
    }

    /**
     * 查询该订单协助创建小程序的情况
     * 服务商调用 alipay.open.mini.isv.query 接口，传入 order_no（订单编号）参数，
     */
    @PayMapping(method = PayMethods.ISV_QUERY)
    public String queryIsvMini(PayRequest payRequest) {
        AlipayOpenMiniIsvQueryModel alipayOpenMiniIsvQueryModel = new AlipayOpenMiniIsvQueryModel();
        // 自动映射
        autoMappingValue(payRequest, alipayOpenMiniIsvQueryModel);
        AlipayOpenMiniIsvQueryRequest request = new AlipayOpenMiniIsvQueryRequest();
        request.setBizModel(alipayOpenMiniIsvQueryModel);
        AlipayOpenMiniIsvQueryResponse response = null;
        try {
            response = getAlipayClient(payRequest.getAppId()).execute(request);
        } catch (AlipayApiException e) {
            throw new RuntimeException(e);
        }
        if (response.isSuccess()) {
            System.out.println("调用成功");
            return response.getStatus();
        } else {
            //todo 失败逻辑
            throw new RuntimeException("调用失败");
        }
    }

    /**
     * 商户确认服务商代创建小程序结果通知
     */
    @EventListener(value = {PayEvent.class})
    public void onIsvMerchantConfirmed(PayEvent<AlipayMessage> payEvent) {
        AlipayMessage payMessage = payEvent.getPayMessage();
        log.info("处理 alipay.open.mini.merchant.confirmed 事件消息:{}", payMessage);
        // todo 业务处理
        String appId = payMessage.getAppId();
        String msgApi = payMessage.getMsgApi();
        String msgId = payMessage.getMsgId();
        PayHandler handler = applicationContext.getBean(payEvent.getHandlerClass());
        handler.onMessage(payMessage);


    }

    @Override
    public void onMessage(PayMessage payMessage) {
        //AlipayMessage alipayMessage = (AlipayMessage)payMessage;
        String bizContent = payMessage.getBizContent();
        log.info("业务响应:bizContent = {}", bizContent);
    }
}
