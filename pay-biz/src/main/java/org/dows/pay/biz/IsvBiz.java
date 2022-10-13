package org.dows.pay.biz;


import cn.hutool.core.bean.BeanUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.framework.api.Response;
import org.dows.pay.api.PayResponse;
import org.dows.pay.api.enums.PayMethods;
import org.dows.pay.api.request.PayIsvRequest;
import org.dows.pay.bo.IsvCreateBo;
import org.dows.pay.bo.RelationBingBo;
import org.dows.pay.gateway.PayDispatcher;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class IsvBiz {

    private final PayDispatcher payDispatcher;

    public void isvCreate() {
        PayIsvRequest payRequest = new PayIsvRequest();
        // todo
//        String channelCode = payLedgersForm.getChannelCode();
//        if (channelCode.equals("alipay")) {
//            payRequest.setChannel("alipay");
//        } else {
//            payRequest.setChannel("weixin");
//        }
//        payRequest.setMethod(PayMethods.ISV_CREATE.getNamespace());
//        IsvCreateBo isvCreateBo = BeanUtil.copyProperties(entity, IsvCreateBo.class);
//        // 设置bizModel
//        payRequest.setBizModel(isvCreateBo);
        // 请求分发
        Response<PayResponse> response = payDispatcher.dispatcher(payRequest);
        PayResponse data = response.getData();
        log.info("返回结果:{}", data);
    }


}
