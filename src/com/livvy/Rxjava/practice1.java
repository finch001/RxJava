package com.livvy.Rxjava;

import rx.Observable;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * Created by Administrator on 2016/7/29 0029.
 */
public class practice1 {
    public static Function<Integer, String> greet(String greeting) {
        return (Integer name) -> greeting + " " + name + "!";
    }

    public static void main(String[] args) {
        //System.out.println(greet("hello").apply(123));
//        List<String> list = new ArrayList<>(Arrays.asList("one", "two", "three", "four", "five"));
//        Observable<String> observable = Observable.from(list);
//        observable.subscribe(System.out::println);
//        observable.subscribe(color -> System.out.println(color + "|"), System.out::println, System.out::println);
//        Observable<Integer> observable1 = Observable.from(new Integer[]{1, 2, 3, 4, 56, 7, 8});
//        observable1.subscribe(System.out::println);
//
//        Observable.just('h', 'w').subscribe(System.out::println, System.err::println, System.out::println);
//        Observable.just(new Student("zhengyan", 23)).map(v -> v.getName() + "is already " + v.getAge()).subscribe(System.out::println);
//        List<Student> studentList = new ArrayList<>(Arrays.asList(new Student("zhengyan", 24), new Student("zhengyan", 25), new Student("zhengyan", 26), new Student("zhengyan", 27)));
//        Observable observable2 = Observable.from(studentList);
        // 间隔的发射 火箭  每0.5秒发射一次
        subscribePrint(
                Observable.interval(500L, TimeUnit.MILLISECONDS),
                "Interval Observable"
        );
        // 第一个为开始时间  第二个和第三个为间隔的时间
        subscribePrint(
                Observable.timer(0L, 1L, TimeUnit.SECONDS),
                "Timed Interval Observable"
        );
        subscribePrint(
                Observable.timer(1L, TimeUnit.SECONDS),
                "Timer Observable"
        );
        subscribePrint(Observable.error(new Exception("Test Error")), "Error Observable");

        subscribePrint(Observable.empty(), "Empty Observable");
        subscribePrint(Observable.never(), "Never Observable");
        //连续发射 第二个参数表示的个数
        subscribePrint(Observable.range(1, 3), "Range Observable");
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    static void subscribePrint(Observable observable, String name) {
        observable.subscribe(
                (v) -> System.out.println(name + " : " + v),
                (e) -> {
                    System.err.println("Error from " + name + ":");
                },
                () -> System.out.println(name + " ended!")
        );
    }

}
