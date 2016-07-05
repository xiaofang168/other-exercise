package com.fangj.exercise.rxjava;

import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import java.util.List;

/**
 * Created by fangjie on 2016/7/5.
 */
class ToOutput implements Func1<Parent, Observable<Output>> {
    public Observable<Output> call(final Parent p) {
        return Observable.from(p.childIds)
                .flatMap(new Func1<String, Observable<Child>>() {
                    public Observable<Child> call(String childId) {
                        return Observable.just(new Child(childId, childId)).subscribeOn(Schedulers.io());
                    }
                })
                .map(new Func1<Child, String>() {
                    public String call(Child c) {
                        return c.getName();
                    }
                })
                .toList()
                .map(new Func1<List<String>, Output>() {
                    public Output call(List<String> l) {
                        return new Output(p.getName(), l);
                    }
                });
    }
}