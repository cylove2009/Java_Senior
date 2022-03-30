package com.yi.proxStatic;

import java.util.List;

public class ProxClothFactory implements  ClothFactory{


    //NikeClothFactory proxobj;
    ClothFactory proxInf;


//    public ProxClothFactory(NikeClothFactory obj){
//
//        this.proxobj = obj;
//    }

    public ProxClothFactory(ClothFactory obj){

        proxInf = obj;
    }

    @Override
    public void doCloth() {
        System.out.println(" Process Start" );
        proxInf.doCloth();
        System.out.println(" Process finish" );
    }
}
