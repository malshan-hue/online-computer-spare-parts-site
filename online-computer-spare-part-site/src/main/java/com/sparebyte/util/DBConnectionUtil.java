/**
 * OOP project year 2 semester 1, 2023
 * 
 * @author Malshan Rathnayake Software Engineering Undergraduate, SLIIT 
 * 
 * @version 1.0
 * Copyright: Malshan, All rights reserved
 * 
 */

package com.sparebyte.util;

/**
 * This is the Database connection creation class .
 * 
 * @author Malshan Rathnaaye, SLIIT Undergraduate
 * @version 1.0
 * @see #CommonUtil
 */
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
			
		}
		
		return connection;
		
	}

}
