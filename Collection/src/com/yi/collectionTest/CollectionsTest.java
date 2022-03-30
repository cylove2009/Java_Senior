package com.yi.collectionTest;

import org.junit.Test;


import java.util.*;

public class CollectionsTest {

@Test
    public void CollectionsTest1(){

        List list = new LinkedList();

            list.add(new Person("Tom12",12));
        //list.add(new Person("Tom15",15));
            list.add(new Person("Tom13",13));
        list.add(new Person("Tom15",15));
            list.add(new Person("Tom16",16));
        //list.add(new Person("Tom15",15));
    //list.add(new Person("Tom15",15));



    Comparator com = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {

                if(o1 instanceof Person && o2 instanceof Person) {
                    Person p1 = (Person) o1;
                    Person p2 = (Person) o2;
                    return p1.getAge() - p2.getAge();
                   // return Integer.compare(p2.getAge(), p1.getAge());
                }else
                    return 0;


            }
        };

        Collections.sort(list,com);
        //Collections.swap(list,0,list.size()-1);

        Collections.max(list);

//        System.out.println(Collections.max(list)); // Person implements comparable
//        System.out.println(Collections.max(list,com)); // Person implements comparable
        System.out.println(Collections.frequency(list,new Person("Tom15",15)));


    CollectionsTest.showList(list);
    System.out.println(Collections.binarySearch(list,new Person("Tom15",15)));


    }

    public static void showList(List list){

        Iterator it = list.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }


    }

    @Test
    public void CollectionsTest2(){

        List list = new LinkedList();

        list.add(new Person("Tom12",12));
        list.add(new Person("Tom15",17));
        list.add(new Person("Tom13",13));
        list.add(new Person("Tom15",15));
        list.add(new Person("Tom16",16));

        list = Collections.synchronizedList(list);


    }
}
