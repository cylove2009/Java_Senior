package com.yi.proxStatic;

public class NikeClothFactory implements ClothFactory{
    @Override
    public void doCloth() {

        System.out.println( "this is do Cloth" + this.getClass());

    }
}
