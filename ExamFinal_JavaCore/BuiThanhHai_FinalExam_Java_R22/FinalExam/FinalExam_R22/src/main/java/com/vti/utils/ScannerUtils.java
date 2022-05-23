package com.vti.utils;

import java.util.Scanner;

public class ScannerUtils {
	private static Scanner scanner = new Scanner(System.in);
	
	// Input Name
	public static String inputName() {
		
		return inputName("Please input a name, please input again.");
	}
	
	public static String inputName(String errorMessage) {
		while (true) {
			try {
				String inputName = scanner.nextLine().trim();
				inputName = inputName.replaceAll("\\s+", " ");
				
				char[] charArr = inputName.toCharArray();
				boolean foundSpace = true;
				for (int i = 0; i < charArr.length; i++) {
					if (Character.isLetter(charArr[i])) {
						if (foundSpace) {
							charArr[i] = Character.toUpperCase(charArr[i]);
							foundSpace = false;
						}
					} else {
						foundSpace = true;
					}
				}
				inputName = String.copyValueOf(charArr);
				return inputName;
			} catch (Exception e) {
				System.err.println(errorMessage);
			}
		}
	}
	
	// Input Integer
	public static int inputInt() {
		
		return inputInt("Number is not integer type, please re-enter!");
	}
	
	public static int inputInt(String errorMessage) {
		while (true) {
			try {
				return Integer.parseInt(scanner.nextLine().trim());
			} catch (Exception e) {
				System.err.println(errorMessage);
			}
		}
	}
	
	// Input Float
	public static float inputFloat() {
			
			return inputFloat("Number is not real number type, please re-enter!");
		}
		
	public static float inputFloat(String errorMessage) {
			while (true) {
				try {
					return Float.parseFloat(scanner.nextLine().trim());
				} catch (Exception e) {
					System.err.println(errorMessage);
				}
			}
		}
		
	// Input Double
	public static double inputDouble() {
		
		return inputDouble("Number is not real number type, please re-enter!");
	}
	
	public static double inputDouble(String errorMessage) {
		while (true) {
			try {
				return Double.parseDouble(scanner.nextLine().trim());
			} catch (Exception e) {
				System.err.println(errorMessage);
			}
		}
	}
	
	// Input String
	public static String inputString() {
		
		return inputString("You have not entered anything, please re-enter!");
	}
	
	public static String inputString(String errorMessage) {
		while (true) {
			String input = scanner.nextLine().trim();
			if (!input.isEmpty()) {
				return input;
			} else {
				System.err.println(errorMessage);
			}
		}
		
	}
	
	// Input email
	public static String inputEmail() {
		return inputEmail("You enter not email format, please re-enter!");
	}
	
	@SuppressWarnings("null")
	public static String inputEmail(String errorMessage) {
		while (true) {
			String email = ScannerUtils.inputString();
			if (email != null || email.contains("@")) {
				return email;
			} else {
				System.err.println(errorMessage);
			}
		}
	}
	
	// Input password
	public static String inputPassword() {
		return inputEmail("Password must be >= 6 & <= 12 characters and have at least 1 uppercase character, please re-enter!");
	}
	
	public static String inputPassword(String errorMessage) {
		while (true) {
			String password = ScannerUtils.inputString();
			
			boolean hasAtLeast1Charecter = false;
			
			for (int i = 0; i < password.length(); i++) {
				if (Character.isUpperCase(password.charAt(i)) == true) {
					hasAtLeast1Charecter = true;
				}
			}
			
			if (password.length() < 6 || password.length() > 12 || hasAtLeast1Charecter == false) {
				return password;
			} else {
				System.err.println(errorMessage);
			}
		}
	}
	
	// Input number phone
	public static String inputNumberPhone() {
		return inputNumberPhone("Please re-enter number phone!");
	}
	
	public static String inputNumberPhone(String errorMessage) {
		while (true) {
			String numberPhone = ScannerUtils.inputString();
			
			if (numberPhone.length() != 10) {
				continue;
			}
			
			if (numberPhone.charAt(0) != '0') {
				continue;
			}
			
			boolean isNumber = true;
			for (int i = 0; i < numberPhone.length(); i++) {
				if (Character.isDigit(numberPhone.charAt(i)) == false) {
					isNumber = false;
					break;
				}
			}
			
			if (isNumber == true) {
				return numberPhone;
			} else {
				System.out.println(errorMessage);
			}
		}
	}
	
	// Input 
}
