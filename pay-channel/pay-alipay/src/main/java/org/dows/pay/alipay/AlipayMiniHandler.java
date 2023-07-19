package org.dows.pay.alipay;

import cn.hutool.core.bean.BeanUtil;
import com.alipay.api.AlipayApiException;
import com.alipay.api.FileItem;
import com.alipay.api.domain.*;
import com.alipay.api.request.*;
import com.alipay.api.response.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.dows.pay.api.PayRequest;
import org.dows.pay.api.annotation.PayMapping;
import org.dows.pay.api.enums.PayMethods;
import org.dows.pay.bo.AlipayBaseInfoBo;
import org.dows.pay.bo.AlipayOpenMiniVersionAuditBo;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

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
public class AlipayMiniHandler extends AbstractAlipayHandler {

    /**
     * 上传小程序模板
     * https://opendocs.alipay.com/mini/03l8bz
     * alipay.open.mini.version.upload(小程序基于模板上传版本)
     */
    @PayMapping(method = PayMethods.MINI_UPLOAD)
    public void uploadMini(PayRequest payRequest) {
        AlipayOpenMiniVersionUploadModel alipayOpenMiniVersionUploadModel = new AlipayOpenMiniVersionUploadModel();
        AlipayOpenMiniVersionUploadRequest request = new AlipayOpenMiniVersionUploadRequest();
        request.setBizModel(alipayOpenMiniVersionUploadModel);
        AlipayOpenMiniVersionUploadResponse response;
        try {
            response = getAlipayClient(payRequest.getAppId()).execute(request);
        } catch (AlipayApiException e) {
            throw new RuntimeException(e);
        }
        if (response.isSuccess()) {
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }
    }


    /**
     * 小程序提交审核
     * https://opendocs.alipay.com/mini/03l9bq
     * alipay.open.mini.version.audit.apply(小程序提交审核)
     */
    @PayMapping(method = PayMethods.MINI_APPLY)
    public void auditMini(PayRequest payRequest) {
        AlipayOpenMiniVersionAuditApplyRequest request = new AlipayOpenMiniVersionAuditApplyRequest();
        AlipayOpenMiniVersionAuditApplyResponse response;
        try {
            response = getAlipayClient(payRequest.getAppId()).execute(request);
        } catch (AlipayApiException e) {
            throw new RuntimeException(e);
        }
        if (response.isSuccess()) {
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }

    }


    /**
     * 小程序撤销审核
     * https://opendocs.alipay.com/mini/03l9br
     */
    @PayMapping(method = PayMethods.MINI_CANCEL)
    public void auditCancelMini(PayRequest payRequest) {
        AlipayOpenMiniVersionAuditCancelRequest request = new AlipayOpenMiniVersionAuditCancelRequest();
        AlipayOpenMiniVersionAuditCancelModel alipayOpenMiniVersionAuditCancelModel = new AlipayOpenMiniVersionAuditCancelModel();
        request.setBizModel(alipayOpenMiniVersionAuditCancelModel);
        AlipayOpenMiniVersionAuditCancelResponse response;
        try {
            response = getAlipayClient(payRequest.getAppId()).execute(request);
        } catch (AlipayApiException e) {
            throw new RuntimeException(e);
        }
        if (response.isSuccess()) {
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }

    }


    /**
     * 小程序上架
     * https://opendocs.alipay.com/mini/03l21p
     * alipay.open.mini.version.online(小程序上架)
     */
    @PayMapping(method = PayMethods.MINI_ONLINE)
    public void onlineMini(PayRequest payRequest) {
        AlipayOpenMiniVersionOnlineModel alipayOpenMiniVersionOnlineModel = new AlipayOpenMiniVersionOnlineModel();
        AlipayOpenMiniVersionOnlineRequest request = new AlipayOpenMiniVersionOnlineRequest();
        request.setBizModel(alipayOpenMiniVersionOnlineModel);
        AlipayOpenMiniVersionOnlineResponse response;
        try {
            response = getAlipayClient(payRequest.getAppId()).execute(request);
        } catch (AlipayApiException e) {
            throw new RuntimeException(e);
        }
        if (response.isSuccess()) {
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }
    }

    /**
     * 小程序上架
     * https://opendocs.alipay.com/mini/03l21p
     * alipay.open.mini.version.online(小程序上架)
     */
    @PayMapping(method = PayMethods.MINI_OFFLINE)
    public void offlineMini(PayRequest payRequest) {
        AlipayOpenMiniVersionOfflineModel alipayOpenMiniVersionOfflineModel = new AlipayOpenMiniVersionOfflineModel();
        AlipayOpenMiniVersionOfflineRequest request = new AlipayOpenMiniVersionOfflineRequest();
        request.setBizModel(alipayOpenMiniVersionOfflineModel);
        AlipayOpenMiniVersionOfflineResponse response;
        try {
            response = getAlipayClient(payRequest.getAppId()).execute(request);
        } catch (AlipayApiException e) {
            throw new RuntimeException(e);
        }
        if (response.isSuccess()) {
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }
    }

    /**
     * 小程序生成体验版
     * https://opendocs.alipay.com/mini/03l9bw
     */
    @PayMapping(method = PayMethods.MINI_CREATE)
    public void createMini(PayRequest payRequest) {
        AlipayOpenMiniExperienceCreateModel alipayOpenMiniExperienceCreateModel = new AlipayOpenMiniExperienceCreateModel();
        AlipayOpenMiniExperienceCreateRequest request = new AlipayOpenMiniExperienceCreateRequest();
        request.setBizModel(alipayOpenMiniExperienceCreateModel);
        AlipayOpenMiniExperienceCreateResponse response;
        try {
            response = getAlipayClient(payRequest.getAppId()).execute(request);
        } catch (AlipayApiException e) {
            throw new RuntimeException(e);
        }
        if (response.isSuccess()) {
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }
    }

    /**
     * 小程序修改基础信息
     * alipay.open.mini.baseinfo.modify(小程序修改基础信息)
     */
    @PayMapping(method = PayMethods.MINI_BASE_INFO_MODIFY)
    public AlipayOpenMiniBaseinfoModifyResponse miniBaseInfoModify(PayRequest payRequest) {
        AlipayOpenMiniInnerbaseinfoCreateModel alipayOpenMiniInnerbaseinfoCreateModel = new AlipayOpenMiniInnerbaseinfoCreateModel();
        // 自动
        autoMappingValue(payRequest, alipayOpenMiniInnerbaseinfoCreateModel);
        AlipayOpenMiniBaseinfoModifyRequest request = new AlipayOpenMiniBaseinfoModifyRequest();
        request.setBizModel(alipayOpenMiniInnerbaseinfoCreateModel);
        AlipayOpenMiniBaseinfoModifyResponse response;
        try {
            response = getAlipayClient(payRequest.getAppId()).certificateExecute(request);
            if (response.isSuccess()) {
                System.out.println("调用成功");
            } else {
                System.out.println("调用失败");
            }
            return response;
        } catch (AlipayApiException e) {
            throw new RuntimeException(e);
        }
    }


    @PayMapping(method = PayMethods.MINI_VERSION_AUDIT_APPLY)
    public AlipayOpenMiniVersionAuditApplyResponse miniVersionAuditApply(PayRequest payRequest) {
        // 自动
        AlipayOpenMiniVersionAuditApplyRequest request = new AlipayOpenMiniVersionAuditApplyRequest();
        AlipayOpenMiniVersionAuditBo alipayOpenMiniVersionAuditBo = (AlipayOpenMiniVersionAuditBo) payRequest.getBizModel();
        // 小程序版本号
        request.setAppVersion(alipayOpenMiniVersionAuditBo.getAppVersion() == null ? "1.0.0" : alipayOpenMiniVersionAuditBo.getAppVersion());
        // 小程序名称
        request.setAppName(alipayOpenMiniVersionAuditBo.getAppName());
        // 小程序版本描述
        request.setVersionDesc(alipayOpenMiniVersionAuditBo.getVersionDesc());
        // 小程序描述
        request.setAppDesc(alipayOpenMiniVersionAuditBo.getAppDesc());
        // 小程序应用简介
        request.setAppSlogan(alipayOpenMiniVersionAuditBo.getAppSlogan());
        // 小程序备注
        request.setMemo(alipayOpenMiniVersionAuditBo.getMemo());
        // 新小程序前台类目
        request.setMiniCategoryIds(alipayOpenMiniVersionAuditBo.getMiniCategoryIds());
        // 小程序投放的端参数
        request.setBundleId(alipayOpenMiniVersionAuditBo.getBundleId() == null ? "com.alipay.alipaywallet" : alipayOpenMiniVersionAuditBo.getBundleId());
        // 小程序客服电话
        request.setServicePhone(alipayOpenMiniVersionAuditBo.getServicePhone());
        // 小程序客服邮箱
        request.setServiceEmail(alipayOpenMiniVersionAuditBo.getServiceEmail());
        // 审核类型
        request.setAuditRule(alipayOpenMiniVersionAuditBo.getAuditRule() == null ? "BASE_PROMOTE" : alipayOpenMiniVersionAuditBo.getAuditRule());
        // 审核通过后是否自动上架
        request.setAutoOnline(alipayOpenMiniVersionAuditBo.getAutoOnline() == null ? "true" : alipayOpenMiniVersionAuditBo.getAutoOnline());
        // 是否使用审核加急权益加速审核
        request.setSpeedUp(alipayOpenMiniVersionAuditBo.getSpeedUp() == null ? "false" : alipayOpenMiniVersionAuditBo.getSpeedUp());
        // 小程序logo图标
        if (StringUtils.isNotEmpty(alipayOpenMiniVersionAuditBo.getAppLogo())) {
            FileItem appLogo = new FileItem(alipayOpenMiniVersionAuditBo.getAppLogo());
            request.setAppLogo(appLogo);
        }
        // 营业执照证件号
        request.setLicenseNo(alipayOpenMiniVersionAuditBo.getLicenseNo());
        // 营业执照名称
        request.setLicenseName(alipayOpenMiniVersionAuditBo.getLicenseName());
        // 营业执照有效期 默认永久
        request.setLicenseValidDate(alipayOpenMiniVersionAuditBo.getLicenseValidDate() == null ? "9999-12-31" :
                alipayOpenMiniVersionAuditBo.getLicenseValidDate());
        // 第一张营业执照照片
        if (StringUtils.isNotEmpty(alipayOpenMiniVersionAuditBo.getFirstLicensePic())) {
            FileItem imageContent = new FileItem(alipayOpenMiniVersionAuditBo.getFirstLicensePic());
            request.setFirstLicensePic(imageContent);
        }
        // 第二张营业执照照片
        if (StringUtils.isNotEmpty(alipayOpenMiniVersionAuditBo.getSecondLicensePic())) {
            FileItem secondLicensePic = new FileItem(alipayOpenMiniVersionAuditBo.getSecondLicensePic());
            request.setSecondLicensePic(secondLicensePic);
        }
        // 第三张营业执照照片
        if (StringUtils.isNotEmpty(alipayOpenMiniVersionAuditBo.getThirdLicensePic())) {
            FileItem thirdLicensePic = new FileItem(alipayOpenMiniVersionAuditBo.getThirdLicensePic());
            request.setThirdLicensePic(thirdLicensePic);
        }
        // 第四张营业执照照片
        if (StringUtils.isNotEmpty(alipayOpenMiniVersionAuditBo.getFourthLicensePic())) {
            FileItem fourthLicensePic = new FileItem(alipayOpenMiniVersionAuditBo.getFourthLicensePic());
            request.setFourthLicensePic(fourthLicensePic);
        }
        // 第五张营业执照照片
        if (StringUtils.isNotEmpty(alipayOpenMiniVersionAuditBo.getFifthLicensePic())) {
            FileItem fifthLicensePic = new FileItem(alipayOpenMiniVersionAuditBo.getFifthLicensePic());
            request.setFifthLicensePic(fifthLicensePic);
        }
        // 小程序第一张应用截图
        if (StringUtils.isNotEmpty(alipayOpenMiniVersionAuditBo.getFirstScreenShot())) {
            FileItem firstScreenShot = new FileItem(alipayOpenMiniVersionAuditBo.getFirstScreenShot());
            request.setFirstScreenShot(firstScreenShot);
        }
        // 小程序第二张应用截图
        if (StringUtils.isNotEmpty(alipayOpenMiniVersionAuditBo.getSecondScreenShot())) {
            FileItem secondScreenShot = new FileItem(alipayOpenMiniVersionAuditBo.getSecondScreenShot());
            request.setSecondScreenShot(secondScreenShot);
        }
        // 小程序第三张应用截图
        if (StringUtils.isNotEmpty(alipayOpenMiniVersionAuditBo.getThirdScreenShot())) {
            FileItem thirdScreenShot = new FileItem(alipayOpenMiniVersionAuditBo.getThirdScreenShot());
            request.setThirdScreenShot(thirdScreenShot);
        }
        // 小程序第四张应用截图
        if (StringUtils.isNotEmpty(alipayOpenMiniVersionAuditBo.getFourthScreenShot())) {
            FileItem fourthScreenShot = new FileItem(alipayOpenMiniVersionAuditBo.getFourthScreenShot());
            request.setFourthScreenShot(fourthScreenShot);
        }
        // 小程序第五张应用截图
        if (StringUtils.isNotEmpty(alipayOpenMiniVersionAuditBo.getFifthScreenShot())) {
            FileItem fifthScreenShot = new FileItem(alipayOpenMiniVersionAuditBo.getFifthScreenShot());
            request.setFifthScreenShot(fifthScreenShot);
        }
        // 门头照
        if (StringUtils.isNotEmpty(alipayOpenMiniVersionAuditBo.getOutDoorPic())) {
            FileItem outDoorPic = new FileItem(alipayOpenMiniVersionAuditBo.getOutDoorPic());
            request.setOutDoorPic(outDoorPic);
        }
//        List<RegionInfo> serviceRegionInfo = new ArrayList<RegionInfo>();
//        RegionInfo serviceRegionInfo0 = new RegionInfo();
//        serviceRegionInfo0.setProvinceName("浙江省");
//        serviceRegionInfo0.setAreaCode("311100");
//        serviceRegionInfo0.setCityCode("310000");
//        serviceRegionInfo0.setProvinceCode("310000");
//        serviceRegionInfo0.setAreaName("余杭区");
//        serviceRegionInfo0.setCityName("杭州市");
//        serviceRegionInfo.add(serviceRegionInfo0);
        // 小程序服务区域类型
        request.setRegionType(alipayOpenMiniVersionAuditBo.getRegionType() == null ? "CHINA" : alipayOpenMiniVersionAuditBo.getRegionType());
        // 省市区信息
        if (!CollectionUtils.isEmpty(alipayOpenMiniVersionAuditBo.getServiceRegionInfo())) {
            request.setServiceRegionInfo(alipayOpenMiniVersionAuditBo.getServiceRegionInfo());
        }
        // 第一张特殊资质图片
        if (StringUtils.isNotEmpty(alipayOpenMiniVersionAuditBo.getFirstSpecialLicensePic())) {
            FileItem firstSpecialLicensePic = new FileItem(alipayOpenMiniVersionAuditBo.getFirstSpecialLicensePic());
            request.setFirstSpecialLicensePic(firstSpecialLicensePic);
        }
        // 第二张特殊资质图片文件
        if (StringUtils.isNotEmpty(alipayOpenMiniVersionAuditBo.getSecondSpecialLicensePic())) {
            FileItem secondSpecialLicensePic = new FileItem(alipayOpenMiniVersionAuditBo.getSecondSpecialLicensePic());
            request.setSecondSpecialLicensePic(secondSpecialLicensePic);
        }
        // 第三张特殊资质图片文件
        if (StringUtils.isNotEmpty(alipayOpenMiniVersionAuditBo.getThirdSpecialLicensePic())) {
            FileItem thirdSpecialLicensePic = new FileItem(alipayOpenMiniVersionAuditBo.getThirdSpecialLicensePic());
            request.setThirdSpecialLicensePic(thirdSpecialLicensePic);
        }
        // 测试账号
        request.setTestAccout(alipayOpenMiniVersionAuditBo.getTestAccount());
        // 测试账号密码
        request.setTestPassword(alipayOpenMiniVersionAuditBo.getTestPassword());
        // 测试附件
        if (StringUtils.isNotEmpty(alipayOpenMiniVersionAuditBo.getTestFileName())) {
            FileItem testFileName = new FileItem(alipayOpenMiniVersionAuditBo.getTestFileName());
            request.setTestFileName(testFileName);
        }
        AlipayOpenMiniVersionAuditApplyResponse response;
        try {
            String authorizerAccessToken = payRequest.getAuthorizerAccessToken();
            response = getAlipayClient(payRequest.getAppId()).certificateExecute(request, null,
                    authorizerAccessToken);
            if (response.isSuccess()) {
                System.out.println("调用成功");
            } else {
                System.out.println("调用失败");
            }
            return response;
        } catch (AlipayApiException e) {
            throw new RuntimeException(e);
        }
    }
}
