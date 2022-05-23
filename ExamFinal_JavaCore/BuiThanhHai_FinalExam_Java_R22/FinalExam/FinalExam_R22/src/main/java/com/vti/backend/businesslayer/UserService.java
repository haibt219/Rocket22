package com.vti.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.datalayer.IUserRepository;
import com.vti.backend.datalayer.UserRepository;
import com.vti.entity.Employee;
import com.vti.entity.Manager;
import com.vti.entity.User;

public class UserService implements IUserService{
	IUserRepository repository;
	
	public UserService() throws FileNotFoundException, IOException {
		repository = new UserRepository();
	}
	
	public User getUserById(int id) throws ClassNotFoundException, SQLException {
		return repository.getUserById(id);
	}
	
	public List<User> getAllUser() throws ClassNotFoundException, SQLException {
		return repository.getAllUser();
	}

	public int deleteEmloyeeById(int id) throws ClassNotFoundException, SQLException {
		return repository.deleteEmloyeeById(id);
	}
	
	public List<Employee> getEmployeeByProjectID(int projectId) throws SQLException, Exception {
		return repository.getEmployeeByProjectID(projectId);
	}

	public List<Manager> getManagerOfAllProject() throws SQLException, Exception {
		return repository.getManagerOfAllProject();
	}

	public User login(String email, String password) throws ClassNotFoundException, SQLException {
		return repository.login(email, password);
	}

	public void createEmployee(String name, String email, int project, String proSkill)
			throws ClassNotFoundException, SQLException {
		repository.createEmployee(name, email, project, proSkill);
	}

	public boolean isUserExistsByEmail(String email) throws SQLException, ClassNotFoundException {
		return repository.isUserExistsByEmail(email);
	}
	

}
