import org.junit.Test;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class networkTest {

    @Test
    public void InetAddressTest() throws UnknownHostException {

        InetAddress localHost = InetAddress.getLocalHost();

        System.out.println(localHost);

    }

    @Test
    public void TcpClient() throws IOException {

        Socket socket = new Socket("192.168.11.29",8181);

        OutputStream os = socket.getOutputStream();
        //InputStream is = socket.getInputStream();

        File f1 = new File("C:\\Users\\Ryan\\Desktop\\Java pjt\\filetest\\heat_sink.jpg");


        InputStream bis = new FileInputStream(f1);


        int len;
        byte[] buf = new byte[1024];

        while((len = bis.read(buf))!= -1 ){

            os.write(buf,0,len);
        }


        socket.shutdownOutput();
//        os.write("test123".getBytes(StandardCharsets.UTF_8));
//
//        os.flush();;
        bis.close();;
        os.close();
        socket.close();;




    }

    @Test
    public void TcpService() throws IOException {

        Socket socket = new Socket();

        ServerSocket ss = new ServerSocket(8181);

        socket = ss.accept();

        InputStream is = socket.getInputStream();

        FileOutputStream os = new FileOutputStream( new File("C:\\Users\\Ryan\\Desktop\\Java pjt\\filetest\\heat_sink_network.jpg"));

        byte[] buffer = new byte[1024];
        int len;

        while((len = is.read(buffer)) != -1){

            os.write(buffer,0,len);

        }

        os.close();;
        is.close();
        ss.close();
        socket.close();

    }


    @Test
    public void UDPClient() throws IOException {

        DatagramSocket ds = new DatagramSocket();

        byte[] data = "This is UDP222222222222222".getBytes(StandardCharsets.UTF_8);

        DatagramPacket dp = new DatagramPacket(data,0, data.length,InetAddress.getLocalHost(),9090);

        ds.send(dp);

        ds.close();;

    }
    @Test
    public void UDPReceiver() throws IOException {

        DatagramSocket dsr = new DatagramSocket(9090);

        byte[] dataR = new byte[1024];

        DatagramPacket dpR= new DatagramPacket(dataR, dataR.length);

        dsr.receive(dpR);


        String str = new String(dpR.getData(),0, dpR.getLength());

        System.out.println(str);

        dsr.close();



    }


}


