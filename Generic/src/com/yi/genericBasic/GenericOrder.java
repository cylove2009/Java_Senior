package com.yi.genericBasic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericOrder <T> {

    private String orderName;
    private int orderId;
    private T orderT;


    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public T getOrderT() {
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }

    public GenericOrder(){

        T[] array_t = (T[]) new Object[10];
        

    }


    public GenericOrder(T orderT){
        this.orderT = orderT;
    }



    public static <E> List<E> copyFromArrayToList(E[] array){
        
        List<E> list = Arrays.asList(array);
        
        return list;
        
    }

    public static <E> List<E> copyFromArrayToList2(E[] array){

        List<E> list = new ArrayList<>();

        for(int i = 0; i < array.length;i++){

            list.add(array[i]);
        }

        return list;

    }
}
