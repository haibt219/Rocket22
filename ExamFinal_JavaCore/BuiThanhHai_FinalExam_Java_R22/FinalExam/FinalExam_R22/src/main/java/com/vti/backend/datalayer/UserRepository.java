package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Employee;
import com.vti.entity.Manager;
import com.vti.entity.User;
import com.vti.utils.JDBCUtils;

public class UserRepository implements IUserRepository{
	private JDBCUtils jdbcUtils;
	
	public UserRepository() throws FileNotFoundException, IOException {
		jdbcUtils = new JDBCUtils();
	}
	
	// Get all user
	public List<User> getAllUser() throws ClassNotFoundException, SQLException {
		try {
			List<User> listUsers = new ArrayList<User>();
			Connection connection = jdbcUtils.getConnect();
			
			Statement statement = connection.createStatement();
			String query = "SELECT * FROM usermanager.user";
			ResultSet resultSet = statement.executeQuery(query);
			
			while (resultSet.next()) {
				int id = resultSet.getInt("UserID");
				String fullName = resultSet.getString("FullName");
				String email = resultSet.getString("Email");
				String role = resultSet.getString("Role");
				int project = resultSet.getInt("ProjectID");
				
				if (role.equals("Manager")) {
					int expInYear = resultSet.getInt("ExpInYear");
					User manager = new Manager(fullName, email, expInYear, project);
					manager.setId(id);
					listUsers.add(manager);
					
				} else {
					String proSkill = resultSet.getString("ProSkill");
					User user = new Employee(fullName, email, project, proSkill);
					user.setId(id);
					listUsers.add(user);
				}

			}
			
			return listUsers;
		} finally {
			jdbcUtils.disConnect();
		}
	}
	
	// Get user by id
	public User getUserById(int id) throws ClassNotFoundException, SQLException {
		try {
			Connection connection = jdbcUtils.getConnect();
			
			String query = "SELECT * FROM usermanager.user WHERE UserID = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				int id2 = resultSet.getInt("UserID");
				String fullName = resultSet.getString("FullName");
				String email = resultSet.getString("Email");
				String role = resultSet.getString("Role");
				int project = resultSet.getInt("ProjectID");
				
				if (role.equals("Manager")) {
					int expInYear = resultSet.getInt("ExpInYear");
					User manager = new Manager(fullName, email, expInYear, project);
					manager.setId(id2);
					return manager;
					
				} else {
					String proSkill = resultSet.getString("ProSkill");
					User employee = new Employee(fullName, email, project, proSkill);
					employee.setId(id2);
					return employee;
				}
			} else {
				return null;
			}
		} finally {
			jdbcUtils.disConnect();
		}
		
	}
	
	// Delete employee
	public int deleteEmloyeeById(int id) throws ClassNotFoundException, SQLException {
		try {
			Connection connection = jdbcUtils.getConnect();
			
			String query = "DELETE FROM user WHERE UserID = ? AND `Role` = 'Employee'";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			
			int count = statement.executeUpdate();
			
			return count;
		} finally {
			jdbcUtils.disConnect();
		}
		
	}

	// Get employee by project id
	public List<Employee> getEmployeeByProjectID(int projectId) throws SQLException, Exception {
		try {
			List<Employee> listUsers = new ArrayList<Employee>();
			Connection connection = jdbcUtils.getConnect();
			
			String query = "SELECT * FROM usermanager.user WHERE ProjectID = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, projectId);
			
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("UserID");
				String fullName = resultSet.getString("FullName");
				String email = resultSet.getString("Email");
				String role = resultSet.getString("Role");
				int project = resultSet.getInt("ProjectID");
				
				String proSkill = resultSet.getString("ProSkill");
				if (role.equals("Employee")) {
					User employee = new Employee(fullName, email, project, proSkill);
					employee.setId(id);
					
					listUsers.add((Employee) employee);
				}
			}
			
			return listUsers;
		} finally {
			jdbcUtils.disConnect();
		}
		
	}
	
	// Get manager by project id
	public List<Manager> getManagerOfAllProject() throws SQLException, Exception {
		try {
			List<Manager> listUsers = new ArrayList<Manager>();
			Connection connection = jdbcUtils.getConnect();
			
			String query = "SELECT * FROM usermanager.user";
			PreparedStatement statement = connection.prepareStatement(query);
			
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("UserID");
				String fullName = resultSet.getString("FullName");
				String email = resultSet.getString("Email");
				String role = resultSet.getString("Role");
				int project = resultSet.getInt("ProjectID");
				
				int expInYear = resultSet.getInt("ExpInYear");
				if (role.equals("Manager")) {
					User manager = new Manager(fullName, email, expInYear, project);
					manager.setId(id);
					
					listUsers.add((Manager) manager);
				}
				
			}
			return listUsers;
		} finally {
			jdbcUtils.disConnect();
		}
		
	}
	
	// Login
	public User login(String email, String password) throws ClassNotFoundException, SQLException {
		try {
			Connection connection = jdbcUtils.getConnect();
			
			String query = "SELECT UserID, FullName, Role FROM `user` WHERE Email = ? AND Password = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, email);
			statement.setString(2, password);
			ResultSet resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				int id = resultSet.getInt("UserID");
				String fullName = resultSet.getString("FullName");
				String role = resultSet.getString("Role");
				
				if (role.equals("Manager")) {
					User manager = new Manager(fullName, email);
					manager.setId(id);
					return manager;
				} else {
					User employee = new Employee(fullName, email);
					employee.setId(id);
					return employee;
				}		
			} else {
				return null;
			}
		} finally {
			jdbcUtils.disConnect();
		}
	}

	public void createEmployee(String name, String email, int project, String proSkill)
			throws ClassNotFoundException, SQLException {
		try {
			Connection connection = jdbcUtils.getConnect();
			
			String query = 	"INSERT INTO user	(FullName	, 	Email	, 	Password	, Role		, 		ProjectID	, 	ProSkill) "
							+ "VALUES			(?			,	?		,	'123456'	, 'Employee'	,	?		,	?		);";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, name);
			statement.setString(2, email);
			statement.setInt(3, project);
			statement.setString(4, proSkill);
			
			
			statement.executeUpdate();
		} finally {
			jdbcUtils.disConnect();
		}
	}
	
	public boolean isUserExistsByEmail(String email) throws SQLException, ClassNotFoundException {
		try {
			Connection connection = jdbcUtils.getConnect();
	
			String query = "SELECT 1 FROM `user` WHERE Email = ? ";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, email);
	
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				return true;
			} else {
				return false;
			}
		} finally {
			jdbcUtils.disConnect();
		}
	}

}
