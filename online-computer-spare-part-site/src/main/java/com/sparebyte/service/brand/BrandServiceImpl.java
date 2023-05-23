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

public class BrandServiceImpl implements IBrandService{
	
	public static final Logger log = Logger.getLogger(BrandServiceImpl.class.getName());
	
	private static Connection connection;
	private static Statement statement;
	
	static {
		createBrandTable();
	}
	
	public static PreparedStatement preparedStatement;
	
	public static void createBrandTable() {
		
		try {
			
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			
			statement.executeUpdate(queryUtil.queryByID(commonConstants.QUERY_ID_CREATE_BRAND_TABLE));
			
			
		}catch(SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	@Override
	public void addBrand(Brand brand) {
		
		String brandID = commonUtil.generateBrandIDs(getBrandIds());
		
		try {
			
			connection = DBConnectionUtil.getDBConnection();
			
			preparedStatement = connection.prepareStatement(queryUtil.queryByID(commonConstants.QUERY_ID_INSERT_BRAND));
			connection.setAutoCommit(false);
			
			brand.setBrandID(brandID);
			preparedStatement.setString(commonConstants.COLUMN_INDEX_ONE, brand.getBrandID());
			preparedStatement.setString(commonConstants.COLUMN_INDEX_TWO, brand.getBrandName());
			preparedStatement.setString(commonConstants.COLUMN_INDEX_THREE, brand.getBrandOrigin());
			preparedStatement.setString(commonConstants.COLUMN_INDEX_FOUR, brand.getBrandProductFocus());
			preparedStatement.setString(commonConstants.COLUMN_INDEX_FIVE, brand.getBrandProductPortfolio());
			
			System.out.println("Create una yakooooooooo!!!!");
			
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
	public void deleteBrand(String brandID) {
		
		if(brandID != null && !brandID.isEmpty()) {
			
			try {
				
				connection = DBConnectionUtil.getDBConnection();
				
				preparedStatement = connection.prepareStatement(queryUtil.queryByID(commonConstants.QUERY_ID_DELETE_BRAND));
				preparedStatement.setString(commonConstants.COLUMN_INDEX_ONE, brandID);
				
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
	public void updateBrand(String brandID, Brand brand) {
		
		if(brandID != null && !brandID.isEmpty()) {
			
			try {
				
				connection = DBConnectionUtil.getDBConnection();
				
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
	public ArrayList<Brand> getBrandById(String brandID) {
		
		ArrayList<Brand> productList = new ArrayList<Brand>();
		
		try {
			
			connection = DBConnectionUtil.getDBConnection();
			
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

	@Override
	public ArrayList<Brand> getBrands() {
		
		ArrayList<Brand> brandList = new ArrayList<Brand>();
		
		try {
			
			connection = DBConnectionUtil.getDBConnection();
			
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
