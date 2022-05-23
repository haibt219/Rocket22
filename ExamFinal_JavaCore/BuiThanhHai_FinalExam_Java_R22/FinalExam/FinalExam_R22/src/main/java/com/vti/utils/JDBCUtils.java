package com.vti.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {
	private Properties properties;
	private Connection connection;
	
	public JDBCUtils() throws FileNotFoundException, IOException {
		properties = new Properties();
		properties.load(new FileInputStream("D:\\VTI Academy\\JavaBasic\\BuiThanhHai_FinalExam_Java_R22\\FinalExam\\FinalExam_R22\\src\\main\\resource\\database.properties"));
	}
	
	// Get Connection
	public Connection getConnect() throws ClassNotFoundException, SQLException {
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		String driver = properties.getProperty("driver");
		Class.forName(driver);
		connection = DriverManager.getConnection(url, username, password);
		
		return connection;	
	}
	
	// Disconnection
	public void disConnect() throws SQLException {
		connection.close();
	}
	
}
