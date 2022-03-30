package com.yi.lambada;

public interface MyInterface3 <T> {


    String method(T s);

    default void show() {
        System.out.println("have a function body");
    }
}
