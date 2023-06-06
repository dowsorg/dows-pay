////
//// Source code recreated from a .class file by IntelliJ IDEA
//// (powered by FernFlower decompiler)
////
//
//package api.impl;
//
//import api.WxOpenMaBasicExtService;
//import api.WxOpenMaExtService;
//import cn.binarywang.wx.miniapp.api.impl.WxMaServiceImpl;
//import cn.binarywang.wx.miniapp.bean.WxMaAuditMediaUploadResult;
//import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
//import cn.binarywang.wx.miniapp.config.WxMaConfig;
//import cn.binarywang.wx.miniapp.executor.AuditMediaUploadRequestExecutor;
//import cn.binarywang.wx.miniapp.json.WxMaGsonBuilder;
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import com.google.gson.JsonArray;
//import com.google.gson.JsonObject;
//import java.io.File;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//import me.chanjar.weixin.common.error.WxErrorException;
//import me.chanjar.weixin.open.api.*;
//import me.chanjar.weixin.open.api.impl.WxOpenMaBasicServiceImpl;
//import me.chanjar.weixin.open.api.impl.WxOpenMaPrivacyServiceImpl;
//import me.chanjar.weixin.open.bean.ma.WxMaQrcodeParam;
//import me.chanjar.weixin.open.bean.ma.WxMaScheme;
//import me.chanjar.weixin.open.bean.message.WxOpenMaSubmitAuditMessage;
//import me.chanjar.weixin.open.bean.result.WxAmpLinkResult;
//import me.chanjar.weixin.open.bean.result.WxDownlooadQrcodeJumpResult;
//import me.chanjar.weixin.open.bean.result.WxGetQrcodeJumpResult;
//import me.chanjar.weixin.open.bean.result.WxOpenMaBindTesterResult;
//import me.chanjar.weixin.open.bean.result.WxOpenMaCategoryListResult;
//import me.chanjar.weixin.open.bean.result.WxOpenMaDomainResult;
//import me.chanjar.weixin.open.bean.result.WxOpenMaGrayReleasePlanResult;
//import me.chanjar.weixin.open.bean.result.WxOpenMaHistoryVersionResult;
//import me.chanjar.weixin.open.bean.result.WxOpenMaPageListResult;
//import me.chanjar.weixin.open.bean.result.WxOpenMaQueryAuditResult;
//import me.chanjar.weixin.open.bean.result.WxOpenMaQueryQuotaResult;
//import me.chanjar.weixin.open.bean.result.WxOpenMaSearchStatusResult;
//import me.chanjar.weixin.open.bean.result.WxOpenMaShowItemResult;
//import me.chanjar.weixin.open.bean.result.WxOpenMaSubmitAuditResult;
//import me.chanjar.weixin.open.bean.result.WxOpenMaTesterListResult;
//import me.chanjar.weixin.open.bean.result.WxOpenMaWeappSupportVersionResult;
//import me.chanjar.weixin.open.bean.result.WxOpenMaWebDomainResult;
//import me.chanjar.weixin.open.bean.result.WxOpenResult;
//import me.chanjar.weixin.open.bean.result.WxOpenVersioninfoResult;
//import me.chanjar.weixin.open.bean.result.WxQrcodeJumpRule;
//import me.chanjar.weixin.open.executor.MaQrCodeRequestExecutor;
//
//public class WxOpenMaExtServiceImpl extends WxMaServiceImpl implements WxOpenMaExtService {
//    private final WxOpenComponentService wxOpenComponentService;
//    private final WxMaConfig wxMaConfig;
//    private final String appId;
//    private final WxOpenMaBasicService basicService;
//    private final WxOpenMaBasicExtService wxOpenMaBasicExtService;
//    private final WxOpenMaPrivacyService privacyService;
//
//    public WxOpenMaExtServiceImpl(WxOpenComponentService wxOpenComponentService, String appId, WxMaConfig wxMaConfig) {
//        this.wxOpenComponentService = wxOpenComponentService;
//        this.appId = appId;
//        this.wxMaConfig = wxMaConfig;
//        this.basicService = new WxOpenMaBasicServiceImpl(this);
//        this.wxOpenMaBasicExtService = new WxOpenMaBasicExtServiceImpl(this);
//        this.privacyService = new WxOpenMaPrivacyServiceImpl(this);
//        this.initHttp();
//    }
//
//    public WxMaJscode2SessionResult jsCode2SessionInfo(String jsCode) throws WxErrorException {
//        return this.wxOpenComponentService.miniappJscode2Session(this.appId, jsCode);
//    }
//
//    public WxMaConfig getWxMaConfig() {
//        return this.wxMaConfig;
//    }
//
//    public String getAccessToken(boolean forceRefresh) throws WxErrorException {
//        return this.wxOpenComponentService.getAuthorizerAccessToken(this.appId, forceRefresh);
//    }
//
//    public WxOpenMaDomainResult getDomain() throws WxErrorException {
//        return this.modifyDomain("get", (List)null, (List)null, (List)null, (List)null);
//    }
//
//    public WxOpenMaDomainResult modifyDomain(String action, List<String> requestDomains, List<String> wsRequestDomains, List<String> uploadDomains, List<String> downloadDomains) throws WxErrorException {
//        JsonObject requestJson = new JsonObject();
//        requestJson.addProperty("action", action);
//        if (!"get".equals(action)) {
//            requestJson.add("requestdomain", this.toJsonArray(requestDomains));
//            requestJson.add("wsrequestdomain", this.toJsonArray(wsRequestDomains));
//            requestJson.add("uploaddomain", this.toJsonArray(uploadDomains));
//            requestJson.add("downloaddomain", this.toJsonArray(downloadDomains));
//        }
//
//        String response = this.post("https://api.weixin.qq.com/wxa/modify_domain", GSON.toJson(requestJson));
//        return (WxOpenMaDomainResult)WxMaGsonBuilder.create().fromJson(response, WxOpenMaDomainResult.class);
//    }
//
//    public String getWebViewDomain() throws WxErrorException {
//        return this.setWebViewDomain("get", (List)null);
//    }
//
//    public WxOpenMaWebDomainResult getWebViewDomainInfo() throws WxErrorException {
//        return this.setWebViewDomainInfo("get", (List)null);
//    }
//
//    public String setWebViewDomain(String action, List<String> domainList) throws WxErrorException {
//        JsonObject requestJson = new JsonObject();
//        requestJson.addProperty("action", action);
//        if (!"get".equals(action)) {
//            requestJson.add("webviewdomain", this.toJsonArray(domainList));
//        }
//
//        return this.post("https://api.weixin.qq.com/wxa/setwebviewdomain", GSON.toJson(requestJson));
//    }
//
//    public WxOpenMaWebDomainResult setWebViewDomainInfo(String action, List<String> domainList) throws WxErrorException {
//        String response = this.setWebViewDomain(action, domainList);
//        return (WxOpenMaWebDomainResult)WxMaGsonBuilder.create().fromJson(response, WxOpenMaWebDomainResult.class);
//    }
//
//    public String getAccountBasicInfo() throws WxErrorException {
//        return this.get("https://api.weixin.qq.com/cgi-bin/account/getaccountbasicinfo", "");
//    }
//
//    public WxOpenMaBindTesterResult bindTester(String wechatId) throws WxErrorException {
//        JsonObject paramJson = new JsonObject();
//        paramJson.addProperty("wechatid", wechatId);
//        String response = this.post("https://api.weixin.qq.com/wxa/bind_tester", GSON.toJson(paramJson));
//        return (WxOpenMaBindTesterResult)WxMaGsonBuilder.create().fromJson(response, WxOpenMaBindTesterResult.class);
//    }
//
//    public WxOpenResult unbindTester(String wechatId) throws WxErrorException {
//        JsonObject paramJson = new JsonObject();
//        paramJson.addProperty("wechatid", wechatId);
//        String response = this.post("https://api.weixin.qq.com/wxa/unbind_tester", GSON.toJson(paramJson));
//        return (WxOpenResult)WxMaGsonBuilder.create().fromJson(response, WxOpenResult.class);
//    }
//
//    public WxOpenResult unbindTesterByUserStr(String userStr) throws WxErrorException {
//        JsonObject paramJson = new JsonObject();
//        paramJson.addProperty("userstr", userStr);
//        String response = this.post("https://api.weixin.qq.com/wxa/unbind_tester", GSON.toJson(paramJson));
//        return (WxOpenResult)WxMaGsonBuilder.create().fromJson(response, WxOpenResult.class);
//    }
//
//    public WxOpenMaTesterListResult getTesterList() throws WxErrorException {
//        JsonObject paramJson = new JsonObject();
//        paramJson.addProperty("action", "get_experiencer");
//        String response = this.post("https://api.weixin.qq.com/wxa/memberauth", GSON.toJson(paramJson));
//        return (WxOpenMaTesterListResult)WxMaGsonBuilder.create().fromJson(response, WxOpenMaTesterListResult.class);
//    }
//
//    public WxOpenResult changeWxaSearchStatus(Integer status) throws WxErrorException {
//        JsonObject paramJson = new JsonObject();
//        paramJson.addProperty("status", status);
//        String response = this.post("https://api.weixin.qq.com/wxa/changewxasearchstatus", GSON.toJson(paramJson));
//        return (WxOpenResult)WxMaGsonBuilder.create().fromJson(response, WxOpenResult.class);
//    }
//
//    public WxOpenMaSearchStatusResult getWxaSearchStatus() throws WxErrorException {
//        String response = this.get("https://api.weixin.qq.com/wxa/getwxasearchstatus", (String)null);
//        return (WxOpenMaSearchStatusResult)WxMaGsonBuilder.create().fromJson(response, WxOpenMaSearchStatusResult.class);
//    }
//
//    public WxOpenMaShowItemResult getShowWxaItem() throws WxErrorException {
//        String response = this.get("https://api.weixin.qq.com/wxa/getshowwxaitem", (String)null);
//        return (WxOpenMaShowItemResult)WxMaGsonBuilder.create().fromJson(response, WxOpenMaShowItemResult.class);
//    }
//
//    public WxOpenResult updateShowWxaItem(Integer flag, String mpAppId) throws WxErrorException {
//        JsonObject paramJson = new JsonObject();
//        paramJson.addProperty("wxa_subscribe_biz_flag", flag);
//        paramJson.addProperty("appid", mpAppId);
//        String response = this.post("https://api.weixin.qq.com/wxa/updateshowwxaitem", GSON.toJson(paramJson));
//        return (WxOpenResult)WxMaGsonBuilder.create().fromJson(response, WxOpenResult.class);
//    }
//
//    public WxOpenResult codeCommit(Long templateId, String userVersion, String userDesc, Object extJsonObject) throws WxErrorException {
//        JsonObject params = new JsonObject();
//        params.addProperty("template_id", templateId);
//        params.addProperty("user_version", userVersion);
//        params.addProperty("user_desc", userDesc);
//        params.addProperty("ext_json", GSON.toJson(extJsonObject));
//        String response = this.post("https://api.weixin.qq.com/wxa/commit", GSON.toJson(params));
//        return (WxOpenResult)WxMaGsonBuilder.create().fromJson(response, WxOpenResult.class);
//    }
//
//    public File getTestQrcode(String pagePath, Map<String, String> params) throws WxErrorException {
//        WxMaQrcodeParam qrcodeParam = WxMaQrcodeParam.create(pagePath);
//        qrcodeParam.addPageParam(params);
//        return (File)this.execute(MaQrCodeRequestExecutor.create(this.getRequestHttp()), "https://api.weixin.qq.com/wxa/get_qrcode", qrcodeParam);
//    }
//
//    public WxOpenMaCategoryListResult getCategoryList() throws WxErrorException {
//        String response = this.get("https://api.weixin.qq.com/wxa/get_category", (String)null);
//        return (WxOpenMaCategoryListResult)WxMaGsonBuilder.create().fromJson(response, WxOpenMaCategoryListResult.class);
//    }
//
//    public WxOpenMaPageListResult getPageList() throws WxErrorException {
//        String response = this.get("https://api.weixin.qq.com/wxa/get_page", (String)null);
//        return (WxOpenMaPageListResult)WxMaGsonBuilder.create().fromJson(response, WxOpenMaPageListResult.class);
//    }
//
//    public WxOpenMaSubmitAuditResult submitAudit(WxOpenMaSubmitAuditMessage submitAuditMessage) throws WxErrorException {
//        String response = this.post("https://api.weixin.qq.com/wxa/submit_audit", GSON.toJson(submitAuditMessage));
//        return (WxOpenMaSubmitAuditResult)WxMaGsonBuilder.create().fromJson(response, WxOpenMaSubmitAuditResult.class);
//    }
//
//    public WxOpenMaQueryAuditResult getAuditStatus(Long auditId) throws WxErrorException {
//        JsonObject params = new JsonObject();
//        params.addProperty("auditid", auditId);
//        String response = this.post("https://api.weixin.qq.com/wxa/get_auditstatus", GSON.toJson(params));
//        return (WxOpenMaQueryAuditResult)WxMaGsonBuilder.create().fromJson(response, WxOpenMaQueryAuditResult.class);
//    }
//
//    public WxOpenMaQueryAuditResult getLatestAuditStatus() throws WxErrorException {
//        String response = this.get("https://api.weixin.qq.com/wxa/get_latest_auditstatus", (String)null);
//        return (WxOpenMaQueryAuditResult)WxMaGsonBuilder.create().fromJson(response, WxOpenMaQueryAuditResult.class);
//    }
//
//    public WxOpenResult releaseAudited() throws WxErrorException {
//        JsonObject params = new JsonObject();
//        String response = this.post("https://api.weixin.qq.com/wxa/release", GSON.toJson(params));
//        return (WxOpenResult)WxMaGsonBuilder.create().fromJson(response, WxOpenResult.class);
//    }
//
//    public WxOpenResult changeVisitStatus(String action) throws WxErrorException {
//        JsonObject params = new JsonObject();
//        params.addProperty("action", action);
//        String response = this.post("https://api.weixin.qq.com/wxa/change_visitstatus", GSON.toJson(params));
//        return (WxOpenResult)WxMaGsonBuilder.create().fromJson(response, WxOpenResult.class);
//    }
//
//    public WxOpenResult revertCodeRelease() throws WxErrorException {
//        String response = this.get("https://api.weixin.qq.com/wxa/revertcoderelease", (String)null);
//        return (WxOpenResult)WxMaGsonBuilder.create().fromJson(response, WxOpenResult.class);
//    }
//
//    public WxOpenMaHistoryVersionResult getHistoryVersion() throws WxErrorException {
//        String response = this.get("https://api.weixin.qq.com/wxa/revertcoderelease", "action=get_history_version");
//        return (WxOpenMaHistoryVersionResult)WxMaGsonBuilder.create().fromJson(response, WxOpenMaHistoryVersionResult.class);
//    }
//
//    public WxOpenResult undoCodeAudit() throws WxErrorException {
//        String response = this.get("https://api.weixin.qq.com/wxa/undocodeaudit", (String)null);
//        return (WxOpenResult)WxMaGsonBuilder.create().fromJson(response, WxOpenResult.class);
//    }
//
//    public String getSupportVersion() throws WxErrorException {
//        JsonObject params = new JsonObject();
//        return this.post("https://api.weixin.qq.com/cgi-bin/wxopen/getweappsupportversion", GSON.toJson(params));
//    }
//
//    public WxOpenMaWeappSupportVersionResult getSupportVersionInfo() throws WxErrorException {
//        String response = this.getSupportVersion();
//        return (WxOpenMaWeappSupportVersionResult)WxMaGsonBuilder.create().fromJson(response, WxOpenMaWeappSupportVersionResult.class);
//    }
//
//    public String setSupportVersion(String version) throws WxErrorException {
//        JsonObject params = new JsonObject();
//        params.addProperty("version", version);
//        return this.post("https://api.weixin.qq.com/cgi-bin/wxopen/setweappsupportversion", GSON.toJson(params));
//    }
//
//    public WxOpenResult setSupportVersionInfo(String version) throws WxErrorException {
//        String response = this.setSupportVersion(version);
//        return (WxOpenResult)WxMaGsonBuilder.create().fromJson(response, WxOpenResult.class);
//    }
//
//    public WxOpenResult grayRelease(Integer grayPercentage) throws WxErrorException {
//        JsonObject params = new JsonObject();
//        params.addProperty("gray_percentage", grayPercentage);
//        String response = this.post("https://api.weixin.qq.com/wxa/grayrelease", GSON.toJson(params));
//        return (WxOpenResult)WxMaGsonBuilder.create().fromJson(response, WxOpenResult.class);
//    }
//
//    public WxOpenResult revertGrayRelease() throws WxErrorException {
//        String response = this.get("https://api.weixin.qq.com/wxa/revertgrayrelease", (String)null);
//        return (WxOpenResult)WxMaGsonBuilder.create().fromJson(response, WxOpenResult.class);
//    }
//
//    public WxOpenMaGrayReleasePlanResult getGrayReleasePlan() throws WxErrorException {
//        String response = this.get("https://api.weixin.qq.com/wxa/getgrayreleaseplan", (String)null);
//        return (WxOpenMaGrayReleasePlanResult)WxMaGsonBuilder.create().fromJson(response, WxOpenMaGrayReleasePlanResult.class);
//    }
//
//    public WxOpenMaQueryQuotaResult queryQuota() throws WxErrorException {
//        String response = this.get("https://api.weixin.qq.com/wxa/queryquota", (String)null);
//        return (WxOpenMaQueryQuotaResult)WxMaGsonBuilder.create().fromJson(response, WxOpenMaQueryQuotaResult.class);
//    }
//
//    public Boolean speedAudit(Long auditId) throws WxErrorException {
//        JsonObject params = new JsonObject();
//        params.addProperty("auditid", auditId);
//        String response = this.post("https://api.weixin.qq.com/wxa/speedupaudit", GSON.toJson(params));
//        WxOpenResult result = (WxOpenResult)WxMaGsonBuilder.create().fromJson(response, WxOpenResult.class);
//        return result.isSuccess();
//    }
//
//    public WxOpenResult addQrcodeJump(WxQrcodeJumpRule wxQrcodeJumpRule) throws WxErrorException {
//        String response = this.post("https://api.weixin.qq.com/cgi-bin/wxopen/qrcodejumpadd", GSON.toJson(wxQrcodeJumpRule));
//        return (WxOpenResult)WxMaGsonBuilder.create().fromJson(response, WxOpenResult.class);
//    }
//
//    public WxGetQrcodeJumpResult getQrcodeJump() throws WxErrorException {
//        String response = this.post("https://api.weixin.qq.com/cgi-bin/wxopen/qrcodejumpget", "{}");
//        return (WxGetQrcodeJumpResult)WxMaGsonBuilder.create().fromJson(response, WxGetQrcodeJumpResult.class);
//    }
//
//    public WxDownlooadQrcodeJumpResult downloadQrcodeJump() throws WxErrorException {
//        String response = this.post("https://api.weixin.qq.com/cgi-bin/wxopen/qrcodejumpdownload", "{}");
//        return (WxDownlooadQrcodeJumpResult)WxMaGsonBuilder.create().fromJson(response, WxDownlooadQrcodeJumpResult.class);
//    }
//
//    public WxOpenResult deleteQrcodeJump(String prefix) throws WxErrorException {
//        JsonObject params = new JsonObject();
//        params.addProperty("prefix", prefix);
//        String response = this.post("https://api.weixin.qq.com/cgi-bin/wxopen/qrcodejumpdelete", GSON.toJson(params));
//        return (WxOpenResult)WxMaGsonBuilder.create().fromJson(response, WxOpenResult.class);
//    }
//
//    public WxOpenResult publishQrcodeJump(String prefix) throws WxErrorException {
//        JsonObject params = new JsonObject();
//        params.addProperty("prefix", prefix);
//        String response = this.post("https://api.weixin.qq.com/cgi-bin/wxopen/qrcodejumppublish", GSON.toJson(params));
//        return (WxOpenResult)WxMaGsonBuilder.create().fromJson(response, WxOpenResult.class);
//    }
//
//    public WxMaScheme generateMaScheme(String jumpWxaPath, String jumpWxaQuery, Boolean isExpire, Long expireTime) throws WxErrorException {
//        JsonObject jumpWxa = null;
//        if (jumpWxaPath != null && jumpWxaQuery != null) {
//            jumpWxa = new JsonObject();
//            jumpWxa.addProperty("path", jumpWxaPath);
//            jumpWxa.addProperty("query", jumpWxaQuery);
//        }
//
//        JsonObject params = new JsonObject();
//        if (jumpWxa != null) {
//            params.add("jump_wxa", jumpWxa);
//        }
//
//        if (isExpire != null) {
//            params.addProperty("is_expire", isExpire);
//        }
//
//        if (expireTime != null) {
//            params.addProperty("expire_time", expireTime);
//        }
//
//        Gson gson = (new GsonBuilder()).disableHtmlEscaping().create();
//        String response = this.post("https://api.weixin.qq.com/wxa/generatescheme", gson.toJson(params));
//        return (WxMaScheme)WxMaGsonBuilder.create().fromJson(response, WxMaScheme.class);
//    }
//
//    public WxOpenResult registerShopComponent() throws WxErrorException {
//        JsonObject params = new JsonObject();
//        String response = this.post("https://api.weixin.qq.com/shop/register/apply", GSON.toJson(params));
//        return (WxOpenResult)WxMaGsonBuilder.create().fromJson(response, WxOpenResult.class);
//    }
//
//    public WxMaAuditMediaUploadResult uploadMedia(File file) throws WxErrorException {
//        return (WxMaAuditMediaUploadResult)this.execute(AuditMediaUploadRequestExecutor.create(this.getRequestHttp()), "https://api.weixin.qq.com/wxa/uploadmedia", file);
//    }
//
//    public WxAmpLinkResult getWxAmpLink() throws WxErrorException {
//        String response = this.post("https://api.weixin.qq.com/cgi-bin/wxopen/wxamplinkget", "{}");
//        return (WxAmpLinkResult)WxMaGsonBuilder.create().fromJson(response, WxAmpLinkResult.class);
//    }
//
//    public WxOpenResult wxAmpLink(String appid, String notifyUsers, String showProfile) throws WxErrorException {
//        JsonObject params = new JsonObject();
//        params.addProperty("appid", appid);
//        params.addProperty("notify_users", notifyUsers);
//        params.addProperty("show_profile", showProfile);
//        String response = this.post("https://api.weixin.qq.com/cgi-bin/wxopen/wxamplink", GSON.toJson(params));
//        return (WxOpenResult)WxMaGsonBuilder.create().fromJson(response, WxOpenResult.class);
//    }
//
//    public WxOpenResult wxAmpUnLink(String appid) throws WxErrorException {
//        JsonObject params = new JsonObject();
//        params.addProperty("appid", appid);
//        String response = this.post("https://api.weixin.qq.com/cgi-bin/wxopen/wxampunlink", GSON.toJson(params));
//        return (WxOpenResult)WxMaGsonBuilder.create().fromJson(response, WxOpenResult.class);
//    }
//
//    private JsonArray toJsonArray(List<String> strList) {
//        JsonArray jsonArray = new JsonArray();
//        if (strList != null && !strList.isEmpty()) {
//            Iterator var3 = strList.iterator();
//
//            while(var3.hasNext()) {
//                String str = (String)var3.next();
//                jsonArray.add(str);
//            }
//        }
//
//        return jsonArray;
//    }
//
//    public WxOpenVersioninfoResult getVersionInfo() throws WxErrorException {
//        JsonObject params = new JsonObject();
//        String response = this.post("https://api.weixin.qq.com/wxa/getversioninfo", GSON.toJson(params));
//        return (WxOpenVersioninfoResult)WxMaGsonBuilder.create().fromJson(response, WxOpenVersioninfoResult.class);
//    }
//
//    public WxOpenMaBasicService getBasicService() {
//        return this.basicService;
//    }
//
//    @Override
//    public WxOpenMaBasicExtService getBasicExtService() {
//        return this.wxOpenMaBasicExtService;
//    }
//
//    public WxOpenMaPrivacyService getPrivacyService() {
//        return this.privacyService;
//    }
//}
