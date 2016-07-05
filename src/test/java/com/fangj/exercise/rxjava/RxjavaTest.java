package com.fangj.exercise.rxjava;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by fangjie on 2016/6/14.
 */
public class RxjavaTest {

    public static void hello(String... names) {
        Observable.from(names).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println("Hello " + s + "!");
            }
        });
    }

    public static String mockSleep() {
        try {
            System.out.println("开始休眠...");
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "mock Complete!";
    }

    public static void mockAndroid() {
        Observable operationObservable = Observable.create(new Observable.OnSubscribe<Object>() {
            @Override
            public void call(Subscriber subscriber) {
                subscriber.onNext(mockSleep());
                subscriber.onCompleted();
            }
        }).subscribeOn(Schedulers.newThread());

        System.out.println("????");

        operationObservable.subscribe(
                new Subscriber() {
                    @Override
                    public void onCompleted() {
                        mockSleep();
                        System.out.println("completed..");
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(Object o) {
                        System.out.println(o);

                    }
                });

    }

    public static void main(String[] args) {
        //hello("Ben", "George");
        //System.out.println(">>");
//        mockAndroid();
        merge();
        System.out.println("main progress");

        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


    public static int get1() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("1");
        return 1;
    }

    public static int get2() {
        System.out.println("2");
        return 2;
    }


    public static void merge() {
        Observable odds = Observable.create(new Observable.OnSubscribe<Object>() {
            @Override
            public void call(Subscriber subscriber) {
                subscriber.onNext(get1());
                subscriber.onCompleted();
            }
        }).subscribeOn(Schedulers.newThread());

        System.out.println(">>");
        Observable<Integer> evens = Observable.just(get2());
        System.out.println(">> events");

        Observable.merge(odds, evens)
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onNext(Integer item) {
                        System.out.println("Next: " + item);
                    }

                    @Override
                    public void onError(Throwable error) {
                        System.err.println("Error: " + error.getMessage());
                    }

                    @Override
                    public void onCompleted() {
                        System.out.println("Sequence complete.");
                    }
                });
    }


}
