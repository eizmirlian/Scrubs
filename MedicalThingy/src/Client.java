import java.io.*;
import java.net.*;

public class Client {
    static DataInputStream dis;
    static DataOutputStream dos;
    static Socket s;
    static InetAddress ip;
    public Client(String ip, int port) {
        try {
            Client.ip = InetAddress.getByName(ip);
            System.out.println(Client.ip.getHostName());
            Client.s = new Socket(Client.ip, port);
            Client.dis = new DataInputStream(s.getInputStream());
            Client.dos = new DataOutputStream(s.getOutputStream());
            
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    public static void send(String m) {
        try {
            Client.dos.writeUTF(m);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String listen() {
        try {
            return Client.dis.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
    }
    public static void close() {
        try {
            Client.s.close();
            Client.dis.close();
            Client.dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

}
