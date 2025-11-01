package ACT2;


import ACT2.Utils.Oper;

import java.io.*;
import java.net.Socket;

import static ACT2.Server.getNmb;
import static ACT2.Server.incr;
import static ACT2.Utils.Calculator.calculate;
import static ACT2.Utils.Valid.opValid;

public class CltThread extends Thread{
    int ClientID;
    Socket SocClient;
    public CltThread(int ClientID, Socket SocClient){
        this.ClientID = ClientID;
        this.SocClient = SocClient;
    }

    public int getClientID() {
        return ClientID;
    }

    public void run(){
        try {
            ObjectOutputStream out = new ObjectOutputStream(SocClient.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(SocClient.getInputStream());

            String cnsl = "Client Connected with IP:["+SocClient.getInetAddress()+"] ID:["+getClientID()+"]";
            System.out.println(cnsl);

            out.writeObject("your IP: "+SocClient.getInetAddress()+", your Server ID: "+getClientID());
            out.flush();

            while (true) {
                Oper op = (Oper) in.readObject();

                if (!opValid(op.getOperator())) {
                    out.writeObject("Error: Invalid Operator");
                    out.flush();
                    continue;
                }


                int resCalc = calculate(op.getNum1(), op.getNum2(), op.getOperator());
                int count = getNmb();
                String env = "result: " + resCalc + " [" + count + "+1] operations are made!";
                System.out.println(env);
                incr();

                out.writeObject(env);
                out.flush();
                out.reset();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
