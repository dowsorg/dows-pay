package org.dows.pay.spider.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.dows.pay.spider.schema.BeanSchema;

import java.util.HashMap;
import java.util.Map;

/**
 * https://pay.weixin.qq.com/wiki/doc/apiv3_partner/apis/chapter11_1_1.shtml
 * https://pay.weixin.qq.com/wiki/doc/apiv3_partner/apis/chapter4_1_1.shtml
 * https://pay.weixin.qq.com/wiki/doc/apiv3_partner/apis/chapter4_1_2.shtml
 */
@Data
@Slf4j
public class WeixinPayLinkModel {

    private final static Map<String, BeanSchema> beanSchemaMap = new HashMap<>();
    private final String root = "https://pay.weixin.qq.com/wiki/doc/apiv3_partner/apis/";
    private String href;
    private String name;

    public void setHref(String href) {
        if (href.startsWith("http")) {
            this.href = href;
        } else {
            this.href = root + href;
        }
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
        WeixinPayLinkModel weixinLinkSchema = new WeixinPayLinkModel();
        weixinLinkSchema.setHref("https://developers.weixin.qq.com/doc/oplatform/openApi/OpenApiDoc/aaa/cloudrun-batch/cloudenv-mgnt/getShareCloudbaseEnv.html");
        BeanSchema beanSchema = weixinLinkSchema.getBeanSchema();
        log.info("...{}", beanSchema);
    }


}
