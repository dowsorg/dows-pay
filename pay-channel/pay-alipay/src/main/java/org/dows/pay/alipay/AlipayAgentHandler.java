package org.dows.pay.alipay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.FileItem;
import com.alipay.api.domain.AlipayOpenAgentConfirmModel;
import com.alipay.api.domain.AlipayOpenAgentCreateModel;
import com.alipay.api.domain.AlipayOpenAgentOrderQueryModel;
import com.alipay.api.domain.ContactModel;
import com.alipay.api.request.*;
import com.alipay.api.response.*;
import com.alipay.service.schema.util.StringUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.dows.app.entity.AppApply;
import org.dows.app.service.AppApplyService;
import org.dows.pay.api.PayRequest;
import org.dows.pay.api.annotation.PayMapping;
import org.dows.pay.api.enums.PayMethods;
import org.dows.pay.api.request.PayCreateIsvRequest;
import org.dows.pay.api.request.PayQueryIsvRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.File;
import java.net.URL;
import java.util.Objects;
import java.util.UUID;

/**
 * 小程序相关业务功能
 * <p>
 * 构建小程序版本
 * <p>
 * 上传版本
 * <p>
 * alipay.open.mini.version.upload
 * <p>
 * 小程序版本上传成功即完成小程序版本构建。
 * <p>
 * 可代调用如下接口管理构建的小程序：
 * <p>
 * alipay.open.mini.version.build.query 查询小程序版本构建状态
 * alipay.open.mini.version.delete 删除商家小程序版本
 * alipay.open.mini.experience.create 生成商家小程序体验版
 * alipay.open.mini.experience.query 查询商家小程序体验版状态
 * alipay.open.app.members.create 添加开发者或体验者
 * alipay.open.mini.experience.cancel 取消商家小程序体验版
 * <p>
 * 查询小程序信息：alipay.open.mini.baseinfo.query
 * 修改小程序信息：alipay.open.mini.baseinfo.modify
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class AlipayAgentHandler extends AbstractAlipayHandler {

    @Autowired
    private AppApplyService appApplyService;

    /**
     * 开启代商户签约、创建应用事务
     * https://opendocs.alipay.com/isv/02s1f9
     * 通过 alipay.open.agent.create（开启代商户签约、创建应用事务）接口创建应用事务，返回生成 batch_no。
     */
    @PayMapping(method = PayMethods.AGENT_CREATE)
    public AlipayOpenAgentCreateResponse createAgent(PayCreateIsvRequest payCreateIsvRequest) {

        AppApply appApply;

        LambdaQueryWrapper<AppApply> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(AppApply::getApplicant, payCreateIsvRequest.getAccount());
        appApply = (AppApply) this.appApplyService.getOne(queryWrapper);

        if (Objects.isNull(appApply)) {
            appApply = new AppApply();
            appApply.setPlatform("ALIPAY");
            appApply.setApplyOrderNo(UUID.randomUUID().toString());
            appApply.setApplicant(payCreateIsvRequest.getAccount());
            appApply.setMerchantNo("111");
            appApply.setAuthStatus("0");
            appApply.setFastRegister(0);
            this.appApplyService.save(appApply);
        }

        AlipayOpenAgentCreateModel alipayOpenAgentCreateModel = new AlipayOpenAgentCreateModel();
        ContactModel contactModel = new ContactModel();
        contactModel.setContactName(payCreateIsvRequest.getContact_name());
        contactModel.setContactMobile(payCreateIsvRequest.getContact_mobile());
        contactModel.setContactEmail(payCreateIsvRequest.getContact_email());
        alipayOpenAgentCreateModel.setContactInfo(contactModel);
        alipayOpenAgentCreateModel.setAccount(payCreateIsvRequest.getAccount());
        // 自动映射
//        autoMappingValue(payRequest, alipayOpenAgentCreateModel);
        AlipayOpenAgentCreateRequest request = new AlipayOpenAgentCreateRequest();
        request.setBizModel(alipayOpenAgentCreateModel);
        AlipayOpenAgentCreateResponse response = null;
        try {
            response = getAlipayClient(payCreateIsvRequest.getAppid()).certificateExecute(request);
        } catch (AlipayApiException e) {
            throw new RuntimeException(e);
        }
        if (response.isSuccess()) {
            LambdaQueryWrapper<AppApply> queryWrapperAppApply = new LambdaQueryWrapper();
            queryWrapperAppApply.eq(AppApply::getApplyOrderNo, appApply.getApplyOrderNo());
            appApply.setPlatformOrderNo(response.getBatchNo());
            this.appApplyService.update(appApply, queryWrapperAppApply);
        }
        return response;

    }

    /**
     * 开启代商户签约、创建应用事务
     * https://opendocs.alipay.com/isv/02s1f9
     * 通过 alipay.open.agent.create（开启代商户签约、创建应用事务）接口创建应用事务，返回生成 batch_no。
     * 回调获取app auth token
     */
    @PayMapping(method = PayMethods.AGENT_FACETOFACE)
    public AlipayOpenAgentFacetofaceSignResponse facetofaceAgent(PayCreateIsvRequest payCreateIsvRequest, String batchNo) {
//        IsvCreateBo isvCreateBo = (IsvCreateBo) payRequest.getBizModel();
        AlipayOpenAgentFacetofaceSignRequest request = new AlipayOpenAgentFacetofaceSignRequest();
        request.setBatchNo(batchNo);
        request.setMccCode(payCreateIsvRequest.getMcc_code());
        request.setRate("0.38");
        request.setSignAndAuth(true);
        FileItem BusinessShopPic = getPicFile(payCreateIsvRequest.getShop_scene_pic());
        request.setShopScenePic(BusinessShopPic);
        FileItem BusinessShopSignPic = getPicFile(payCreateIsvRequest.getShop_sign_board_pic());
        request.setShopSignBoardPic(BusinessShopSignPic);
        request.setShopName(payCreateIsvRequest.getShop_name());
        if(payCreateIsvRequest.getIsPerson()==0){
            FileItem BusinessLicensePic = new FileItem(payCreateIsvRequest.getBusiness_license_pic());
            request.setBusinessLicensePic(BusinessLicensePic);
        }
        if (!StringUtil.isEmpty(payCreateIsvRequest.getBusiness_license_mobile())) {
            payCreateIsvRequest.setBusiness_license_mobile(payCreateIsvRequest.getBusiness_license_mobile());
        }
//        AlipayOpenAgentFacetofaceSignResponse response = null;
        try {
            return getAlipayClient(payCreateIsvRequest.getAppid()).certificateExecute(request);
        } catch (AlipayApiException e) {
            throw new RuntimeException(e);
        }


    }

    /**
     * 开启代商户签约、创建应用事务
     * https://opendocs.alipay.com/isv/02s1f9
     * 通过 alipay.open.agent.create（开启代商户签约、创建应用事务）接口创建应用事务，返回生成 batch_no。
     */
    @PayMapping(method = PayMethods.AGENT_COMMON)
    public void commonAgent(PayRequest payRequest) {
        AlipayOpenAgentCommonSignRequest request = new AlipayOpenAgentCommonSignRequest();
        AlipayOpenAgentCommonSignResponse response;
        try {
            response = getAlipayClient(payRequest.getAppId()).certificateExecute(request);
        } catch (AlipayApiException e) {
            throw new RuntimeException(e);
        }
        if (response.isSuccess()) {
            System.out.println("调用成功");
        } else {
            //todo 失败逻辑
            throw new RuntimeException("调用失败");
        }

    }

    /**
     * 开启代商户签约、创建应用事务
     * https://opendocs.alipay.com/isv/02s1f9
     * 通过 alipay.open.agent.create（开启代商户签约、创建应用事务）接口创建应用事务，返回生成 batch_no。
     *
     * @return
     */
    @PayMapping(method = PayMethods.AGENT_CONFIRM)
    public AlipayOpenAgentConfirmResponse confirmAgent(PayCreateIsvRequest payCreateIsvRequest, String batchNo) {
        AlipayOpenAgentConfirmModel alipayOpenAgentConfirmModel = new AlipayOpenAgentConfirmModel();
        alipayOpenAgentConfirmModel.setBatchNo(batchNo);
        AlipayOpenAgentConfirmRequest request = new AlipayOpenAgentConfirmRequest();
        request.setBizModel(alipayOpenAgentConfirmModel);
//        AlipayOpenAgentConfirmResponse response;
        try {
            return getAlipayClient(payCreateIsvRequest.getAppid()).certificateExecute(request);
        } catch (AlipayApiException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 开启代商户签约、创建应用事务
     * https://opendocs.alipay.com/isv/02s1f9
     * 通过 alipay.open.agent.create（开启代商户签约、创建应用事务）接口创建应用事务，返回生成 batch_no。
     */
    @PayMapping(method = PayMethods.AGENT_QUERY)
    public AlipayOpenAgentOrderQueryResponse queryAgent(PayQueryIsvRequest payQueryIsvRequest) {
        AlipayOpenAgentOrderQueryResponse response = new AlipayOpenAgentOrderQueryResponse();
        String BatchNo = payQueryIsvRequest.getBatch_no();
        if (StringUtil.isEmpty(BatchNo)) {
            try {
                LambdaQueryWrapper<AppApply> queryWrapper = new LambdaQueryWrapper();
                queryWrapper.eq(AppApply::getApplicant, payQueryIsvRequest.getAccount());
                AppApply appApply = this.appApplyService.getOne(queryWrapper);
                BatchNo = appApply.getPlatformOrderNo();
            } catch (Exception e) {
                response.setSubMsg("支付宝账号未申请");
                return response;
            }
        }
        AlipayOpenAgentOrderQueryModel alipayOpenAgentOrderQueryModel = new AlipayOpenAgentOrderQueryModel();
        alipayOpenAgentOrderQueryModel.setBatchNo(BatchNo);
        AlipayOpenAgentOrderQueryRequest request = new AlipayOpenAgentOrderQueryRequest();
        request.setBizModel(alipayOpenAgentOrderQueryModel);
        try {
            return getAlipayClient(payQueryIsvRequest.getAppid()).certificateExecute(request);
        } catch (AlipayApiException e) {
            throw new RuntimeException(e);
        }
    }

    public static FileItem getPicFile(String path) {
        FileItem file = null;
        if (path.startsWith("http")) {
            URL url;
            try {
                url = new URL(path);
                String tempPath = path.substring(path.lastIndexOf('/'));
                String patrol = "/opt/dows/tenant/image"+tempPath;
                File mediaFile = new File(patrol);
                FileUtils.copyURLToFile(url, mediaFile);
                file = new FileItem(patrol);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            file = new FileItem(path);
        }
        return file;
    }

}
