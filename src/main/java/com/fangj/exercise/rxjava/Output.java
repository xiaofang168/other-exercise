package com.fangj.exercise.rxjava;

import java.util.List;

/**
 * Created by fangjie on 2016/7/5.
 */
public class Output {
    public String name;
    public List<String> childNames;

    public Output(String name, List<String> childNames) {
        this.name = name;
        this.childNames = childNames;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getChildNames() {
        return childNames;
    }

    public void setChildNames(List<String> childNames) {
        this.childNames = childNames;
    }
}
