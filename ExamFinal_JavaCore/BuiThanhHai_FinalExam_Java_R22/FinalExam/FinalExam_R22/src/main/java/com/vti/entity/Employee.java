package com.vti.entity;

public class Employee extends User {
	private int projectId;
	private String proSkill;
	
	public Employee() {
		
	}
	
	public Employee(String fullName, String email) {
		super(fullName, email, Role.EMPLOYEE);
	}

	public Employee(String fullName, String email, int projectId, String proSkill) {
		super(fullName, email, Role.EMPLOYEE);
		this.projectId = projectId;
		this.proSkill = proSkill;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProSkill() {
		return proSkill;
	}

	public void setProSkill(String proSkill) {
		this.proSkill = proSkill;
	}
	
	@Override
	public String toString() {
		return "[EmployeeID: " + getId()  + " | FullName: " + getFullName() + " | Email: " + getEmail() + " | ProjectID: " + getProjectId() + " | ProSkil: " + getProSkill() + " | Role: " + getRole() + "]";
	}
	
}
