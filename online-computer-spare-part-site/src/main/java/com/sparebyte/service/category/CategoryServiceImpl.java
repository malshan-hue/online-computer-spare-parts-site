/**
 * OOP project year 2 semester 1, 2023
 * 
 * @author Malshan Rathnayake Software Engineering Undergraduate, SLIIT 
 * 
 * @version 1.0
 * Copyright: Malshan, All rights reserved
 * 
 */

package com.sparebyte.service.category;

/**
 * Contract for the implementation of Category Service.
 * 
 * @author Malshan Rathnayake, SLIIT Undergraduate
 * @version 1.0
 */
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.sparebyte.models.Category;
import com.sparebyte.util.DBConnectionUtil;
import com.sparebyte.util.commonConstants;
import com.sparebyte.util.commonUtil;
import com.sparebyte.util.queryUtil;

public class CategoryServiceImpl implements ICategoryService {
	
	public static final Logger log = Logger.getLogger(ICategoryService.class.getName());
	
	private static Connection connection;
	private static Statement statement;
	
	static {
		
		createCategoryTable();
	}
	
	public static PreparedStatement preparedStatement;
	
	public static void createCategoryTable() {
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			
			statement.executeUpdate(queryUtil.queryByID(commonConstants.QUERY_ID_CREATE_CATEGORY_TABLE));
			
			System.out.println("Created");
			
		}catch(SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}
	
	

	@Override
	public void addCategory(Category category) {
		
		String categoryID = commonUtil.generateCategoryIDs(getCategoryIds());
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			
			preparedStatement = connection.prepareStatement(queryUtil.queryByID(commonConstants.QUERY_ID_INSERT_CATEGORY));
			
			category.setCatID(categoryID);
			preparedStatement.setString(commonConstants.COLUMN_INDEX_ONE, category.getCatID());
			preparedStatement.setString(commonConstants.COLUMN_INDEX_TWO, category.getCatName());
			preparedStatement.setString(commonConstants.COLUMN_INDEX_THREE, category.getCatDesc());
			preparedStatement.setString(commonConstants.COLUMN_INDEX_FOUR, category.getCatCreatedDate());
			preparedStatement.setString(commonConstants.COLUMN_INDEX_FIVE, category.getCatUpdatedDate());
			
			preparedStatement.execute();
			connection.commit();
			
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
		
	}

	@Override
	public ArrayList<Category> getCategories() {
		
		ArrayList<Category> categoryList = new ArrayList<Category>();
		
		try {
			
			connection = DBConnectionUtil.getDBConnection();
			
			preparedStatement = connection.prepareStatement(queryUtil.queryByID(commonConstants.QUERY_ID_GET_ALL_CATEGORIES));
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				Category category = new Category();
				
				category.setCatID(resultSet.getString(commonConstants.COLUMN_INDEX_ONE));
				category.setCatName(resultSet.getString(commonConstants.COLUMN_INDEX_TWO));
				category.setCatDesc(resultSet.getString(commonConstants.COLUMN_INDEX_THREE));
				category.setCatCreatedDate(resultSet.getString(commonConstants.COLUMN_INDEX_FOUR));
				category.setCatUpdatedDate(resultSet.getString(commonConstants.COLUMN_INDEX_FIVE));
				
				categoryList.add(category);
			}
		}catch(SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}finally {
			
			try {
				
				if(preparedStatement != null){
					preparedStatement.close();
				}
				
				if(connection != null) {
					connection.close();
				}
			}catch(SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		
		return categoryList;
	}
	
	@Override
	public void deleteCategory(String catID) {
		
		
		if(catID != null && !catID.isEmpty()) {
			
			try {
				
				connection = DBConnectionUtil.getDBConnection();
				
				preparedStatement = connection.prepareStatement(queryUtil.queryByID(commonConstants.QUERY_ID_DELETE_CATEGORY));
				preparedStatement.setString(commonConstants.COLUMN_INDEX_ONE, catID);
				
				
				
				preparedStatement.executeUpdate();
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
		}
		
	}
	
	@Override
	public void updateCategory(String catID, Category category) {
		
		if(catID != null && !catID.isEmpty()) {
			
			try {
				connection = DBConnectionUtil.getDBConnection();
				
				preparedStatement = connection.prepareStatement(queryUtil.queryByID(commonConstants.QUERY_ID_UPDATE_CATEGORY));
				
				preparedStatement.setString(commonConstants.COLUMN_INDEX_ONE, category.getCatName());
				preparedStatement.setString(commonConstants.COLUMN_INDEX_TWO, category.getCatDesc());
				preparedStatement.setString(commonConstants.COLUMN_INDEX_THREE, category.getCatUpdatedDate());
				preparedStatement.setString(commonConstants.COLUMN_INDEX_FOUR, category.getCatID());
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
				}catch(SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
			
		}

	}
	
	@Override
	public ArrayList<Category> getCategoryById(String catID) {
		
		ArrayList<Category> categoryList = new ArrayList<Category>();
		
		try {
			
			connection = DBConnectionUtil.getDBConnection();
			
			preparedStatement = connection.prepareStatement(queryUtil.queryByID(commonConstants.QUERY_ID_GET_CATEGORY));
			preparedStatement.setString(commonConstants.COLUMN_INDEX_ONE, catID);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				Category category = new Category();
				
				category.setCatID(resultSet.getString(commonConstants.COLUMN_INDEX_ONE));
				category.setCatName(resultSet.getString(commonConstants.COLUMN_INDEX_TWO));
				category.setCatDesc(resultSet.getString(commonConstants.COLUMN_INDEX_THREE));
				category.setCatCreatedDate(resultSet.getString(commonConstants.COLUMN_INDEX_FOUR));
				category.setCatUpdatedDate(resultSet.getString(commonConstants.COLUMN_INDEX_FIVE));
				
				categoryList.add(category);
			}
		}catch(SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}finally {
			
			try {
				
				if(preparedStatement != null){
					preparedStatement.close();
				}
				
				if(connection != null) {
					connection.close();
				}
			}catch(SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		
		return categoryList;
	}
	
	private ArrayList<String> getCategoryIds(){
		
		ArrayList<String> arrayList = new ArrayList<String>();
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection.prepareStatement(queryUtil.queryByID(commonConstants.QUERY_ID_GET_CATEGORY_IDS));
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				arrayList.add(resultSet.getString(commonConstants.COLUMN_INDEX_ONE));
			}
		}catch(SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
			
		}finally {
			
			try {
				if(preparedStatement != null){
					preparedStatement.close();
				}
				
				if(connection != null) {
					connection.close();
				}
			}catch(SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		
		return arrayList;
	}









}
