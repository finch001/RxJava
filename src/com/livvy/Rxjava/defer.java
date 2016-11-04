package com.livvy.Rxjava;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/10/27 0027.
 */
public class Defer {
    public static void main(String[] args) {
        Defer defer = new Defer();
        // 只有在订阅的时候才会创建create
//        Observable<Integer> deffered = Observable.defer(defer::getNumber);
//
//        deffered.subscribe(number -> {
//            System.out.println(String.valueOf(number));
//        });

//        Observable.range(10, 100).subscribe(new Subscriber<Integer>() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable throwable) {
//
//            }
//
//            @Override
//            public void onNext(Integer integer) {
//                System.out.println(integer);
//            }
//        });

        Subscription subscription = Observable.interval(3, TimeUnit.SECONDS).subscribe(new Subscriber<Long>() {
            @Override
            public void onCompleted() {
                System.out.println("completed");
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onNext(Long aLong) {
                System.out.println(aLong);
            }
        });
    }

    private Observable<Integer> getNumber() {
        return Observable.create(subscriber -> {
            if (subscriber.isUnsubscribed()) {
                return;
            }
            subscriber.onNext(47);
            subscriber.onCompleted();
        });
    }


}
