package org.dows.pay.alipay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.domain.*;
import com.alipay.api.request.*;
import com.alipay.api.response.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.pay.api.PayRequest;
import org.dows.pay.api.annotation.PayMapping;
import org.dows.pay.api.enums.PayMethods;
import org.springframework.stereotype.Service;

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

}
