////
//// Source code recreated from a .class file by IntelliJ IDEA
//// (powered by FernFlower decompiler)
////
//
//package api.impl;
//
//import api.WxOpenMaBasicExtService;
//import cn.binarywang.wx.miniapp.api.impl.WxMaServiceImpl;
//import cn.binarywang.wx.miniapp.config.WxMaConfig;
//import com.google.gson.JsonArray;
//import com.google.gson.JsonObject;
//
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//
//import me.chanjar.weixin.common.error.WxErrorException;
//import me.chanjar.weixin.open.api.WxOpenComponentService;
//import me.chanjar.weixin.open.bean.ma.WxFastMaCategory;
//import me.chanjar.weixin.open.bean.result.WxFastMaAccountBasicInfoResult;
//import me.chanjar.weixin.open.bean.result.WxFastMaBeenSetCategoryResult;
//import me.chanjar.weixin.open.bean.result.WxFastMaCheckNickameResult;
//import me.chanjar.weixin.open.bean.result.WxFastMaQueryNicknameStatusResult;
//import me.chanjar.weixin.open.bean.result.WxFastMaSetNickameResult;
//import me.chanjar.weixin.open.bean.result.WxOpenResult;
//import me.chanjar.weixin.open.util.json.WxOpenGsonBuilder;
//
///**
// * @deprecated
// */
//@Deprecated
//public class WxOpenFastMaServiceImpl extends WxMaServiceImpl implements WxOpenMaBasicExtService {
//    private final WxOpenComponentService wxOpenComponentService;
//    private final WxMaConfig wxMaConfig;
//    private final String appId;
//
//    public WxOpenFastMaServiceImpl(WxOpenComponentService wxOpenComponentService, String appId, WxMaConfig wxMaConfig) {
//        this.wxOpenComponentService = wxOpenComponentService;
//        this.appId = appId;
//        this.wxMaConfig = wxMaConfig;
//        this.initHttp();
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
//    public WxFastMaAccountBasicInfoResult getAccountBasicInfo() throws WxErrorException {
//        String response = this.get("https://api.weixin.qq.com/cgi-bin/account/getaccountbasicinfo", "");
//        return (WxFastMaAccountBasicInfoResult) WxOpenGsonBuilder.create().fromJson(response, WxFastMaAccountBasicInfoResult.class);
//    }
//
//    public WxFastMaSetNickameResult setNickname(String accessToken, String nickname, String idCard, String license, String namingOtherStuff1, String namingOtherStuff2) throws WxErrorException {
//        JsonObject params = new JsonObject();
//        params.addProperty("nick_name", nickname);
//        params.addProperty("id_card", idCard);
//        params.addProperty("license", license);
//        params.addProperty("naming_other_stuff_1", namingOtherStuff1);
//        params.addProperty("naming_other_stuff_2", namingOtherStuff2);
//        String response = this.post("https://api.weixin.qq.com/wxa/setnickname?component_access_token=" + accessToken, GSON.toJson(params));
//        return (WxFastMaSetNickameResult) WxOpenGsonBuilder.create().fromJson(response, WxFastMaSetNickameResult.class);
//    }
//
//    public WxFastMaQueryNicknameStatusResult querySetNicknameStatus(String auditId) throws WxErrorException {
//        JsonObject params = new JsonObject();
//        params.addProperty("audit_id", auditId);
//        String response = this.post("https://api.weixin.qq.com/wxa/api_wxa_querynickname", GSON.toJson(params));
//        return (WxFastMaQueryNicknameStatusResult) WxOpenGsonBuilder.create().fromJson(response, WxFastMaQueryNicknameStatusResult.class);
//    }
//
//    public WxFastMaCheckNickameResult checkWxVerifyNickname(String nickname) throws WxErrorException {
//        JsonObject params = new JsonObject();
//        params.addProperty("nick_name", nickname);
//        String response = this.post("https://api.weixin.qq.com/cgi-bin/wxverify/checkwxverifynickname", GSON.toJson(params));
//        return (WxFastMaCheckNickameResult) WxOpenGsonBuilder.create().fromJson(response, WxFastMaCheckNickameResult.class);
//    }
//
//    public WxOpenResult modifyHeadImage(String headImgMediaId, float x1, float y1, float x2, float y2) throws WxErrorException {
//        JsonObject params = new JsonObject();
//        params.addProperty("head_img_media_id", headImgMediaId);
//        params.addProperty("x1", x1);
//        params.addProperty("y1", y1);
//        params.addProperty("x2", x2);
//        params.addProperty("y2", y2);
//        String response = this.post("https://api.weixin.qq.com/cgi-bin/account/modifyheadimage", GSON.toJson(params));
//        return (WxOpenResult) WxOpenGsonBuilder.create().fromJson(response, WxOpenResult.class);
//    }
//
//    public WxOpenResult modifySignature(String signature) throws WxErrorException {
//        JsonObject params = new JsonObject();
//        params.addProperty("signature", signature);
//        String response = this.post("https://api.weixin.qq.com/cgi-bin/account/modifysignature", GSON.toJson(params));
//        return (WxOpenResult) WxOpenGsonBuilder.create().fromJson(response, WxOpenResult.class);
//    }
//
//    public WxOpenResult componentRebindAdmin(String taskid) throws WxErrorException {
//        JsonObject params = new JsonObject();
//        params.addProperty("taskid", taskid);
//        String response = this.post("https://api.weixin.qq.com/cgi-bin/account/componentrebindadmin", GSON.toJson(params));
//        return (WxOpenResult) WxOpenGsonBuilder.create().fromJson(response, WxOpenResult.class);
//    }
//
//    public String getAllCategories() throws WxErrorException {
//        return this.get("https://api.weixin.qq.com/cgi-bin/wxopen/getallcategories", "");
//    }
//
//    public WxOpenResult addCategory(List<WxFastMaCategory> categoryList) throws WxErrorException {
//        Map<String, Object> map = new HashMap();
//        map.put("categories", categoryList);
//        String response = this.post("https://api.weixin.qq.com/cgi-bin/wxopen/addcategory", WxOpenGsonBuilder.create().toJson(map));
//        return (WxOpenResult) WxOpenGsonBuilder.create().fromJson(response, WxOpenResult.class);
//    }
//
//    public WxOpenResult deleteCategory(int first, int second) throws WxErrorException {
//        JsonObject params = new JsonObject();
//        params.addProperty("first", first);
//        params.addProperty("second", second);
//        String response = this.post("https://api.weixin.qq.com/cgi-bin/wxopen/deletecategory", GSON.toJson(params));
//        return (WxOpenResult) WxOpenGsonBuilder.create().fromJson(response, WxOpenResult.class);
//    }
//
//    public WxFastMaBeenSetCategoryResult getCategory() throws WxErrorException {
//        String response = this.get("https://api.weixin.qq.com/cgi-bin/wxopen/getcategory", "");
//        return (WxFastMaBeenSetCategoryResult) WxOpenGsonBuilder.create().fromJson(response, WxFastMaBeenSetCategoryResult.class);
//    }
//
//    public WxOpenResult modifyCategory(WxFastMaCategory category) throws WxErrorException {
//        String response = this.post("https://api.weixin.qq.com/cgi-bin/wxopen/modifycategory", GSON.toJson(category));
//        return (WxOpenResult) WxOpenGsonBuilder.create().fromJson(response, WxOpenResult.class);
//    }
//
//    private JsonArray toJsonArray(List<String> strList) {
//        JsonArray jsonArray = new JsonArray();
//        if (strList != null && !strList.isEmpty()) {
//            Iterator var3 = strList.iterator();
//
//            while (var3.hasNext()) {
//                String str = (String) var3.next();
//                jsonArray.add(str);
//            }
//        }
//
//        return jsonArray;
//    }
//}
