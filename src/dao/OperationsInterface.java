package dao;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface OperationsInterface extends Remote {

	String usersFromCourse(String course) throws RemoteException;

	String skillsFromCity(String city) throws RemoteException;

	void newExpUser(String email, String exp) throws  RemoteException;

	String expFromUser(String email) throws RemoteException;

	String listUsers() throws RemoteException;

	String infoUser(String email) throws RemoteException;
}
