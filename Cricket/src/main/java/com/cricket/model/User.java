package com.cricket.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table(name="team")
public class User {
@Id
private int id;
@NotBlank()
private String username;
@NotNull()
private String dob;
private int age;
@NotNull()
private String role;
@NotNull
private String country;
@NotNull
private String password;
public User()
{
	
}

public User(String username, String dob, int age, String role, String country, String password) {
	super();
	this.username = username;
	this.dob = dob;
	this.age = age;
	this.role = role;
	this.country = country;
	this.password = password;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getDob() {
	return dob;
}
public void setDob(String dob) {
	this.dob = dob;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}


}
