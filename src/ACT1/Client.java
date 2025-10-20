package ACT1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
public static void main(String[] args){
    try{
        int port = 1234;
        Socket SocClient = new Socket("Localhost", port);
        System.out.println("Client is connected on server "+port);

        // receiving msg
        BufferedReader in = new BufferedReader(new InputStreamReader(SocClient.getInputStream()));
        String Info = in.readLine();
        System.out.println(Info);

        //closing connection
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}
}
