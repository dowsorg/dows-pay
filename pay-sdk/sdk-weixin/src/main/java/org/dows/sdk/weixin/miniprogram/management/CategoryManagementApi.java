package org.dows.sdk.weixin.miniprogram.management;

/**
 * @author lait.zhang@gmail.com
 * @description categoryManagementApi
 */
public interface CategoryManagementApi{

    /**
     * 本接口可以获取该小程序允许设置的所有类目且仅支持获取一级类目和二级类目，注意不同主体所允许设置的类目不同。使用过程中如遇到问题，可在发帖交流
     * https://api.weixin.qq.com/cgi-bin/wxopen/getallcategories?access_token=ACCESS_TOKEN
     * 
     * @param getAllCategoriesRequest
     * 
     */
    GetAllCategoriesResponse getAllCategories(GetAllCategoriesRequest getAllCategoriesRequest);

    /**
     * 使用本接口获取小程序已设置的所有类目。使用过程中如遇到问题，可在发帖交流。
     * https://api.weixin.qq.com/cgi-bin/wxopen/getcategory?access_token=ACCESS_TOKEN
     * 
     * @param getSettingCategoriesRequest
     * 
     */
    GetSettingCategoriesResponse getSettingCategories(GetSettingCategoriesRequest getSettingCategoriesRequest);

    /**
     * 本接口用于获取不同主体对应的可设置的类目信息，使用过程中如遇到问题，可在发帖交流。
     * https://api.weixin.qq.com/cgi-bin/wxopen/getcategoriesbytype?access_token=ACCESS_TOKEN
     * 
     * @param getAllCategoriesByTypeRequest
     * 
     */
    GetAllCategoriesByTypeResponse getAllCategoriesByType(GetAllCategoriesByTypeRequest getAllCategoriesByTypeRequest);

    /**
     * 调用本接口可以给小程序添加类目，添加的类目需要在中。使用过程中如遇到问题，可在发帖交流。
     * https://api.weixin.qq.com/cgi-bin/wxopen/addcategory?access_token=ACCESS_TOKEN
     * 
     * @param addCategoryRequest
     * 
     */
    AddCategoryResponse addCategory(AddCategoryRequest addCategoryRequest);

    /**
     * 调用本接口可以删除小程序的指定类目。使用过程中如遇到问题，可在发帖交流。
     * https://api.weixin.qq.com/cgi-bin/wxopen/deletecategory?access_token=ACCESS_TOKEN
     * 
     * @param deleteCategoryRequest
     * 
     */
    DeleteCategoryResponse deleteCategory(DeleteCategoryRequest deleteCategoryRequest);

    /**
     * 通过获取已设置的类目列表接口（getSettingCategories）可以获取当前小程序已设置的类目列表。如果某一下类目审核不通过需要补充或者修改资质信息，可以调用本接口进行处理。使用过程中如遇到问题，可在发帖交流。
     * https://api.weixin.qq.com/cgi-bin/wxopen/modifycategory?access_token=ACCESS_TOKEN
     * 
     * @param modifyCategoryRequest
     * 
     */
    ModifyCategoryResponse modifyCategory(ModifyCategoryRequest modifyCategoryRequest);

    /**
     * 接口可获取已设置的二级类目及用于代码审核的可选三级类目。使用过程中如遇到问题，可在发帖交流。
     * https://api.weixin.qq.com/wxa/get_category?access_token=ACCESS_TOKEN
     * 
     * @param getAllCategoryNameRequest
     * 
     */
    GetAllCategoryNameResponse getAllCategoryName(GetAllCategoryNameRequest getAllCategoryNameRequest);
}