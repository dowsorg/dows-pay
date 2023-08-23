package org.dows.pay.alipay;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.FileItem;
import com.alipay.api.domain.*;
import com.alipay.api.request.*;
import com.alipay.api.response.*;
import com.alipay.service.schema.util.StringUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.dows.app.api.mini.request.PayApplyStatusReq;
import org.dows.app.api.mini.response.AppApplyAndItemResponse;
import org.dows.app.entity.AppApply;
import org.dows.app.entity.AppApplyItem;
import org.dows.app.service.AppApplyItemService;
import org.dows.app.service.AppApplyService;
import org.dows.framework.api.Response;
import org.dows.framework.api.exceptions.BizException;
import org.dows.pay.api.PayRequest;
import org.dows.pay.api.annotation.PayMapping;
import org.dows.pay.api.enums.PayMethods;
import org.dows.pay.api.request.PayCreateIsvRequest;
import org.dows.pay.api.request.PayQueryIsvRequest;
import org.dows.pay.bo.IsvCreateBo;
import org.dows.pay.entity.PayApply;
import org.dows.pay.service.PayApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.File;
import java.net.URL;
import java.util.Date;
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

    @Autowired
    private PayApplyService payApplyService;

    @Autowired
    private AppApplyItemService appApplyItemService;
    /**
     * 开启代商户签约、创建应用事务
     * https://opendocs.alipay.com/isv/02s1f9
     * 通过 alipay.open.agent.create（开启代商户签约、创建应用事务）接口创建应用事务，返回生成 batch_no。
     */
    @PayMapping(method = PayMethods.AGENT_CREATE)
    public AlipayOpenAgentCreateResponse createAgent(PayCreateIsvRequest request) {
        if (Objects.isNull(request.getMerchantNo())) {
            throw new BizException("获取商户号为空");
        }

        LambdaQueryWrapper<PayApply> queryWrapper = new LambdaQueryWrapper<PayApply>()
                .eq(PayApply::getMerchantNo, request.getMerchantNo())
                .eq(PayApply::getApplyType, 2)
                .eq(PayApply::getAccount, request.getAccount())
                .eq(PayApply::getDeleted, false);
        PayApply payApply = this.payApplyService.getOne(queryWrapper);

        if (Objects.isNull(payApply)) {
            payApply = new PayApply();
            payApply.setMerchantNo(request.getMerchantNo());
            payApply.setBizName("支付宝当面付");
            payApply.setAccount(request.getAccount());
            payApply.setApplyType(2);
            payApply.setDt(new Date());
            payApply.setAliReq(JSON.toJSONString(request));
            payApply.setUpdateTime(new Date());
            payApplyService.save(payApply);
        }

        AlipayOpenAgentCreateModel alipayOpenAgentCreateModel = new AlipayOpenAgentCreateModel();

        ContactModel contactModel = new ContactModel();
        contactModel.setContactName(request.getContact_name());
        contactModel.setContactMobile(request.getContact_mobile());
        contactModel.setContactEmail(request.getContact_email());
        alipayOpenAgentCreateModel.setContactInfo(contactModel);
        alipayOpenAgentCreateModel.setAccount(request.getAccount());

        AlipayOpenAgentCreateRequest createRequest = new AlipayOpenAgentCreateRequest();
        createRequest.setBizModel(alipayOpenAgentCreateModel);

        AlipayOpenAgentCreateResponse response;
        try {
            response = getAlipayClient(request.getAppid()).certificateExecute(createRequest);
        } catch (Exception e) {
            log.error("createAgent fail:",e);
            throw new BizException("创建应用事务出错:"+e.getMessage());
        }
        if (response.isSuccess()) {
            payApply.setAliReq(JSON.toJSONString(request));
            payApply.setApplyNo(response.getBatchNo());
            payApplyService.updateById(payApply);
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
        AlipayOpenAgentFacetofaceSignRequest request = new AlipayOpenAgentFacetofaceSignRequest();
        request.setBatchNo(batchNo);
        // https://opendocs.alipay.com/isv/d90ee567_alipay.open.agent.facetoface.sign?scene=common&pathHash=20d91b56
        request.setMccCode(payCreateIsvRequest.getMcc_code());
        request.setRate("0.38");
        request.setSignAndAuth(true);
        request.setLongTerm(payCreateIsvRequest.isLong_term());
        FileItem BusinessShopPic = getPicFile(payCreateIsvRequest.getShop_scene_pic());
        request.setShopScenePic(BusinessShopPic);

        FileItem BusinessShopSignPic = getPicFile(payCreateIsvRequest.getShop_sign_board_pic());
        request.setShopSignBoardPic(BusinessShopSignPic);
        if (StrUtil.isNotBlank(payCreateIsvRequest.getBusiness_license_auth_pic())) {
            request.setBusinessLicenseAuthPic(getPicFile(payCreateIsvRequest.getBusiness_license_auth_pic()));
        }

        request.setShopName(payCreateIsvRequest.getShop_name());
        if(payCreateIsvRequest.getIsPerson()==0){
            FileItem BusinessLicensePic = getPicFile(payCreateIsvRequest.getBusiness_license_pic());
            request.setBusinessLicensePic(BusinessLicensePic);
        }
        if (!StringUtil.isEmpty(payCreateIsvRequest.getBusiness_license_mobile())) {
            payCreateIsvRequest.setBusiness_license_mobile(payCreateIsvRequest.getBusiness_license_mobile());
        }
        if (payCreateIsvRequest.getCountry_code()!=null
                && payCreateIsvRequest.getCity_code()!=null
                && payCreateIsvRequest.getProvince_code()!=null
                && payCreateIsvRequest.getDetail_address()!=null
                && payCreateIsvRequest.getDistrict_code()!=null) {
            SignAddressInfo signAddressInfo = new SignAddressInfo();
            signAddressInfo.setCityCode(payCreateIsvRequest.getCity_code());
            signAddressInfo.setCountryCode(payCreateIsvRequest.getCountry_code());
            signAddressInfo.setDetailAddress(payCreateIsvRequest.getDetail_address());
            signAddressInfo.setDistrictCode(payCreateIsvRequest.getDistrict_code());
            request.setShopAddress(signAddressInfo);
        }

        try {
            return getAlipayClient(payCreateIsvRequest.getAppid()).certificateExecute(request);
        } catch (AlipayApiException e) {
            log.error("facetofaceAgent fail:",e);
            throw new BizException("facetofaceAgent fail:"+e.getMessage());
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
        try {
            return getAlipayClient(payCreateIsvRequest.getAppid()).certificateExecute(request);
        } catch (AlipayApiException e) {
            log.error("confirmAgent fail:",e);
            throw new BizException("提交事务报错:"+e.getMessage());
        }
    }

    /**
     * 开启代商户签约、创建应用事务
     * https://opendocs.alipay.com/isv/02s1f9
     * 通过 alipay.open.agent.create（开启代商户签约、创建应用事务）接口创建应用事务，返回生成 batch_no。
     */
    @PayMapping(method = PayMethods.AGENT_QUERY)
    public AlipayOpenAgentOrderQueryResponse queryAgent(PayQueryIsvRequest payQueryIsvRequest) {
        if (StrUtil.isEmpty(payQueryIsvRequest.getAppid())) {
            payQueryIsvRequest.setAppid("2021003129694075");
        }
        AlipayOpenAgentOrderQueryModel alipayOpenAgentOrderQueryModel = new AlipayOpenAgentOrderQueryModel();
        alipayOpenAgentOrderQueryModel.setBatchNo(payQueryIsvRequest.getBatch_no());
        AlipayOpenAgentOrderQueryRequest request = new AlipayOpenAgentOrderQueryRequest();
        request.setBizModel(alipayOpenAgentOrderQueryModel);
        try {
            return getAlipayClient(payQueryIsvRequest.getAppid()).certificateExecute(request);
        } catch (AlipayApiException e) {
            throw new RuntimeException(e);
        }
    }

    public Response<PayCreateIsvRequest> getApplyIsvByMerchantNo(PayApplyStatusReq req) {
        PayApply appApply = payApplyService.getByMerchantNoAndType(req.getMerchantNo(), req.getApplyType());
        if (appApply != null) {
            if (StrUtil.isNotBlank(appApply.getAliReq())) {
                PayCreateIsvRequest payCreateIsvRequest= JSON.parseObject(appApply.getAliReq(),PayCreateIsvRequest.class);
                return Response.ok(payCreateIsvRequest);
            }
        }
        return Response.ok(new PayCreateIsvRequest());
    }

    public static FileItem getPicFile(String path) {
        FileItem file;
        if (path.startsWith("http")) {
            try {
                String substringPath = path.substring(path.lastIndexOf(StringPool.SLASH, path.lastIndexOf(StringPool.SLASH) - 1));
                String patrol = "/opt/dows/tenant/image"+substringPath;
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
