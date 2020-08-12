package com.lzj.test.v1;


import com.lzj.spring.beans.BeanDefinition;
import com.lzj.spring.beans.factroy.xml.XmlBeanDefinitionReader;
import com.lzj.spring.beans.support.DefaultBeanFactory;
import com.lzj.spring.context.ApplicationContext;
import com.lzj.spring.context.support.ClassPathApplicationContext;
import com.lzj.spring.context.support.FileSystemApplicationContext;
import com.lzj.test.v1.bean.TestService;
import org.junit.Test;

public class TestSpring {
  /*  @Test
    public  void test1(){
        BeanFactory factory = new DefaultBeanFactory("spring_v1.xml");
       BeanDefinition beanDefinition =  factory.getBeanDefinition("testService");
      String beanClassName =  beanDefinition.getBeanClassName();
       if("com.lzj.test.v1.bean.TestService".equals(beanClassName)){
           System.out.println("true");
       }
      TestService testService = (TestService) factory.getBean("testService");
       testService.print();
    }*/


/*    @Test
    public  void test2(){
        DefaultBeanFactory defaultBeanFactory = new DefaultBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(defaultBeanFactory);
        reader.loadBeanDefinition("spring_v1.xml");
        BeanDefinition definition = defaultBeanFactory.getBeanDefinition("testService");
        String beanClassName = definition.getBeanClassName();
        if("com.lzj.test.v1.bean.TestService".equals(beanClassName)){
            System.out.println("true");
        }
        TestService testService = (TestService) defaultBeanFactory.getBean("testService");
        testService.print();


    }

 */
    @Test
    public void testClassPathApplication(){
        ApplicationContext applicationContext = new ClassPathApplicationContext("spring_v1.xml");
        TestService testService = (TestService) applicationContext.getBean("testService");
        testService.print();
    }

    @Test
    public  void testFileSystemPathApplication(){
        ApplicationContext applicationContext = new FileSystemApplicationContext("E:\\IDEA\\writespring\\src\\test\\resources\\spring_v1.xml");
        TestService testService = (TestService) applicationContext.getBean("testService");
        testService.print();
    }
    @Test
    public void testScope(){
        ApplicationContext applicationContext = new FileSystemApplicationContext("E:\\IDEA\\writespring\\src\\test\\resources\\spring_v1.xml");
        TestService testService1 = (TestService) applicationContext.getBean("testService");
        TestService testService2 = (TestService) applicationContext.getBean("testService");
        TestService testService3 = (TestService) applicationContext.getBean("testService");
        System.out.println(testService1 +"," +testService2+","+testService3);
    }
    @Test
    public  void testScope1(){
        ApplicationContext applicationContext = new ClassPathApplicationContext("spring_v1.xml");
        TestService testService = (TestService) applicationContext.getBean("testService");
       TestService testService1 = (TestService) applicationContext.getBean("testService");
        System.out.println(testService+","+testService1);
    }
}
