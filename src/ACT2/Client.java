package ACT2;

import ACT2.Utils.Oper;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            int port = 1234;
            Socket socket = new Socket("localhost", port);
            System.out.println("Client is connected on server " + port);

            Scanner scn = new Scanner(System.in);

            // IMPORTANT: output FIRST, input SECOND (matching server)
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in  = new ObjectInputStream(socket.getInputStream());

            // welcome message from server
            String info = (String) in.readObject();
            System.out.println(info);

            // LOOP
            while (true) {
                System.out.print("put first number: ");
                int num1 = scn.nextInt();

                System.out.print("put Sec number: ");
                int num2 = scn.nextInt();

                System.out.print("put operator: ");
                char oper = scn.next().charAt(0);

                // send object
                Oper op = new Oper(num1, num2, oper);
                out.writeObject(op);
                out.flush();
                out.reset(); // IMPORTANT: avoids cached/stale object

                // receive response as object
                String response = (String) in.readObject();
                System.out.println(response);
            }


        } catch (Exception e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}
