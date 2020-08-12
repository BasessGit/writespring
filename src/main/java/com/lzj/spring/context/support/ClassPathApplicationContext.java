package com.lzj.spring.context.support;

import com.lzj.spring.beans.factroy.xml.XmlBeanDefinitionReader;
import com.lzj.spring.beans.support.DefaultBeanFactory;
import com.lzj.spring.context.ApplicationContext;
import com.lzj.spring.core.Resource;
import com.lzj.spring.core.supprot.AbsolutePathResource;
import com.lzj.spring.core.supprot.ClassPathResource;

public class ClassPathApplicationContext  extends  AbstractApplicationContext{

    public ClassPathApplicationContext(String config) {
        super(config);

    }

    @Override
    public Resource getResource(String config) {
        return  new ClassPathResource(config,this.getClassLoader());
    }
}
