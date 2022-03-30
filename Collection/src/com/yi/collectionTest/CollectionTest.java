package com.yi.collectionTest;

import org.junit.Test;

import java.util.*;

public class CollectionTest {

    @Test
    public void test1(){

        Collection coll = new ArrayList();

//        Collection coll2 = new HashSet();
        Collection coll2 = Arrays.asList(123,456,789);

        coll.add(123);
        coll.add(456);
//        Person p = new Person("Jerry",20);
//        coll.add(p);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(new String("Tom"));
        coll.add(false);




        //System.out.println(coll.hashCode());
        //System.out.println(coll.contains(123));

        //System.out.println(coll.contains(new String("Tom")));
        //System.out.println(coll.contains(new Person("Jerry",20)));//false -->true


        //System.out.println(coll.containsAll(coll2));
        System.out.println(coll);
        //coll.removeAll(coll2);
        //coll.retainAll(coll2);
        //System.out.println(coll);

        Object[] objects = coll.toArray(); // collection -> Array

        for(int i = 0; i< objects.length ; i++){

            //System.out.println(objects[i]);
        }

        //Array to Collection

        List list = Arrays.asList(new String[]{"abc","edf","ghi"});

        System.out.println(list);

        Iterator it = list.iterator();

        while(it.hasNext()){

            System.out.println(it.next());

        }


    }

    @Test
    public void test2(){
        Collection coll = new ArrayList();

//        Collection coll2 = new HashSet();
//        Collection coll2 = Arrays.asList(123,456,789);

        coll.add(123);
        coll.add(456);
//        Person p = new Person("Jerry",20);
//        coll.add(p);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(new String("Tom"));
        coll.add(false);


//        for(Object i : coll){
//            System.out.println(i);
//        }

//        while (coll.iterator().hasNext()){ //incorrect
//            System.out.println(coll.iterator().next());
//        }

        Iterator it = coll.iterator();

        while(it.hasNext()){

            Object obj = new Object();
            obj = it.next();

            if(obj.equals("Tom")){
                it.remove();
            }

        }

        System.out.println(coll);

    }
}
