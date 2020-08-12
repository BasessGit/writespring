package com.lzj.spring.beans.support;

import com.lzj.spring.beans.BeanDefinition;
import com.lzj.spring.beans.PropertyValue;

import java.util.ArrayList;
import java.util.List;

public class GenericBeanDefinition implements BeanDefinition {
    private  String beanId;
    private  String beanName;
    private  String scope;
    private  boolean  isDefaultIsPrototype=  false;
    private boolean isDefaultSingleton =  true;

    private List<PropertyValue> propertyValues = new ArrayList<>();

    public GenericBeanDefinition(String beanId, String beanName) {
            this.beanId = beanId;
            this.beanName = beanName;
}


    @Override
    public String getBeanClassName() {
        return  this.beanName;
    }


    @Override
    public String getScope() {
        return this.scope;
    }

    @Override
    public void setScope(String scope) {
        this.scope = scope;
        this.isDefaultSingleton = SCOPE_DEFAULT.equals(scope) || SCOPE_SINGLETON.equals(scope);
        this.isDefaultIsPrototype = SCOPE_PROTOTYPE.equals(scope);

    }


    @Override
    public boolean isSingleton() {
        return  isDefaultSingleton;
    }

    @Override
    public boolean isProtoType() {
        return isDefaultIsPrototype;
    }

    @Override
    public void setPropertyValue(PropertyValue propertyValue) {
        this.propertyValues.add(propertyValue);
    }

    @Override
    public List<PropertyValue> getProperty() {
        return this.propertyValues;
    }
}
