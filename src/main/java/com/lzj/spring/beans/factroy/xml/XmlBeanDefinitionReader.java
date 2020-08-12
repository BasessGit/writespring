package com.lzj.spring.beans.factroy.xml;

import com.lzj.spring.beans.BeanDefinition;
import com.lzj.spring.beans.PropertyValue;
import com.lzj.spring.beans.RuntimeBeanReference;
import com.lzj.spring.beans.TypeStringValue;
import com.lzj.spring.beans.factroy.BeanDefinitionResgistry;
import com.lzj.spring.beans.factroy.BeanDefinitionStoreException;

import com.lzj.spring.beans.support.GenericBeanDefinition;
import com.lzj.spring.core.Resource;
import com.sun.org.apache.bcel.internal.generic.ARETURN;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class XmlBeanDefinitionReader {
    private static final String ID_ATTRIBUTE = "id";
    private static final String CLASS_ATTRIBUTE= "class";
    private  static final String SCOPE_ATTRIBUTE = "scope";
    public static final String  PROPERTY_ELEMENT = "property";
    public static final String NAME_ATTRIBUTE = "name";
    public static final String REF_ATTRIBUTE = "ref";
    public static final String VALUE_ATTRIBUTE ="value";

    private BeanDefinitionResgistry beanDefinitionResgistry;

    public XmlBeanDefinitionReader(BeanDefinitionResgistry beanDefinitionResgistry) {
        this.beanDefinitionResgistry = beanDefinitionResgistry;
    }

    public void loadBeanDefinition(Resource resource) {
        InputStream inputStream = null;

        try {
            inputStream = resource.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        SAXReader reader = new SAXReader();
        Document document = null;

        try {
            document = reader.read(inputStream);
        } catch (DocumentException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                throw new BeanDefinitionStoreException( "文件解析异常", e);
            }
        }
        Element element = document.getRootElement();

        Iterator<Element> elementIterator = element.elementIterator();
        BeanDefinition beanDefinition = null;
        while (elementIterator.hasNext()) {

            element = elementIterator.next();
            String beanId = element.attributeValue(ID_ATTRIBUTE);
            String beanClassName = element.attributeValue(CLASS_ATTRIBUTE);
            beanDefinition = new GenericBeanDefinition(beanId,beanClassName);
            String scope = null;
            if(element.attributeValue(SCOPE_ATTRIBUTE) != null){
               scope  = element.attributeValue(SCOPE_ATTRIBUTE);
               beanDefinition.setScope(scope);
            }
            getProperty(element,beanDefinition);
            beanDefinitionResgistry.registerBeanDefinition(beanId, beanDefinition);
        }
    }

    private void getProperty(Element element, BeanDefinition beanDefinition) {
      Iterator<Element> elementIterator =   element.elementIterator(PROPERTY_ELEMENT);
      while (elementIterator.hasNext()){
          Element propertyElement = elementIterator.next();
          String name = propertyElement.attributeValue(NAME_ATTRIBUTE);
           if(name == null || name.isEmpty()){
               throw  new RuntimeException("name属性不能够为空");
           }
           Object value = parsePropertyValue(propertyElement);
          PropertyValue propertyValue = new PropertyValue(name,value);
           beanDefinition.setPropertyValue(propertyValue);
      }
    }

    private Object parsePropertyValue(Element propertyElement) {
        boolean hasRefProperty = propertyElement.attributeValue(REF_ATTRIBUTE) != null;
        boolean hasValueAttribute = propertyElement.attributeValue(VALUE_ATTRIBUTE) != null;
        if(hasRefProperty){
            String refValue  = propertyElement.attributeValue(REF_ATTRIBUTE);
            RuntimeBeanReference reference = new RuntimeBeanReference(refValue);
            return reference;
        }else  if (hasValueAttribute){
            String stringValue = propertyElement.attributeValue(VALUE_ATTRIBUTE);
            TypeStringValue stringType = new TypeStringValue(stringValue);
            return  stringType;
        }else {
            throw  new RuntimeException("为获取到ref/value属性");
        }
    }

}


