package com.tutu359;

import org.junit.Test;

import java.util.Optional;

public class OptionalApi {
    
    @Test
    public void test1() {
        // 传入null直接抛异常
        //Optional<String> optional = Optional.of(null);

        // 可以传null，但使用时要小心：orElse
        Optional<String> optional = Optional.ofNullable(null);

        System.out.println("optional.orElse(\"qwe\") = " + optional.orElse("qwe"));
    }
}
