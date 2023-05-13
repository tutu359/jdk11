package com.tutu359;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;

public class IOApi {

    @Test
    public void test1() throws IOException {
        var classLoader = this.getClass().getClassLoader();
        // 去resource文件夹目录下
        var inputStream = classLoader.getResourceAsStream("file1");

        // 输出在src同级目录下
        // try(){}自动关流
        try (var outputStream = new FileOutputStream("file2")) {
            inputStream.transferTo(outputStream);
        }
        inputStream.close();
    }
}
