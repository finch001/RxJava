package com.livvy.Properity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Created by Administrator on 2016/6/27 0027.
 */
public class OptionalDemo {
    public static void main(String[] args) {
        //这个是必须为非空指针
        Optional<String> fullName = Optional.ofNullable(null);
        // 判断是否有值  如果有 返回true 否则返回false
        System.out.println("Full name is null ?" + fullName.isPresent());
        // 返回的是一个回调方法
        System.out.println("Full name is null " + fullName.orElseGet(() -> "[none]"));
        // 返回的是一个特定的字符串
        System.out.println(fullName.map(s -> "hey " + s + " !").orElse("Hey Stranger !"));
        // 这个如果没有是Null 则会报NoSuchElementException异常
        //System.out.println(fullName.get());

        List<String> names = Arrays.asList("a", "b", "c");
        Collections.sort(names, (String a, String b) -> a.compareTo(b));
        for (String name : names) {
            System.out.println(name);
        }
        // 匿名的实现
        // 也可以看作是隐式的final 来看待 不过我觉得还是直接设置为final 直接好了
        final int finalInt = 1;
        Converter<String, Integer> converter = (hello -> Integer.valueOf(hello));
        Converter<Integer, String> converter1 = (from -> String.valueOf(from + finalInt));
        int convertInt = converter.convert("125478");

        String convertInt2 = converter1.convert(100);

        System.out.println("lambda : " + convertInt);
        System.out.println("lambda : " + convertInt2);


    }
}

@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
}
