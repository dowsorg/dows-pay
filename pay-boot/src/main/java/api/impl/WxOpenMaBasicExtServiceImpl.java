////
//// Source code recreated from a .class file by IntelliJ IDEA
//// (powered by FernFlower decompiler)
////
//
//package api.impl;
//
//import cn.binarywang.wx.miniapp.api.WxMaService;
//import com.google.gson.JsonArray;
//import com.google.gson.JsonObject;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//import me.chanjar.weixin.common.error.WxErrorException;
//import api.WxOpenMaBasicExtService;
//import me.chanjar.weixin.open.bean.ma.WxFastMaCategory;
//import me.chanjar.weixin.open.bean.result.WxFastMaAccountBasicInfoResult;
//import me.chanjar.weixin.open.bean.result.WxFastMaBeenSetCategoryResult;
//import me.chanjar.weixin.open.bean.result.WxFastMaCheckNickameResult;
//import me.chanjar.weixin.open.bean.result.WxFastMaQueryNicknameStatusResult;
//import me.chanjar.weixin.open.bean.result.WxFastMaSetNickameResult;
//import me.chanjar.weixin.open.bean.result.WxOpenResult;
//import me.chanjar.weixin.open.util.json.WxOpenGsonBuilder;
//
//public class WxOpenMaBasicExtServiceImpl implements WxOpenMaBasicExtService {
//    private final WxMaService wxMaService;
//
//    public WxOpenMaBasicExtServiceImpl(WxMaService wxMaService) {
//        this.wxMaService = wxMaService;
//    }
//
//    public WxFastMaAccountBasicInfoResult getAccountBasicInfo() throws WxErrorException {
//        String response = this.wxMaService.get("https://api.weixin.qq.com/cgi-bin/account/getaccountbasicinfo", "");
//        return (WxFastMaAccountBasicInfoResult)WxOpenGsonBuilder.create().fromJson(response, WxFastMaAccountBasicInfoResult.class);
//    }
//
//    public WxFastMaSetNickameResult setNickname(String accessToken,String nickname, String idCard, String license, String namingOtherStuff1, String namingOtherStuff2) throws WxErrorException {
//        JsonObject params = new JsonObject();
//        params.addProperty("nick_name", nickname);
//        params.addProperty("id_card", idCard);
//        params.addProperty("license", license);
//        params.addProperty("naming_other_stuff_1", namingOtherStuff1);
//        params.addProperty("naming_other_stuff_2", namingOtherStuff2);
//        String response = this.wxMaService.post("https://api.weixin.qq.com/wxa/setnickname?access_token=" + accessToken, params);
//        return (WxFastMaSetNickameResult)WxOpenGsonBuilder.create().fromJson(response, WxFastMaSetNickameResult.class);
//    }
//
//    public WxFastMaQueryNicknameStatusResult querySetNicknameStatus(String auditId) throws WxErrorException {
//        JsonObject params = new JsonObject();
//        params.addProperty("audit_id", auditId);
//        String response = this.wxMaService.post("https://api.weixin.qq.com/wxa/api_wxa_querynickname", params);
//        return (WxFastMaQueryNicknameStatusResult)WxOpenGsonBuilder.create().fromJson(response, WxFastMaQueryNicknameStatusResult.class);
//    }
//
//    public WxFastMaCheckNickameResult checkWxVerifyNickname(String nickname) throws WxErrorException {
//        JsonObject params = new JsonObject();
//        params.addProperty("nick_name", nickname);
//        String response = this.wxMaService.post("https://api.weixin.qq.com/cgi-bin/wxverify/checkwxverifynickname", params);
//        return (WxFastMaCheckNickameResult)WxOpenGsonBuilder.create().fromJson(response, WxFastMaCheckNickameResult.class);
//    }
//
//    public WxOpenResult modifyHeadImage(String headImgMediaId, float x1, float y1, float x2, float y2) throws WxErrorException {
//        JsonObject params = new JsonObject();
//        params.addProperty("head_img_media_id", headImgMediaId);
//        params.addProperty("x1", x1);
//        params.addProperty("y1", y1);
//        params.addProperty("x2", x2);
//        params.addProperty("y2", y2);
//        String response = this.wxMaService.post("https://api.weixin.qq.com/cgi-bin/account/modifyheadimage", params);
//        return (WxOpenResult)WxOpenGsonBuilder.create().fromJson(response, WxOpenResult.class);
//    }
//
//    public WxOpenResult modifySignature(String signature) throws WxErrorException {
//        JsonObject params = new JsonObject();
//        params.addProperty("signature", signature);
//        String response = this.wxMaService.post("https://api.weixin.qq.com/cgi-bin/account/modifysignature", params);
//        return (WxOpenResult)WxOpenGsonBuilder.create().fromJson(response, WxOpenResult.class);
//    }
//
//    public WxOpenResult componentRebindAdmin(String taskid) throws WxErrorException {
//        JsonObject params = new JsonObject();
//        params.addProperty("taskid", taskid);
//        String response = this.wxMaService.post("https://api.weixin.qq.com/cgi-bin/account/componentrebindadmin", params);
//        return (WxOpenResult)WxOpenGsonBuilder.create().fromJson(response, WxOpenResult.class);
//    }
//
//    public String getAllCategories() throws WxErrorException {
//        return this.wxMaService.get("https://api.weixin.qq.com/cgi-bin/wxopen/getallcategories", "");
//    }
//
//    public WxOpenResult addCategory(List<WxFastMaCategory> categoryList) throws WxErrorException {
//        Map<String, Object> map = new HashMap();
//        map.put("categories", categoryList);
//        String response = this.wxMaService.post("https://api.weixin.qq.com/cgi-bin/wxopen/addcategory", WxOpenGsonBuilder.create().toJson(map));
//        return (WxOpenResult)WxOpenGsonBuilder.create().fromJson(response, WxOpenResult.class);
//    }
//
//    public WxOpenResult deleteCategory(int first, int second) throws WxErrorException {
//        JsonObject params = new JsonObject();
//        params.addProperty("first", first);
//        params.addProperty("second", second);
//        String response = this.wxMaService.post("https://api.weixin.qq.com/cgi-bin/wxopen/deletecategory", params);
//        return (WxOpenResult)WxOpenGsonBuilder.create().fromJson(response, WxOpenResult.class);
//    }
//
//    public WxFastMaBeenSetCategoryResult getCategory() throws WxErrorException {
//        String response = this.wxMaService.get("https://api.weixin.qq.com/cgi-bin/wxopen/getcategory", "");
//        return (WxFastMaBeenSetCategoryResult)WxOpenGsonBuilder.create().fromJson(response, WxFastMaBeenSetCategoryResult.class);
//    }
//
//    public WxOpenResult modifyCategory(WxFastMaCategory category) throws WxErrorException {
//        String response = this.wxMaService.post("https://api.weixin.qq.com/cgi-bin/wxopen/modifycategory", category);
//        return (WxOpenResult)WxOpenGsonBuilder.create().fromJson(response, WxOpenResult.class);
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
//}
