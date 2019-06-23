package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashSet;

import bean.user;

public class operations extends UnicastRemoteObject implements OperationsInterface{

	public operations() throws RemoteException {
	}

	// (1) listar todas as pessoas formadas em um determinado curso;
	public String usersFromCourse(String course) {
		ArrayList<user> users = read.read_db();
		
		ArrayList<user> users_course = new ArrayList<user>();
		
		for(user u : users) {
			if(u.getCertification().equals(course)){
				users_course.add(u);
			}
		}
		
		return utils.arrayLUserstoString(users_course);
		
	}
	
	// (2) listar as habilidades dos perfis que moram em uma determinada cidade
	public String skillsFromCity(String city) {
		ArrayList<user> users = read.read_db();
		
		HashSet<String> skills_city = new HashSet<String>();
		
		for(user u : users) {
			if(u.getCity().equals(city)){
				for(String skill : u.getSkills()) {
					skills_city.add(skill);
				}
			}
		}
		
		return skills_city.toString();		
	}
	
	// (3) acrescentar uma nova experiência em um perfil;
	public void newExpUser(String email, String exp) {
		ArrayList<user> users = read.read_db();
		
		for(user u : users) {
			if(u.getEmail().equals(email)){
				u.newExperience(exp);
			}
		}
		
		write.write_db(users);
	}
	
	// (4) dado o email do perfil, retornar sua experiência
	public String expFromUser(String email) {
		ArrayList<user> users = read.read_db();
		
		for(user u : users) {
			if(u.getEmail().equals(email)){
				return u.getExperience().toString();
			}
		}
		
		return "";		
	}
	
	// (5) listar todas as informações de todos os perfis;
	public String listUsers() {
		ArrayList<user> users = read.read_db();
		
		return utils.arrayLUserstoString(users);
	}
	
	// (6) dado o email de um perfil, retornar suas informações.
	public String infoUser(String email) {
		ArrayList<user> users = read.read_db();
		
		for(user u : users) {
			if(u.getEmail().equals(email)){
				return u.toString();
			}
		}
		
		return "";		
	}
}
