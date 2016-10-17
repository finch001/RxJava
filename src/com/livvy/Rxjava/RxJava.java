package com.livvy.Rxjava;

import rx.Observable;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2016/6/8 0008.
 */
public class RxJava {
    public static void main(String[] args) {
//        Observable<String> sentenceObservable = Observable.just("this", "is", "a", "sentence");
//
//        sentenceObservable.map(s -> s.toUpperCase() + " ").toList().map(strings -> {
//            Collections.reverse(strings);
//            return strings.toString();
//        }).subscribe(s -> System.out.print(s));


        List<String> StringList = Arrays.asList("one", "two", "three", "four");

        Observable<String> stringObservable = Observable.just(2, 5, 8, 9, 10).map(v -> v * 3).map(v -> (v % 2 == 0) ? "even" : "ood");

        //stringObservable.subscribe(s -> System.out.println(s));
        Observable<Integer> flatMapObservable = Observable.just(2, 500).flatMap(v -> Observable.range(v, 3), (x, y) -> x + y);

        flatMapObservable.subscribe(v -> System.out.println(v));

    }
}
