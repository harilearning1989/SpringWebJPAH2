package com.web.demo.helper;

import com.google.common.io.Resources;

import java.io.IOException;
import java.nio.charset.Charset;

public class JSONHelper {
    public static String readResource(final String fileName, Charset charset) throws IOException {
        return Resources.toString(Resources.getResource(fileName), charset);
    }

}
