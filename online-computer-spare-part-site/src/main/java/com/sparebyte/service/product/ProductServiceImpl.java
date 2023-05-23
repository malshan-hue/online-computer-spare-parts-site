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
import com.sparebyte.service.user.UserServiceImpl;
import com.sparebyte.util.DBConnectionUtil;
import com.sparebyte.util.commonConstants;
import com.sparebyte.util.commonUtil;
import com.sparebyte.util.queryUtil;

public class ProductServiceImpl implements IProductService{
	
	public static final Logger log = Logger.getLogger(UserServiceImpl.class.getName());
	
	private static Connection connection;
	private static Statement statement;
	
	static {
		
		createProductTable();
	}
	
	public static PreparedStatement preparedStatement;
	
	public static void createProductTable() {
		
		
		try {
			
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			
			statement.executeLargeUpdate(queryUtil.queryByID(commonConstants.QUERY_ID_CREATE_PRODUCT_TABLE));
			
			System.out.println("created");
			
		}catch(SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}
	
	public void addProduct(Product product) {
		
		String productID = commonUtil.generateProductIDs(getProductIds());
		
		try {
			
			connection = DBConnectionUtil.getDBConnection();
			
			preparedStatement = connection.prepareStatement(queryUtil.queryByID(commonConstants.QUERY_ID_INSERT_PRODUCT));
			connection.setAutoCommit(false);
			
			product.setProductID(productID);
			preparedStatement.setString(commonConstants.COLUMN_INDEX_ONE, product.getProductID());
			preparedStatement.setString(commonConstants.COLUMN_INDEX_TWO, product.getProductName());
			preparedStatement.setString(commonConstants.COLUMN_INDEX_THREE, product.getProductDec());
			preparedStatement.setString(commonConstants.COLUMN_INDEX_FOUR, product.getProductCategory());
			preparedStatement.setString(commonConstants.COLUMN_INDEX_FIVE, product.getProductBrand());
			preparedStatement.setString(commonConstants.COLUMN_INDEX_SIX, product.getProductModel());
			preparedStatement.setString(commonConstants.COLUMN_INDEX_SEVEN, product.getProductPrice());
			preparedStatement.setString(commonConstants.COLUMN_INDEX_EIGHT, product.getProductStock());
			preparedStatement.setString(commonConstants.COLUMN_INDEX_NINE, product.getProductImagePath());
			
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
	public void deleteProduct(String productID) {
		
		if(productID != null && !productID.isEmpty()) {
			
			try {
				
				connection = DBConnectionUtil.getDBConnection();
				
				preparedStatement = connection.prepareStatement(queryUtil.queryByID(commonConstants.QUERY_ID_DELETE_PRODUCT));
				preparedStatement.setString(commonConstants.COLUMN_INDEX_ONE, productID);
				
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
	public void updateProduct(String productID, Product product) {
		
		if(productID != null && !productID.isEmpty()) {
			
			try {
				
				System.out.println(productID + product.getProductName());
				
				connection = DBConnectionUtil.getDBConnection();
				
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
	public ArrayList<Product> getProductById(String productID) {
		
		ArrayList<Product> productList = new ArrayList<Product>();
		
		try {
			
			connection = DBConnectionUtil.getDBConnection();
			
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

	
	public ArrayList<Product> getProducts(){
		
		ArrayList<Product> productList = new ArrayList<Product>();
		
		try {
			
			connection = DBConnectionUtil.getDBConnection();
			
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
