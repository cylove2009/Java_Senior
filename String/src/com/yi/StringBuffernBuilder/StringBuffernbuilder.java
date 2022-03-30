package com.yi.StringBuffernBuilder;

import org.junit.Test;

public class StringBuffernbuilder {

    @Test
    public void StringBufferTest(){

        // efficiency StringBuilder > StringBuffer (Synchronized) > String

        StringBuffer s1 = new StringBuffer(30);

        s1.append(1);
        s1.append(1.2);
        s1.append("abc");


        s1.append("dfg".toCharArray(),0,2);
        s1.delete(1,4);
        s1.insert(1,"xyz");
        s1.reverse();
        s1.substring(2,6);


        System.out.println(s1);



    }

    @Test
    public void StringBuilderTest(){

        StringBuilder s3 = null;

        s3 = new StringBuilder();

        System.out.println(s3);

        s3.append("abcdsfsfsdsdfsfdsfsdfs");

        System.out.println(s3);

    }
}
