package com.yi.lambada;

public interface MyInterface {

       default void show() {
              System.out.println("have a function body");
       }
}
