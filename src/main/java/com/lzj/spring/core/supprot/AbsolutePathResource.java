package com.lzj.spring.core.supprot;

import com.lzj.spring.core.Resource;

import java.io.*;

public class AbsolutePathResource implements Resource {

    private String  path;
    private File file;
    private  ClassLoader loader;

    public AbsolutePathResource(String  config) {
        this.path = config;

    }

    public AbsolutePathResource(String path, ClassLoader loader) {
            this.path = path;
            this.loader = loader;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        file = new File(path);
        return    new FileInputStream(file);
    }

    @Override
    public String getDescription() {
        return file.getAbsolutePath();
    }
}
