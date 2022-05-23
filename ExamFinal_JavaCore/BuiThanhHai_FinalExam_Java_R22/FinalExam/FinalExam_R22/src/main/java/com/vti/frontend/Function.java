package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.presentationlayer.UserController;
import com.vti.entity.Employee;
import com.vti.entity.Manager;
import com.vti.entity.User;
import com.vti.utils.ScannerUtils;

public class Function {
	private UserController controller;
	
	public Function() throws FileNotFoundException, IOException {
		controller = new UserController();
	}
	
	
	public void getAllUser() throws ClassNotFoundException, SQLException {
		List<User> listUsers = controller.getAllUser();
		
		System.out.printf("|%-5s | %-20s | %-22s | %-10s | \n", "ID", "Fullname", "Email", "Role ");
		System.out.println("|-------------------------------------------------------------------|");
		for (User user : listUsers) {
			System.out.printf("|%-5s | %-20s | %-22s | %-10s | \n", user.getId(), user.getFullName(), user.getEmail(), user.getRole());
			System.out.println("|-------------------------------------------------------------------|");
		}
	}
	
	public void getUserById() throws ClassNotFoundException, SQLException {
		System.out.println("Enter UserID:");
		int id = ScannerUtils.inputInt();

		User user = controller.getUserById(id);
		if (user != null) {
			System.out.println(user);
		} else {
			System.out.println("Does not exist user with id = " + id + "!");
		}
	}
	
	public void deteleEmployeeById() throws ClassNotFoundException, SQLException {
		System.out.println("Enter UserID:");
		int id = ScannerUtils.inputInt();
		
		int aff_count = controller.deleteEmloyeeById(id);
		if (aff_count > 0) {
			System.out.println("Delete successfully!");
		} else {
			System.out.println("Does not exist user with id = " + id + "!");
		}
	}
	
	public void getEmployeeByProjectId() throws SQLException, Exception {
		System.out.println("Enter EmployeeID:");
		int id = ScannerUtils.inputInt();
		
		List<Employee> listEmployees = controller.getEmployeeByProjectID(id);
		System.out.println(".---------------------------------------------------------------------------------------------.");
		System.out.printf("|%-5s | %-20s | %-22s | %-10s | %-10s | %-10s |\n", "ID", "Fullname", "Email", "Role", "ProjectID", "ProSkill");
		System.out.println("|---------------------------------------------------------------------------------------------|");
		for (Employee employee : listEmployees) {
			System.out.printf("|%-5s | %-20s | %-22s | %-10s | %-10s | %-10s |\n", employee.getId(), employee.getFullName(), employee.getEmail(), employee.getRole(), employee.getProjectId(), employee.getProSkill());
			System.out.println("|---------------------------------------------------------------------------------------------|");
		}
	}
	
	public void getManagerOfAllProject() throws SQLException, Exception {	
		List<Manager> listManagers = controller.getManagerOfAllProject();
		System.out.println(".---------------------------------------------------------------------------------------------.");
		System.out.printf("|%-5s | %-20s | %-22s | %-10s | %-10s | %-10s |\n", "ID", "Fullname", "Email", "Role", "ProjectID", "ExpInYear");
		System.out.println("|---------------------------------------------------------------------------------------------|");
		for (Manager manager : listManagers) {
			System.out.printf("|%-5s | %-20s | %-22s | %-10s | %-10s | %-10s |\n", manager.getId(), manager.getFullName(), manager.getEmail(), manager.getRole(), manager.getProject(), manager.getExpInYear());
			System.out.println("|---------------------------------------------------------------------------------------------|");
		}
	}
	
	public User login() throws ClassNotFoundException, SQLException {
		while (true) {
			System.out.println("--------- LOGIN ----------");
			System.out.println("Enter Email:");
			String email = ScannerUtils.inputEmail();
			System.out.println("Enter Password:");
			String password = ScannerUtils.inputPassword();
			
			User user = controller.login(email, password);
			if (user != null) {
				System.out.printf("Welcome %s %s%s", user.getFullName(), user.getRole(),"!\n");
				return user;
			} else {
				System.out.println("You have entered the wrong email or password, Please re-enter!");
			}
		}
	}
	
	public void createEmployee() throws ClassNotFoundException, SQLException {	
		System.out.println("Enter FullName:");
		String name = ScannerUtils.inputName();
		System.out.println("Enter Email:");
		String email;
		while (true) {
			email = ScannerUtils.inputEmail();
			boolean result = controller.isUserExistsByEmail(email);
			if (result == true) {
				System.out.println("This email already exists, please enter another email!");
			} else {
				break;
			}
		}
		System.out.println("Enter ProjectID:");
		int project = ScannerUtils.inputInt();
		System.out.println("Enter Proskill:");
		String proSkill = ScannerUtils.inputString();
		
		controller.createEmployee(name, email, project,  proSkill);
		System.out.println("You have successfully created an employee named" + name);
	}
	
	
}
