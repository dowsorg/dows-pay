package org.dows.sdk.weixin.miniprogram.management;

import org.dows.sdk.weixin.miniprogram.management.request.*;
import org.dows.sdk.weixin.miniprogram.management.response.*;

/**
 * @author
 * @description 调用方式以及出入参和HTTPS相同，仅是调用的token不同该接口所属的权限集id为：30、61服务商获得其中之一权限集授权后，可通过使用代商家进行调用
 * @date
 */
public interface CategoryManagementApi {
    /**
     * 本接口可以获取该小程序允许设置的所有类目且仅支持获取一级类目和二级类目，注意不同主体所允许设置的类目不同。使用过程中如遇到问题，可在发帖交流
     *
     * @param getAllCategoriesRequest
     */
    GetAllCategoriesResponse getAllCategories(GetAllCategoriesRequest getAllCategoriesRequest);

    /**
     * 使用本接口获取小程序已设置的所有类目。使用过程中如遇到问题，可在发帖交流。
     *
     * @param getSettingCategoriesRequest
     */
    GetSettingCategoriesResponse getSettingCategories(GetSettingCategoriesRequest getSettingCategoriesRequest);

    /**
     * 本接口用于获取不同主体对应的可设置的类目信息，使用过程中如遇到问题，可在发帖交流。
     *
     * @param getAllCategoriesByTypeRequest
     */
    GetAllCategoriesByTypeResponse getAllCategoriesByType(GetAllCategoriesByTypeRequest getAllCategoriesByTypeRequest);

    /**
     * 调用本接口可以给小程序添加类目，添加的类目需要在中。使用过程中如遇到问题，可在发帖交流。
     *
     * @param addCategoryRequest
     */
    AddCategoryResponse addCategory(AddCategoryRequest addCategoryRequest);

    /**
     * 调用本接口可以删除小程序的指定类目。使用过程中如遇到问题，可在发帖交流。
     *
     * @param deleteCategoryRequest
     */
    DeleteCategoryResponse deleteCategory(DeleteCategoryRequest deleteCategoryRequest);

    /**
     * 通过获取已设置的类目列表接口（getSettingCategories）可以获取当前小程序已设置的类目列表。如果某一下类目审核不通过需要补充或者修改资质信息，可以调用本接口进行处理。使用过程中如遇到问题，可在发帖交流。
     *
     * @param modifyCategoryRequest
     */
    ModifyCategoryResponse modifyCategory(ModifyCategoryRequest modifyCategoryRequest);

    /**
     * 接口可获取已设置的二级类目及用于代码审核的可选三级类目。使用过程中如遇到问题，可在发帖交流。
     *
     * @param getAllCategoryNameRequest
     */
    GetAllCategoryNameResponse getAllCategoryName(GetAllCategoryNameRequest getAllCategoryNameRequest);

}
