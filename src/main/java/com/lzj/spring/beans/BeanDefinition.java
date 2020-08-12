package com.lzj.spring.beans;

import java.util.List;

public interface BeanDefinition {
    public static final String SCOPE_SINGLETON = "singleton";
    public static final String SCOPE_PROTOTYPE = "prototype";
    public static final String SCOPE_DEFAULT = "";
    String getBeanClassName();
    String getScope();
    void setScope(String scope);
    public boolean isSingleton();
    public boolean isProtoType();
    public  void setPropertyValue(PropertyValue propertyValue);
    public List<PropertyValue> getProperty();

}
