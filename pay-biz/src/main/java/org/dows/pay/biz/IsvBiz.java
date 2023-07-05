package org.dows.pay.biz;

import cn.hutool.core.bean.BeanUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.framework.api.Response;
import org.dows.pay.api.PayResponse;
import org.dows.pay.api.enums.PayMethods;
import org.dows.pay.api.request.PayIsvRequest;
import org.dows.pay.bo.IsvCreateBo;
import org.dows.pay.bo.IsvCreateTyBo;
import org.dows.pay.form.IsvCreateForm;
import org.dows.pay.form.IsvCreateTyForm;
import org.dows.pay.form.IsvQueryForm;
import org.dows.pay.gateway.PayDispatcher;
import org.springframework.stereotype.Service;

/**
 * ISV 代理商业务
 */
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
        IsvCreateBo isvCreateBo = BeanUtil.copyProperties(isvCreateForm, IsvCreateBo.class);
        // 设置请求方法
        payRequest.setMethod(PayMethods.ISV_CREATE.getNamespace());
        // 设置业务参数对象bizModel
        payRequest.setBizModel(isvCreateBo);
        // 填充公共参数
        payRequest.autoSet(isvCreateForm);
        // 请求分发
        Response<PayResponse> response = payDispatcher.dispatcher(payRequest);
        PayResponse data = response.getData();
        log.info("返回结果:{}", data);
    }

    /**
     * isv 创建
     *
     * @param isvCreateForm
     */
    public void isvApply(IsvCreateForm isvCreateForm) {
        PayIsvRequest payRequest = new PayIsvRequest();
        // todo
        IsvCreateBo isvCreateBo = BeanUtil.copyProperties(isvCreateForm, IsvCreateBo.class);
        // 设置请求方法
        payRequest.setMethod(PayMethods.ISV_APPLY.getNamespace());
        // 设置业务参数对象bizModel
        payRequest.setBizModel(isvCreateBo);
        // 填充公共参数
        payRequest.autoSet(isvCreateForm);
        // 请求分发
        Response<PayResponse> response = payDispatcher.dispatcher(payRequest);
        PayResponse data = response.getData();
        log.info("返回结果:{}", data);
    }

    /**
     * isvTy 创建
     *
     * @param isvCreateTyForm
     */
    public void isvTyCreate(IsvCreateTyForm isvCreateTyForm) {
        PayIsvRequest payRequest = new PayIsvRequest();
        // todo
        IsvCreateTyBo isvCreateTyBo = BeanUtil.copyProperties(isvCreateTyForm, IsvCreateTyBo.class);
        // 设置请求方法
        payRequest.setMethod(PayMethods.ISV_TY_CREATE.getNamespace());
        // 设置业务参数对象bizModel
        payRequest.setBizModel(isvCreateTyBo);
        // 填充公共参数
        payRequest.autoSet(isvCreateTyForm);
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
    public Response isvQuery(IsvQueryForm isvQueryForm) {
        PayIsvRequest payRequest = new PayIsvRequest();
        IsvCreateBo isvCreateBo = BeanUtil.copyProperties(isvQueryForm, IsvCreateBo.class);
        payRequest.setMethod(PayMethods.ISV_QUERY.getNamespace());
        // 设置bizModel
        payRequest.setBizModel(isvCreateBo);
        // 填充公共参数
        payRequest.autoSet(isvQueryForm);
        // 请求分发
        Response<PayResponse> response = payDispatcher.dispatcher(payRequest);
        PayResponse data = response.getData();
        log.info("返回结果:{}", data);
        return response;
    }


}
