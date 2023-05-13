package com.tutu359;

import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionApi {
    @Test
    public void test1() {
        List<String> list = List.of("qwe", "asd", "11");
        // list.add("使用add方法直接抛异常");

        list = new ArrayList<>(list);
        list.add("这样再添加就没事了");

        System.out.println("list = " + list);
    }

    @Test
    public void test2() {
        List<String> list = Arrays.asList("qwe", "asd", "11");
        list.add("使用add方法直接抛异常");
    }

    @Test
    public void test3() {
        LocalDate localDate = LocalDate.of(2023, 5, 13);
        System.out.println("localDate = " + localDate);
    }
}
