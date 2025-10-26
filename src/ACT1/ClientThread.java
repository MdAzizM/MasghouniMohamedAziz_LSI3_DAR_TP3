package ACT1;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread{
    int ClientID;
    Socket SocClient;
    public ClientThread(int ClientID, Socket SocClient){
        this.ClientID = ClientID;
        this.SocClient = SocClient;
    }

    public int getClientID() {
        return ClientID;
    }

    public void run(){
        OutputStream os = null;
        try {
            os = SocClient.getOutputStream();
            PrintWriter out = new PrintWriter(os, true);

            String cnsl = "Client Connected with IP:["+SocClient.getInetAddress()+"] ID:["+getClientID()+"]";
            String res = " your IP: "+SocClient.getInetAddress()+", your Server ID: "+getClientID();
            System.out.println(cnsl);
            out.println(res);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
