package org.dows.sdk.weixin.open1;

/**
 * @description 
 * @author lait.zhang@gmail.com
 * @date  2023年6月2日 下午2:52:10
 */
public interface 模板库管理Api{

    /**
     * description: 
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//doc/oplatform/openApi/OpenApiDoc/thirdparty-management/template-management/getTemplatedRaftList.html
     * api: https://api.weixin.qq.com/wxa/gettemplatedraftlist?access_token=ACCESS_TOKEN
     * 
     * @param 获取草稿箱列表Request
     * 
     */
    获取草稿箱列表Response 获取草稿箱列表(获取草稿箱列表Request 获取草稿箱列表Request);

    /**
     * description: 该接口用于将草稿添加到模板库设置为持久的代码模板。使用过程中如遇到问题，可在开放,发帖交流。
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//doc/oplatform/openApi/OpenApiDoc/thirdparty-management/template-management/addToTemplate.html
     * api: https://api.weixin.qq.com/wxa/addtotemplate?access_token=ACCESS_TOKEN
     * 
     * @param 将草稿添加到模板库Request
     * 
     */
    将草稿添加到模板库Response 将草稿添加到模板库(将草稿添加到模板库Request 将草稿添加到模板库Request);

    /**
     * description: 通过该接口可以获取模板库里的模板列表信息。使用过程中如遇到问题，可在,发帖交流,请求方式是get，不是post。如果之前使用了post请求的用户，请切换成get
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//doc/oplatform/openApi/OpenApiDoc/thirdparty-management/template-management/getTemplateList.html
     * api: https://api.weixin.qq.com/wxa/gettemplatelist?access_token=ACCESS_TOKEN
     * 
     * @param 获取模板列表Request
     * 
     */
    获取模板列表Response 获取模板列表(获取模板列表Request 获取模板列表Request);

    /**
     * description: 通过该接口可以删除指定的模板。因为代码模板库的模板数量是有上限的，当达到上限或者有某个模板不再需要时，建议调用本接口删除指定的代码模板。使用过程中如遇到问题，可在,发帖交流。
     * doc: https://pay.weixin.qq.com/wiki/doc/apiv3/apis//doc/oplatform/openApi/OpenApiDoc/thirdparty-management/template-management/deleteTemplate.html
     * api: https://api.weixin.qq.com/wxa/deletetemplate?access_token=ACCESS_TOKEN
     * 
     * @param 删除代码模板Request
     * 
     */
    删除代码模板Response 删除代码模板(删除代码模板Request 删除代码模板Request);
}