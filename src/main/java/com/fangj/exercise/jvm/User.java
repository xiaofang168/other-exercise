package com.fangj.exercise.jvm;

/**
 * @author fangjie
 * @date Created in 4:42 下午 2021/9/15.
 */
public class User {
    private final String a = "dddd";
    private final static int b = 1;
    private int sex;
    private String addr;

    public String getA() {
        return a;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public static void main(String[] args) {
        int i = Runtime.getRuntime().availableProcessors();
        System.out.println(i + ">>>");
    }

}
