package org.dows.sdk.weixin.open.xcxllzdyy;

import org.dows.sdk.weixin.open.xcxllzdyy.request.*;
import org.dows.sdk.weixin.open.xcxllzdyy.response.*;

/**
 * 广告位管理
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:27:31
 */
public interface GuangGaoWeiGuanLiApi {

    /**
     * 创建广告单元
     * descr: 该 API 用于为小程序创建广告单元。使用过程中如遇到问题，可在,发帖交流。,其中access_token为
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ams/ad-mgnt/AgencyCreateAdunit.html
     * api: https://api.weixin.qq.com/wxa/operationams?action=agency_create_adunit&access_token=xxxxxxxxxxxxxxx
     *
     * @param chuangJianGuangGaoDanYuanRequest
     */
    ChuangJianGuangGaoDanYuanResponse chuangJianGuangGaoDanYuan(ChuangJianGuangGaoDanYuanRequest chuangJianGuangGaoDanYuanRequest);

    /**
     * 更新广告单元
     * descr: 该 API 用于为小程序更新广告单元。使用过程中如遇到问题，可在,发帖交流。,其中access_token为
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ams/ad-mgnt/AgencyUpdateAdunit.html
     * api: https://api.weixin.qq.com/wxa/operationams?action=agency_update_adunit&access_token=xxxxxxxxxxxxxxx
     *
     * @param gengXinGuangGaoDanYuanRequest
     */
    GengXinGuangGaoDanYuanResponse gengXinGuangGaoDanYuan(GengXinGuangGaoDanYuanRequest gengXinGuangGaoDanYuanRequest);

    /**
     * 获取原生模板广告模板类型
     * descr: 该 API 用于查询原生模板广告模板类型。使用过程中如遇到问题，可在,发帖交流。,其中access_token为
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ams/ad-mgnt/AgencyGetTmplType.html
     * api: https://api.weixin.qq.com/wxa/operationams?action=agency_get_tmpl_type&access_token=xxxxxxxxxxxxxxx
     *
     * @param huoQuYuanShengMoBanGuangGaoMoBanLeiXingRequest
     */
    HuoQuYuanShengMoBanGuangGaoMoBanLeiXingResponse huoQuYuanShengMoBanGuangGaoMoBanLeiXing(HuoQuYuanShengMoBanGuangGaoMoBanLeiXingRequest huoQuYuanShengMoBanGuangGaoMoBanLeiXingRequest);

    /**
     * 获取原生模板广告自定义模板绑定情况
     * descr: 该 API 用于查询服务商自定义创建的原生模板绑定的广告单元列表。使用过程中如遇到问题，可在,发帖交流。,其中access_token为,1、当仅需要获取原生模板广告自定义模板信息时，不需要传递ad_unit_id及is_return_tmpl_bind_list参数；当需要获取某个自定义模板绑定的商户广告单元信息时，需要传递ad_unit_id及is_return_tmpl_bind_list参数。返回的广告单元列表按照创建时间倒序，用户请以分页的形式获取。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ams/ad-mgnt/GetAgencyTmplIdList.html
     * api: https://api.weixin.qq.com/wxa/operationams?action=get_agency_ad_unit_list&access_token=xxxxxxxxxxxxxxx
     *
     * @param huoQuYuanShengMoBanGuangGaoZiDingYiMoBanBangDingQingKuangRequest
     */
    HuoQuYuanShengMoBanGuangGaoZiDingYiMoBanBangDingQingKuangResponse huoQuYuanShengMoBanGuangGaoZiDingYiMoBanBangDingQingKuang(HuoQuYuanShengMoBanGuangGaoZiDingYiMoBanBangDingQingKuangRequest huoQuYuanShengMoBanGuangGaoZiDingYiMoBanBangDingQingKuangRequest);

    /**
     * 设置封面广告位开关状态
     * descr: 该 API 用于设置小程序封面广告位开关状态。使用过程中如遇到问题，可在,发帖交流。,其中access_token为
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ams/ad-mgnt/SetCoverAdposStatus.html
     * api: https://api.weixin.qq.com/wxa/operationams?action=agency_set_cover_adpos_status&access_token=xxxxxxxxxxxxxxx
     *
     * @param sheZhiFengMianGuangGaoWeiKaiGuanZhuangTaiRequest
     */
    SheZhiFengMianGuangGaoWeiKaiGuanZhuangTaiResponse sheZhiFengMianGuangGaoWeiKaiGuanZhuangTai(SheZhiFengMianGuangGaoWeiKaiGuanZhuangTaiRequest sheZhiFengMianGuangGaoWeiKaiGuanZhuangTaiRequest);

    /**
     * 设置封面广告位场景值
     * descr: 该 API 用于设置小程序封面广告位场景值。使用过程中如遇到问题，可在,发帖交流。,其中access_token为,1、封面广告场景值可选值，以逗号分隔：1000,1001,1007,1008,1010,1011,1012,1013,1014,1017,1019,1022,1023,1024,1025,1026,1028,1029,1030,1031,1032,1034,1036,1037,1038,1039,1043,1044,1045,1046,1047,1048,1049,1052,1056,1057,1059,1060,1064,1065,1067,1068,1069,1071,1072,1073,1077,1078,1079,1081,1084,1088,1090,1092,1095,1096,1097,1099,1100,1103,1104,1107,1113,1114,1119,1120,1121,1124,1125,1126,1129,1131,1133,1135,1145,1146,1148,1150,1151,1153,1154,1155,1157,1158,1160,1167,1169,1171,1173,1175,1177,1185,1186,1187,1189,1191,1192,1020,1035,1058,1074,1082,1091,1102,1144,1152,1005,1006,1027,1042,1053,1054,1106,1089,1242,1245,1208,1168,1194,1252,1176,1184,1193,1195,1197,1198,1206,1216,1179,1202,1207,1231,1196,1223,1200,1201,1215,1228,1230,2、开启封面广告后，默认场景值全选（11.15之前默认值为以下33个） 1001,1026,1089,1103,1104,1145,1169,1005,1006,1027,1042,1053,1054,1106,1007,1008,1036,1044,1035,1102,1144,1152,1010,1023,1028,1113,1114,1146,1167,1088,1096,1158,1160,备注：场景值定义参考见
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ams/ad-mgnt/SetCoverAdposScene.html
     * api: https://api.weixin.qq.com/wxa/operationams?action=agency_set_cover_adpos_scene&access_token=xxxxxxxxxxxxxxx
     *
     * @param sheZhiFengMianGuangGaoWeiChangJingZhiRequest
     */
    SheZhiFengMianGuangGaoWeiChangJingZhiResponse sheZhiFengMianGuangGaoWeiChangJingZhi(SheZhiFengMianGuangGaoWeiChangJingZhiRequest sheZhiFengMianGuangGaoWeiChangJingZhiRequest);

    /**
     * 获取封面广告位状态
     * descr: 该 API 用于查询小程序封面广告位状态。使用过程中如遇到问题，可在,发帖交流。,其中access_token为
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ams/ad-mgnt/GetCoverAdposStatus.html
     * api: https://api.weixin.qq.com/wxa/operationams?action=agency_get_cover_adpos_status&access_token=xxxxxxxxxxxxxxx
     *
     * @param huoQuFengMianGuangGaoWeiZhuangTaiRequest
     */
    HuoQuFengMianGuangGaoWeiZhuangTaiResponse huoQuFengMianGuangGaoWeiZhuangTai(HuoQuFengMianGuangGaoWeiZhuangTaiRequest huoQuFengMianGuangGaoWeiZhuangTaiRequest);

    /**
     * 获取封面广告位场景设置
     * descr: 该 API 用于查询小程序封面广告场景值。使用过程中如遇到问题，可在,发帖交流。,其中access_token为
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ams/ad-mgnt/GetCoverAdposScene.html
     * api: https://api.weixin.qq.com/wxa/operationams?action=agency_get_cover_adpos_scene&access_token=xxxxxxxxxxxxxxx
     *
     * @param huoQuFengMianGuangGaoWeiChangJingSheZhiRequest
     */
    HuoQuFengMianGuangGaoWeiChangJingSheZhiResponse huoQuFengMianGuangGaoWeiChangJingSheZhi(HuoQuFengMianGuangGaoWeiChangJingSheZhiRequest huoQuFengMianGuangGaoWeiChangJingSheZhiRequest);

    /**
     * 获取广告位（除封面广告位）或指定广告单元的信息
     * descr: 该 API 用于查询广告位（除封面广告位）或指定广告单元的信息。使用过程中如遇到问题，可在,发帖交流。,其中access_token为,1、返回的广告单元列表按照创建时间倒序，用户请以分页的形式获取。当需要获取全部广告位的清单时，无需传递广告位类型名称及广告单元ID；当需要获取某类型广告位的清单时，仅需传递广告位类型名称；当需要获取某广告位 id 的数据时，仅需传递广告单元ID。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ams/ad-mgnt/GetAdunitList.html
     * api: https://api.weixin.qq.com/wxa/operationams?action=agency_get_adunit_list&access_token=xxxxxxxxxxxxxxx
     *
     * @param huoQuGuangGaoWei（ChuFengMianGuangGaoWei）HuoZhiDingGuangGaoDanYuanDeXinXiRequest
     *
     */
/*    HuoQuGuangGaoWei（ChuFengMianGuangGaoWei）
    HuoZhiDingGuangGaoDanYuanDeXinXiResponse huoQuGuangGaoWei（ChuFengMianGuangGaoWei）

    HuoZhiDingGuangGaoDanYuanDeXinXi(HuoQuGuangGaoWei（ChuFengMianGuangGaoWei）HuoZhiDingGuangGaoDanYuanDeXinXiRequest huoQuGuangGaoWei（ChuFengMianGuangGaoWei）HuoZhiDingGuangGaoDanYuanDeXinXiRequest);*/

    /**
     * 获取广告单元代码
     * descr: 该 API 用于查询广告单元代码。使用过程中如遇到问题，可在,发帖交流。,其中access_token为
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ams/ad-mgnt/GetAdunitCode.html
     * api: https://api.weixin.qq.com/wxa/operationams?action=agency_get_adunit_code&access_token=xxxxxxxxxxxxxxx
     *
     * @param huoQuGuangGaoDanYuanDaiMaRequest
     */
    HuoQuGuangGaoDanYuanDaiMaResponse huoQuGuangGaoDanYuanDaiMa(HuoQuGuangGaoDanYuanDaiMaRequest huoQuGuangGaoDanYuanDaiMaRequest);
}