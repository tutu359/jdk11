package com.tutu359;

import org.junit.Test;

import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class StreamApi {

    @Test
    public void test3() {
        Stream<?> stream1 = Stream.of("qwe", "asd", 11);
        stream1.forEach(System.out::println);

        Stream<?> stream2 = Stream.of();
        stream2.forEach(System.out::println);

        // null被理解为可变参数的数组对象， 后续遍历数组会出现空指针异常
        /*Stream<?> stream3 = Stream.of(null);
        stream3.forEach(System.out::println);*/

        Stream<?> stream4 = Stream.ofNullable(null);
        stream4.forEach(System.out::println);
    }

    @Test
    public void test4() {
        Predicate<Integer> predicate = i -> i % 2 != 0;

        Stream.of("1356789".split(""))
                .map(Integer::parseInt)
                .takeWhile(predicate)
                .forEach(System.out::println);

        // takeWhile 从流中一直获取断言为真的元素，一旦没取到符合条件的数就停止 类似于 &&
    }

    @Test
    public void test5() {
        Stream.of("13 5 6 7 8 9".split(" "))
                .map(Integer::parseInt)
                .dropWhile(StreamApi::predicate)
                .forEach(System.out::println);  // 6 7 8 9

        // dropWhile 从流中一直丢弃断言为真的元素，一直条件不符，开始获取
    }

    @Test
    public void test6() {
        UnaryOperator<Integer> unaryOperator = i -> ++i;

        // 流的无限迭代
        Stream.iterate(1, unaryOperator)
                .limit(100) // 限制流中的元素
                .forEach(System.out::println);
    }

    @Test
    public void test7() {
        UnaryOperator<Integer> unaryOperator = i -> ++i;
        Predicate<Integer> predicate = i -> i <= 1000;

        // 流的有限迭代
        Stream.iterate(1, predicate, unaryOperator)
                .forEach(System.out::println);
    }

    public static boolean predicate(Integer i){
        return i % 2 != 0;
    }

}
