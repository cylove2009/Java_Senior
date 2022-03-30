package com.yi.ExceptionPractice;

public class ExceptionPrep {

    public static void main(String[] args) {

        try{

        int i = Integer.parseInt(args[1]);
        int j =Integer.parseInt(args[2]);

        //try{

            EcmDef.ecm(i,j);

        }catch(NumberFormatException e){
            e.printStackTrace();
        }catch(ArithmeticException a){
            a.printStackTrace();
        }catch(EcDef e){
            e.getMessage();
        }catch(ArrayIndexOutOfBoundsException a){
            a.printStackTrace();
        }




    }
}

class EcmDef {


    public static int ecm(int a1, int a2) throws EcDef {

        if(a1 < 0 || a2 <0)
            throw new EcDef("minus input");
        else
            return a1/a2;
    }
}
class EcDef extends Exception{

    static final long SerialVersionUID = 1232132324234L; // missing

    public EcDef(){};

    public EcDef(String message){
        super(message); // wrong
        System.out.println(message);
    }

}
