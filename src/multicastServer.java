import java.io.IOException;
import java.net.*;
import java.util.Date;

public class multicastServer {
public static void main(String args[]) throws SocketException {
        System.out.println("멀티캐스트 타임 서버");
                DatagramSocket serverSocket = null;  //UDP
        try {
            serverSocket = new DatagramSocket();
            while (true) {
                String dateText = new Date().toString();

                byte[] buffer = new byte[256];
                buffer = dateText.getBytes();

                InetAddress group = InetAddress.getByName("224.0.0.7");
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, 10000);
                serverSocket.send(packet);
                System.out.println("전송된 시간: " + dateText);
                try {
                    Thread.sleep(1000);  //1초 단위 딜레이
                } catch (InterruptedException ex) {
                    // Handle exception
                }
            }

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
}
}
