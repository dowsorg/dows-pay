package org.dows.pay.spider.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.dows.pay.spider.schema.BeanSchema;

import java.util.HashMap;
import java.util.Map;

/**
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ aaa/bbb-cloudrun-batch/cloudenv-mgnt/ getShareCloudbaseEnv.html
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/aaa/cloudrun-batch/cloudenv-mgnt/getShareCloudbaseEnv.html
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/cloudrun-batch/cloudenv-mgnt/getShareCloudbaseEnv.html
 * https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/ ticket-token/ startPushTicket.html
 */
@Data
@Slf4j
public class WeixinDeveloperLinkModel {

    private final static Map<String, BeanSchema> beanSchemaMap = new HashMap<>();
    private final String root = "https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/";
    private String href;
    private String name;


    public void setHref(String href) {
        this.href = "https://developers.weixin.qq.com" + href;

    }

    public BeanSchema getBeanSchema() {
        String pkgBeanMethod = href.substring(root.length(), href.lastIndexOf("."));
        int methodIndex = pkgBeanMethod.lastIndexOf("/");
        String method = pkgBeanMethod.substring(methodIndex + 1);
        String pkgBean = pkgBeanMethod.substring(0, methodIndex);
        int beanIndex = pkgBean.lastIndexOf("/");
        String bean = pkgBean.substring(beanIndex + 1);

        BeanSchema beanSchema = beanSchemaMap.get(bean);

        if (beanSchema == null) {
            beanSchema = new BeanSchema();
            if (beanIndex > 0) {
                String pkg = pkgBean.substring(0, beanIndex);
                beanSchema.setPkg(pkg);
            }
            beanSchema.setName(bean);
            beanSchemaMap.put(bean, beanSchema);
        }
        return beanSchema;
    }


    public static void main(String[] args) {
        WeixinDeveloperLinkModel weixinLinkSchema = new WeixinDeveloperLinkModel();
        weixinLinkSchema.setHref("https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/aaa/cloudrun-batch/cloudenv-mgnt/getShareCloudbaseEnv.html");
        BeanSchema beanSchema = weixinLinkSchema.getBeanSchema();
        log.info("...{}", beanSchema);
    }


}
