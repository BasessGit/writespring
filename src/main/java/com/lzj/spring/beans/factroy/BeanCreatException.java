package com.lzj.spring.beans.factroy;

import com.lzj.spring.BeanException;

public class BeanCreatException extends BeanException {
    private String beanName;
    public BeanCreatException(String message) {
        super(message);
    }

    public BeanCreatException(String message, Throwable cause) {
        super(message, cause);
    }

    public BeanCreatException(String message, String beanName) {
        super("Error creating bean with name '" + beanName + "': " + message);
        this.beanName = beanName;
    }

    public BeanCreatException(String message, Throwable cause, String beanName) {
        super(message, cause);
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
