package org.dows.pay.biz;

/**
 * 小程序BIZ
 */

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.open.bean.result.WxFastMaSetNickameResult;
import me.chanjar.weixin.open.bean.result.WxOpenResult;
import me.chanjar.weixin.open.util.json.WxOpenGsonBuilder;
import org.apache.commons.lang3.StringUtils;
import org.dows.app.api.mini.AppApplyApi;
import org.dows.app.api.mini.request.PayApplyStatusReq;
import org.dows.app.api.mini.response.AppApplyAndItemResponse;
import org.dows.app.entity.AppBase;
import org.dows.app.service.AppBaseService;
import org.dows.auth.api.weixin.WeixinTokenApi;
import org.dows.auth.biz.context.SecurityUtils;
import org.dows.framework.api.Response;
import org.dows.pay.enums.WxSetNickNameExceptionEnum;
import org.dows.pay.api.PayResponse;
import org.dows.pay.api.enums.PayMethods;
import org.dows.pay.api.request.PayIsvRequest;
import org.dows.pay.bo.WxBaseInfoBo;
import org.dows.pay.bo.WxFastMaCategoryBo;
import org.dows.pay.enums.WxSetSignatureExceptionEnum;
import org.dows.pay.form.SetWxBaseInfoForm;
import org.dows.pay.form.WxBaseInfoForm;
import org.dows.pay.form.WxFastMaCategoryForm;
import org.dows.pay.gateway.PayDispatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Autowired
    private AppApplyApi appApplyApi;

    @Autowired
    private AppBaseService appBaseService;

    /**
     * MiniCategory 创建类目
     *
     * @param wxFastMaCategoryForm
     */
    public Response addCategory(WxFastMaCategoryForm wxFastMaCategoryForm) {
        PayIsvRequest payRequest = new PayIsvRequest();
        // todo
        WxFastMaCategoryBo wxFastMaCategoryBo = BeanUtil.copyProperties(wxFastMaCategoryForm,
                WxFastMaCategoryBo.class);
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
        String merchantNo = SecurityUtils.getMerchantNo();
//        if (StringUtils.isBlank(merchantNo)) {
//            merchantNo = "xhr0001";
//        }
        try {
            saveOrUpdateAppBase(setWxBaseInfoForm, merchantNo);
            log.info("获取商户信息，merchantNo：{}", merchantNo);
            WxBaseInfoForm wxBaseInfoForm = BeanUtil.copyProperties(setWxBaseInfoForm, WxBaseInfoForm.class);
            // 获取access_token使用authorizer_access_token
            String authorizerAccessToken = weixinTokenApi.getAuthorizerAccessToken(setWxBaseInfoForm.getMerchantAppId());
            wxBaseInfoForm.setAuthorizerAccessToken(authorizerAccessToken);
            Response response = new Response();
            WxFastMaSetNickameResult wxFastMaSetNickameResult = null;
            WxOpenResult setSignatureWxOpenResult;
            WxOpenResult setHeadImageWxOpenResult;
            WxOpenResult addCategoryWxOpenResult;
            // 设置昵称
            if (setWxBaseInfoForm.getNickName() != null) {
                PayApplyStatusReq req = new PayApplyStatusReq();
                req.setMerchantNo(merchantNo);
                req.setAppId(setWxBaseInfoForm.getMerchantAppId());
                req.setApplyType(1);
                Response<AppApplyAndItemResponse> applyInfoByMerchantNo = appApplyApi.getApplyInfoByMerchantNo(req);
                if (applyInfoByMerchantNo != null) {
                    String certPicture = applyInfoByMerchantNo.getData().getCertPicture();
                    wxBaseInfoForm.setLicense(certPicture);
                    Response<PayResponse> setNickNameResponse = setNickName(wxBaseInfoForm);
                    if (setNickNameResponse != null) {
                        String body = setNickNameResponse.getData().getBody();
                        wxFastMaSetNickameResult =
                                WxOpenGsonBuilder.create().fromJson(body, WxFastMaSetNickameResult.class);
                        log.info("设置微信小程序名称返回结果：{}", JSONObject.toJSONString(wxFastMaSetNickameResult));
                        if (wxFastMaSetNickameResult.getErrcode().equals("0")) {
                            // 有审核id需要审核 无审核id直接通过
                            if (wxFastMaSetNickameResult.getAuditId() != null) {
                                updateStatus(setWxBaseInfoForm.getMerchantAppId(), merchantNo,
                                        1, String.valueOf(wxFastMaSetNickameResult.getAuditId()),
                                        0, 0, wxFastMaSetNickameResult.getErrmsg());
                            } else {
                                updateStatus(setWxBaseInfoForm.getMerchantAppId(), merchantNo,
                                        3, String.valueOf(wxFastMaSetNickameResult.getAuditId()),
                                        0, 0, wxFastMaSetNickameResult.getErrmsg());
                            }
                        } else {
                            response.setCode(Integer.valueOf(wxFastMaSetNickameResult.getErrcode()));
                            WxSetNickNameExceptionEnum messageByCode =
                                    WxSetNickNameExceptionEnum.getMessageByCode(wxFastMaSetNickameResult.getErrcode());
                            if (messageByCode != null) {
                                response.setDescr("设置小程序名称失败：" + messageByCode.getMessage());
                            } else {
                                response.setDescr("设置小程序名称失败：" + wxFastMaSetNickameResult.getErrmsg());
                            }
                            updateStatus(setWxBaseInfoForm.getMerchantAppId(), merchantNo,
                                    2, null,
                                    0, 2, response.getDescr());
                            return response;
                        }
                    } else {
                        updateStatus(setWxBaseInfoForm.getMerchantAppId(), merchantNo,
                                2, null,
                                2, 2, "设置小程序名称失败：返回结果为空");
                        response.setCode(500);
                        response.setDescr("设置小程序昵称返回结果为空");
                        return response;
                    }
                } else {
                    updateStatus(setWxBaseInfoForm.getMerchantAppId(), merchantNo,
                            0, null,
                            2, 2, "设置小程序名称失败：内部未查询到小程序相关信息");
                    return Response.failed("未查询到小程序相关信息");
                }
            }
            // 设置头像
            if (setWxBaseInfoForm.getHeadImgMediaId() != null) {
                Response<PayResponse> setHeadImageResponse = setHeadImage(wxBaseInfoForm);
                if (setHeadImageResponse != null) {
                    String body = setHeadImageResponse.getData().getBody();
                    setHeadImageWxOpenResult = WxOpenGsonBuilder.create().fromJson(body, WxOpenResult.class);
                    String errcode = setHeadImageWxOpenResult.getErrcode();
                    if (!errcode.equals("0")) {
                        WxSetSignatureExceptionEnum messageByCode = WxSetSignatureExceptionEnum.getMessageByCode(errcode);
                        response.setCode(Integer.valueOf(errcode));
                        if (messageByCode != null) {
                            response.setDescr("设置小程序头像失败：" + messageByCode.getMessage());
                        } else {
                            response.setDescr("设置小程序头像失败：" + setHeadImageWxOpenResult.getErrmsg());
                        }
                        updateStatus(setWxBaseInfoForm.getMerchantAppId(), merchantNo,
                                -1, null,
                                0, 2, response.getDescr());
                        return response;
                    }
                }
                log.info("设置微信小程序头像返回结果：{}", JSONObject.toJSONString(response));
            }
            // 设置简介
            if (setWxBaseInfoForm.getSignature() != null) {
                Response<PayResponse> setSignatureResponse = setSignature(wxBaseInfoForm);
                log.info("设置微信小程序简介返回结果：{}", JSONObject.toJSONString(response));
                if (setSignatureResponse != null) {
                    String body = setSignatureResponse.getData().getBody();
                    setSignatureWxOpenResult = WxOpenGsonBuilder.create().fromJson(body, WxOpenResult.class);
                    String errcode = setSignatureWxOpenResult.getErrcode();
                    if (!errcode.equals("0")) {
                        WxSetSignatureExceptionEnum messageByCode = WxSetSignatureExceptionEnum.getMessageByCode(errcode);
                        response.setCode(Integer.valueOf(errcode));
                        if (messageByCode != null) {
                            response.setDescr("设置简介失败：" + messageByCode.getMessage());
                        } else {
                            response.setDescr("设置简介失败：" + setSignatureWxOpenResult.getErrmsg());
                        }
                        updateStatus(setWxBaseInfoForm.getMerchantAppId(), merchantNo,
                                -1, null,
                                0, 2, response.getDescr());
                        return response;
                    }
                } else {
                    response.setCode(500);
                    response.setDescr("设置简介失败：返回结果为空");
                    updateStatus(setWxBaseInfoForm.getMerchantAppId(), merchantNo,
                            -1, null,
                            0, 2, response.getDescr());
                    return response;
                }
            }
            // 设置类目
            if (!StringUtils.isBlank(String.valueOf(setWxBaseInfoForm.getFirst())) && setWxBaseInfoForm.getCerticate() != null) {
                // todo
                WxFastMaCategoryForm wxFastMaCategoryForm = BeanUtil.copyProperties(setWxBaseInfoForm, WxFastMaCategoryForm.class);
                List<WxFastMaCategoryBo.Certificate> certicates = new ArrayList<>();
                WxFastMaCategoryBo.Certificate certificate = new WxFastMaCategoryBo.Certificate();
                certificate.setKey("资质证书");
                certificate.setValue(setWxBaseInfoForm.getCerticate());
                certicates.add(certificate);
                wxFastMaCategoryForm.setCerticates(certicates);
                Response<PayResponse> addCategoryResponse = addCategory(wxFastMaCategoryForm);
                log.info("设置微信小程序类目结果：{}", JSONObject.toJSONString(addCategoryResponse));
                if (addCategoryResponse != null) {
                    String body = addCategoryResponse.getData().getBody();
                    addCategoryWxOpenResult = WxOpenGsonBuilder.create().fromJson(body, WxOpenResult.class);
                    String errcode = addCategoryWxOpenResult.getErrcode();
                    if (!errcode.equals("0")) {
                        WxSetSignatureExceptionEnum messageByCode = WxSetSignatureExceptionEnum.getMessageByCode(errcode);
                        response.setCode(Integer.valueOf(errcode));
                        if (messageByCode != null) {
                            response.setDescr("设置类目失败：" + messageByCode.getMessage());
                        } else {
                            response.setDescr("设置类目失败：" + addCategoryWxOpenResult.getErrmsg());
                        }
                        updateStatus(setWxBaseInfoForm.getMerchantAppId(), merchantNo,
                                -1, null,
                                2, 2, response.getDescr());
                        return response;
                    } else {
                        response.setCode(0);
                        response.setDescr("设置微信小程序昵称、简介、类目相关信息已提交成功");
                        // 提交成功
                        updateStatus(setWxBaseInfoForm.getMerchantAppId(), merchantNo,
                                -1, null,
                                1, 0, "昵称、简介、类目已提交审核");
                        log.info("设置微信小程序类目结果：{}", JSONObject.toJSONString(response));
                        return response;
                    }
                } else {
                    response.setCode(500);
                    response.setDescr("设置类目返回结果为空");
                    // 提交成功
                    updateStatus(setWxBaseInfoForm.getMerchantAppId(), merchantNo,
                            -1, null,
                            0, 2, response.getDescr());
                    return response;
                }
            }
            return response;
        } catch (Exception e) {
            updateStatus(setWxBaseInfoForm.getMerchantAppId(), merchantNo,
                    2, null,
                    0, 2, "内部错误：" + e.getMessage());
            return Response.failed(e.getMessage());
        }
    }


    private void saveOrUpdateAppBase(SetWxBaseInfoForm setWxBaseInfoForm, String merchantNo) {
        // 根据tenantId和ALIPAY查询是已有记录
        LambdaQueryWrapper<AppBase> queryWrapper = new LambdaQueryWrapper<AppBase>();
        if (StringUtils.isNotEmpty(setWxBaseInfoForm.getMerchantAppId())) {
            queryWrapper.eq(AppBase::getAppId, setWxBaseInfoForm.getMerchantAppId());
        }
        queryWrapper.eq(AppBase::getAppType, 1);
        if (StringUtils.isNotEmpty(merchantNo)) {
            queryWrapper.eq(AppBase::getMerchantNo, merchantNo);
        }
        AppBase appBase = new AppBase();
        appBase.setAppName(setWxBaseInfoForm.getNickName());
        appBase.setBrief(setWxBaseInfoForm.getSignature());
        appBase.setFirstId(setWxBaseInfoForm.getFirst());
        appBase.setHasFinish(0);
        appBase.setCerticate(setWxBaseInfoForm.getCerticate());
        AppBase checkAppBase = appBaseService.getOne(queryWrapper);
        if (!Objects.isNull(checkAppBase)) {
            // todo 更新AppApply以及Item
            appBase.setId(checkAppBase.getId());
            LambdaQueryWrapper<AppBase> queryWrapperAppApply = new LambdaQueryWrapper();
            queryWrapperAppApply.eq(AppBase::getId, checkAppBase.getId());
            appBaseService.update(appBase, queryWrapperAppApply);
            log.info("更新AppBase");
        } else {
            appBase.setMerchantNo(merchantNo);
            appBase.setAppId(setWxBaseInfoForm.getMerchantAppId());
            appBase.setSecondId(25);
            appBase.setAppType(1);
            appBaseService.save(appBase);
            log.info("保存AppBase");
        }
    }

    private void updateStatus(String merchantAppId,
                              String merchantNo,
                              int appNameAuditStatus,
                              String appNameAuditNo,
                              int categoryAuditStatus,
                              int hasFinish,
                              String reason) {

        AppBase appBase = new AppBase();
        if (appNameAuditStatus != -1) {
            appBase.setAppNameAuditStatus(appNameAuditStatus);
        }
        if (appNameAuditNo != null) {
            appBase.setAppNameAuditNo(appNameAuditNo);
        }
        appBase.setCategoryAuditStatus(categoryAuditStatus);
        if (reason != null) {
            appBase.setReason(reason);
        }
        appBase.setHasFinish(hasFinish);
        LambdaQueryWrapper<AppBase> queryWrapperAppApply = new LambdaQueryWrapper();
        queryWrapperAppApply.eq(AppBase::getMerchantNo, merchantNo);
        if (merchantAppId != null) {
            queryWrapperAppApply.eq(AppBase::getAppId, merchantAppId);
        }
        queryWrapperAppApply.eq(AppBase::getAppType, 1);
        appBaseService.update(appBase, queryWrapperAppApply);
    }
}
