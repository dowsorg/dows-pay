////
//// Source code recreated from a .class file by IntelliJ IDEA
//// (powered by FernFlower decompiler)
////
//
//package api;
//
//import java.util.List;
//
//import me.chanjar.weixin.common.error.WxErrorException;
//import me.chanjar.weixin.open.bean.ma.WxFastMaCategory;
//import me.chanjar.weixin.open.bean.result.WxFastMaAccountBasicInfoResult;
//import me.chanjar.weixin.open.bean.result.WxFastMaBeenSetCategoryResult;
//import me.chanjar.weixin.open.bean.result.WxFastMaCheckNickameResult;
//import me.chanjar.weixin.open.bean.result.WxFastMaQueryNicknameStatusResult;
//import me.chanjar.weixin.open.bean.result.WxFastMaSetNickameResult;
//import me.chanjar.weixin.open.bean.result.WxOpenResult;
//
//public interface WxOpenMaBasicExtService {
//    String OPEN_GET_ACCOUNT_BASIC_INFO = "https://api.weixin.qq.com/cgi-bin/account/getaccountbasicinfo";
//    String OPEN_SET_NICKNAME = "https://api.weixin.qq.com/wxa/setnickname";
//    String OPEN_API_WXA_QUERYNICKNAME = "https://api.weixin.qq.com/wxa/api_wxa_querynickname";
//    String OPEN_CHECK_WX_VERIFY_NICKNAME = "https://api.weixin.qq.com/cgi-bin/wxverify/checkwxverifynickname";
//    String OPEN_MODIFY_HEADIMAGE = "https://api.weixin.qq.com/cgi-bin/account/modifyheadimage";
//    String OPEN_MODIFY_SIGNATURE = "https://api.weixin.qq.com/cgi-bin/account/modifysignature";
//    String OPEN_COMPONENT_REBIND_ADMIN = "https://api.weixin.qq.com/cgi-bin/account/componentrebindadmin";
//    String OPEN_GET_ALL_CATEGORIES = "https://api.weixin.qq.com/cgi-bin/wxopen/getallcategories";
//    String OPEN_ADD_CATEGORY = "https://api.weixin.qq.com/cgi-bin/wxopen/addcategory";
//    String OPEN_DELETE_CATEGORY = "https://api.weixin.qq.com/cgi-bin/wxopen/deletecategory";
//    String OPEN_GET_CATEGORY = "https://api.weixin.qq.com/cgi-bin/wxopen/getcategory";
//    String OPEN_MODIFY_CATEGORY = "https://api.weixin.qq.com/cgi-bin/wxopen/modifycategory";
//
//    WxFastMaAccountBasicInfoResult getAccountBasicInfo() throws WxErrorException;
//
//    WxFastMaSetNickameResult setNickname(String var0, String var1, String var2, String var3, String var4, String var5) throws WxErrorException;
//
//    WxFastMaQueryNicknameStatusResult querySetNicknameStatus(String var1) throws WxErrorException;
//
//    WxFastMaCheckNickameResult checkWxVerifyNickname(String var1) throws WxErrorException;
//
//    WxOpenResult modifyHeadImage(String var1, float var2, float var3, float var4, float var5) throws WxErrorException;
//
//    WxOpenResult modifySignature(String var1) throws WxErrorException;
//
//    WxOpenResult componentRebindAdmin(String var1) throws WxErrorException;
//
//    String getAllCategories() throws WxErrorException;
//
//    WxOpenResult addCategory(List<WxFastMaCategory> var1) throws WxErrorException;
//
//    WxOpenResult deleteCategory(int var1, int var2) throws WxErrorException;
//
//    WxFastMaBeenSetCategoryResult getCategory() throws WxErrorException;
//
//    WxOpenResult modifyCategory(WxFastMaCategory var1) throws WxErrorException;
//}
