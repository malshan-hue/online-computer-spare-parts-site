/**
 * OOP project year 2 semester 1, 2023
 * 
 * @author Malshan Rathnayake Software Engineering Undergraduate, SLIIT 
 * 
 * @version 1.0
 * Copyright: Malshan, All rights reserved
 * 
 */
package com.sparebyte.service.user;

import java.sql.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.sparebyte.models.User;
import com.sparebyte.util.commonConstants;
import com.sparebyte.util.DBConnectionUtil;
import com.sparebyte.util.commonUtil;
import com.sparebyte.util.queryUtil;

/**
 * Contract for the implementation of User Service.
 * 
 * @author Malshan Rathnayake, SLIIT Undergraduate
 * @version 1.0
 */
public class UserServiceImpl implements IUserService{
	
	public static final Logger log = Logger.getLogger(UserServiceImpl.class.getName());
	
	private static Connection connection;
	private static Statement statement;
	
	static {
		
		createUserTable();
	}
	
	private PreparedStatement preparedStatement;
	
	private static void createUserTable() {
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			
			//statement.executeUpdate(UserQueryUtil.queryByID(UserCommonConstants.QUERY_ID_DROP_TABLE));
			
			statement.executeUpdate(queryUtil.queryByID(commonConstants.QUERY_ID_CREATE_USER_TABLE));
			
		}
		catch(SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
		
	}

	@Override
	public void addUser(User user) {
		
		
		String userID = commonUtil.generateUserIDs(getUserIDs());
		;
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			
			System.out.println("connected");
			
			preparedStatement = connection.prepareStatement(queryUtil.queryByID(commonConstants.QUERY_ID_INSERT_USER));
			connection.setAutoCommit(false);
			
			user.setUserId(userID);
			preparedStatement.setString(commonConstants.COLUMN_INDEX_ONE, user.getUserId());
			preparedStatement.setString(commonConstants.COLUMN_INDEX_TWO, user.getUserName());
			preparedStatement.setString(commonConstants.COLUMN_INDEX_THREE, user.getEmail());
			preparedStatement.setString(commonConstants.COLUMN_INDEX_FOUR, user.getPassword());
			preparedStatement.setString(commonConstants.COLUMN_INDEX_FIVE, user.getMobileNo());
			preparedStatement.setString(commonConstants.COLUMN_INDEX_SIX, user.getUserRole());
			
			
			preparedStatement.execute();
			connection.commit();
		}
		catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
		finally {
			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			}
			catch (SQLException e){
				log.log(Level.SEVERE, e.getMessage());
			}

		}
		
	}
	
	@Override
	public void updateUser(String userID, User user) {
		
		if(userID != null && !userID.isEmpty()) {
			
			try {
				
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection.prepareStatement(queryUtil.queryByID(commonConstants.QUERY_ID_UPDATE_USER));
				
				preparedStatement.setString(commonConstants.COLUMN_INDEX_ONE, user.getUserName());
				preparedStatement.setString(commonConstants.COLUMN_INDEX_TWO, user.getEmail());
				preparedStatement.setString(commonConstants.COLUMN_INDEX_THREE, user.getPassword());
				preparedStatement.setString(commonConstants.COLUMN_INDEX_FOUR, user.getMobileNo());
				preparedStatement.setString(commonConstants.COLUMN_INDEX_FIVE, userID);
				
				preparedStatement.executeLargeUpdate();
				
			}catch(SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
				
				log.log(Level.SEVERE, e.getMessage());
				
			}finally {
				
				try {
					
					if(preparedStatement != null) {
						preparedStatement.close();
					}
					
					if(connection != null) {
						
						connection.close();
					}
				}catch(SQLException e){
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
		
	}
	
	@Override
	public User getUserByName(String userName) {
		return actionOnUser(userName).get(0);
	}
	
	@Override
	public ArrayList<User> getUsers(){
		return actionOnUser(null);
	}
	
	private ArrayList<User> actionOnUser(String userName){
		
		ArrayList<User> userList = new ArrayList<User>();
		
		try {
			
			connection = DBConnectionUtil.getDBConnection();
			
			if(userName != null && !userName.isEmpty()) {
				
				System.out.println(userName);
				
				preparedStatement = connection.prepareStatement(queryUtil.queryByID(commonConstants.QUERY_ID_GET_USER));
				preparedStatement.setString(commonConstants.COLUMN_INDEX_ONE, userName);
				
				
				ResultSet resultSet = preparedStatement.executeQuery();
				
				while (resultSet.next()) {
					User user = new User();
					user.setUserId(resultSet.getString(commonConstants.COLUMN_INDEX_ONE));
					user.setUserName(resultSet.getString(commonConstants.COLUMN_INDEX_TWO));
					user.setEmail(resultSet.getString(commonConstants.COLUMN_INDEX_THREE));
					user.setPassword(resultSet.getString(commonConstants.COLUMN_INDEX_FOUR));
					user.setMobileNo(resultSet.getString(commonConstants.COLUMN_INDEX_FIVE));
					user.setUserRole(resultSet.getString(commonConstants.COLUMN_INDEX_SIX));
					
					userList.add(user);
				}
				
			}
			else {
				
				preparedStatement = connection.prepareStatement(queryUtil.queryByID(commonConstants.QUERY_ID_ALL_USERS));
				
				ResultSet resultSet = preparedStatement.executeQuery();
				
				while (resultSet.next()) {
					User user = new User();
					user.setUserId(resultSet.getString(commonConstants.COLUMN_INDEX_ONE));
					user.setUserName(resultSet.getString(commonConstants.COLUMN_INDEX_TWO));
					user.setEmail(resultSet.getString(commonConstants.COLUMN_INDEX_THREE));
					user.setPassword(resultSet.getString(commonConstants.COLUMN_INDEX_FOUR));
					user.setMobileNo(resultSet.getString(commonConstants.COLUMN_INDEX_FIVE));
					user.setUserRole(resultSet.getString(commonConstants.COLUMN_INDEX_SIX));
					
					System.out.println("moda chathura");
					
					userList.add(user);
				}
				
			}
			
		}catch(SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}finally {
			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			}catch(SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		
		return userList;
		
	}
	
	private ArrayList<String> getUserIDs(){
		
		ArrayList<String> arraylist = new ArrayList<String>();
		
		try {
			
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection.prepareStatement(queryUtil.queryByID(commonConstants.QUERY_ID_GET_USER_IDS));
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				arraylist.add(resultSet.getString(commonConstants.COLUMN_INDEX_ONE));
			}
			
		}
		catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
		}
		finally {
			
			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			}
			catch(SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		
		return arraylist;
	}

	@Override
	public void updateUserRole(String userID, User user) {
		
		if(userID != null && !userID.isEmpty()) {
			
			try {
				
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection.prepareStatement(queryUtil.queryByID(commonConstants.QUERY_ID_UPDATE_USER_ROLE));
				
				preparedStatement.setString(commonConstants.COLUMN_INDEX_ONE, user.getUserRole());
				preparedStatement.setString(commonConstants.COLUMN_INDEX_TWO, user.getUserId());

				
				preparedStatement.executeLargeUpdate();
				
			}catch(SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
				
				log.log(Level.SEVERE, e.getMessage());
				
			}finally {
				
				try {
					
					if(preparedStatement != null) {
						preparedStatement.close();
					}
					
					if(connection != null) {
						
						connection.close();
					}
				}catch(SQLException e){
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
		
	}



}
