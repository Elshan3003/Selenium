package com.Selenium.utils;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	private static Connection connection;
	private static Statement statement;
	private static ResultSet resultset;
	
	private static void setConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/4stay_test","root","root");
			statement=connection.createStatement();
			assertNotNull(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static String getSingleString(String query) {
		setConnection();
		String value = null;
		
		try {
			resultset=statement.executeQuery(query);
			while(resultset.next()){
				value=resultset.getString(1);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally{
			closeConnection();
		}		
		return value;		
	}

	private static void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	

}
