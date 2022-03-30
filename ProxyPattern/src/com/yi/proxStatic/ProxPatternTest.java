package com.yi.proxStatic;

import org.junit.Test;

public class ProxPatternTest {

    @Test
    public void test1(){


        NikeClothFactory nikeClothFactory = new NikeClothFactory();

        ProxClothFactory proxClothFactory = new ProxClothFactory(nikeClothFactory);

        proxClothFactory.doCloth();


    }



}
