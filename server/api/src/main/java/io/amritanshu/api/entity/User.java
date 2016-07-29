package io.amritanshu.api.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

public class User {

	@Id
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator = "customUUID")
	private String userId;

	@Column(unique = true)
	private String username;
	
	private String password;

	private String firstName;
	private String lastName;

	private String city;
	private String state;
	private int zipCode;

	private String role = "User";

	public String getId() {
		return userId;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public int getZipCode() {
		return zipCode;
	}

	public String getRole() {
		return role;
	}

	@Override
	public String toString() {
		return "Movie [id=" + userId + ", username=" + username + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", city=" + city + ", state=" + state + ", zip=" + zipCode + "]";
	}
}