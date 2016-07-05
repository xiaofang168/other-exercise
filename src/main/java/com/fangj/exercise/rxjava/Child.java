package com.fangj.exercise.rxjava;

/**
 * Created by fangjie on 2016/7/5.
 */
public class Child {
    public String id;
    public String name;

    public Child(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
