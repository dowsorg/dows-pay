////
//// Source code recreated from a .class file by IntelliJ IDEA
//// (powered by FernFlower decompiler)
////
//
//package api;
//
//import cn.binarywang.wx.miniapp.api.WxMaService;
//import cn.binarywang.wx.miniapp.bean.WxMaAuditMediaUploadResult;
//import java.io.File;
//import java.util.List;
//import java.util.Map;
//import me.chanjar.weixin.common.error.WxErrorException;
//import me.chanjar.weixin.open.api.WxOpenMaBasicService;
//import me.chanjar.weixin.open.api.WxOpenMaPrivacyService;
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
//
//public interface WxOpenMaExtService extends WxMaService {
//    String API_MODIFY_DOMAIN = "https://api.weixin.qq.com/wxa/modify_domain";
//    String API_SET_WEBVIEW_DOMAIN = "https://api.weixin.qq.com/wxa/setwebviewdomain";
//    String API_GET_ACCOUNT_BASICINFO = "https://api.weixin.qq.com/cgi-bin/account/getaccountbasicinfo";
//    String API_BIND_TESTER = "https://api.weixin.qq.com/wxa/bind_tester";
//    String API_UNBIND_TESTER = "https://api.weixin.qq.com/wxa/unbind_tester";
//    String API_GET_TESTERLIST = "https://api.weixin.qq.com/wxa/memberauth";
//    String API_CHANGE_WXA_SEARCH_STATUS = "https://api.weixin.qq.com/wxa/changewxasearchstatus";
//    String API_GET_WXA_SEARCH_STATUS = "https://api.weixin.qq.com/wxa/getwxasearchstatus";
//    String API_GET_SHOW_WXA_ITEM = "https://api.weixin.qq.com/wxa/getshowwxaitem";
//    String API_UPDATE_SHOW_WXA_ITEM = "https://api.weixin.qq.com/wxa/updateshowwxaitem";
//    String API_CODE_COMMIT = "https://api.weixin.qq.com/wxa/commit";
//    String API_TEST_QRCODE = "https://api.weixin.qq.com/wxa/get_qrcode";
//    String API_GET_CATEGORY = "https://api.weixin.qq.com/wxa/get_category";
//    String API_GET_PAGE = "https://api.weixin.qq.com/wxa/get_page";
//    String API_SUBMIT_AUDIT = "https://api.weixin.qq.com/wxa/submit_audit";
//    String API_GET_AUDIT_STATUS = "https://api.weixin.qq.com/wxa/get_auditstatus";
//    String API_GET_LATEST_AUDIT_STATUS = "https://api.weixin.qq.com/wxa/get_latest_auditstatus";
//    String API_RELEASE = "https://api.weixin.qq.com/wxa/release";
//    String API_CHANGE_VISITSTATUS = "https://api.weixin.qq.com/wxa/change_visitstatus";
//    String API_REVERT_CODE_RELEASE = "https://api.weixin.qq.com/wxa/revertcoderelease";
//    String API_GET_WEAPP_SUPPORT_VERSION = "https://api.weixin.qq.com/cgi-bin/wxopen/getweappsupportversion";
//    String API_SET_WEAPP_SUPPORT_VERSION = "https://api.weixin.qq.com/cgi-bin/wxopen/setweappsupportversion";
//    String API_QRCODE_JUMP_ADD = "https://api.weixin.qq.com/cgi-bin/wxopen/qrcodejumpadd";
//    String API_QRCODE_JUMP_GET = "https://api.weixin.qq.com/cgi-bin/wxopen/qrcodejumpget";
//    String API_QRCODE_JUMP_DOWNLOAD = "https://api.weixin.qq.com/cgi-bin/wxopen/qrcodejumpdownload";
//    String API_QRCODE_JUMP_DELETE = "https://api.weixin.qq.com/cgi-bin/wxopen/qrcodejumpdelete";
//    String API_QRCODE_JUMP_PUBLISH = "https://api.weixin.qq.com/cgi-bin/wxopen/qrcodejumppublish";
//    String API_UNDO_CODE_AUDIT = "https://api.weixin.qq.com/wxa/undocodeaudit";
//    String API_GRAY_RELEASE = "https://api.weixin.qq.com/wxa/grayrelease";
//    String API_REVERT_GRAY_RELEASE = "https://api.weixin.qq.com/wxa/revertgrayrelease";
//    String API_GET_GRAY_RELEASE_PLAN = "https://api.weixin.qq.com/wxa/getgrayreleaseplan";
//    String API_QUERY_QUOTA = "https://api.weixin.qq.com/wxa/queryquota";
//    String API_SPEED_AUDIT = "https://api.weixin.qq.com/wxa/speedupaudit";
//    String API_GENERATE_SCHEME = "https://api.weixin.qq.com/wxa/generatescheme";
//    String API_REGISTER_SHOP_COMPONENT = "https://api.weixin.qq.com/shop/register/apply";
//    String API_AUDIT_UPLOAD_MEDIA = "https://api.weixin.qq.com/wxa/uploadmedia";
//    String API_WX_AMP_LINK_GET = "https://api.weixin.qq.com/cgi-bin/wxopen/wxamplinkget";
//    String API_WX_AMP_LINK_CREATE = "https://api.weixin.qq.com/cgi-bin/wxopen/wxamplink";
//    String API_WX_AMP_LINK_UN = "https://api.weixin.qq.com/cgi-bin/wxopen/wxampunlink";
//    String API_GET_VERSION_INFO = "https://api.weixin.qq.com/wxa/getversioninfo";
//
//    WxOpenMaDomainResult getDomain() throws WxErrorException;
//
//    WxOpenMaDomainResult modifyDomain(String var1, List<String> var2, List<String> var3, List<String> var4, List<String> var5) throws WxErrorException;
//
//    String getWebViewDomain() throws WxErrorException;
//
//    WxOpenMaWebDomainResult getWebViewDomainInfo() throws WxErrorException;
//
//    String setWebViewDomain(String var1, List<String> var2) throws WxErrorException;
//
//    WxOpenMaWebDomainResult setWebViewDomainInfo(String var1, List<String> var2) throws WxErrorException;
//
//    String getAccountBasicInfo() throws WxErrorException;
//
//    WxOpenMaBindTesterResult bindTester(String var1) throws WxErrorException;
//
//    WxOpenResult unbindTester(String var1) throws WxErrorException;
//
//    WxOpenResult unbindTesterByUserStr(String var1) throws WxErrorException;
//
//    WxOpenMaTesterListResult getTesterList() throws WxErrorException;
//
//    WxOpenResult changeWxaSearchStatus(Integer var1) throws WxErrorException;
//
//    WxOpenMaSearchStatusResult getWxaSearchStatus() throws WxErrorException;
//
//    WxOpenMaShowItemResult getShowWxaItem() throws WxErrorException;
//
//    WxOpenResult updateShowWxaItem(Integer var1, String var2) throws WxErrorException;
//
//    WxOpenResult codeCommit(Long var1, String var2, String var3, Object var4) throws WxErrorException;
//
//    File getTestQrcode(String var1, Map<String, String> var2) throws WxErrorException;
//
//    WxOpenMaCategoryListResult getCategoryList() throws WxErrorException;
//
//    WxOpenMaPageListResult getPageList() throws WxErrorException;
//
//    WxOpenMaSubmitAuditResult submitAudit(WxOpenMaSubmitAuditMessage var1) throws WxErrorException;
//
//    WxOpenMaQueryAuditResult getAuditStatus(Long var1) throws WxErrorException;
//
//    WxOpenMaQueryAuditResult getLatestAuditStatus() throws WxErrorException;
//
//    WxOpenResult releaseAudited() throws WxErrorException;
//
//    WxOpenResult changeVisitStatus(String var1) throws WxErrorException;
//
//    WxOpenResult revertCodeRelease() throws WxErrorException;
//
//    WxOpenMaHistoryVersionResult getHistoryVersion() throws WxErrorException;
//
//    WxOpenResult undoCodeAudit() throws WxErrorException;
//
//    String getSupportVersion() throws WxErrorException;
//
//    WxOpenMaWeappSupportVersionResult getSupportVersionInfo() throws WxErrorException;
//
//    String setSupportVersion(String var1) throws WxErrorException;
//
//    WxOpenResult setSupportVersionInfo(String var1) throws WxErrorException;
//
//    WxOpenResult grayRelease(Integer var1) throws WxErrorException;
//
//    WxOpenResult revertGrayRelease() throws WxErrorException;
//
//    WxOpenMaGrayReleasePlanResult getGrayReleasePlan() throws WxErrorException;
//
//    WxOpenMaQueryQuotaResult queryQuota() throws WxErrorException;
//
//    Boolean speedAudit(Long var1) throws WxErrorException;
//
//    WxOpenResult addQrcodeJump(WxQrcodeJumpRule var1) throws WxErrorException;
//
//    WxGetQrcodeJumpResult getQrcodeJump() throws WxErrorException;
//
//    WxDownlooadQrcodeJumpResult downloadQrcodeJump() throws WxErrorException;
//
//    WxOpenResult deleteQrcodeJump(String var1) throws WxErrorException;
//
//    WxOpenResult publishQrcodeJump(String var1) throws WxErrorException;
//
//    WxMaScheme generateMaScheme(String var1, String var2, Boolean var3, Long var4) throws WxErrorException;
//
//    WxOpenResult registerShopComponent() throws WxErrorException;
//
//    WxOpenMaBasicService getBasicService();
//
//    WxOpenMaBasicExtService getBasicExtService();
//
//    WxOpenMaPrivacyService getPrivacyService();
//
//    WxMaAuditMediaUploadResult uploadMedia(File var1) throws WxErrorException;
//
//    WxAmpLinkResult getWxAmpLink() throws WxErrorException;
//
//    WxOpenResult wxAmpLink(String var1, String var2, String var3) throws WxErrorException;
//
//    WxOpenResult wxAmpUnLink(String var1) throws WxErrorException;
//
//    WxOpenVersioninfoResult getVersionInfo() throws WxErrorException;
//}
