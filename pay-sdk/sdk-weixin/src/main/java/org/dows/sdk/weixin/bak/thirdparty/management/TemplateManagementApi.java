package org.dows.sdk.weixin.bak.thirdparty.management;

import org.dows.sdk.weixin.bak.thirdparty.management.request.AddToTemplateRequest;
import org.dows.sdk.weixin.bak.thirdparty.management.request.DeleteTemplateRequest;
import org.dows.sdk.weixin.bak.thirdparty.management.request.GetTemplateListRequest;
import org.dows.sdk.weixin.bak.thirdparty.management.request.GetTemplatedRaftListRequest;
import org.dows.sdk.weixin.bak.thirdparty.management.response.AddToTemplateResponse;
import org.dows.sdk.weixin.bak.thirdparty.management.response.DeleteTemplateResponse;
import org.dows.sdk.weixin.bak.thirdparty.management.response.GetTemplateListResponse;
import org.dows.sdk.weixin.bak.thirdparty.management.response.GetTemplatedRaftListResponse;

/**
 * @author lait.zhang@gmail.com
 * @description templateManagementApi
 * @date 2023年5月29日 上午11:32:00
 */
public interface TemplateManagementApi {

    /**
     * description:
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/thirdparty-management/template-management/getTemplatedRaftList.html
     * api: https://api.weixin.qq.com/wxa/gettemplatedraftlist?access_token=ACCESS_TOKEN
     *
     * @param getTemplatedRaftListRequest
     */
    GetTemplatedRaftListResponse getTemplatedRaftList(GetTemplatedRaftListRequest getTemplatedRaftListRequest);

    /**
     * description: 该接口用于将草稿添加到模板库设置为持久的代码模板。使用过程中如遇到问题，可在开放发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/thirdparty-management/template-management/addToTemplate.html
     * api: https://api.weixin.qq.com/wxa/addtotemplate?access_token=ACCESS_TOKEN
     *
     * @param addToTemplateRequest
     */
    AddToTemplateResponse addToTemplate(AddToTemplateRequest addToTemplateRequest);

    /**
     * description: 通过该接口可以获取模板库里的模板列表信息。使用过程中如遇到问题，可在发帖交流请求方式是get，不是post。如果之前使用了post请求的用户，请切换成get
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/thirdparty-management/template-management/getTemplateList.html
     * api: https://api.weixin.qq.com/wxa/gettemplatelist?access_token=ACCESS_TOKEN
     *
     * @param getTemplateListRequest
     */
    GetTemplateListResponse getTemplateList(GetTemplateListRequest getTemplateListRequest);

    /**
     * description: 通过该接口可以删除指定的模板。因为代码模板库的模板数量是有上限的，当达到上限或者有某个模板不再需要时，建议调用本接口删除指定的代码模板。使用过程中如遇到问题，可在发帖交流。
     * doc: https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/thirdparty-management/template-management/deleteTemplate.html
     * api: https://api.weixin.qq.com/wxa/deletetemplate?access_token=ACCESS_TOKEN
     *
     * @param deleteTemplateRequest
     */
    DeleteTemplateResponse deleteTemplate(DeleteTemplateRequest deleteTemplateRequest);
}