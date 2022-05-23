package com.vti.backend.datalayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Employee;
import com.vti.entity.Manager;
import com.vti.entity.User;

public interface IUserRepository {
	public List<User> getAllUser() throws ClassNotFoundException, SQLException;
	
	public User getUserById(int id) throws ClassNotFoundException, SQLException;
	
	public int deleteEmloyeeById(int id) throws ClassNotFoundException, SQLException;
	
	public List<Employee> getEmployeeByProjectID(int projectId) throws SQLException, Exception;
	
	public List<Manager> getManagerOfAllProject() throws SQLException, Exception;
	
	public User login(String email, String password) throws ClassNotFoundException, SQLException;
	
	public void createEmployee(String name, String email, int project, String proSkill) throws ClassNotFoundException, SQLException;
	
	public boolean isUserExistsByEmail(String email) throws SQLException, ClassNotFoundException;
}
