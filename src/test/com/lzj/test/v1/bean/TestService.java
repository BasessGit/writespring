package com.lzj.test.v1.bean;

public class TestService {
    private TestDao testDao;
    private  String name;

    public TestService() {
    }

    public TestService(TestDao testDao, String name) {
        this.testDao = testDao;
        this.name = name;
    }

    public TestDao getTestDao() {
        return testDao;
    }

    public void setTestDao(TestDao testDao) {
        this.testDao = testDao;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
