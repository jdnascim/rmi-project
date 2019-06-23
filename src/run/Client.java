package run;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import dao.CommandManager;
import dao.Commands;
import dao.OperationsInterface;
import dao.ParsedCommand;

public class Client {


    private String processCommand(String raw, OperationsInterface rInterface) {
        ParsedCommand cmd = CommandManager.processCommand(raw);

        try {
            if( cmd.type == Commands.LIST_FROM_COURSE) {
                return rInterface.usersFromCourse(cmd.value);
            }
            if( cmd.type == Commands.SKILLS_FROM_CITY) {
                return rInterface.skillsFromCity(cmd.value);
            }
            if( cmd.type == Commands.ADD_EXPERIENCE) {
                rInterface.newExpUser(cmd.parameterName, cmd.value);
            }
            if( cmd.type == Commands.LIST_PROFILE) {
                return rInterface.infoUser(cmd.value);
            }
            if( cmd.type == Commands.EXPERIENCE_PROFILE ) {
                return rInterface.expFromUser(cmd.value);
            }
            if( cmd.type == Commands.LIST_ALL) {
                return rInterface.listUsers();
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return "";
    }


    public static void main(String[] args) {
        try {
            long start = System.nanoTime();
            long end;

            if( args.length != 2 ) {
                System.err.println("Wrong arguments: try to execute client with <IPAddress> and <Command>");
                return;
            }

            Client client = new Client();
            Registry reg = LocateRegistry.getRegistry(args[0], 1099);
            OperationsInterface rInterface = (OperationsInterface) reg.lookup("resume2");
            String message = client.processCommand(args[1], rInterface);
            System.out.println(message);

            end = System.nanoTime();
            System.out.println("Connection time: " + (end - start)/1000000 + "ms");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
