/**
 * @ProjectName:zhyt_contract
 * @PackageName:com.zhyt.contract.controller
 * @Description: 地址管理业务请求分发
 *
 * @author gaozh
 * @Date: 2022年11月10日
 *
 * @Company: crudoil
 * @Copyright: Copyright (c) 2021-2050
 */
package org.dows.pay.weixin.controller;


import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONObject;
import com.github.binarywang.wxpay.bean.ecommerce.*;
import com.github.binarywang.wxpay.bean.profitsharingV3.ProfitSharingNotifyData;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.v3.util.AesUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.util.crypto.SHA1;
import me.chanjar.weixin.common.util.crypto.WxCryptUtil;
import me.chanjar.weixin.open.api.WxOpenService;
import me.chanjar.weixin.open.bean.message.WxOpenXmlMessage;
import org.apache.commons.io.IOUtils;
import org.dows.pay.api.util.HttpRequestUtils;
import org.dows.pay.boot.PayClientFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.Objects;

/**
 * @ClassName: WeixinPayNotifyController
 * @Description: 微信支付回调
 *
 * @Date 2022年11月10日
 * @author tqhuang
 */
@RestController
@RequestMapping("/nztest")
@RequiredArgsConstructor
@Slf4j
public class WeixinPayNotifyController

{
    @Autowired
    private PayClientFactory payClientFactory;

    private static final Gson GSON = (new GsonBuilder()).create();

    private static final ThreadLocal<DocumentBuilder> BUILDER_LOCAL ;
    static {
        BUILDER_LOCAL = ThreadLocal.withInitial(() -> {
            try {
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                factory.setExpandEntityReferences(false);
                factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
                return factory.newDocumentBuilder();
            } catch (ParserConfigurationException var1) {
                throw new IllegalArgumentException(var1);
            }
        });
    }


    /**
     * 微信支付回调
     *
     * @author tqhuang
     * @Date 2022年11月10日
     */

    @PostMapping("/payNotify")
    public PartnerTransactionsNotifyResult wxPayNotify(HttpServletRequest request, HttpServletResponse response) throws WxPayException {
        String notifyData = HttpRequestUtils.getRequestParam(request).toString();
        String requestHeader = request.getHeader("WECHAT_PAY_SIGNATURE");
        SignatureHeader header = JSONObject.parseObject(requestHeader,SignatureHeader.class);
        if (Objects.nonNull(header) && !this.verifyNotifySign(header, notifyData)) {
            throw new WxPayException("非法请求，头部信息验证失败");
        } else {
            NotifyResponse notifyResponse = (NotifyResponse)GSON.fromJson(notifyData, NotifyResponse.class);
            NotifyResponse.Resource resource = notifyResponse.getResource();
            String cipherText = resource.getCiphertext();
            String associatedData = resource.getAssociatedData();
            String nonce = resource.getNonce();
            String apiV3Key = this.payClientFactory.getWeixinClient(notifyResponse.getId()).getConfig().getApiV3Key();

            try {
                String result = AesUtils.decryptToString(associatedData, nonce, cipherText, apiV3Key);
                PartnerTransactionsResult transactionsResult = (PartnerTransactionsResult)GSON.fromJson(result, PartnerTransactionsResult.class);
                PartnerTransactionsNotifyResult notifyResult = new PartnerTransactionsNotifyResult();
                notifyResult.setRawData(notifyResponse);
                notifyResult.setResult(transactionsResult);
                return notifyResult;
            } catch (IOException | GeneralSecurityException var12) {
                throw new WxPayException("解析报文异常！", var12);
            }
        }

    }
    private boolean verifyNotifySign(SignatureHeader header, String data) {
        String beforeSign = String.format("%s\n%s\n%s\n", header.getTimeStamp(), header.getNonce(), data);
        NotifyResponse notifyResponse = (NotifyResponse)GSON.fromJson(data, NotifyResponse.class);
        return this.payClientFactory.getWeixinClient(notifyResponse.getId()).getConfig().getVerifier().verify(header.getSerialNo(), beforeSign.getBytes(StandardCharsets.UTF_8), header.getSigned());
    }

    /**
     * 微信退款回调
     *
     * @author tqhuang
     * @Date 2022年11月10日
     */

    @PostMapping("/refundNotify")
    public RefundNotifyResult wxPayRefundNotify(HttpServletRequest request, HttpServletResponse response) throws WxPayException {
        String notifyData = HttpRequestUtils.getRequestParam(request).toString();
        String requestHeader = request.getHeader("WECHAT_PAY_SIGNATURE");
        SignatureHeader header = JSONObject.parseObject(requestHeader,SignatureHeader.class);

        if (Objects.nonNull(header) && !this.verifyNotifySign(header, notifyData)) {
            throw new WxPayException("非法请求，头部信息验证失败");
        } else {
            NotifyResponse notifyResponse = (NotifyResponse)GSON.fromJson(notifyData, NotifyResponse.class);
            NotifyResponse.Resource resource = notifyResponse.getResource();
            String cipherText = resource.getCiphertext();
            String associatedData = resource.getAssociatedData();
            String nonce = resource.getNonce();
            String apiV3Key =  this.payClientFactory.getWeixinClient(notifyResponse.getId()).getConfig().getApiV3Key();

            try {
                String result = AesUtils.decryptToString(associatedData, nonce, cipherText, apiV3Key);
                RefundNotifyResult notifyResult = (RefundNotifyResult)GSON.fromJson(result, RefundNotifyResult.class);
                notifyResult.setRawData(notifyResponse);
                return notifyResult;
            } catch (IOException | GeneralSecurityException var11) {
                throw new WxPayException("解析报文异常！", var11);
            }
        }
    }

    /**
     * 微信分账动账通知
     *
     * @author tqhuang
     * @Date 2022年11月10日
     */

    @PostMapping("/profitSharingNotify")
    public ProfitSharingNotifyData wxPaySharingNotify(HttpServletRequest request, HttpServletResponse response)
    {
        ProfitSharingNotifyData profitSharingNotifyData = null;
        String notifyData = HttpRequestUtils.getRequestParam(request).toString();
        NotifyResponse notifyResponse = (NotifyResponse)GSON.fromJson(notifyData, NotifyResponse.class);
        String requestHeader = request.getHeader("WECHAT_PAY_SIGNATURE");
        SignatureHeader header = JSONObject.parseObject(requestHeader,SignatureHeader.class);
        try{
            profitSharingNotifyData =  this.payClientFactory.getWeixinClient(notifyResponse.getId()).getProfitSharingV3Service().getProfitSharingNotifyData(notifyData,header);
        }catch (WxPayException e) {
            e.printStackTrace();
        }
        return profitSharingNotifyData;
    }

    /**
     * 服务商代商户申请小程序通知（授权事件接收）
     * @author tqhuang
     * @Date 2022年11月10日
     */

    @PostMapping("/wtr/wechat/message_event{$APPID}")
    public String wxAuthNotify(@RequestBody WxOpenXmlMessage wxMessage)
    {
        String route = "";
        try {
             route = this.payClientFactory.getWxOpenClient(wxMessage.getAppId()).getWxOpenComponentService().route(wxMessage);
        }catch (WxErrorException e) {
            e.printStackTrace();
        }
        return route;
    }

    /**
     * 授权URL信息接收
     * @author tqhuang
     * @Date 2022年11月10日
     */

    @PostMapping("/wtr/wechat/auth_event")
    public String wxAuthUrlNotify( HttpServletRequest request,HttpServletResponse response)
    {
        String route = "";
        try (InputStream inputStream = request.getInputStream()){
            String xml = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            WxOpenXmlMessage wxMessage = WxOpenXmlMessage.fromXml(xml);
            WxOpenService wxOpenClient = this.payClientFactory.getWxOpenClient(wxMessage.getAppId());
            DocumentBuilder db = (DocumentBuilder)BUILDER_LOCAL.get();
            Document document = db.parse(new InputSource(new StringReader(xml)));
            Element root = document.getDocumentElement();
            String cipherText = root.getElementsByTagName("Encrypt").item(0).getTextContent();
            //todo 微信服务器不推签的时候自己加
            String temp = String.valueOf(System.currentTimeMillis());
            String signature = SHA1.gen(new String[]{wxOpenClient.getWxOpenConfigStorage().getComponentToken(), temp, "xxxx", cipherText});
            wxMessage =  WxOpenXmlMessage.fromEncryptedXml
                    (xml,wxOpenClient.getWxOpenConfigStorage(), temp,"xxxx",signature);
            route = wxOpenClient.getWxOpenComponentService().route(wxMessage);
        }catch (WxErrorException | IOException | SAXException e) {
            e.printStackTrace();
        }
        return route;
    }
}
