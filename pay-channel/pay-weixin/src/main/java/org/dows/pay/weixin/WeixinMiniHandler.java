package org.dows.pay.weixin;

import com.alipay.api.AlipayApiException;
import com.alipay.api.domain.AlipayOpenMiniVersionOnlineModel;
import com.alipay.api.domain.AlipayOpenMiniVersionUploadModel;
import com.alipay.api.request.AlipayOpenMiniVersionAuditApplyRequest;
import com.alipay.api.request.AlipayOpenMiniVersionOnlineRequest;
import com.alipay.api.request.AlipayOpenMiniVersionUploadRequest;
import com.alipay.api.response.AlipayOpenMiniVersionOnlineResponse;
import com.alipay.api.response.AlipayOpenMiniVersionUploadResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 小程序相关业务功能
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class WeixinMiniHandler extends AbstractWeixinHandler {

    /**
     * 上传小程序模板
     * https://opendocs.alipay.com/mini/03l8bz
     * alipay.open.mini.version.upload(小程序基于模板上传版本)
     */
    public void upoadMini() {

        AlipayOpenMiniVersionUploadModel alipayOpenMiniVersionUploadModel = new AlipayOpenMiniVersionUploadModel();
        AlipayOpenMiniVersionUploadRequest request = new AlipayOpenMiniVersionUploadRequest();
        request.setBizModel(alipayOpenMiniVersionUploadModel);
        try {
            AlipayOpenMiniVersionUploadResponse response = getWeixinClient("").execute(request);
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
    public void onlineMini() {

        AlipayOpenMiniVersionOnlineModel alipayOpenMiniVersionOnlineModel = new AlipayOpenMiniVersionOnlineModel();
        AlipayOpenMiniVersionOnlineRequest request = new AlipayOpenMiniVersionOnlineRequest();
        request.setBizModel(alipayOpenMiniVersionOnlineModel);

        AlipayOpenMiniVersionOnlineResponse response = null;
        try {
            response = getWeixinClient("").execute(request);
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
