package com.yi.collectionTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ListTest {

    @Test
    public void listTest1(){

        List list = new ArrayList();
        List listB = Arrays.asList(111,222,333);

        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("Tom",12));
        list.add(457);
        list.add(2,234);

        list.addAll(0,listB);

//        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.get(list.size()-1));

//        System.out.println(list.get(3));
//       System.out.println(list.indexOf("AAA"));
//        System.out.println(list.lastIndexOf(456));
//        System.out.println(list.indexOf(456));
        //list.set(1,"1111");
       // System.out.println(list.subList(0,2));
//        Iterator it = list.iterator();
//
//        while(it.hasNext()){
//
//            System.out.println(it.next());
//        }
//
//        for(Object i: list){
//
//            System.out.println(i);
//
//        }

    }

    @Test
    public void testListRemove() {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);//
    }

    private void updateList(List list) {
       // list.remove(2);
    list.remove(new Integer(2));

    }


    @Test
    public void SearchStringInList(){

        List<String> stringList = new LinkedList<>();

        StringBuilder s = new StringBuilder("catsandog");

        stringList.add("cat");
        stringList.add("cats");
        stringList.add("and");
        stringList.add("sand");

        int i = 4;
        System.out.println(s.substring(1,s.length()));

        System.out.println(stringList.contains(s.substring(3,4)));


    }

}
