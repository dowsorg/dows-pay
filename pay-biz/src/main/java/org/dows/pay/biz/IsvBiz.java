package org.dows.pay.biz;


import cn.hutool.core.bean.BeanUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.framework.api.Response;
import org.dows.pay.api.PayResponse;
import org.dows.pay.api.enums.PayMethods;
import org.dows.pay.api.request.PayIsvRequest;
import org.dows.pay.bo.IsvCreateBo;
import org.dows.pay.form.IsvCreateForm;
import org.dows.pay.form.IsvQueryForm;
import org.dows.pay.gateway.PayDispatcher;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class IsvBiz {
    private final PayDispatcher payDispatcher;

    /**
     * isv 创建
     *
     * @param isvCreateForm
     */
    public void isvCreate(IsvCreateForm isvCreateForm) {
        PayIsvRequest payRequest = new PayIsvRequest();
        // todo
        String channelCode = isvCreateForm.getChannel();
        if (channelCode.equals("alipay")) {
            payRequest.setChannel("alipay");
        } else {
            payRequest.setChannel("weixin");
        }
        payRequest.setMethod(PayMethods.ISV_CREATE.getNamespace());
        IsvCreateBo isvCreateBo = BeanUtil.copyProperties(isvCreateForm, IsvCreateBo.class);
        // 设置bizModel
        payRequest.setBizModel(isvCreateBo);
        payRequest.autoSet(isvCreateForm);
        // 请求分发
        Response<PayResponse> response = payDispatcher.dispatcher(payRequest);
        PayResponse data = response.getData();
        log.info("返回结果:{}", data);
    }


    /**
     * isv查询
     *
     * @param isvQueryForm
     */
    public void isvQuery(IsvQueryForm isvQueryForm) {
        PayIsvRequest payRequest = new PayIsvRequest();
        // todo
        String channelCode = isvQueryForm.getChannel();
        if (channelCode.equals("alipay")) {
            payRequest.setChannel("alipay");
        } else {
            payRequest.setChannel("weixin");
        }
        payRequest.setMethod(PayMethods.ISV_QUERY.getNamespace());
        IsvCreateBo isvCreateBo = BeanUtil.copyProperties(isvQueryForm, IsvCreateBo.class);
        // 设置bizModel
        payRequest.setBizModel(isvCreateBo);
        // 请求分发
        Response<PayResponse> response = payDispatcher.dispatcher(payRequest);
        PayResponse data = response.getData();
        log.info("返回结果:{}", data);
    }


}
