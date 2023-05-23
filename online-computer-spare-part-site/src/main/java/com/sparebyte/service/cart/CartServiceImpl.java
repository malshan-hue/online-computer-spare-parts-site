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

public class CartServiceImpl implements ICartService{
	
	public static final Logger log = Logger.getLogger(BrandServiceImpl.class.getName());
	
	private static Connection connection;
	private static Statement statement;
	
	static {
		
		createCartTable();
	}
	
	public static PreparedStatement preparedStatement;
	
	public static void createCartTable() {
		
		try {
			
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			
			statement.executeUpdate(queryUtil.queryByID(commonConstants.QUERY_ID_CREATE_CART_TABLE));
			
			
		}catch(SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	@Override
	public void addToCart(Cart cart) {
		
		String cartID = commonUtil.generateCartIDs(getCartIds());
		
		try {
			
			connection = DBConnectionUtil.getDBConnection();
			
			preparedStatement = connection.prepareStatement(queryUtil.queryByID(commonConstants.QUERY_ID_INSERT_CART));
			connection.setAutoCommit(false);
			
			cart.setCartID(cartID);
			preparedStatement.setString(commonConstants.COLUMN_INDEX_ONE, cart.getCartID());
			preparedStatement.setString(commonConstants.COLUMN_INDEX_TWO, cart.getUserID());
			preparedStatement.setString(commonConstants.COLUMN_INDEX_THREE, cart.getProductName());
			preparedStatement.setString(commonConstants.COLUMN_INDEX_FOUR, cart.getAmount());
			
			preparedStatement.execute();
			connection.commit();
			
		}catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			
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
	public void deleteFromCart(String cartID) {


		if(cartID != null && !cartID.isEmpty()) {
			
			try {
				
				connection = DBConnectionUtil.getDBConnection();
				
				preparedStatement = connection.prepareStatement(queryUtil.queryByID(commonConstants.QUERY_ID_DELETE_CART));
				preparedStatement.setString(commonConstants.COLUMN_INDEX_ONE, cartID);
				
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
