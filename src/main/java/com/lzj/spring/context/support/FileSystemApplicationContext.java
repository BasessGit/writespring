package com.lzj.spring.context.support;

import com.lzj.spring.beans.factroy.xml.XmlBeanDefinitionReader;
import com.lzj.spring.beans.support.DefaultBeanFactory;
import com.lzj.spring.context.ApplicationContext;
import com.lzj.spring.core.Resource;
import com.lzj.spring.core.supprot.AbsolutePathResource;

public class FileSystemApplicationContext extends  AbstractApplicationContext {


    public FileSystemApplicationContext(String config) {
        super(config);
    }

    @Override
    public Resource getResource(String config) {
        return  new AbsolutePathResource(config,this.getClassLoader());
    }
}
