package org.dows.pay.alipay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.domain.AlipayOpenMiniVersionOnlineModel;
import com.alipay.api.domain.AlipayOpenMiniVersionUploadModel;
import com.alipay.api.request.*;
import com.alipay.api.response.AlipayOpenMiniVersionOnlineResponse;
import com.alipay.api.response.AlipayOpenMiniVersionUploadResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.pay.api.PayHandler;
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
public class AlipayMiniHandler  extends AbstractAlipayHandler  {

    private final AlipayClient alipayClient;
    private final AlipayClient certAlipayClient;


    /**
     * 上传小程序模板
     * https://opendocs.alipay.com/mini/03l8bz
     * alipay.open.mini.version.upload(小程序基于模板上传版本)
     */
    public void upoadMini(AlipayOpenMiniVersionUploadModel alipayOpenMiniVersionUploadModel) {
        AlipayOpenMiniVersionUploadRequest request = new AlipayOpenMiniVersionUploadRequest();
        request.setBizModel(alipayOpenMiniVersionUploadModel);
        try {
            AlipayOpenMiniVersionUploadResponse response = alipayClient.execute(request);
            if (response.isSuccess()) {
                System.out.println("调用成功");
            } else {
                System.out.println("调用失败");
            }
        } catch (AlipayApiException e) {
            throw new RuntimeException(e);
        }

    }


    /**
     * 小程序提交审核
     * https://opendocs.alipay.com/mini/03l9bq
     * alipay.open.mini.version.audit.apply(小程序提交审核)
     */
    public void auditMini() {
        AlipayOpenMiniVersionAuditApplyRequest request = new AlipayOpenMiniVersionAuditApplyRequest();
        request.setServiceEmail("example@mail.com");

    }


    /**
     * 小程序上架
     * https://opendocs.alipay.com/mini/03l21p
     * alipay.open.mini.version.online(小程序上架)
     */
    public void onlineMini(AlipayOpenMiniVersionOnlineModel alipayOpenMiniVersionOnlineModel) {
        AlipayOpenMiniVersionOnlineRequest request = new AlipayOpenMiniVersionOnlineRequest();
        request.setBizModel(alipayOpenMiniVersionOnlineModel);

        AlipayOpenMiniVersionOnlineResponse response = null;
        try {
            response = alipayClient.execute(request);
        } catch (AlipayApiException e) {
            throw new RuntimeException(e);
        }
        if (response.isSuccess()) {
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }
    }


}
