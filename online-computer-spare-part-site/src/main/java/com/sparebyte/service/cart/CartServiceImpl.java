/**
 * OOP project year 2 semester 1, 2023
 * 
 * @author Malshan Rathnayake Software Engineering Undergraduate, SLIIT 
 * 
 * @version 1.0
 * Copyright: Malshan, All rights reserved
 * 
 */

package com.sparebyte.service.cart;

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

import com.sparebyte.models.Cart;
import com.sparebyte.service.brand.BrandServiceImpl;
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
public class CartServiceImpl implements ICartService{
	
	/** Initialize logger */
	public static final Logger log = Logger.getLogger(BrandServiceImpl.class.getName());
	
	private static Connection connection;
	private static Statement statement;
	
	static {
		//Create table for cart
		createCartTable();
	}
	
	public static PreparedStatement preparedStatement;
	
	
	/**
	 * This method initially create a table structure to insert cart entries
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
	public static void createCartTable() {
		
		try {
			
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			
			// Create new cart table as per SQL query available in queries.xml
			statement.executeUpdate(queryUtil.queryByID(commonConstants.QUERY_ID_CREATE_CART_TABLE));
			
			
		}catch(SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}
	
	/**
	 * This method is to add set of cart items to the table
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
	public void addToCart(Cart cart) {
		
		//Get the generated cartID
		String cartID = commonUtil.generateCartIDs(getCartIds());
		
		try {
			
			connection = DBConnectionUtil.getDBConnection();
			
			/*
			 * Qyery is available in quwries.xml file and use
			 * insert_cart key to extract value of it
			 */
			preparedStatement = connection.prepareStatement(queryUtil.queryByID(commonConstants.QUERY_ID_INSERT_CART));
			connection.setAutoCommit(false);
			
			//Set the generated cartID to the product model
			cart.setCartID(cartID);
			
			//Set the values of each column using the corresponding cart properties
			preparedStatement.setString(commonConstants.COLUMN_INDEX_ONE, cart.getCartID());
			preparedStatement.setString(commonConstants.COLUMN_INDEX_TWO, cart.getUserID());
			preparedStatement.setString(commonConstants.COLUMN_INDEX_THREE, cart.getProductName());
			preparedStatement.setString(commonConstants.COLUMN_INDEX_FOUR, cart.getAmount());
			
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
	 * This method is to delete praticular cart based on the provided cartID
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
	public void deleteFromCart(String cartID) {

		//Check whether brandID is available
		if(cartID != null && !cartID.isEmpty()) {
			
			try {
				
				connection = DBConnectionUtil.getDBConnection();
				
				/*
				 * Delete cart query will retrive from queries.xml file
				 */
				preparedStatement = connection.prepareStatement(queryUtil.queryByID(commonConstants.QUERY_ID_DELETE_CART));
				preparedStatement.setString(commonConstants.COLUMN_INDEX_ONE, cartID);
				
				//Delete praticular cart
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
	 * This method is to delete praticular cart based on the provided userID
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
	public void clearCart(String userID) {
		
		if(userID != null && !userID.isEmpty()) {
			
			try {
				
				connection = DBConnectionUtil.getDBConnection();
				
				preparedStatement = connection.prepareStatement(queryUtil.queryByID(commonConstants.QUERY_ID_CLEAR_CART));
				preparedStatement.setString(commonConstants.COLUMN_INDEX_ONE, userID);
				
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
	public ArrayList<Cart> getCartdById(String cartID) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * This method is to retrive all cart details based on provided userID
	 * 
	 * @return ArrayList<Cart> array list of products will be return
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
	public ArrayList<Cart> getCart(String userID) {
		
		ArrayList<Cart> cartList = new ArrayList<Cart>();
		
		try {
			
			connection = DBConnectionUtil.getDBConnection();
			
			preparedStatement = connection.prepareStatement(queryUtil.queryByID(commonConstants.QUERY_TD_GET_ALL_CART));
			preparedStatement.setString(commonConstants.COLUMN_INDEX_ONE, userID);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				Cart cart = new Cart();
				
				cart.setCartID(resultSet.getString(commonConstants.COLUMN_INDEX_ONE));
				cart.setUserID(resultSet.getString(commonConstants.COLUMN_INDEX_TWO));
				cart.setProductName(resultSet.getString(commonConstants.COLUMN_INDEX_THREE));
				cart.setAmount(resultSet.getString(commonConstants.COLUMN_INDEX_FOUR));
				
				cartList.add(cart);
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
		
		return cartList;
	}
	
	/**
	 * 
	 * @return ArrayList<Cart> array list of brandID list will be return
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
	private ArrayList<String> getCartIds(){
		
		ArrayList<String> arrayList = new ArrayList<String>();
				
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection.prepareStatement(queryUtil.queryByID(commonConstants.QUERY_ID_GET_CART_IDS));
			
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
