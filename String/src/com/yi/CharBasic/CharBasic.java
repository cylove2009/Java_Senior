package com.yi.CharBasic;

import org.junit.Test;

public class CharBasic {

    @Test
    public void char2integer(){

        char num = '9';

        System.out.println(Integer.parseInt(""+num));

        System.out.println(Character.valueOf(num).getClass());


    }

}
