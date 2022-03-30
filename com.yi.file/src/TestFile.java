import org.junit.Test;

import java.io.*;

public class TestFile {

    @Test
    public void test() throws IOException {

        File f1 = new File("testabc.txt");
        File f2 = new File("C:\\Users\\Ryan\\Desktop\\Java pjt\\filetest\\hello.txt");

        System.out.println(f1.exists());
        //System.out.println(f1.isAbsolute());

        System.out.println(f2.exists());

        FileReader fr = new FileReader(f2);

       int tmp = fr.read();

        while(tmp != -1 ){
            System.out.println((char) tmp);
            tmp = fr.read();
        }

        fr.close();


    }

    @Test
    public void filetest2() throws IOException {


        File f1 = new File("C:\\Users\\Ryan\\Desktop\\Java pjt\\filetest\\hello.txt");
        File f2 = new File("C:\\Users\\Ryan\\Desktop\\Java pjt\\filetest\\hellocopy.txt");



        FileReader fr= new FileReader(f1);
        FileWriter wr = new FileWriter(f2,true);

        char[] cbuf = new char[5];

        int len = 0;

        while((len = fr.read(cbuf)) != -1){

            for(int i = 0; i < len; i++) {
                wr.write(cbuf[i]);
            }
//            wr.write(cbuf,0,len);
        }



        fr.close();
        wr.close();

    }

    @Test
    public void FileInputOutputStreamtest3() throws IOException {

        File f1 = new File("C:\\Users\\Ryan\\Desktop\\Java pjt\\filetest\\heat_sink.jpg");
        File f2 = new File("C:\\Users\\Ryan\\Desktop\\Java pjt\\filetest\\heat_sink2.jpg");

        FileInputStream fis = new FileInputStream(f1);
        FileOutputStream fos = new FileOutputStream(f2);


        byte[] buff = new byte[1024];

        int len = 0 ;
        while((len = fis.read(buff)) != -1){

            fos.write(buff,0,len);
        }

        fos.close();;
        fis.close();
    }

    @Test
    public void BufferInputOutputStreamtest() throws IOException {

        File f1 = new File("C:\\Users\\Ryan\\Desktop\\Java pjt\\filetest\\heat_sink.jpg");
        File f2 = new File("C:\\Users\\Ryan\\Desktop\\Java pjt\\filetest\\heat_sink3.jpg");

        FileInputStream fis = new FileInputStream(f1);
        FileOutputStream fos = new FileOutputStream(f2);

        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        int len = 0;

        byte[] buffer = new byte[1024];

        while((len=bis.read(buffer)) != -1){

            bos.write(buffer,0,len);

        }

        bis.close();;
        bos.close();




    }
}
