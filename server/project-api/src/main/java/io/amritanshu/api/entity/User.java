package io.amritanshu.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
@NamedQueries({ @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username=:pUsername"),
		@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u ORDER BY u.firstName ASC"),
		@NamedQuery(name = "User.login", query = "SELECT u FROM User u WHERE u.username=:pUsername AND u.password=:pPassword") })
public class User {

	@Id
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator = "customUUID")
	private String id;

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
		return id;
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

	public void setId(String id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", username=" + username + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", city=" + city + ", state=" + state + ", zip=" + zipCode + "]";
	}
}