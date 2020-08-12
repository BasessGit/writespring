package com.lzj.spring.beans;

public interface SingletonBeanRegistry {
    void registrySingleton(String beanId, Object singletonBean);
    Object getSingletonBean(String beanId);
}
