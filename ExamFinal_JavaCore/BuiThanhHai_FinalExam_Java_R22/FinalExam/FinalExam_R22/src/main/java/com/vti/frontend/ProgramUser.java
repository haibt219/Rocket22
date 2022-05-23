package com.vti.frontend;



import java.sql.SQLException;

import com.vti.entity.Role;
import com.vti.entity.User;
import com.vti.utils.ScannerUtils;


public class ProgramUser {
	public static void main(String[] args) throws SQLException, Exception {
		menuLogin();
	}

	private static void menuLogin() throws Exception {
		Function function = new Function();
		
		User user = function.login();
		if (user.getRole() == Role.MANAGER) {
			menuManager();
		} else {
			menuEmployee();
		}
	}
	
	private static void menuManager() throws Exception {
		Function function = new Function();
		
		boolean isContinue = true;
		while (isContinue) {
			System.out.println("1. Get all user.");
			System.out.println("2. Get user by id.");
			System.out.println("3. Detele employee by id.");
			System.out.println("4. Get employee by projectID.");
			System.out.println("5. Get manager of all project.");
			System.out.println("6. Create employee.");
			System.out.println("7. Exit.");
			System.out.println("Enter choice:");
			int choice = ScannerUtils.inputInt();
			
			switch (choice) {
			case 1:
				function.getAllUser();
				break;
			case 2:
				function.getUserById();
				break;
			case 3:
				function.deteleEmployeeById();
				break;
			case 4:
				function.getEmployeeByProjectId();
				break;
			case 5:
				function.getManagerOfAllProject();
				break;
			case 6:
				function.createEmployee();
				break;
			case 7:
				isContinue = false;
				System.out.println("Exit program.");
				break;
			default: 
				System.out.println("The function is only available from 1 to 7, Please re-enter the function!");
				break;
			}
		}
	}
	
	private static void menuEmployee() throws Exception {
		Function function = new Function();
		
		boolean isContinue = true;
		while (isContinue) {
			System.out.println("1. Get all user.");
			System.out.println("2. Get user by id.");
			System.out.println("3 Get employee by projectID.");
			System.out.println("4. Get manager of all project.");
			System.out.println("5. Exit.");
			System.out.println("Enter choice:");
			int choice = ScannerUtils.inputInt();
			
			switch (choice) {
			case 1:
				function.getAllUser();
				break;
			case 2:
				function.getUserById();
				break;
			case 3:
				function.getEmployeeByProjectId();
				break;
			case 4:
				function.getManagerOfAllProject();
				break;
			case 5:
				isContinue = false;
				System.out.println("Exit program.");
				break;
			default: 
				System.out.println("The function is only available from 1 to 7, Please re-enter the function!");
				break;
			}
		}
	}
}
