/**
 * OOP project year 2 semester 1, 2023
 * 
 * @author Malshan Rathnayake Software Engineering Undergraduate, SLIIT 
 * 
 * @version 1.0
 * Copyright: Malshan, All rights reserved
 * 
 */

package com.sparebyte.service.product;

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

import com.sparebyte.models.Product;
import com.sparebyte.util.DBConnectionUtil;
import com.sparebyte.util.commonConstants;
import com.sparebyte.util.commonUtil;
import com.sparebyte.util.queryUtil;

/**
 * Contract for the implementation of Product Service.
 * 
 * @author Malshan Rathnayake, SLIIT Undergraduate
 * @version 1.0
 */
public class ProductServiceImpl implements IProductService{
	
	/** Initialize logger */
	public static final Logger log = Logger.getLogger(ProductServiceImpl.class.getName());
	
	private static Connection connection;
	private static Statement statement;
	
	static {
		//Create table for Products
		createProductTable();
	}
	
	public static PreparedStatement preparedStatement;
	
	/**
	 * This method initially create a table structure to insert product entries
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
	public static void createProductTable() {
		
		
		try {
			
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			
			// Create new product table as per SQL query available in queries.xml
			statement.executeLargeUpdate(queryUtil.queryByID(commonConstants.QUERY_ID_CREATE_PRODUCT_TABLE));
			
		}catch(SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}
	
	/**
	 * This method is to add set of products to  the table
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
	public void addProduct(Product product) {
		
		//Get the generated productID
		String productID = commonUtil.generateProductIDs(getProductIds());
		
		try {
			
			connection = DBConnectionUtil.getDBConnection();
			
			/*
			 * Qyery is available in quwries.xml file and use
			 * insert_product key to extract value of it
			 */
			preparedStatement = connection.prepareStatement(queryUtil.queryByID(commonConstants.QUERY_ID_INSERT_PRODUCT));
			connection.setAutoCommit(false);
			
			//Set the generated productID to the product model
			product.setProductID(productID);
			
			//Set the values of each column using the corresponding product properties
			preparedStatement.setString(commonConstants.COLUMN_INDEX_ONE, product.getProductID());
			preparedStatement.setString(commonConstants.COLUMN_INDEX_TWO, product.getProductName());
			preparedStatement.setString(commonConstants.COLUMN_INDEX_THREE, product.getProductDec());
			preparedStatement.setString(commonConstants.COLUMN_INDEX_FOUR, product.getProductCategory());
			preparedStatement.setString(commonConstants.COLUMN_INDEX_FIVE, product.getProductBrand());
			preparedStatement.setString(commonConstants.COLUMN_INDEX_SIX, product.getProductModel());
			preparedStatement.setString(commonConstants.COLUMN_INDEX_SEVEN, product.getProductPrice());
			preparedStatement.setString(commonConstants.COLUMN_INDEX_EIGHT, product.getProductStock());
			preparedStatement.setString(commonConstants.COLUMN_INDEX_NINE, product.getProductImagePath());
			
			//Add product by executing preparedStatement
			preparedStatement.execute();
			connection.commit();
			
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
	
	/**
	 * This method is to delete praticular product based on the provided productID
	 * 
	 * @param productID
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
	public void deleteProduct(String productID) {
		
		//Check whether productID is available
		if(productID != null && !productID.isEmpty()) {
			
			try {
				
				connection = DBConnectionUtil.getDBConnection();
				
				/*
				 * Delete product query will retrive from queries.xml file
				 */
				preparedStatement = connection.prepareStatement(queryUtil.queryByID(commonConstants.QUERY_ID_DELETE_PRODUCT));
				preparedStatement.setString(commonConstants.COLUMN_INDEX_ONE, productID);
				
				//Delete praticular product
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
	 * This method is to update praticular product based on provided productID
	 * 
	 * @param productID
	 * @param product
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
	public void updateProduct(String productID, Product product) {
		
		//Check whether productID is available
		if(productID != null && !productID.isEmpty()) {
			
			try {
				
				connection = DBConnectionUtil.getDBConnection();
				
				/*
				 * update product query will retrive from queries.xml file
				 */
				preparedStatement = connection.prepareStatement(queryUtil.queryByID(commonConstants.QUERY_ID_UPDATE_PRODUCT));
				
				preparedStatement.setString(commonConstants.COLUMN_INDEX_ONE, product.getProductName());
				preparedStatement.setString(commonConstants.COLUMN_INDEX_TWO, product.getProductDec());
				preparedStatement.setString(commonConstants.COLUMN_INDEX_THREE, product.getProductCategory());
				preparedStatement.setString(commonConstants.COLUMN_INDEX_FOUR, product.getProductBrand());
				preparedStatement.setString(commonConstants.COLUMN_INDEX_FIVE, product.getProductModel());
				preparedStatement.setString(commonConstants.COLUMN_INDEX_SIX, product.getProductPrice());
				preparedStatement.setString(commonConstants.COLUMN_INDEX_SEVEN, product.getProductStock());
				preparedStatement.setString(commonConstants.COLUMN_INDEX_EIGHT, productID);
				
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
	 * This method is to retrive product details based on provided productID
	 * 
	 * @param productID
	 * @return ArrayList<Product> array list of product will be return
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
	public ArrayList<Product> getProductById(String productID) {
		
		ArrayList<Product> productList = new ArrayList<Product>();
		
		try {
			
			connection = DBConnectionUtil.getDBConnection();
			
			/*
			 * Get product by ID query will retrive from queries.xml file
			 */
			preparedStatement = connection.prepareStatement(queryUtil.queryByID(commonConstants.QUERY_ID_GET_PRODUCT));
			preparedStatement.setString(commonConstants.COLUMN_INDEX_ONE, productID);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				Product product = new Product();
				
				product.setProductID(resultSet.getString(commonConstants.COLUMN_INDEX_ONE));
				product.setProductName(resultSet.getString(commonConstants.COLUMN_INDEX_TWO));
				product.setProductDec(resultSet.getString(commonConstants.COLUMN_INDEX_THREE));
				product.setProductCategory(resultSet.getString(commonConstants.COLUMN_INDEX_FOUR));
				product.setProductBrand(resultSet.getString(commonConstants.COLUMN_INDEX_FIVE));
				product.setProductModel(resultSet.getString(commonConstants.COLUMN_INDEX_SIX));
				product.setProductPrice(resultSet.getString(commonConstants.COLUMN_INDEX_SEVEN));
				product.setProductStock(resultSet.getString(commonConstants.COLUMN_INDEX_EIGHT));
				product.setProductImagePath(resultSet.getString(commonConstants.COLUMN_INDEX_NINE));
				
				productList.add(product);
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
	 * This method is to retrive all product details
	 * 
	 * @return ArrayList<Product> array list of products will be return
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
	public ArrayList<Product> getProducts(){
		
		ArrayList<Product> productList = new ArrayList<Product>();
		
		try {
			
			connection = DBConnectionUtil.getDBConnection();
			
			/*
			 * Get products query will retrive from queries.xml file
			 */
			preparedStatement = connection.prepareStatement(queryUtil.queryByID(commonConstants.QUERY_ID_GET_ALL_PRODUCTS));
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				Product product = new Product();
				
				product.setProductID(resultSet.getString(commonConstants.COLUMN_INDEX_ONE));
				product.setProductName(resultSet.getString(commonConstants.COLUMN_INDEX_TWO));
				product.setProductDec(resultSet.getString(commonConstants.COLUMN_INDEX_THREE));
				product.setProductCategory(resultSet.getString(commonConstants.COLUMN_INDEX_FOUR));
				product.setProductBrand(resultSet.getString(commonConstants.COLUMN_INDEX_FIVE));
				product.setProductModel(resultSet.getString(commonConstants.COLUMN_INDEX_SIX));
				product.setProductPrice(resultSet.getString(commonConstants.COLUMN_INDEX_SEVEN));
				product.setProductStock(resultSet.getString(commonConstants.COLUMN_INDEX_EIGHT));
				product.setProductImagePath(resultSet.getString(commonConstants.COLUMN_INDEX_NINE));
				
				productList.add(product);
				
			}
			
			
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
		
		return productList;
	}
	
	/**
	 * 
	 * @return ArrayList<Product> array list of productID list will be return
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
	private ArrayList<String> getProductIds(){
		
		ArrayList<String> arrayList = new ArrayList<String>();
				
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection.prepareStatement(queryUtil.queryByID(commonConstants.QUERY_ID_GET_PRODUCT_IDS));
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				arrayList.add(resultSet.getString(commonConstants.COLUMN_INDEX_ONE));
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
			}catch(SQLException e){
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return arrayList;
	}

		

}
