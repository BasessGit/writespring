package com.lzj.spring.context.support;

import com.lzj.spring.beans.factroy.xml.XmlBeanDefinitionReader;
import com.lzj.spring.beans.support.DefaultBeanFactory;
import com.lzj.spring.context.ApplicationContext;
import com.lzj.spring.core.Resource;
import com.lzj.spring.core.supprot.ClassPathResource;
import com.lzj.spring.utils.ClassUtil;
import com.sun.corba.se.impl.presentation.rmi.StubInvocationHandlerImpl;

public abstract class  AbstractApplicationContext  implements ApplicationContext {
    private DefaultBeanFactory defaultBeanFactory = null;
    private ClassLoader classLoader;

    public AbstractApplicationContext(String config) {
        defaultBeanFactory = new DefaultBeanFactory();
        XmlBeanDefinitionReader reader  = new XmlBeanDefinitionReader(defaultBeanFactory);
        reader.loadBeanDefinition(this.getResource(config));
        defaultBeanFactory.setClassLoader(this.getClassLoader());
    }


    @Override
    public void setClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public ClassLoader getClassLoader() {
        return this.classLoader != null ? this.classLoader : ClassUtil.getClassLoader();
    }


    @Override
    public Object getBean(String beanId) {
        return defaultBeanFactory.getBean(beanId);
    }

    public  abstract  Resource getResource(String config);
}
