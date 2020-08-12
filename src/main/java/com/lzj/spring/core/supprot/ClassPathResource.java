package com.lzj.spring.core.supprot;

import com.lzj.spring.core.Resource;
import com.lzj.spring.utils.ClassUtil;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ClassPathResource implements Resource {
    private String path;
    private  ClassLoader loader;

    public ClassPathResource(String path) {
        this.path = path;

    }

    public ClassPathResource(String path, ClassLoader loader) {
        this.path = path;
        this.loader = loader;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        InputStream inputStream = null;
        inputStream = loader.getResourceAsStream(path);
        if (null == inputStream){
                throw  new FileNotFoundException(path +"加载异常");
            }
    return inputStream;
    }

    @Override
    public String getDescription() {
        return this.path;
    }
}
