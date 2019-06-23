package dao;

import java.util.ArrayList;

import bean.user;

public class utils {
	private static final String pathyml = "/Users/la-alanrgo/Documents/UNICAMP/Charlinho/rmi-project/src/movie-data.yml";
	
	protected static String getPathYML() {
		return pathyml;
	}
	
	protected static String arrayLUserstoString(ArrayList<user> users) {
		String s = "";
		
		for(user u : users) {
			s = s.concat(u.toString() + "\n");
		}
	
		return s.substring(0, s.length()-1);
	}
}
