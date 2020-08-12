package com.lzj.spring.beans.factroy;

import com.lzj.spring.beans.BeanDefinition;

public interface BeanDefinitionResgistry {
    BeanDefinition getBeanDefinition(String beanName);
    void registerBeanDefinition(String beanId, BeanDefinition beanDefinition);
}
