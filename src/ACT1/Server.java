package ACT1;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try{
            int ClientOrder = 0;
            int port = 1234;
            ServerSocket server = new ServerSocket(port);
            System.out.println("server online on "+port);
            while(true){
                Socket SocketClient = server.accept();
                ClientOrder++;
                Thread t = new ClientThread(ClientOrder, SocketClient);
                t.start();
            }
        }catch (IOException e){
            System.out.println(e);
        }
    }
}