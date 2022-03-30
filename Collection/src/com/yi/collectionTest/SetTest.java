package com.yi.collectionTest;

import org.junit.Test;

import java.util.*;

public class SetTest {

    @Test
    public void SetTest1(){

        Set<String> set = new HashSet();

        set.add("ABC");
        set.add("abc");

        System.out.println(set);

        Iterator<String> it = set.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }

        for(String i:set){

            System.out.println(i);
        }




    }

@Test
    public void SetGenericTest(){

        Set<Person> set = new HashSet();
        Set<Person> set2 = new HashSet(); // Person has to override hashCode and equals.

        set.add(new Person("Kason",12));
        set.add(new Person("Jason",11));


        set2.add(new Person("Kason",12));
        set2.add(new Person("Jason",11));

        Object[] pa = set.toArray();

        System.out.println(set.equals(set2));

        for(Object i : pa){

            System.out.println(i);


        }


        //System.out.println(set.hashCode());

    }

    @Test
    public void TreeSetTest(){

        Comparator com = new Comparator() {
            //按照年龄从小到大排列
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof User && o2 instanceof User){
                    User u1 = (User)o1;
                    User u2 = (User)o2;
                    return Integer.compare(u1.getAge(),u2.getAge());
                    //return u1.getAge() - u2.getAge();
                }else{
                    throw new RuntimeException("输入的数据类型不匹配");
                }
            }
        };





        TreeSet set = new TreeSet(com);

        set.add(new User("Tom",12));
        set.add(new User("Jerry",32));
        set.add(new User("Jim",2));
        set.add(new User("Mike",65));
        set.add(new User("Mary",33));
        set.add(new User("Jack",33));
        set.add(new User("Jack",56));

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void TreeSetTest2(){

        TreeSet set = new TreeSet(); //User class needs to have compareTo

        //失败：不能添加不同类的对象
//        set.add(123);
//        set.add(456);
//        set.add("AA");
//        set.add(new User("Tom",12));

        //举例一：
//        set.add(34);
//        set.add(-34);
//        set.add(43);
//        set.add(11);
//        set.add(8);

        //举例二：
        set.add(new User("Tom",12));
        set.add(new User("Jerry",32));
        set.add(new User("Jim",2));
        set.add(new User("Mike",65));
        set.add(new User("Jack",33));
        set.add(new User("Jack",56));


        Iterator iterator = set.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
