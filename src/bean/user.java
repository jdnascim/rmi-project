package bean;

import java.util.ArrayList;

public class user {
	private String email, name, lastName, city, certification;
	private ArrayList<String> skills, experience;
	
	public user(String email, String name, String lastName, String city, String certification, ArrayList<String> skills,
			ArrayList<String> experience) {
		super();
		this.email = email;
		this.name = name;
		this.lastName = lastName;
		this.city = city;
		this.certification = certification;
		this.skills = skills;
		this.experience = experience;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCertification() {
		return certification;
	}

	public void setCertification(String certification) {
		this.certification = certification;
	}

	public ArrayList<String> getSkills() {
		return skills;
	}

	public void setSkills(ArrayList<String> skills) {
		this.skills = skills;
	}
	
	public void newSkill(String skill) {
		this.skills.add(skill);
	}

	public ArrayList<String> getExperience() {
		return experience;
	}

	public void setExperience(ArrayList<String> experience) {
		this.experience = experience;
	}
	
	public void newExperience(String exp) {
		this.experience.add(exp);
	}

	@Override
	public String toString() {
		//return "user [email=" + email + ", name=" + name + ", lastName=" + lastName + ", city=" + city
		//		+ ", certification=" + certification + ", skills=" + skills + ", experience=" + experience.toString() + "]";
		
		String str = "- certification: " + certification + '\n'
				+ "  city: " + city + '\n'
				+ "  email: " + email + '\n'
				+ "  experience: " + experience.toString() + '\n'
				+ "  lastName: " + lastName + '\n'
				+ "  name: " + name + '\n'
				+ "  skills: " + skills.toString();
		
		return str;
	}
	
	
}