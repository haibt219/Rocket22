package com.vti.entity;

public class Manager extends User {
	private int expInYear;
	private int project;
	
	public Manager() {
		
	}
	
	public Manager(String fullName, String email) {
		super(fullName, email, Role.MANAGER);
	}
	
	public Manager(String fullName, String email, int expInYear, int project) {
		super(fullName, email, Role.MANAGER);
		this.expInYear = expInYear;
		this.project = project;
	}

	public int getExpInYear() {
		return expInYear;
	}

	public void setExpInYear(int expInYear) {
		this.expInYear = expInYear;
	}

	public int getProject() {
		return project;
	}

	public void setProject(int project) {
		this.project = project;
	}
	
	@Override
	public String toString() {
		return "[ManagerID: " + getId()  + " | FullName: " + getFullName() + " | Email: " + getEmail() + " | ExpInYear: " + getExpInYear() + " | ProjectID: " + getProject() + " | Role: " + getRole() + "]";
	}
}
