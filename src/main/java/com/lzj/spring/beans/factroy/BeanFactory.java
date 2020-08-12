package com.lzj.spring.beans.factroy;

import com.lzj.spring.beans.BeanDefinition;

public interface BeanFactory {

  Object getBean(String beanId);
}
