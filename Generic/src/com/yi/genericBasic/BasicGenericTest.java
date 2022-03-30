package com.yi.genericBasic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BasicGenericTest {

    @Test
    public void GenericTest1(){

        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(111);
        arrayList.add(222);
        arrayList.add(333);

        Iterator<Integer> i = arrayList.iterator();;

        while(i.hasNext()){

            int value = i.next();
            System.out.println(value);
        }
    }

    @Test
    public void GenericOrderTest(){

        String[] s1 = new String[]{"aa","bb","cc"};

        //Person[] p = new Person[]{new Person("name",12), new Person("name2",12)};

        //int[] i = new int[]{1,2,3,4};

        Integer[] i = new Integer[]{1,2,3,4};

        ArrayList<String>  arrayList = new ArrayList<>();

        arrayList.add("aa");
        arrayList.add("bb");
        arrayList.add("cc");


        List<String> ints = GenericOrder.copyFromArrayToList(s1);
        List<String> ints2 = GenericOrder.copyFromArrayToList2(s1);
        //List<Person> ints3 = GenericOrder.copyFromArrayToList(p);

        System.out.println(ints);
       // System.out.println(ints3);








    }

    @Test
    public void GenericOrderInheritance(){

        SubOrder subOrder = new SubOrder();
        subOrder.setOrderT("String is assigned"); // no need to explicitly mentioned generic type "Sting"

        SubOrderGerneric subOrderGerneric = new SubOrderGerneric();

        subOrderGerneric.setOrderT("Sting is Ok");
        subOrderGerneric.setOrderId(111);
        subOrderGerneric.setOrderId('A');




    }

    @Test
    public void GenericTest2(){

        List<?> listFather4all = null;
        List<String> list_string = null;
        List<Object> list_object = null;

        listFather4all = list_object;
        listFather4all = list_string;


    }

}
