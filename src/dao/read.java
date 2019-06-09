package dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import bean.user;

public class read {
	
	protected static ArrayList<user> read_db() {
		String email, name, lastName, city, certification;
		ArrayList<String> skills, experience;
		ArrayList<user> users = new ArrayList<user>();
		
        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(utils.getPathYML()))) {

            // read line by line
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

        String usersStr[] = sb.toString().split("-");
        
        for(int i = 1; i < usersStr.length; i++) {
        	email = "";
        	certification = "";
        	name = "";
        	lastName = "";
        	city = "";
        	
        	skills = new ArrayList<String>();
        	experience = new ArrayList<String>();
        	
        	String[] userPar = usersStr[i].split("\n");
        	
        	for(String par : userPar) {
        		String valres[] = par.strip().split(":");
        		switch(valres[0]) {
        			case "email":
        				email = valres[1].strip();
        				break;
        			case "city":
        				city = valres[1].strip();
        				break;
        			case "certification":
        				certification = valres[1].strip();
        				break;
        			case "name":
        				name = valres[1].strip();
        				break;
        			case "lastName":
        				lastName = valres[1].strip();
        				break;
        			case "experience":
        				for(String exp : valres[1].strip().substring(1, valres[1].length()-2).split(",")) {
        					
        					experience.add(exp.strip());
        				}
        				break;
        			case "skills":
        				for(String skl : valres[1].strip().substring(1, valres[1].length()-2).split(",")) {
        					skills.add(skl.strip());
        				}
        				break;
        		}
        	}
        	
        	users.add(new user(email, name, lastName, city, certification, skills, experience));
        }
        
        
        return users;	
 
	}


}
