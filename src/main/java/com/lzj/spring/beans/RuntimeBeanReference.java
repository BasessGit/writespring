package com.lzj.spring.beans;

public class RuntimeBeanReference {
    private String refBean;

    public RuntimeBeanReference() {
    }

    public RuntimeBeanReference(String refBean) {
        this.refBean = refBean;
    }

    public String getRefBean() {
        return refBean;
    }

    public void setRefBean(String refBean) {
        this.refBean = refBean;
    }
}
