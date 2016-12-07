package com.livvy.Rxjava.RxAndroid;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Func1;

import java.util.List;

/**
 * Created by Administrator on 2016/11/23 0023.
 */
public class Repeat {
    public static void main(String[] args) {
        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("hello");
            }
        }).map(new Func1<String, String>() {
            @Override
            public String call(String s) {
                return s + " word";
            }
        }).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("completed");
            }
            @Override
            public void onError(Throwable e) {
                System.out.println("error");
            }
            @Override
            public void onNext(String s) {
                System.out.println("rx " + s);
            }
        });
    }

    private static void distictUntil(List<String> appInfos) {
        Observable<String> distictUntil = Observable.from(appInfos);

        distictUntil.distinctUntilChanged().subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onNext(String s) {
                print(s);
            }
        });
    }

    private static void distinct(List<String> appInfos) {
        Observable<String> full = Observable.from(appInfos).take(3).repeat(3);
        // distinct 针对整个列表使用 去重  注意此处如果数据过大 可能会导致内存溢出
        full.distinct().subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onNext(String s) {
                print(s);
            }
        });
    }

    private static void take(List<String> appInfos) {
        // take takeLast
        Observable.from(appInfos).takeLast(3).subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onNext(String s) {
                print(s);
            }
        });
    }

    private static void filter(List<String> appInfos) {
        Observable.from(appInfos).filter(appinfo -> appinfo.startsWith("a")).subscribe(new Observer<String>() {
            int i = 0;

            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onNext(String s) {
                i++;
                print(s + i + "   hello");
            }
        });

        Observable.from(appInfos).filter(new Func1<String, Boolean>() {
            @Override
            public Boolean call(String s) {
                return s.startsWith("q");
            }
        }).subscribe(new Observer<String>() {
            int i;

            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onNext(String s) {
                i++;
                print(s + i + "   hello");
            }
        });
    }

    private static void range() {
        Observable.range(10, 3).repeat(3).subscribe(new Observer<Integer>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onNext(Integer integer) {
                print(integer);
            }
        });
    }

    private static void justObservable(List<AppInfo> appInfos) {
        Observable.just(appInfos.get(0), appInfos.get(1), appInfos.get(2)).repeat(3).subscribe(new Subscriber<AppInfo>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onNext(AppInfo appInfo) {
                System.out.print("hello\n");
                System.out.println(appInfo);
            }
        });
    }

    public Observable<Integer> getInt() {
        return Observable.create(subscriber -> {
            print("Defer");
            if (subscriber.isUnsubscribed()) {
                return;
            }
            subscriber.onNext(42);
            subscriber.onCompleted();
        });
    }

    public static void print(Object o) {
        System.out.println(o.toString());
    }
}
