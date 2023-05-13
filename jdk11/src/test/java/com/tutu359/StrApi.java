package com.tutu359;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.stream.Stream;

public class StrApi {

    @Test
    public void test1() {
        // isBlank 判断字符串是否都是空白(支持全语言空白字符)
        String str = "\t \n　　";
        System.out.println("str.isBlank() = " + str.isBlank());


        // 11后面是全角汉字空格
        str = "\n qwe \t asd \t 11　　";

        System.out.println("str.strip() = " + str.strip());
        System.out.println("str.strip().length() = " + str.strip().length());

        System.out.println("str.trim() = " + str.trim());
        System.out.println("str.trim().length() = " + str.trim().length());

        // 区别
        // trim方法不能去除非英文空格(只能去除码值<=32的空白字符)，strip方法可以去除包括英文和其他所有语言中的空白字符
    }

    @Test
    public void test3() {
        String str = "　\n qwe \t asd \t 11　　　";

        // 去除字符串首部空白
        System.out.println("str.stripLeading() = " + str.stripLeading());
        System.out.println("str.stripLeading().length() = " + str.stripLeading().length());

        // 去除字符串尾部空白
        System.out.println("str.stripTrailing() = " + str.stripTrailing());
        System.out.println("str.stripTrailing().length() = " + str.stripTrailing().length());
    }

    @Test
    public void test4() {
        String str = "qwe";
        System.out.println("str.repeat(5) = " + str.repeat(5));
    }

    @Test
    public void test5() {
        String str = "qwe \n asd \n 11";

        str.lines().forEach(System.out::println);
        System.out.println("str.lines().count() = " + str.lines().count());
    }

    @Test
    public void test6() throws IOException {
        // 使用场景：将文本读成大字符串，然后用流来处理
        FileInputStream fis = new FileInputStream("src/test/java/com/tutu359/StrApi.java");
        byte[] buffer = new byte[fis.available()];
        fis.read(buffer);
        fis.close();

        String str = new String(buffer);
        str.lines()
                .map(s -> "+++" + s + "---")
                .forEach(System.out::println);
    }
}
