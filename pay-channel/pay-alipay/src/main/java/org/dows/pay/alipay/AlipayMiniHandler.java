package org.dows.pay.alipay;

import cn.hutool.core.bean.BeanUtil;
import com.alipay.api.AlipayApiException;
import com.alipay.api.FileItem;
import com.alipay.api.domain.*;
import com.alipay.api.request.*;
import com.alipay.api.response.*;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
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

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
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
        AlipayOpenMiniVersionAuditApplyResponse response = null;
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
//            FileItem appLogo = new FileItem(alipayOpenMiniVersionAuditBo.getAppLogo());
            String imageBase64 = "iVBORw0KGgoAAAANSUhEUgAAAAoAAAAKCAYAAACNMs+9AAAAEUlEQVR42mP4TyRgGFVIX4UAI/uOgGWVNeQAAAAASUVORK5CYII=";
            // 下列FileItem中也可用直接读取本地文件的方式来获取文件
            // FileItem imageContent = new FileItem("本地文件的绝对路径");
            FileItem appLogo = new FileItem("appLogo.jpg", Base64.getDecoder().decode(imageBase64));
            request.setAppLogo(appLogo);
//            File appLogoFile = getFile(alipayOpenMiniVersionAuditBo.getAppLogo());
//            FileItem imageContent = new FileItem(appLogoFile.getPath());
//            request.setAppLogo(imageContent);
        }
        // 营业执照证件号
        request.setLicenseNo(alipayOpenMiniVersionAuditBo.getLicenseNo());
        // 营业执照名称
        request.setLicenseName(alipayOpenMiniVersionAuditBo.getLicenseName());
        // 营业执照有效期 默认永久
        request.setLicenseValidDate(alipayOpenMiniVersionAuditBo.getLicenseValidDate() == null ? "9999-12-31" :
                alipayOpenMiniVersionAuditBo.getLicenseValidDate());

        List<FileItem> licensePics = new ArrayList<>();

        // 第一张营业执照照片
        if (StringUtils.isNotEmpty(alipayOpenMiniVersionAuditBo.getFirstLicensePic())) {
            String firstLicensePicUrls = alipayOpenMiniVersionAuditBo.getFirstLicensePic();
            List<String> firstLicensePicList = Arrays.asList(firstLicensePicUrls.split(","));
            if (!CollectionUtils.isEmpty(firstLicensePicList)) {
                for (int i = 0; i < firstLicensePicList.size() && i < 5; i++) {
                    File uboIdDocCopyFile = getFile(firstLicensePicList.get(i));
                    FileItem imageContent = new FileItem(uboIdDocCopyFile.getPath());
                    licensePics.add(imageContent);
                }
                if (!licensePics.isEmpty()) {
                    request.setFirstLicensePic(licensePics.get(0));
                    if (licensePics.size() > 1) {
                        request.setSecondLicensePic(licensePics.get(1));
                    }
                    if (licensePics.size() > 2) {
                        request.setThirdLicensePic(licensePics.get(2));
                    }
                    if (licensePics.size() > 3) {
                        request.setFourthLicensePic(licensePics.get(3));
                    }
                    if (licensePics.size() > 4) {
                        request.setFifthLicensePic(licensePics.get(4));
                    }
                }
            }
        }
//        // 第二张营业执照照片
//        if (StringUtils.isNotEmpty(alipayOpenMiniVersionAuditBo.getSecondLicensePic())) {
//            FileItem secondLicensePic = new FileItem(alipayOpenMiniVersionAuditBo.getSecondLicensePic());
//            request.setSecondLicensePic(secondLicensePic);
//        }
//        // 第三张营业执照照片
//        if (StringUtils.isNotEmpty(alipayOpenMiniVersionAuditBo.getThirdLicensePic())) {
//            FileItem thirdLicensePic = new FileItem(alipayOpenMiniVersionAuditBo.getThirdLicensePic());
//            request.setThirdLicensePic(thirdLicensePic);
//        }
//        // 第四张营业执照照片
//        if (StringUtils.isNotEmpty(alipayOpenMiniVersionAuditBo.getFourthLicensePic())) {
//            FileItem fourthLicensePic = new FileItem(alipayOpenMiniVersionAuditBo.getFourthLicensePic());
//            request.setFourthLicensePic(fourthLicensePic);
//        }
//        // 第五张营业执照照片
//        if (StringUtils.isNotEmpty(alipayOpenMiniVersionAuditBo.getFifthLicensePic())) {
//            FileItem fifthLicensePic = new FileItem(alipayOpenMiniVersionAuditBo.getFifthLicensePic());
//            request.setFifthLicensePic(fifthLicensePic);
//        }
        // 小程序第一张应用截图
        if (StringUtils.isNotEmpty(alipayOpenMiniVersionAuditBo.getFirstScreenShot())) {
            String firstScreenShotUrls = alipayOpenMiniVersionAuditBo.getFirstScreenShot();
            List<String> firstScreenShotList = Arrays.asList(firstScreenShotUrls.split(","));
            if (!CollectionUtils.isEmpty(firstScreenShotList)) {
                licensePics.clear();
                for (int i = 0; i < firstScreenShotList.size() && i < 5; i++) {
                    File uboIdDocCopyFile = getFile(firstScreenShotList.get(i));
                    FileItem imageContent = new FileItem(uboIdDocCopyFile.getPath());
                    licensePics.add(imageContent);
                }
                if (!licensePics.isEmpty()) {
                    request.setFirstScreenShot(licensePics.get(0));
                    if (licensePics.size() > 1) {
                        request.setSecondScreenShot(licensePics.get(1));
                    }
                    if (licensePics.size() > 2) {
                        request.setThirdScreenShot(licensePics.get(2));
                    }
                    if (licensePics.size() > 3) {
                        request.setFourthScreenShot(licensePics.get(3));
                    }
                    if (licensePics.size() > 4) {
                        request.setFifthScreenShot(licensePics.get(4));
                    }
                }
            }
        }
//        // 小程序第二张应用截图
//        if (StringUtils.isNotEmpty(alipayOpenMiniVersionAuditBo.getSecondScreenShot())) {
//            FileItem secondScreenShot = new FileItem(alipayOpenMiniVersionAuditBo.getSecondScreenShot());
//            request.setSecondScreenShot(secondScreenShot);
//        }
//        // 小程序第三张应用截图
//        if (StringUtils.isNotEmpty(alipayOpenMiniVersionAuditBo.getThirdScreenShot())) {
//            FileItem thirdScreenShot = new FileItem(alipayOpenMiniVersionAuditBo.getThirdScreenShot());
//            request.setThirdScreenShot(thirdScreenShot);
//        }
//        // 小程序第四张应用截图
//        if (StringUtils.isNotEmpty(alipayOpenMiniVersionAuditBo.getFourthScreenShot())) {
//            FileItem fourthScreenShot = new FileItem(alipayOpenMiniVersionAuditBo.getFourthScreenShot());
//            request.setFourthScreenShot(fourthScreenShot);
//        }
//        // 小程序第五张应用截图
//        if (StringUtils.isNotEmpty(alipayOpenMiniVersionAuditBo.getFifthScreenShot())) {
//            FileItem fifthScreenShot = new FileItem(alipayOpenMiniVersionAuditBo.getFifthScreenShot());
//            request.setFifthScreenShot(fifthScreenShot);
//        }
        // 门头照
        if (StringUtils.isNotEmpty(alipayOpenMiniVersionAuditBo.getOutDoorPic())) {
            File outDoorPicFile = getFile(alipayOpenMiniVersionAuditBo.getOutDoorPic());
            FileItem outDoorPic = new FileItem(outDoorPicFile.getPath());
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
            String firstSpecialLicensePicUrls = alipayOpenMiniVersionAuditBo.getFirstSpecialLicensePic();
            List<String> firstSpecialLicenseList = Arrays.asList(firstSpecialLicensePicUrls.split(","));
            if (!CollectionUtils.isEmpty(firstSpecialLicenseList)) {
                licensePics.clear();
                for (int i = 0; i < firstSpecialLicenseList.size() && i < 5; i++) {
                    File uboIdDocCopyFile = getFile(firstSpecialLicenseList.get(i));
                    FileItem imageContent = new FileItem(uboIdDocCopyFile.getPath());
                    licensePics.add(imageContent);
                }
                if (!licensePics.isEmpty()) {
                    request.setFirstSpecialLicensePic(licensePics.get(0));
                    if (licensePics.size() > 1) {
                        request.setSecondSpecialLicensePic(licensePics.get(1));
                    }
                    if (licensePics.size() > 2) {
                        request.setThirdSpecialLicensePic(licensePics.get(2));
                    }
                }
            }
//        // 第二张特殊资质图片文件
//        if (StringUtils.isNotEmpty(alipayOpenMiniVersionAuditBo.getSecondSpecialLicensePic())) {
//            FileItem secondSpecialLicensePic = new FileItem(alipayOpenMiniVersionAuditBo.getSecondSpecialLicensePic());
//            request.setSecondSpecialLicensePic(secondSpecialLicensePic);
//        }
//        // 第三张特殊资质图片文件
//        if (StringUtils.isNotEmpty(alipayOpenMiniVersionAuditBo.getThirdSpecialLicensePic())) {
//            FileItem thirdSpecialLicensePic = new FileItem(alipayOpenMiniVersionAuditBo.getThirdSpecialLicensePic());
//            request.setThirdSpecialLicensePic(thirdSpecialLicensePic);
//        }
            // 测试账号
            request.setTestAccout(alipayOpenMiniVersionAuditBo.getTestAccount());
            // 测试账号密码
            request.setTestPassword(alipayOpenMiniVersionAuditBo.getTestPassword());
            // 测试附件
            if (StringUtils.isNotEmpty(alipayOpenMiniVersionAuditBo.getTestFileName())) {
                File testFileName = getFile(alipayOpenMiniVersionAuditBo.getTestFileName());
                FileItem testFileItem = new FileItem(testFileName.getPath());
                request.setTestFileName(testFileItem);
            }
            try {
                String authorizerAccessToken = payRequest.getAuthorizerAccessToken();
                log.info("请求小程序审核入参：{}", request);
                response = getAlipayClient(payRequest.getAppId()).certificateExecute(request, null,
                        authorizerAccessToken);
                log.info("请求小程序审核出参：{}", response);
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
        return response;
    }

    public static File getFile(String path) {
        File file = null;
        if (path.startsWith("http")) {
            String substringPath = path.substring(path.lastIndexOf(StringPool.SLASH, path.lastIndexOf(StringPool.SLASH) - 1));
            return new File("/opt/dows/tenant/image" + substringPath);
//            String replacePath = path.replaceAll("https:/", "https://");
//            log.info("replacePath===={}",replacePath);
//            URL url;
//            try {
//                url = new URL(replacePath);
//                String tempPath = path.substring(path.lastIndexOf('/'));
//                File mediaFile = new File("/opt/dows/tenant/image" + tempPath);
//                FileUtils.copyURLToFile(url, mediaFile);
//            } catch (Exception e) {
//                System.out.println("url convert error:" + e);
//                log.error("url convert error:", e);
//            }
        } else {
            String filePath = getFilePath(path);
            file = new File(filePath);
            return file;
        }

    }


    public static String getFilePath(String path) {
//        String arrPath[] = path.split(DateUtil.formatDate(DateUtil.date()));
//        if (ObjectUtil.isNotEmpty(arrPath) && arrPath.length > 1) {
//            path = arrPath[1];
//        }
        String jPath = "/opt/dows/tenant" + path;
        log.info("图片绝对路径 ：{}", jPath);
        return jPath;
    }
}
