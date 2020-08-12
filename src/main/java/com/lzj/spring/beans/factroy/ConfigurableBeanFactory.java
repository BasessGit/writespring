package com.lzj.spring.beans.factroy;

public interface ConfigurableBeanFactory  extends  BeanFactory{
    public  void  setClassLoader(ClassLoader classLoader);
    public ClassLoader getClassLoader();

}
