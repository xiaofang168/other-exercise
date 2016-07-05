package com.fangj.exercise.rxjava;


import rx.Observable;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by fangjie on 2016/7/5.
 */
public class Executor {

    public static Observable<Child> getChildren(Parent p) {
        return Observable.from(p.childIds)
                .flatMap(new Func1<String, Observable<Child>>() {
                    public Observable<Child> call(String childId) {
                        return Observable.just(new Child(childId, childId)).subscribeOn(Schedulers.io());
                    }
                });
    }

}
