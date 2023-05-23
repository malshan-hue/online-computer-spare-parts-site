/**
 * OOP project year 2 semester 1, 2023
 * 
 * @author Malshan Rathnayake Software Engineering Undergraduate, SLIIT 
 * 
 * @version 1.0
 * Copyright: Malshan, All rights reserved
 * 
 */

package com.sparebyte.service.brand;

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

import com.sparebyte.models.Brand;
import com.sparebyte.util.DBConnectionUtil;
import com.sparebyte.util.commonConstants;
import com.sparebyte.util.commonUtil;
import com.sparebyte.util.queryUtil;

/**
 * Contract for the implementation of Brand Service.
 * 
 * @author Malshan Rathnayake, SLIIT Undergraduate
 * @version 1.0
 */
public class BrandServiceImpl implements IBrandService{
	
	/** Initialize logger */
	public static final Logger log = Logger.getLogger(BrandServiceImpl.class.getName());
	
	private static Connection connection;
	private static Statement statement;
	
	static {
		//Create table for brands
		createBrandTable();
	}
	
	public static PreparedStatement preparedStatement;
	
	
	/**
	 * This method initially create a table structure to insert brand entries
	 * 
	 * @throws SQLException
	 *             - Thrown when database access error occurs or this method is
	 *             called on a closed connection
	 *             
	 * @throws SAXException
	 *             - Encapsulate a general SAX error or warning
	 *             
	 * @throws IOException
	 *             - Exception produced by failed or interrupted I/O operations.
	 *             
	 * @throws ParserConfigurationException
	 *             - Indicates a serious configuration error
	 *             
	 * @throws ClassNotFoundException
	 *             - Thrown when an application tries to load in a class through
	 *             its string name using
	 * 
	 */
	public static void createBrandTable() {
		
		try {
			
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			
			// Create new brand table as per SQL query available in queries.xml
			statement.executeUpdate(queryUtil.queryByID(commonConstants.QUERY_ID_CREATE_BRAND_TABLE));
			
			
		}catch(SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}
	
	/**
	 * This method is to add set of brands to  the table
	 * 
	 * @throws SQLException
	 *             - Thrown when database access error occurs or this method is
	 *             called on a closed connection
	 *             
	 * @throws SAXException
	 *             - Encapsulate a general SAX error or warning
	 *             
	 * @throws IOException
	 *             - Exception produced by failed or interrupted I/O operations.
	 *             
	 * @throws ParserConfigurationException
	 *             - Indicates a serious configuration error
	 *             
	 * @throws ClassNotFoundException
	 *             - Thrown when an application tries to load in a class through
	 *             its string name using
	 * 
	 */
	@Override
	public void addBrand(Brand brand) {
		
		//Get the generated brandID
		String brandID = commonUtil.generateBrandIDs(getBrandIds());
		
		try {
			
			connection = DBConnectionUtil.getDBConnection();
			
			/*
			 * Qyery is available in quwries.xml file and use
			 * insert_brand key to extract value of it
			 */
			preparedStatement = connection.prepareStatement(queryUtil.queryByID(commonConstants.QUERY_ID_INSERT_BRAND));
			connection.setAutoCommit(false);
			
			//Set the generated brandID to the product model
			brand.setBrandID(brandID);
			
			//Set the values of each column using the corresponding brand properties
			preparedStatement.setString(commonConstants.COLUMN_INDEX_ONE, brand.getBrandID());
			preparedStatement.setString(commonConstants.COLUMN_INDEX_TWO, brand.getBrandName());
			preparedStatement.setString(commonConstants.COLUMN_INDEX_THREE, brand.getBrandOrigin());
			preparedStatement.setString(commonConstants.COLUMN_INDEX_FOUR, brand.getBrandProductFocus());
			preparedStatement.setString(commonConstants.COLUMN_INDEX_FIVE, brand.getBrandProductPortfolio());
			
			//Add brand by executing preparedStatement
			preparedStatement.execute();
			connection.commit();
			
		}catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			
			log.log(Level.SEVERE, e.getMessage());
		}finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
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
	
	/**
	 * This method is to delete praticular brand based on the provided brandID
	 * 
	 * @param brandID
	 * 
	 * @throws SQLException
	 *             - Thrown when database access error occurs or this method is
	 *             called on a closed connection
	 *             
	 * @throws SAXException
	 *             - Encapsulate a general SAX error or warning
	 *             
	 * @throws IOException
	 *             - Exception produced by failed or interrupted I/O operations.
	 *             
	 * @throws ParserConfigurationException
	 *             - Indicates a serious configuration error
	 *             
	 * @throws ClassNotFoundException
	 *             - Thrown when an application tries to load in a class through
	 *             its string name using
	 * 
	 */
	@Override
	public void deleteBrand(String brandID) {
		
		//Check whether brandID is available
		if(brandID != null && !brandID.isEmpty()) {
			
			try {
				
				connection = DBConnectionUtil.getDBConnection();
				
				/*
				 * Delete brand query will retrive from queries.xml file
				 */
				preparedStatement = connection.prepareStatement(queryUtil.queryByID(commonConstants.QUERY_ID_DELETE_BRAND));
				preparedStatement.setString(commonConstants.COLUMN_INDEX_ONE, brandID);
				
				//Delete praticular brand
				preparedStatement.executeLargeUpdate();
				
			}catch(SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
				
			}finally {
				/*
				 * Close prepared statement and database connectivity at the end of
				 * transaction
				 */
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
	
	/**
	 * This method is to update praticular brand based on provided brandID
	 * 
	 * @param brandID
	 * @param brand
	 * 
	 * @throws SQLException
	 *             - Thrown when database access error occurs or this method is
	 *             called on a closed connection
	 *             
	 * @throws SAXException
	 *             - Encapsulate a general SAX error or warning
	 *             
	 * @throws IOException
	 *             - Exception produced by failed or interrupted I/O operations.
	 *             
	 * @throws ParserConfigurationException
	 *             - Indicates a serious configuration error
	 *             
	 * @throws ClassNotFoundException
	 *             - Thrown when an application tries to load in a class through
	 *             its string name using
	 * 
	 */
	@Override
	public void updateBrand(String brandID, Brand brand) {
		
		//Check whether brandID is available
		if(brandID != null && !brandID.isEmpty()) {
			
			try {
				
				connection = DBConnectionUtil.getDBConnection();
				
				/*
				 * update brand query will retrive from queries.xml file
				 */
				preparedStatement = connection.prepareStatement(queryUtil.queryByID(commonConstants.QUERY_ID_UPDATE_BRAND));
				
				preparedStatement.setString(commonConstants.COLUMN_INDEX_ONE, brand.getBrandName());
				preparedStatement.setString(commonConstants.COLUMN_INDEX_TWO, brand.getBrandOrigin());
				preparedStatement.setString(commonConstants.COLUMN_INDEX_THREE, brand.getBrandProductFocus());
				preparedStatement.setString(commonConstants.COLUMN_INDEX_FOUR, brand.getBrandProductPortfolio());
				preparedStatement.setString(commonConstants.COLUMN_INDEX_FIVE, brandID);
				
				preparedStatement.executeLargeUpdate();
				
			}catch(SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			}finally {
				/*
				 * Close prepared statement and database connectivity at the end of
				 * transaction
				 */
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
	
	/**
	 * This method is to retrive brand details based on provided brandID
	 * 
	 * @param productID
	 * @return ArrayList<Brand> array list of product will be return
	 * 
	 * @throws SQLException
	 *             - Thrown when database access error occurs or this method is
	 *             called on a closed connection
	 *             
	 * @throws SAXException
	 *             - Encapsulate a general SAX error or warning
	 *             
	 * @throws IOException
	 *             - Exception produced by failed or interrupted I/O operations.
	 *             
	 * @throws ParserConfigurationException
	 *             - Indicates a serious configuration error
	 *             
	 * @throws ClassNotFoundException
	 *             - Thrown when an application tries to load in a class through
	 *             its string name using
	 * 
	 */
	@Override
	public ArrayList<Brand> getBrandById(String brandID) {
		
		ArrayList<Brand> productList = new ArrayList<Brand>();
		
		try {
			
			connection = DBConnectionUtil.getDBConnection();
			
			/*
			 * Get brand by ID query will retrive from queries.xml file
			 */
			preparedStatement = connection.prepareStatement(queryUtil.queryByID(commonConstants.QUERY_ID_GET_BRAND));
			preparedStatement.setString(commonConstants.COLUMN_INDEX_ONE, brandID);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				Brand brand = new Brand();
				
				brand.setBrandID(resultSet.getString(commonConstants.COLUMN_INDEX_ONE));
				brand.setBrandName(resultSet.getString(commonConstants.COLUMN_INDEX_TWO));
				brand.setBrandOrigin(resultSet.getString(commonConstants.COLUMN_INDEX_THREE));
				brand.setBrandProductFocus(resultSet.getString(commonConstants.COLUMN_INDEX_FOUR));
				brand.setBrandProductPortfolio(resultSet.getString(commonConstants.COLUMN_INDEX_FIVE));
				
				productList.add(brand);
			}
		}
		catch(SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			
			log.log(Level.SEVERE, e.getMessage());
		}finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
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
		
		return productList;
	}
	
	/**
	 * This method is to retrive all brand details
	 * 
	 * @return ArrayList<Brand> array list of products will be return
	 * 
	 * @throws SQLException
	 *             - Thrown when database access error occurs or this method is
	 *             called on a closed connection
	 *             
	 * @throws SAXException
	 *             - Encapsulate a general SAX error or warning
	 *             
	 * @throws IOException
	 *             - Exception produced by failed or interrupted I/O operations.
	 *             
	 * @throws ParserConfigurationException
	 *             - Indicates a serious configuration error
	 *             
	 * @throws ClassNotFoundException
	 *             - Thrown when an application tries to load in a class through
	 *             its string name using
	 * 
	 */
	@Override
	public ArrayList<Brand> getBrands() {
		
		ArrayList<Brand> brandList = new ArrayList<Brand>();
		
		try {
			
			connection = DBConnectionUtil.getDBConnection();
			
			/*
			 * Get brand query will retrive from queries.xml file
			 */
			preparedStatement = connection.prepareStatement(queryUtil.queryByID(commonConstants.QUERY_D_GET_ALL_BRANDS));
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				Brand brand = new Brand();
				
				brand.setBrandID(resultSet.getString(commonConstants.COLUMN_INDEX_ONE));
				brand.setBrandName(resultSet.getString(commonConstants.COLUMN_INDEX_TWO));
				brand.setBrandOrigin(resultSet.getString(commonConstants.COLUMN_INDEX_THREE));
				brand.setBrandProductFocus(resultSet.getString(commonConstants.COLUMN_INDEX_FOUR));
				brand.setBrandProductPortfolio(resultSet.getString(commonConstants.COLUMN_INDEX_FIVE));
				
				brandList.add(brand);
			}
			
		}catch(SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			
			log.log(Level.SEVERE, e.getMessage());
		}finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
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
		
		return brandList;
	}
	
	/**
	 * 
	 * @return ArrayList<Brand> array list of brandID list will be return
	 * 
	 * @throws SQLException
	 *             - Thrown when database access error occurs or this method is
	 *             called on a closed connection
	 *             
	 * @throws SAXException
	 *             - Encapsulate a general SAX error or warning
	 *             
	 * @throws IOException
	 *             - Exception produced by failed or interrupted I/O operations.
	 *             
	 * @throws ParserConfigurationException
	 *             - Indicates a serious configuration error
	 *             
	 * @throws ClassNotFoundException
	 *             - Thrown when an application tries to load in a class through
	 *             its string name using
	 * 
	 */
	private ArrayList<String> getBrandIds(){
		
		ArrayList<String> arrayList = new ArrayList<String>();
				
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection.prepareStatement(queryUtil.queryByID(commonConstants.QUERY_ID_GET_BRAND_IDS));
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				arrayList.add(resultSet.getString(commonConstants.COLUMN_INDEX_ONE));
			}
		}catch(SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
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
		return arrayList;
	}

}
