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
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.dows.app.api.mini.AppApplyApi;
import org.dows.app.api.mini.request.AppApplyRequest;
import org.dows.app.biz.AppApplyBiz;
import org.dows.app.entity.AppApply;
import org.dows.app.service.AppApplyService;
import org.dows.auth.api.TempRedisApi;
import org.dows.framework.api.Response;
import org.dows.pay.api.PayEvent;
import org.dows.pay.api.PayHandler;
import org.dows.pay.api.PayMessage;
import org.dows.pay.api.PayRequest;
import org.dows.pay.api.annotation.PayMapping;
import org.dows.pay.api.enums.PayChannels;
import org.dows.pay.api.enums.PayMethods;
import org.dows.pay.api.message.AlipayMessage;
import org.dows.pay.api.message.alipay.MiniConfirmed;
import org.dows.pay.api.util.JsonUtils;
import org.dows.pay.bo.IsvCreateBo;
import org.dows.user.biz.UserCompanyBiz;
import org.dows.user.biz.UserCompanyRequest;
import org.dows.user.entity.UserCompany;
import org.springframework.beans.factory.annotation.Autowired;
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

    private final AppApplyBiz appApplyBiz;

    private final UserCompanyBiz userCompanyBiz;
    @Autowired
    private TempRedisApi tempRedisApi;

    @Autowired
    private AppApplyService appApplyService;

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
    public AlipayOpenMiniIsvCreateResponse createIsvMini(PayRequest payRequest) {
//        UUID uuid = idGenerator.generateId();
        IsvCreateBo isvCreateBo = (IsvCreateBo) payRequest.getBizModel();
        // todo 先查询该营业执照有没有申请过，如果没有就保存，如果有直接查询比对是否是相同的申请（orderNo为空 其他字段值全部相同通道+应用名）
//        AppApplyRequest appApply = new AppApplyRequest();
//        appApply.setAppName(isvCreateBo.getAppName());
//        appApply.setPlatform(PayChannels.ALIPAY.name());
//        appApply.setContactName(isvCreateBo.getContactName());
//        appApply.setContactPhone(isvCreateBo.getContactPhone());
//        Response responseAppApply = appApplyBiz.getOneAppApply(appApply);
//        if (responseAppApply == null || responseAppApply.getData() == null || ((AppApply)responseAppApply.getData()).getPlatformOrderNo() == null) {
//            // todo 保存请求
//            appApply.setApplyOrderNo(uuid.toString());
//            appApplyBiz.saveApply(appApply);
//        }else{
//            appApply.setApplyOrderNo(((AppApply)responseAppApply.getData()).getApplyOrderNo());
//        }

        CreateMiniRequest createMiniRequest = new CreateMiniRequest();
        // 自动
        autoMappingValue(payRequest, createMiniRequest);
        createMiniRequest.setOutOrderNo(payRequest.getApplyOrderNo());
        createMiniRequest.setAlipayAccount(isvCreateBo.getAccount());
        AlipayOpenMiniIsvCreateRequest request = new AlipayOpenMiniIsvCreateRequest();
        AlipayOpenMiniIsvCreateModel model = new AlipayOpenMiniIsvCreateModel();
        model.setCreateMiniRequest(createMiniRequest);
        request.setBizModel(model);
        AlipayOpenMiniIsvCreateResponse response = null;
        try {
            log.info("请求入参：{}", request);
            response = getAlipayClient(payRequest.getAppId()).certificateExecute(request);
            log.info("请求返回结果：{}", response);
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
        UserCompany responseUserCompany = userCompanyBiz.getOneUserCompany(userCompanyRequest);
        if (responseUserCompany == null) {
            userCompanyRequest.setCertNo(createMiniRequest.getCertNo());
            userCompanyRequest.setCompanyName(createMiniRequest.getCertName());
            userCompanyRequest.setLegalPerson(createMiniRequest.getLegalPersonalName());
            userCompanyBiz.saveUserCompany(userCompanyRequest);
        }

        if (response.isSuccess()) {
            // todo 保存订单号 及对应申请的营业执照 和联系人 信息，返回申请小程序记录表ID 后续通过ID查询
            String orderNo = response.getOrderNo();
            log.info("创建支付宝小程序成功，返回订单号为:{}", orderNo);
            /**
             * todo 建立关联关系（小程序申请对象） [小程序与营业执照的关系],通过营业执照来关联 小程序名 及对应的orderNo
             */
            AppApplyRequest appApplyUpdateRequest = new AppApplyRequest();
            appApplyUpdateRequest.setApplyOrderNo(payRequest.getApplyOrderNo());
            appApplyUpdateRequest.setPlatformOrderNo(orderNo);
            // 申请状态 0未申请 1-申请中 2-已申请 3.申请失败
            appApplyUpdateRequest.setAppStatus(String.valueOf(1));
            appApplyBiz.updateApplyPlatformOrderNo(appApplyUpdateRequest);
            log.info("调用成功,响应信息:{}", JSONUtil.toJsonStr(response));
        } else {
            log.error("调用失败,响应信息:{}", JSONUtil.toJsonStr(response));
        }
        return response;
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
        MiniConfirmed miniConfirmed = JsonUtils
                .parseObject(bizContent, new TypeReference<MiniConfirmed>() {
                });
        log.info(String.valueOf(miniConfirmed));
        AppApply appApply = new AppApply();
        appApply.setPlatform("ALIPAY");
        appApply.setPlatformOrderNo(miniConfirmed.getOrder_no());
        appApply.setApplyOrderNo(miniConfirmed.getOut_order_no());
        if (miniConfirmed.getStatus().equals("AGREED")) {
            // 成功
            appApply.setAppStatus(String.valueOf(2));
            appApply.setRejectionReason("注册小程序申请成功");
        } else if (miniConfirmed.getStatus().equals("REJECTED")) {
            // 拒绝
            appApply.setAppStatus(String.valueOf(3));
            appApply.setRejectionReason("注册小程序申请失败：");
        } else if (miniConfirmed.getStatus().equals("TIMEOUT")) {
            // 超时
            // 拒绝
            appApply.setAppStatus(String.valueOf(3));
            appApply.setRejectionReason("注册小程序申请失败（超时）");
        }
        // 修改完成信息
        // 更新AppApply
        LambdaQueryWrapper<AppApply> queryWrapperAppApply = new LambdaQueryWrapper();
        queryWrapperAppApply.eq(AppApply::getPlatform, appApply.getPlatform());
        queryWrapperAppApply.eq(AppApply::getApplyOrderNo, appApply.getApplyOrderNo());
        queryWrapperAppApply.eq(AppApply::getPlatformOrderNo, appApply.getPlatformOrderNo());
        appApplyService.update(appApply, queryWrapperAppApply);
    }
}
