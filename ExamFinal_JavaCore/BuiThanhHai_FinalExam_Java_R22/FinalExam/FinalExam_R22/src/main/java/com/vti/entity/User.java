package com.vti.entity;

public class User {
	private static int countId = 0;
	private int id;
	private String fullName;
	private String email;
	private String password;
	private Role role;
	
	public User() {
		countId++;
		this.id = countId;
	}

	public User(String fullName, String email) {
		countId++;
		this.id = countId;
		this.fullName = fullName;
		this.email = email;
	}

	public User(String fullName, String email, Role role) {
		countId++;
		this.id = countId;
		this.fullName = fullName;
		this.email = email;
		this.role = role;
	}

	public static int getCountId() {
		return countId;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "[UserID: " + id + " | FullName: " + fullName + " | Email: " + email + "]";
	}
	
	
}
