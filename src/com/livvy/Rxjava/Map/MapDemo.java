package com.livvy.Rxjava.Map;

import rx.Observable;
import rx.Subscriber;
import rx.observables.ConnectableObservable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Pattern;


/**
 * Created by Administrator on 2016/7/29 0029.
 */
public class MapDemo {
    // V表示原来的类型  M表示后来的数据格式
//    public static <V, M> List<M> map(List<V> list, Mapper<V, M> mapper) {
//        List<M> mapped = new ArrayList<>(list.size());
//
//        for (V v : list) {
//            mapped.add(mapper.map(v));
//        }
//        return mapped;
//    }

    static ConnectableObservable<String> from(final InputStream stream) {
        return from(new BufferedReader(new InputStreamReader(stream)));
    }

    static ConnectableObservable<String> from(final BufferedReader reader) {
        return Observable.create(new Observable.OnSubscribe<String>() { // (2)
            @Override
            public void call(Subscriber<? super String> subscriber) {
                if (subscriber.isUnsubscribed()) { // (3)
                    return;
                }
                try {
                    String line;
                    while (!subscriber.isUnsubscribed() &&
                            (line = reader.readLine()) != null) { // (4)
                        if (line == null || line.equals("exit")) { // (5)
                            break;
                        }

                        subscriber.onNext(line); // (6)
                    }
                } catch (IOException e) { // (7)
                    subscriber.onError(e);
                }
                if (!subscriber.isUnsubscribed()) // (8)
                    subscriber.onCompleted();
            }
        }).publish();
    }


    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>(Arrays.asList("h", "e", "l", "l", "o"));
//        List<String> stringList1 = map(stringList, new Mapper<String, String>() {
//            @Override
//            public String map(String value) {
//                return value + "fuck";
//            }
//        });
        Function<String, String> odd = (value) -> (value + "!");
        Predicate<Integer> predicate = (value) -> value % 2 != 0;
//        List<String> mapped = map(stringList, odd);

        ConnectableObservable<String> input = from(System.in);
        Observable<Double> a = varStream("a", input);
        Observable<Double> b = varStream("b", input);

        reactiveSum(a, b);

        System.out.println();
    }

    private static void reactiveSum(Observable<Double> a, Observable<Double> b) {
        Observable.combineLatest(a, b, (x, y) -> x + y)
                .subscribe(sum -> System.out.println("update : a + b" + sum), error -> {
                    System.out.println("got a error");
                    error.printStackTrace();
                }, () -> System.out.println("Exiting.............."));


    }

    public static Observable<Double> varStream(final String name, Observable<String> input) {
        final Pattern pattern = Pattern.compile(
                "\\s*" + name + "\\s*[:|=]\\s*(-?\\d+\\.?\\d*)$"
        );

        return input.map(pattern::matcher)
                .filter(m -> m.matches() && m.group(1) != null)
                .map(matcher -> matcher.group(1))
                .map(Double::parseDouble);
    }

}
