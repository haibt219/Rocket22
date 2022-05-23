package com.vti.backend.presentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.businesslayer.IUserService;
import com.vti.backend.businesslayer.UserService;
import com.vti.entity.Employee;
import com.vti.entity.Manager;
import com.vti.entity.User;

public class UserController {
	IUserService service;
	
	public UserController() throws FileNotFoundException, IOException {
		service = new UserService();
	}
	
	// List method
	public List<User> getAllUser() throws ClassNotFoundException, SQLException {
		return service.getAllUser();
	}
	
	public User getUserById(int id) throws ClassNotFoundException, SQLException {
		return service.getUserById(id);
	}
	
	public int deleteEmloyeeById(int id) throws ClassNotFoundException, SQLException {
		return service.deleteEmloyeeById(id);
	}
	
	public List<Employee> getEmployeeByProjectID(int projectId) throws SQLException, Exception {
		return service.getEmployeeByProjectID(projectId);
	}
	
	public List<Manager> getManagerOfAllProject() throws SQLException, Exception {
		return service.getManagerOfAllProject();
	}
	
	public User login(String email, String password) throws ClassNotFoundException, SQLException {
		return service.login(email, password);
	}
	
	public void createEmployee(String name, String email, int project, String proSkill)
			throws ClassNotFoundException, SQLException {
		service.createEmployee(name, email, project, proSkill);
	}
	
	public boolean isUserExistsByEmail(String email) throws SQLException, ClassNotFoundException {
		return service.isUserExistsByEmail(email);
	}
}
