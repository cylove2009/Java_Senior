package com.yi.StringBasic;

import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Locale;

public class StringMethodTest {

    @Test
    public void StringMethodTest(){

        String s1 = "HelloWorld123llo";
        //String s2 = s1.replace('h','b');
        //String s2 = s1.toLowerCase(Locale.ROOT);
        String s2 = s1.substring(0,6);


        System.out.println(s2);
        System.out.println(s2.charAt(1));
        String str = "12hello34world5java7891mysql456";
        //把字符串中的数字替换成,，如果结果中开头和结尾有，的话去掉
//        String s3 = str.replaceAll("\\d+", ",").replaceAll("^,|,$", "");
//        System.out.println(s3);
        System.out.println(s2.startsWith("ll",2));
        System.out.println(s1.endsWith("123"));
        System.out.println(s1.indexOf("llo"));
        System.out.println(s1.lastIndexOf("llo"));
    }

    @Test
    public void StringCovertOtherMethodTest(){
        
        String s1 = "123";

        s1 = "456";

        //Integer integer = Integer.
        int i = Integer.parseInt(s1);


        System.out.println(i);

        String s = String.valueOf(i);
        String s2 = i + "";

        //String vs char []

        char[] chars = {'a','b','c'};

        String s3 = String.copyValueOf(chars);

        char[] chars2 = s1.toCharArray();

//        System.out.println(chars2);
        System.out.println(s3);

        //String vs bytes  charsets has to be consistent
        
        String s5 = "123456中国馆";
        byte[] bytes = s5.getBytes(StandardCharsets.UTF_8); //coding
        System.out.println(Arrays.toString(bytes));

        String s6 = new String(bytes,StandardCharsets.UTF_8); // decoding
        System.out.println(s6);




    }


}
