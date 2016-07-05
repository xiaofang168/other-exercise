package com.fangj.exercise.rxjava;

import org.junit.Test;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fangjie on 2016/7/5.
 */
public class ExecutorTest {

    @Test
    public void test() {
        Observable<String> ids = Observable.just("1", "2", "3");
        Observable<Parent> parents = ids.flatMap(new Func1<String, Observable<Parent>>() {
            @Override
            public Observable<Parent> call(String id) {
                List<String> list = new ArrayList<String>();
                list.add(id);
                return Observable.just(new Parent(id,id,list));
            }
        });
        Observable<Output> outputObservable = parents.flatMap(new ToOutput());

        outputObservable.subscribe(

                new Subscriber<Output>() {

                    @Override
                    public void onCompleted() {
                        System.out.println("completed..");
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(Output o) {
                        System.out.println(o.getName());
                    }

                });
    }


    @Test
    public void ParallelExecutionTest() {

    }
}
