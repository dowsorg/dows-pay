package org.dows.pay.biz;

/**
 * 小程序BIZ
 */

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSONObject;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.app.entity.AppApplyItem;
import org.dows.auth.api.weixin.WeixinTokenApi;
import org.dows.framework.api.Response;
import org.dows.pay.api.PayResponse;
import org.dows.pay.api.enums.PayMethods;
import org.dows.pay.api.request.PayIsvRequest;
import org.dows.pay.bo.WxBaseInfoBo;
import org.dows.pay.bo.WxFastMaCategoryBo;
import org.dows.pay.form.SetWxBaseInfoForm;
import org.dows.pay.form.WxBaseInfoForm;
import org.dows.pay.form.WxFastMaCategoryForm;
import org.dows.pay.gateway.PayDispatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ISV 代理商业务
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MiniBiz {
    private final PayDispatcher payDispatcher;

    @Autowired
    private WeixinTokenApi weixinTokenApi;

    /**
     * MiniCategory 创建类目
     *
     * @param wxFastMaCategoryForm
     */
    public Response addCategory(WxFastMaCategoryForm wxFastMaCategoryForm) {
        PayIsvRequest payRequest = new PayIsvRequest();
        // todo
        WxFastMaCategoryBo wxFastMaCategoryBo = BeanUtil.copyProperties(wxFastMaCategoryForm, WxFastMaCategoryBo.class);
        // 设置请求方法
        payRequest.setMethod(PayMethods.MINI_CATEGORY_ADD.getNamespace());
        // 设置业务参数对象bizModel
        payRequest.setBizModel(wxFastMaCategoryBo);
        // 填充公共参数
        payRequest.autoSet(wxFastMaCategoryForm);
        // 请求分发
        Response<PayResponse> response = payDispatcher.dispatcher(payRequest);
        PayResponse data = response.getData();
        log.info("返回结果:{}", data);
        return response;
    }

    /**
     * MiniCategory 查询类目
     *
     * @param wxFastMaCategoryForm
     */
    public Response category(WxFastMaCategoryForm wxFastMaCategoryForm) {
        PayIsvRequest payRequest = new PayIsvRequest();
        // todo
        WxFastMaCategoryBo wxFastMaCategoryBo = BeanUtil.copyProperties(wxFastMaCategoryForm, WxFastMaCategoryBo.class);
        // 设置请求方法
        payRequest.setMethod(PayMethods.MINI_CATEGORY.getNamespace());
        // 设置业务参数对象bizModel
        payRequest.setBizModel(wxFastMaCategoryBo);
        // 填充公共参数
        payRequest.autoSet(wxFastMaCategoryForm);
        // 请求分发
        Response<PayResponse> response = payDispatcher.dispatcher(payRequest);
        PayResponse data = response.getData();
        log.info("返回结果:{}", data);
        return response;
    }

    /**
     * MiniCategory 更新类目
     *
     * @param wxFastMaCategoryForm
     */
    public Response updateCategory(WxFastMaCategoryForm wxFastMaCategoryForm) {
        PayIsvRequest payRequest = new PayIsvRequest();
        // todo
        WxFastMaCategoryBo wxFastMaCategoryBo = BeanUtil.copyProperties(wxFastMaCategoryForm, WxFastMaCategoryBo.class);
        // 设置请求方法
        payRequest.setMethod(PayMethods.MINI_CATEGORY_ADD.getNamespace());
        // 设置业务参数对象bizModel
        payRequest.setBizModel(wxFastMaCategoryBo);
        // 填充公共参数
        payRequest.autoSet(wxFastMaCategoryForm);
        // 请求分发
        Response<PayResponse> response = payDispatcher.dispatcher(payRequest);
        PayResponse data = response.getData();
        log.info("返回结果:{}", data);
        return response;
    }

    /**
     * MiniCategory 删除类目
     *
     * @param wxFastMaCategoryForm
     */
    public Response delCategory(WxFastMaCategoryForm wxFastMaCategoryForm) {
        PayIsvRequest payRequest = new PayIsvRequest();
        // todo
        WxFastMaCategoryBo wxFastMaCategoryBo = BeanUtil.copyProperties(wxFastMaCategoryForm, WxFastMaCategoryBo.class);
        // 设置请求方法
        payRequest.setMethod(PayMethods.MINI_CATEGORY_DEL.getNamespace());
        // 设置业务参数对象bizModel
        payRequest.setBizModel(wxFastMaCategoryBo);
        // 填充公共参数
        payRequest.autoSet(wxFastMaCategoryForm);
        // 请求分发
        Response<PayResponse> response = payDispatcher.dispatcher(payRequest);
        PayResponse data = response.getData();
        log.info("返回结果:{}", data);
        return response;
    }

    /**
     * MiniCategory 查询已设置类目
     *
     * @param wxFastMaCategoryForm
     */
    public Response getCategory(WxFastMaCategoryForm wxFastMaCategoryForm) {
        PayIsvRequest payRequest = new PayIsvRequest();
        // todo
        WxFastMaCategoryBo wxFastMaCategoryBo = BeanUtil.copyProperties(wxFastMaCategoryForm, WxFastMaCategoryBo.class);
        // 设置请求方法
        payRequest.setMethod(PayMethods.MINI_CATEGORY_HANDLED.getNamespace());
        // 设置业务参数对象bizModel
        payRequest.setBizModel(wxFastMaCategoryBo);
        // 填充公共参数
        payRequest.autoSet(wxFastMaCategoryForm);
        // 请求分发
        Response<PayResponse> response = payDispatcher.dispatcher(payRequest);
        PayResponse data = response.getData();
        log.info("返回结果:{}", data);
        return response;
    }

    /**
     * MiniBaseInfo 代商户设置小程序名称
     *
     * @param wxBaseInfoForm
     */
    public Response setNickName(WxBaseInfoForm wxBaseInfoForm) {
        PayIsvRequest payRequest = new PayIsvRequest();
        // todo
        WxBaseInfoBo wxBaseInfoBo = BeanUtil.copyProperties(wxBaseInfoForm, WxBaseInfoBo.class);
        // 设置请求方法
        payRequest.setMethod(PayMethods.MINI_BASE_NICKNAME.getNamespace());
        // 设置业务参数对象bizModel
        payRequest.setBizModel(wxBaseInfoBo);
        // 填充公共参数
        payRequest.autoSet(wxBaseInfoForm);
        // 请求分发
        Response<PayResponse> response = payDispatcher.dispatcher(payRequest);
        PayResponse data = response.getData();
        log.info("返回结果:{}", data);
        return response;
    }

    /**
     * MiniBaseInfo 查询小程序名称状态
     *
     * @param wxBaseInfoForm
     */
    public Response getNickNameStatus(WxBaseInfoForm wxBaseInfoForm) {
        PayIsvRequest payRequest = new PayIsvRequest();
        // todo
        WxBaseInfoBo wxBaseInfoBo = BeanUtil.copyProperties(wxBaseInfoForm, WxBaseInfoBo.class);
        // 设置请求方法
        payRequest.setMethod(PayMethods.MINI_BASE_STATUS.getNamespace());
        // 设置业务参数对象bizModel
        payRequest.setBizModel(wxBaseInfoBo);
        // 填充公共参数
        payRequest.autoSet(wxBaseInfoForm);
        // 请求分发
        Response<PayResponse> response = payDispatcher.dispatcher(payRequest);
        PayResponse data = response.getData();
        log.info("返回结果:{}", data);
        return response;
    }

    /**
     * MiniBaseInfo 代商户设置小程序介绍
     *
     * @param wxBaseInfoForm
     */
    public Response setSignature(WxBaseInfoForm wxBaseInfoForm) {
        PayIsvRequest payRequest = new PayIsvRequest();
        // todo
        WxBaseInfoBo wxBaseInfoBo = BeanUtil.copyProperties(wxBaseInfoForm, WxBaseInfoBo.class);
        // 设置请求方法
        payRequest.setMethod(PayMethods.MINI_BASE_SIGNATURE.getNamespace());
        // 设置业务参数对象bizModel
        payRequest.setBizModel(wxBaseInfoBo);
        // 填充公共参数
        payRequest.autoSet(wxBaseInfoForm);
        // 请求分发
        Response<PayResponse> response = payDispatcher.dispatcher(payRequest);
        PayResponse data = response.getData();
        log.info("返回结果:{}", data);
        return response;
    }

    /**
     * MiniBaseInfo 代商户设置小程序头像
     *
     * @param wxBaseInfoForm
     */
    public Response setHeadImage(WxBaseInfoForm wxBaseInfoForm) {
        PayIsvRequest payRequest = new PayIsvRequest();
        // todo
        WxBaseInfoBo wxBaseInfoBo = BeanUtil.copyProperties(wxBaseInfoForm, WxBaseInfoBo.class);
        // 设置请求方法
        payRequest.setMethod(PayMethods.MINI_BASE_HEADIMAGE.getNamespace());
        // 设置业务参数对象bizModel
        payRequest.setBizModel(wxBaseInfoBo);
        // 填充公共参数
        payRequest.autoSet(wxBaseInfoForm);
        // 请求分发
        Response<PayResponse> response = payDispatcher.dispatcher(payRequest);
        PayResponse data = response.getData();
        log.info("返回结果:{}", data);
        return response;
    }

    /**
     * MiniBaseInfo 设置微信小程序 名称 、介绍、类目。头像等信息
     *
     * @param setWxBaseInfoForm
     */
    public Response setWxinApplyInfo(SetWxBaseInfoForm setWxBaseInfoForm) {
        WxBaseInfoForm wxBaseInfoForm = BeanUtil.copyProperties(setWxBaseInfoForm, WxBaseInfoForm.class);
        // todo
        WxBaseInfoBo wxBaseInfoBo = BeanUtil.copyProperties(wxBaseInfoForm, WxBaseInfoBo.class);
        WxFastMaCategoryForm wxFastMaCategoryForm = BeanUtil.copyProperties(setWxBaseInfoForm, WxFastMaCategoryForm.class);
        // 获取access_token使用authorizer_access_token
        String authorizerAccessToken = weixinTokenApi.getAuthorizerAccessToken(setWxBaseInfoForm.getMerchantAppId());
        wxBaseInfoForm.setAuthorizerAccessToken(authorizerAccessToken);
        Response response = null;
        if (setWxBaseInfoForm.getNickName() != null) {
            response = setNickName(wxBaseInfoForm);
            log.info("设置微信小程序名称结果：{}", JSONObject.toJSONString(response));
        }
        if (setWxBaseInfoForm.getHeadImgMediaId() != null) {
            response = setHeadImage(wxBaseInfoForm);
            log.info("设置微信小程序头像结果：{}", JSONObject.toJSONString(response));
        }
        if (setWxBaseInfoForm.getSignature() != null) {
            response = setSignature(wxBaseInfoForm);
            log.info("设置微信小程序简介结果：{}", JSONObject.toJSONString(response));
        }
//        response = addCategory(wxFastMaCategoryForm);
        log.info("设置微信小程序类目结果：{}", JSONObject.toJSONString(response));
        return response;
    }
}
