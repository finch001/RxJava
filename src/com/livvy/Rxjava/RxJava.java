package com.livvy.Rxjava;

import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;

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

        Observable<String> stringObservable = Observable.from(StringList);

        stringObservable.subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println(s);
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                System.err.println(throwable);
            }
        }, new Action0() {
            @Override
            public void call() {
                System.out.println("we have finish yet");
            }
        });
    }
}
