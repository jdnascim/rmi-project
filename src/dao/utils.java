package dao;

import java.nio.file.Paths;
import java.util.ArrayList;

import bean.user;

public class utils {
	private static String pathyml = "/src/movie-data.yml";

	protected static String getPathYML() {

		return Paths.get("").toAbsolutePath() +  pathyml;
	}
	
	protected static String arrayLUserstoString(ArrayList<user> users) {
		String s = "";
		
		for(user u : users) {
			s = s.concat(u.toString() + "\n");
		}
	
		return s.substring(0, s.length()-1);
	}
}
