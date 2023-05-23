package com.sparebyte.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnectionUtil extends commonUtil {
	
	private static Connection connection;
	
	private DBConnectionUtil() {
		
	}
	
	public static Connection getDBConnection() throws ClassNotFoundException, SQLException{
		
		if (connection == null || connection.isClosed()) {
			Class.forName(properties.getProperty(commonConstants.DRIVER_NAME));
			connection = DriverManager.getConnection(properties.getProperty(commonConstants.URL),
					properties.getProperty(commonConstants.USERNAME), properties.getProperty(commonConstants.PASSWORD));
			
			System.out.println("connected");
		}
		
		return connection;
		
	}

}
