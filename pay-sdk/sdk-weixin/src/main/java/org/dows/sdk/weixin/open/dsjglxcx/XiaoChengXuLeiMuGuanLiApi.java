package org.dows.sdk.weixin.open.dsjglxcx;

import org.dows.sdk.weixin.open.dsjglxcx.request.*;
import org.dows.sdk.weixin.open.dsjglxcx.response.*;

/**
 * 小程序类目管理
 *
 * @author lait.zhang@gmail.com
 * @descr
 * @date 2023年6月3日 上午10:27:31
 */
public interface XiaoChengXuLeiMuGuanLiApi {

    /**
     * 获取可设置的所有类目
     * descr: 本接口可以获取该小程序允许设置的所有类目且仅支持获取一级类目和二级类目，注意不同主体所允许设置的类目不同。使用过程中如遇到问题，可在,发帖交流
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/category-management/getAllCategories.html
     * api: https://api.weixin.qq.com/cgi-bin/wxopen/getallcategories?access_token=ACCESS_TOKEN
     *
     * @param huoQuKeSheZhiDeSuoYouLeiMuRequest
     */
    HuoQuKeSheZhiDeSuoYouLeiMuResponse huoQuKeSheZhiDeSuoYouLeiMu(HuoQuKeSheZhiDeSuoYouLeiMuRequest huoQuKeSheZhiDeSuoYouLeiMuRequest);

    /**
     * 获取已设置的所有类目
     * descr: 使用本接口获取小程序已设置的所有类目。使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/category-management/getSettingCategories.html
     * api: https://api.weixin.qq.com/cgi-bin/wxopen/getcategory?access_token=ACCESS_TOKEN
     *
     * @param huoQuYiSheZhiDeSuoYouLeiMuRequest
     */
    HuoQuYiSheZhiDeSuoYouLeiMuResponse huoQuYiSheZhiDeSuoYouLeiMu(HuoQuYiSheZhiDeSuoYouLeiMuRequest huoQuYiSheZhiDeSuoYouLeiMuRequest);

    /**
     * 获取不同类型主体可设置的类目
     * descr: 本接口用于获取不同主体对应的可设置的类目信息，使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/category-management/getAllCategoriesByType.html
     * api: https://api.weixin.qq.com/cgi-bin/wxopen/getcategoriesbytype?access_token=ACCESS_TOKEN
     *
     * @param huoQuBuTongLeiXingZhuTiKeSheZhiDeLeiMuRequest
     */
    HuoQuBuTongLeiXingZhuTiKeSheZhiDeLeiMuResponse huoQuBuTongLeiXingZhuTiKeSheZhiDeLeiMu(HuoQuBuTongLeiXingZhuTiKeSheZhiDeLeiMuRequest huoQuBuTongLeiXingZhuTiKeSheZhiDeLeiMuRequest);

    /**
     * 添加类目
     * descr: 调用本接口可以给小程序添加类目，添加的类目需要在,中。使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/category-management/addCategory.html
     * api: https://api.weixin.qq.com/cgi-bin/wxopen/addcategory?access_token=ACCESS_TOKEN
     *
     * @param tianJiaLeiMuRequest
     */
    TianJiaLeiMuResponse tianJiaLeiMu(TianJiaLeiMuRequest tianJiaLeiMuRequest);

    /**
     * 删除类目
     * descr: 调用本接口可以删除小程序的指定类目。使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/category-management/deleteCategory.html
     * api: https://api.weixin.qq.com/cgi-bin/wxopen/deletecategory?access_token=ACCESS_TOKEN
     *
     * @param shanChuLeiMuRequest
     */
    ShanChuLeiMuResponse shanChuLeiMu(ShanChuLeiMuRequest shanChuLeiMuRequest);

    /**
     * 修改类目资质信息
     * descr: 通过获取已设置的类目列表接口（getSettingCategories）可以获取当前小程序已设置的类目列表。如果某一下类目审核不通过需要补充或者修改资质信息，可以调用本接口进行处理。使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/category-management/modifyCategory.html
     * api: https://api.weixin.qq.com/cgi-bin/wxopen/modifycategory?access_token=ACCESS_TOKEN
     *
     * @param xiuGaiLeiMuZiZhiXinXiRequest
     */
    XiuGaiLeiMuZiZhiXinXiResponse xiuGaiLeiMuZiZhiXinXi(XiuGaiLeiMuZiZhiXinXiRequest xiuGaiLeiMuZiZhiXinXiRequest);

    /**
     * 获取类目名称信息
     * descr: 接口可获取已设置的二级类目及用于代码审核的可选三级类目。使用过程中如遇到问题，可在,发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/miniprogram-management/category-management/getAllCategoryName.html
     * api: https://api.weixin.qq.com/wxa/get_category?access_token=ACCESS_TOKEN
     *
     * @param huoQuLeiMuMingChengXinXiRequest
     */
    HuoQuLeiMuMingChengXinXiResponse huoQuLeiMuMingChengXinXi(HuoQuLeiMuMingChengXinXiRequest huoQuLeiMuMingChengXinXiRequest);
}