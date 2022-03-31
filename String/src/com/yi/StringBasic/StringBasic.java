package com.yi.StringBasic;

import com.yi.Person;
import org.junit.Test;

import java.sql.SQLOutput;
import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;

public class StringBasic {

    @Test
    public void StringStorageTest1(){

        String s1 = "123"; // store method area, no change
        String s2 = new String("123"); // store in heap
        String s3 = new String("123"); // store in heap


        Person p1 = new Person("Tom",26); //String stores in heap
        Person p2 = new Person("Tom",26);

        Person p3 = new Person(new String("Tom"),26); // String stores in method area.
        Person p4 = new Person(new String("Tom"),26);


//        s2.replace("1","2");

//        System.out.println(s1 == s2);
//        System.out.println(s2 == s3);
//
       System.out.println(p1.getName().equals(p2.getName()));
       System.out.println(p1.getName()== p2.getName());
//
//        p1.setName("Jerry");
//        System.out.println(p2.getName());

        System.out.println(p3.getName().equals(p4.getName()));// p3/p4 is pointing to the same string in the method area
        System.out.println(p3.getName()== p4.getName()); //p3, p4 different object but pointing to the same string in method area

    }

    @Test
    public void StringStorageTest2(){

        String s0 ="AABB";
        String s1 = "AA";
        String s2 = "BB";

        String s3 = "AA" + "BB";
        String s4 = s1 + "BB";
        String s5 = "AA" + s2;
        String s6 = s1 + s2;

        final String s9 = "AA";
        String s10 = s9 + "BB";



        System.out.println(s0 == s3);
        System.out.println(s0 == s4);
        System.out.println(s0 == s6);

        System.out.println(s4 == s6);
        System.out.println(s5 == s6);

        String s7 = s3.intern();
        System.out.println(s7 == s0);
        System.out.println(s10 == s0);






    }

    @Test
    public void StringCompareTest(){

        String s1 = "AA";
        String s2 = new String("BB");

        System.out.println(s1.compareTo(s2));
        
    }
    @Test
    public void SubStringTest(){

        String s1 = "abcde";
        System.out.println(s1.substring(0,3));
        System.out.println(s1.substring(0,4));
        System.out.println(s1.substring(2,4));
    }


    @Test
    public void StringConvertertoCharArray(){
//        String s1 = "abcde";
//
//        char[] s = s1.toCharArray();
//
//        System.out.println(s.length);
//
//
//        s.toString();

        String s="abbaa";
        String t="cddcd";


        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();

        HashMap<Character,Integer> smap = new HashMap<>();
        HashMap<Character,Integer> tmap = new HashMap<>();

        for(int i = 0 ; i < s1.length; i++){

            if(smap.containsKey(s1[i]))

                smap.put(s1[i],smap.get(s1[i])+i);
            else
                smap.put(s1[i], i);

        }

        for(int i = 0 ; i < t1.length; i++){

            if(tmap.containsKey(t1[i]))

                tmap.put(t1[i],tmap.get(t1[i])+i);
            else
                tmap.put(t1[i], i);

        }

        System.out.println(smap.values());
        System.out.println(tmap.values());

//        if(smap.values().containsAll(tmap.values()))
//            return true;
//        else
//            return false;
    }

    @Test
    public void StringPlusTest(){

        StringBuilder s = new StringBuilder("ABC");

        Stack<Character> stack = new Stack<>();

        String res = "";

        char[] resChar = new char[s.length()];

        for(char i: s.toString().toCharArray()){
            stack.add(i);
        }


        //StringBuilder str = new StringBuilder();
        String str = "";
        while(!stack.empty()){
             str = stack.pop().toString() + str;
        }

        //str.reverse().toString();
        System.out.println(str);
    }


    @Test
    public void String2Int(){

        String six = "6";
        String six_2 = "6";

        StringBuilder ssix = new StringBuilder("6");
        int isix = 6;
        String temp = "" + 6;


        if(isix == Integer.parseInt(six)) //true
            System.out.println("yes, true");

        System.out.println(String.valueOf(isix) == six);

        System.out.println(String.valueOf(isix) == ssix.toString());

        System.out.println(String.valueOf(isix).equals(ssix.toString()));

        System.out.println(six.equals(ssix.toString()));

        System.out.println(six_2.equals(temp));


//        System.out.println(six.compareTo(String.valueOf(isix)));
//
//        System.out.println(temp == six);
//
//        System.out.println(String.valueOf(isix) == six);


    };





}
