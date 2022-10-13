package org.dows.pay.biz;

import cn.hutool.json.JSONUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.framework.api.Response;
import org.dows.pay.api.PayResponse;
import org.dows.pay.api.request.PayLedgersRequest;
import org.dows.pay.entity.PayLedgers;
import org.dows.pay.form.PayLedgersForm;
import org.dows.pay.gateway.PayDispatcher;
import org.dows.pay.service.PayLedgersService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 账本设置
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class LedgersSettingBiz {

    private final PayLedgersService payLedgersService;

    private final PayDispatcher payDispatcher;

    /**
     * 分账关系设置
     * 根据当前商户ID+支付通道ID 查询分账配置，并调用支付通道对应的分账接口，设置第三方分账
     */
    public void allotSetting(PayLedgersForm payLedgersForm) {
        // 根据 params 查询分账配置实体
        PayLedgers entity = payLedgersService.lambdaQuery()
                .eq(PayLedgers::getAppId, payLedgersForm.getAppId())
                .eq(PayLedgers::getAccountId, payLedgersForm.getAccountId())

                .getEntity();
        // 填充分账请求对象
        PayLedgersRequest payRequest = new PayLedgersRequest();
        // todo
        //payRequest.autoSet(params);
        String isvNo = payLedgersForm.getIsvNo();
        if(isvNo.equals("alipay")){
            payRequest.setChannel("alipay");
        } else {
            payRequest.setChannel("weixin");
        }
        payRequest.setMethod("dows.trade.royalty.relation.bind");
        String account = entity.getChannelAccountNo();
        //JSONUtil.toJsonStr()
        String params = "{" +
                "  \"receiver_list\":[" +
                "    {" +
                "      \"type\":\"userId\"," +
                "      \"account\":"+account+"," +
                "      \"name\":\"测试名称\"," +
                "      \"memo\":\"分账给测试商户\"," +
                "      \"login_name\":\"test@alitest.xyz\"," +
                "      \"bind_login_name\":\"test@alitest.xyz\"" +
                "    }" +
                "  ]," +
                "  \"out_request_no\":\"2019032200000001\"" +
                "}";

        payRequest.setBizContent(JSONUtil.toJsonStr(entity));
        // 请求分发
        Response<PayResponse> response = payDispatcher.dispatcher(payRequest);
        PayResponse data = response.getData();

        log.info("返回结果:{}", data);
    }


}
