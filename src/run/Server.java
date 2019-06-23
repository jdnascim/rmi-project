package run;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import dao.operations;

public class Server {

    public static void main(String[] args) {
        try {
            Registry reg = LocateRegistry.createRegistry(1099);
            operations service = new operations();
            reg.rebind("resume", service);

            System.out.println("System is ready!");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
