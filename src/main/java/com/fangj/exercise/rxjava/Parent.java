package com.fangj.exercise.rxjava;

import java.util.List;

/**
 * Created by fangjie on 2016/7/5.
 */
public class Parent {
    public String id;
    public String name;
    public List<String> childIds;

    public Parent(String id, String name, List<String> childIds) {
        this.id = id;
        this.name = name;
        this.childIds = childIds;
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

    public List<String> getChildIds() {
        return childIds;
    }

    public void setChildIds(List<String> childIds) {
        this.childIds = childIds;
    }
}
