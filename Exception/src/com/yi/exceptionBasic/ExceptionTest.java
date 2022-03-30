package com.yi.exceptionBasic;

import org.junit.Test;

import javax.imageio.IIOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionTest {

    @Test
    public void ExceptionTest(){

        int x = 5;
        try{

            x=x/0;
            System.out.println("try output");

        }catch(ArithmeticException e){

            e.printStackTrace();
        }finally{

            System.out.println("output finally" + x);
        }


    }

    @Test
    public void WithnoExceptionTest(){

        int x = 5;

        x=x/0;

        System.out.println("output finally");
    }

    @Test
    public void FileException() {

        File file = new File("test.txt");

        FileInputStream fis = null;
        try
        {

             fis = new FileInputStream(file);

            int data = fis.read();
            while (data != -1) {

                data = fis.read();
            }
        } catch (FileNotFoundException e) {   // FileNotFoundException and IOException cannot switch order. Child always come first.

            e.printStackTrace();

        }catch (IOException exp){

            exp.printStackTrace();

        }finally{

            try{
                if(fis != null) //  FileInputStream can be null
                    fis.close();}
            catch(IOException e){
                e.printStackTrace();
            }
        }

    }
}
