package org.dows.sdk.client.core;

import org.dows.sdk.client.ApiScan;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

public class ApiScannerRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        AnnotationAttributes apiScanAttrs = AnnotationAttributes
                .fromMap(importingClassMetadata.getAnnotationAttributes(ApiScan.class.getName()));
        String[] scanPackages = apiScanAttrs.getStringArray("scanPackages");
        String[] urlLocations = apiScanAttrs.getStringArray("urlLocations");

        ApiClassPathBeanDefinitionScanner scanner = new ApiClassPathBeanDefinitionScanner(registry);
        scanner.register();
        scanner.doScan(scanPackages);
    }

}
