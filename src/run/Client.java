package run;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import dao.OperationsInterface;

public class Client {

    public static void main(String[] args) {
        try {
            Registry reg = LocateRegistry.getRegistry("127.0.0.1", 1099);
            OperationsInterface rInterface = (OperationsInterface) reg.lookup("resume");
            String message =  rInterface.infoUser("alan@ricardo.com");
            System.out.println("Echo: " + message);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}