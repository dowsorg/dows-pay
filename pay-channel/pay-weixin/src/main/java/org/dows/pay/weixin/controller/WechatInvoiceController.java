package org.dows.pay.weixin.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.framework.api.Response;
import org.dows.pay.weixin.WeixinPayHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/wechat/invoice")
@Slf4j
public class WechatInvoiceController {


    private final WeixinPayHandler weixinPayHandler;


    @GetMapping("/checkOpen")
    public Response checkSubMeOpenInvoice(String subMchCode) {
        return weixinPayHandler.checkSubMeOpenInvoice(subMchCode);
    }

    @GetMapping("/configDevelopOptions")
    public Response configDevelopOptions(String subMchCode) {
        return weixinPayHandler.configDevelopOptions(subMchCode);
    }


}
