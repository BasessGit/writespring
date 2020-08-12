package com.lzj.spring.beans.support;


import com.lzj.spring.beans.BeanDefinition;
import com.lzj.spring.beans.factroy.BeanCreatException;
import com.lzj.spring.beans.factroy.BeanDefinitionResgistry;
import com.lzj.spring.beans.factroy.BeanFactory;
import com.lzj.spring.beans.factroy.ConfigurableBeanFactory;
import com.lzj.spring.utils.ClassUtil;

import java.util.HashMap;
import java.util.Map;


public class DefaultBeanFactory extends DefaultSingletonBeanRegistry  implements ConfigurableBeanFactory, BeanDefinitionResgistry {

    private  Map<String,BeanDefinition> beanDefinitionHashMap  = new HashMap<>();

    private ClassLoader classLoader;



    @Override
    public BeanDefinition getBeanDefinition(String beanName) {
        return beanDefinitionHashMap.get(beanName);
    }

    @Override
    public void registerBeanDefinition(String beanId, BeanDefinition beanDefinition) {
            beanDefinitionHashMap.put(beanId,beanDefinition);
    }


    @Override
    public Object getBean(String beanId) {
       BeanDefinition beanDefinition = beanDefinitionHashMap.get(beanId);
        if (null == beanDefinition){
            return  null;
        }
        if (beanDefinition.isSingleton()){
           Object isSingletonBean = this.getSingletonBean(beanId);
           if (null == isSingletonBean){
               this.registrySingleton(beanId,creatBean(beanDefinition));
               isSingletonBean = this.getSingletonBean(beanId);
           }
           return  isSingletonBean;
       }
       return  creatBean(beanDefinition);

    }

    private Object  creatBean(  BeanDefinition beanDefinition){
     String beanClassName = beanDefinition.getBeanClassName();
        try {
            return  this.classLoader.loadClass(beanClassName).newInstance();
        } catch (Exception e) {
           throw   new BeanCreatException("创建"+beanDefinition.getBeanClassName()+"失败",  e);
        }
    }

    @Override
    public void setClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public ClassLoader getClassLoader() {
        return  this.classLoader != null ? this.classLoader :ClassUtil.getClassLoader();
    }
}
