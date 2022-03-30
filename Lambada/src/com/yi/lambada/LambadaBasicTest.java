package com.yi.lambada;

import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;




public class LambadaBasicTest {


    @Test
    public void basicTest() {

        //Regular

        Comparator com_no_generic = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        };

        //Comparator com_no_generic_lambda = (o1, o2) -> Integer.compare(o1, o2);

        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                ;
                return o1.compareTo(o2);
            }
        };

        System.out.println(comp.compare("A1", "A2"));

        //Lambda
        Comparator<String> comp2 = (o1, o2) -> o1.compareTo(o2);

        System.out.println(comp2.compare("A1", "A2"));

//======================================================================================

        //Regular
        MyInterface min = new MyInterface() {
            @Override
            public void show() {
                System.out.println("myinterface show");
            }
        };
        //Lambda
        ///MyInterface min2 = ()-> System.out.println("any string");  // lambda no working, only one abstract method.


        MyInterface2 mi2 = new MyInterface2() {
            @Override
            public void method() {

            }
        };

        MyInterface2 mi22 = () -> {
            System.out.println("any string");
        };

        mi22.method();
//======================================================================================
    }

    @Test
    public void SelfDefinedInterface3Test() {

        //Regular instanlize an interface
        MyInterface3<String> myInterface3 = new MyInterface3() {
            @Override
            public String method(Object s) {

                return s + "abc";
            }
        };

        //Lambda instanlize an interface
        MyInterface3<String> myInterface3_lambda = s -> s + "abc";

        System.out.println(myInterface3_lambda.method("abc"));

    }

    @Test
    public void ConsumerTest() {


        Consumer<String> comsumer = new Consumer<String>() {
            @Override
            public void accept(String s) {

                System.out.println(s + "+end");
            }
        };

        Consumer<String> stringConsumer = s -> System.out.println(s.toUpperCase(Locale.ROOT));

        stringConsumer.accept("low to high");

        Predicate<String> objectPredicate = new Predicate<String>() {

            @Override
            public boolean test(String s) {
                return false;
            }
        };
    }

    @Test
    public void PredicateTest() {

        List<String> list = Arrays.asList("北京", "南京", "天津", "东京", "西京", "普京");

        System.out.println(LambadaBasicTest.newStringListByPolicyPredicate(list, s -> s.contains("京")));

        List<String> jing = LambadaBasicTest.newStringListByPolicyPredicate(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });

        System.out.println(jing);

    }

@Test
    public void FunctionTest(){

        ArrayList<String> arrayListData = new ArrayList<String>();
        //ArrayList<String> arrayListDataOut = new ArrayList<String>;

        arrayListData.add("run");
        arrayListData.add("sit");
        arrayListData.add("climb");

        //REGULAR
        Function<List<String>, List<String>> stringIntegerFunction = new Function<List<String>, List<String>>() {

            @Override
            public List<String> apply(List<String> strings) {

                ArrayList<String> arrayList = new ArrayList<String>();

                for(String s : strings){
                    arrayList.add( s + "ing");
                }
                return arrayList;
            }
        };

        List<String> arrayListDataOut = stringIntegerFunction.apply(arrayListData);

        //System.out.println(arrayListDataOut);

        // Lambda
        Function<List<String>, List<String>> stringIntegerFunction2 = strings -> {

            ArrayList<String> arrayList = new ArrayList<String>();

            for(String s : strings){
                arrayList.add( s + "xyz");
            }
            return arrayList;
        };

        System.out.println(stringIntegerFunction2.apply(arrayListData));



        }


    static List<String> newStringListByPolicyPredicate(List<String> str, Predicate<String> pre) {

        ArrayList<String> newList = new ArrayList<String>();

        for (String s : str) {
            if (pre.test(s))
                newList.add(s);
        }
        return newList;

    }

//    static List<String> newStringListByPolicyFunction(List<String> str, Function<List<String>, List<String>> func)
//    {
//
//    }

    @Test
    public void FunctionalInterfaceTest() {

        /*
         * java内置的4大核心函数式接口
         *
         * 消费型接口 Consumer<T>     void accept(T t)
         * 供给型接口 Supplier<T>     T get()
         * 函数型接口 Function<T,R>   R apply(T t)
         * 断定型接口 Predicate<T>    boolean test(T t)
         *

         */


        Consumer<Integer> consumerInteger = new Consumer<Integer>() {

            @Override
            public void accept(Integer integer) {

            }
        };

        IntConsumer intConsumer = new IntConsumer() {
            @Override
            public void accept(int value) {

            }
        };
    }

}

