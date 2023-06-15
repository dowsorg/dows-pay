/**
 * @ProjectName:zhyt_contract
 * @PackageName:com.zhyt.contract.controller
 * @Description: 地址管理业务请求分发
 * @author gaozh
 * @Date: 2022年11月10日
 * @Company: crudoil
 * @Copyright: Copyright (c) 2021-2050
 */
package org.dows.pay.weixin.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.kms.aliyun.utils.StringUtils;
import com.github.binarywang.wxpay.bean.ecommerce.*;
import com.github.binarywang.wxpay.bean.notify.CombineNotifyResult;
import com.github.binarywang.wxpay.bean.profitsharingV3.ProfitSharingNotifyData;
import com.github.binarywang.wxpay.bean.request.WxPayOrderQueryV3Request;
import com.github.binarywang.wxpay.bean.result.WxPayOrderQueryV3Result;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.v3.util.AesUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.open.api.WxOpenService;
import me.chanjar.weixin.open.bean.message.WxOpenXmlMessage;
import org.apache.commons.io.IOUtils;
import org.dows.account.api.AccountTenantApi;
import org.dows.account.api.AccountUserApi;
import org.dows.account.bo.AccountTenantBo;
import org.dows.account.bo.AccountUserBo;
import org.dows.account.vo.AccountTenantVo;
import org.dows.account.vo.AccountUserVo;
import org.dows.app.api.mini.AppLicenseApi;
import org.dows.app.api.mini.request.AppLicenseRequest;
import org.dows.framework.api.Response;
import org.dows.order.api.OrderInstanceBizApiService;
import org.dows.order.bo.OrderInstanceBo;
import org.dows.order.bo.OrderUpdatePaymentStatusBo;
import org.dows.order.enums.OrderPayTypeEnum;
import org.dows.pay.api.util.HttpRequestUtils;
import org.dows.pay.boot.PayClientFactory;
import org.dows.pay.service.PayTransactionService;
import org.dows.store.api.StoreInstanceApi;
import org.dows.store.api.request.StoreInstanceRequest;
import org.dows.user.api.api.UserCompanyApi;
import org.dows.user.api.dto.UserCompanyDTO;
import org.dows.user.api.vo.UserCompanyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.Date;
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
public class WeixinPayNotifyController {
    @Autowired
    private PayClientFactory payClientFactory;

    private static final Gson GSON = (new GsonBuilder()).create();

    private static final ThreadLocal<DocumentBuilder> BUILDER_LOCAL;

    private final UserCompanyApi userCompanyApi;

    private final AccountUserApi acountUserApi;

    private final AccountTenantApi acountTenantApi;

    private final AppLicenseApi appLicenseApi;

    private final OrderInstanceBizApiService orderInstanceBizApiService;

    private final StoreInstanceApi storeInstanceApi;

    private final PayTransactionService payTransactionService;


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
        log.info("wxPayNotify start......");
        String notifyData = HttpRequestUtils.getRequestParam(request).toString();
        String requestHeader = request.getHeader("WECHAT_PAY_SIGNATURE");
        SignatureHeader header = JSONObject.parseObject(requestHeader, SignatureHeader.class);
        if (Objects.nonNull(header) && !this.verifyNotifySign(header, notifyData)) {
            throw new WxPayException("非法请求，头部信息验证失败");
        } else {
            NotifyResponse notifyResponse = (NotifyResponse) GSON.fromJson(notifyData, NotifyResponse.class);
            NotifyResponse.Resource resource = notifyResponse.getResource();
            String cipherText = resource.getCiphertext();
            String associatedData = resource.getAssociatedData();
            String nonce = resource.getNonce();
            String apiV3Key = this.payClientFactory.getWeixinClient("wxdb8634feb22a5ab9").getConfig().getApiV3Key();

            try {
                String result = AesUtils.decryptToString(associatedData, nonce, cipherText, apiV3Key);
                PartnerTransactionsResult transactionsResult = (PartnerTransactionsResult) GSON.fromJson(result, PartnerTransactionsResult.class);
                log.info("wx pay notify result is {}", JSON.toJSONString(result));
                PartnerTransactionsNotifyResult notifyResult = new PartnerTransactionsNotifyResult();
                if (Objects.equals(transactionsResult.getTradeState(),"SUCCESS")) {
                    notifyResult.setRawData(notifyResponse);
                    notifyResult.setResult(transactionsResult);
                    OrderUpdatePaymentStatusBo instanceBo = new OrderUpdatePaymentStatusBo();
                    instanceBo.setTradeStatus(3);
                    instanceBo.setPayChannel(1);
                    instanceBo.setTradeType(1);
                    instanceBo.setOrderId(transactionsResult.getOutTradeNo());
                    orderInstanceBizApiService.updateOrderInstance(instanceBo);
                    payTransactionService.updateStatusByOrderId(transactionsResult.getOutTradeNo(),OrderPayTypeEnum.pay_finish.getCode());
                }
                return notifyResult;
            } catch (IOException | GeneralSecurityException var12) {
                throw new WxPayException("解析报文异常！", var12);
            }
        }

    }

    /**
     * 微信支付合单回调
     *
     * @author tqhuang
     * @Date 2022年11月10日
     */

    @PostMapping("/payCombineNotify")
    public CombineNotifyResult wxPayComBineNotify(HttpServletRequest request, HttpServletResponse response) throws WxPayException {
        String notifyData = HttpRequestUtils.getRequestParam(request).toString();
        String requestHeader = request.getHeader("WECHAT_PAY_SIGNATURE");
        SignatureHeader header = JSONObject.parseObject(requestHeader, SignatureHeader.class);
        if (Objects.nonNull(header) && !this.verifyNotifySign(header, notifyData)) {
            throw new WxPayException("非法请求，头部信息验证失败");
        } else {
            NotifyResponse notifyResponse = (NotifyResponse) GSON.fromJson(notifyData, NotifyResponse.class);
            NotifyResponse.Resource resource = notifyResponse.getResource();
            String cipherText = resource.getCiphertext();
            String associatedData = resource.getAssociatedData();
            String nonce = resource.getNonce();
            String apiV3Key = this.payClientFactory.getWeixinClient(notifyResponse.getId()).getConfig().getApiV3Key();

            try {
                String result = AesUtils.decryptToString(associatedData, nonce, cipherText, apiV3Key);
                CombineNotifyResult transactionsResult = (CombineNotifyResult) GSON.fromJson(result, CombineNotifyResult.class);
                return transactionsResult;
            } catch (IOException | GeneralSecurityException var12) {
                throw new WxPayException("解析报文异常！", var12);
            }
        }

    }

    private boolean verifyNotifySign(SignatureHeader header, String data) {
        String beforeSign = String.format("%s\n%s\n%s\n", header.getTimeStamp(), header.getNonce(), data);
        NotifyResponse notifyResponse = (NotifyResponse) GSON.fromJson(data, NotifyResponse.class);
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
        SignatureHeader header = JSONObject.parseObject(requestHeader, SignatureHeader.class);

        if (Objects.nonNull(header) && !this.verifyNotifySign(header, notifyData)) {
            throw new WxPayException("非法请求，头部信息验证失败");
        } else {
            NotifyResponse notifyResponse = (NotifyResponse) GSON.fromJson(notifyData, NotifyResponse.class);
            NotifyResponse.Resource resource = notifyResponse.getResource();
            String cipherText = resource.getCiphertext();
            String associatedData = resource.getAssociatedData();
            String nonce = resource.getNonce();
            String apiV3Key = this.payClientFactory.getWeixinClient(notifyResponse.getId()).getConfig().getApiV3Key();

            try {
                String result = AesUtils.decryptToString(associatedData, nonce, cipherText, apiV3Key);
                RefundNotifyResult notifyResult = (RefundNotifyResult) GSON.fromJson(result, RefundNotifyResult.class);
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
    public ProfitSharingNotifyData wxPaySharingNotify(HttpServletRequest request, HttpServletResponse response) {
        ProfitSharingNotifyData profitSharingNotifyData = null;
        String notifyData = HttpRequestUtils.getRequestParam(request).toString();
        NotifyResponse notifyResponse = (NotifyResponse) GSON.fromJson(notifyData, NotifyResponse.class);
        String requestHeader = request.getHeader("WECHAT_PAY_SIGNATURE");
        SignatureHeader header = JSONObject.parseObject(requestHeader, SignatureHeader.class);
        try {
            profitSharingNotifyData = this.payClientFactory.getWeixinClient(notifyResponse.getId()).getProfitSharingV3Service().getProfitSharingNotifyData(notifyData, header);
        } catch (WxPayException e) {
            e.printStackTrace();
        }
        return profitSharingNotifyData;
    }

    /**
     * 服务商代商户申请小程序通知（授权事件接收）
     *
     * @author tqhuang
     * @Date 2022年11月10日
     */

    @PostMapping("/wtr/wechat/message_event/{$APPID}")
    public String wxAuthNotify(@PathVariable("APPID") String APPID,
                               @RequestBody String format,
                               @RequestParam String signature,
                               @RequestParam String timestamp,
                               @RequestParam String nonce,
                               @RequestParam String encrypt_type,
                               @RequestParam String msg_signature) {
        log.info("收到事件回调通知APPID{}, format{}，signature{}，timestamp{}，nonce{}，encrypt_type{}，msg_signature{}",
                APPID, format, signature, timestamp, nonce, encrypt_type, msg_signature
        );
        String route = "";
        try {
            WxOpenXmlMessage wxMessage = new WxOpenXmlMessage();
            wxMessage.setAppId(APPID);
            route = this.payClientFactory.getWxOpenClient(APPID).getWxOpenComponentService().route(wxMessage);

        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return route;
    }

    /**
     * 授权URL信息接收
     *
     * @author tqhuang
     * @Date 2022年11月10日
     */

    /*@PostMapping("/wtr/wechat/auth_event")
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
    }*/
    @PostMapping("/wtr/wechat/auth_event")
    public String wxAuthUrlNotify(HttpServletRequest request, String signature, String timestamp,
                                  String nonce, String encrypt_type, String msg_signature,
                                  String auth_code, String AuthorizerAppid, String AuthorizationCode) {

        try (InputStream inputStream = request.getInputStream()) {
            String xml = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            if (!StringUtils.isEmpty(auth_code)) {
                log.info("接收票据信息 预授权码独立信息");
                return "success";
            }
            log.info("接收票据事件密文：" + xml);
            WxOpenXmlMessage wxMessage = WxOpenXmlMessage.fromXml(xml);
            WxOpenService wxOpenClient = this.payClientFactory.getWxOpenClient(wxMessage.getAppId());
            wxMessage = WxOpenXmlMessage.fromEncryptedXml(xml, wxOpenClient.getWxOpenConfigStorage(), timestamp, nonce, msg_signature);
            log.info("收到授权事件推送通知: {} ", wxMessage.toString());

            //更新数据库以及变量
            if (wxMessage.getInfoType() == null) {
                log.info("未知事件类型，过滤");
                return "success";
            }
            String InfoType = wxMessage.getInfoType();
            if (InfoType.equals("component_verify_ticket")) {
                String componentVerifyTicket = wxMessage.getComponentVerifyTicket();
                Long createTime = wxMessage.getCreateTime();
                log.info("收到授权事件：验证票据通知 ComponentVerifyTicket=" + componentVerifyTicket);

                if (!StringUtils.isEmpty(componentVerifyTicket)) {
                    //todo实现数据库存储

                }
            } else if (InfoType.equals("authorized") || InfoType.equals("updateauthorized")) {//获取授权AuthorizationCode

                AuthorizerAppid = wxMessage.getAuthorizerAppid();
                AuthorizationCode = wxMessage.getAuthorizationCode();
                //todo 根据appid获取信息，获取后进行更新AuthorizationCode信息
                log.info("收到授权事件：回调填写授权码信息！appid={}", AuthorizerAppid);
            } else if (InfoType.equals("notify_third_fasteregister")) {
                log.info("收到授权事件：注册审核事件推送通知");
                //				String AppId = xmlMap.get("AppId")+"";//三方平台appid
                Long createTime = wxMessage.getCreateTime();
                String appid = wxMessage.getAuthorizerAppid();//创建成功的小程序id
                String get_auth_code = wxMessage.getAuthCode();//第三方授权码
                String infoCode = wxMessage.getInfo().getCode();//企业代码
                int infoCodeType = wxMessage.getInfo().getCodeType();//企业代码
                //通过企业码查询userId
                UserCompanyDTO userCompanyDTO = new UserCompanyDTO();
                userCompanyDTO.setCompanyCode(infoCode);
                Response<UserCompanyVo> userCompany = userCompanyApi.getUserCompany(userCompanyDTO);
                UserCompanyVo userCompanyVo = userCompany.getData();
                //通过userId查询accountId
                AccountUserBo accountUserBo = new AccountUserBo();
                accountUserBo.setUserId(userCompanyVo.getUserId());
                Response<AccountUserVo> accountUser = acountUserApi.getAccountUser(accountUserBo);
                AccountUserVo accountUserVo = accountUser.getData();
                //更新账户与商户关联关系
                accountUserBo.setAppId(appid);
                accountUserBo.setAccountId(accountUserVo.getAccountId());
                acountUserApi.updateAccountUser(accountUserBo);
                //更新租户与账户关联关系
                AccountTenantBo accountTenantBo = new AccountTenantBo();
                accountTenantBo.setAccountId(accountUserVo.getAccountId());
                Response<AccountTenantVo> accountTenant = acountTenantApi.getAccountTenant(accountTenantBo);
                AccountTenantVo accountTenantVo = accountTenant.getData();
                //保存应用许可证

                AppLicenseRequest appLicenseRequest = AppLicenseRequest.builder()
                        .appId(appid)
                        .appKey(get_auth_code)
                        .accountId(accountUserVo.getAccountId())
                        .status("1")//0-关 1-开
                        .dt(new Date())
                        .tenantId(accountTenantVo.getTenantId())
                        .build();
                appLicenseApi.saveAppLicense(appLicenseRequest);

                //企业
                String infoLegalPersonaName = wxMessage.getInfo().getLegalPersonaName();//法人姓名
                String infoLegalPersonaWechat = wxMessage.getInfo().getLegalPersonaWechat();//法人微信号
                String infoName = wxMessage.getInfo().getName();//企业名称
                //个人
                String infoWxuser = wxMessage.getInfo().getWxuser();//个人微信号
                String infoIdname = wxMessage.getInfo().getIdname();//个人姓名

                String msg = wxMessage.getMsg();//推送返回结果内容
                int status = wxMessage.getStatus();//推送事件结果状态

                String taskid = wxMessage.getInfo().getUniqueId();//推送事件id

                //修改完成信息
                //分为个人与企业
                if (!StringUtils.isEmpty(taskid)) {//个人申请
                    log.info("收到授权事件：个人回调修改注册信息！taskid={}", taskid);
                    //todo 个人回调修改注册信息
                } else {
                    log.info("收到授权事件：企业回调修改注册信息！code={},legalPersonaName={},legalPersonaWechat={}", infoCode, infoLegalPersonaName, infoLegalPersonaWechat);
                    //todo 企业回调修改注册信息
                }
            } else if (InfoType.equals("wxa_nickname_audit")) {
                //todo 小程序更名逻辑实现

            }

        } catch (Exception e) {
            log.error("接收票据事件异常" + e.getMessage(), e);
        }
        return "success";
    }

}