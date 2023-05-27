package org.dows.pay.spider.config;

import cn.hutool.core.util.EnumUtil;
import cn.hutool.extra.template.TemplateConfig;
import cn.hutool.extra.template.TemplateEngine;
import cn.hutool.extra.template.TemplateUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MindcoderConfig {

    @Bean
    public TemplateEngine templateEngine() {
        TemplateConfig.ResourceMode resourceMode = EnumUtil.fromString(TemplateConfig.ResourceMode.class, "CLASSPATH");
        TemplateConfig templateConfig = new TemplateConfig("/ftl", resourceMode);
        TemplateEngine templateEngine = TemplateUtil.createEngine(templateConfig);
        return templateEngine;
    }
}