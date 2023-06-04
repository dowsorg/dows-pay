package org.dows.sdk.client.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;
import java.util.Set;

@Slf4j
public class ApiClassPathBeanDefinitionScanner extends ClassPathBeanDefinitionScanner implements BeanFactoryAware {

    private BeanFactory beanFactory;

    public ApiClassPathBeanDefinitionScanner(BeanDefinitionRegistry registry) {
        super(registry);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    public void register() {
        addIncludeFilter(new TypeFilter() {
            public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
                //只支持接口
                return true;
            }
        });
    }

    protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
        Set<BeanDefinitionHolder> beanDefinitionHolders = super.doScan(basePackages);
        //ApiService apiService = new ApiService();
        //apiService.setApiUrlProperties(beanFactory.getBean(ApiUrlProperties.class));
        for (BeanDefinitionHolder holder : beanDefinitionHolders) {
            GenericBeanDefinition definition = (GenericBeanDefinition) holder.getBeanDefinition();

            try {
                Class<?> clazz = Class.forName(definition.getBeanClassName());
                definition.getPropertyValues().add("targetClass", clazz);
                //definition.getPropertyValues().add("apiService", apiService);
                definition.setBeanClass(ApiFactoryBean.class);
            } catch (ClassNotFoundException e) {
                log.error("class not found! className [{}]", definition.getBeanClassName(), e);
                throw new RuntimeException("class not found!");
            }
        }
        return beanDefinitionHolders;
    }

    @Override
    protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
        return (beanDefinition.getMetadata().isInterface() && beanDefinition.getMetadata().isIndependent());
    }


}
