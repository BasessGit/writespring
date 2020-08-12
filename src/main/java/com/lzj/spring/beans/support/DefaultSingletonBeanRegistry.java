package com.lzj.spring.beans.support;

import com.lzj.spring.beans.SingletonBeanRegistry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private Map<String,Object> isSingletonMap = new ConcurrentHashMap<>();

    @Override
    public void registrySingleton(String beanId, Object singletonBean) {
        if (singletonBean == isSingletonMap.get(beanId)){
            throw  new  IllegalArgumentException("该对象已存在，请勿重复注册");
        }
        isSingletonMap.put(beanId,singletonBean);
        }


    @Override
    public Object getSingletonBean(String beanId) {
        return  isSingletonMap.get(beanId);
    }
}
