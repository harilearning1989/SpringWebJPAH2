package com.web.demo.helper;

import java.io.InputStream;

public class CSVHelper {
    public static InputStream loadEmpFile(String fileName) {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        return classloader.getResourceAsStream(fileName);
    }
}
