package com.lzj.spring.utils;

public class ClassUtil {
    public  static  ClassLoader getClassLoader(){
        ClassLoader classLoader = null;
        try {
            classLoader = Thread.currentThread().getContextClassLoader();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (null == classLoader){
            classLoader = ClassUtil.class.getClassLoader();
            if (null == classLoader){
                try {
                    classLoader  =   ClassLoader.getSystemClassLoader();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("休息一下");
        return  classLoader;
    }

}
