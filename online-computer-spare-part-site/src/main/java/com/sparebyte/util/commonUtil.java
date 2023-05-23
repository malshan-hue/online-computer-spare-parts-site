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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sparebyte.service.user.IUserService;

/**
 * This is the common utility class to load all property details at once when it
 * is initializing .
 * 
 * @author Malshan Rathnayake, SLIIT Undergraduate
 * @version 1.0
 */
public class commonUtil {
	
	/** Initialize logger */
	public static final Logger log = Logger.getLogger(IUserService.class.getName());
	
	public static final Properties properties = new Properties();
	
	static {
		try {
			
			// Read the property only once when load the class
			properties.load(queryUtil.class.getResourceAsStream(commonConstants.PROPERTY_FILE));
		}
		catch (IOException e){
				log.log(Level.SEVERE, e.getMessage());
		}
	}
	
	/**
	 * Add new user ID
	 * 
	 * @param arrayList
	 * @return
	 */
	public static String generateUserIDs(ArrayList<String> arraylist) {
		
		String id;
		int next = arraylist.size();
		
		id = commonConstants.USER_ID_PREFIX + next;
		
		if(arraylist.contains(id)) {
			next++;
			id = commonConstants.USER_ID_PREFIX + next;
		}
		
		return id;
		
	}
	
	/**
	 * Add new product ID
	 * 
	 * @param arrayList
	 * @return
	 */
	public static String generateProductIDs(ArrayList<String> arraylist) {
		
		String id;
		int next = arraylist.size();
		
		id = commonConstants.PRODUCT_ID_PREFIX + next;
		
		if(arraylist.contains(id)) {
			next++;
			id = commonConstants.PRODUCT_ID_PREFIX + next;
		}
		
		return id;
		
	}
	
	/**
	 * Add new category ID
	 * 
	 * @param arrayList
	 * @return
	 */
	public static String generateCategoryIDs(ArrayList<String> arraylist) {
		
		String id;
		int next = arraylist.size();
		
		id = commonConstants.CATEGORY_ID_PREFIX + next;
		
		if(arraylist.contains(id)) {
			next++;
			id = commonConstants.CATEGORY_ID_PREFIX + next;
		}
		
		return id;
		
	}
	
	/**
	 * Add new brand ID
	 * 
	 * @param arrayList
	 * @return
	 */
	public static String generateBrandIDs(ArrayList<String> arraylist) {
		
		String id;
		int next = arraylist.size();
		
		id = commonConstants.BRAND_ID_PREFIX + next;
		
		if(arraylist.contains(id)) {
			next++;
			id = commonConstants.BRAND_ID_PREFIX + next;
		}
		
		return id;
		
	}
	
	/**
	 * Add new cart ID
	 * 
	 * @param arrayList
	 * @return
	 */
	public static String generateCartIDs(ArrayList<String> arraylist) {
		
		String id;
		int next = arraylist.size();
		
		id = commonConstants.CART_ID_PREFIX + next;
		
		if(arraylist.contains(id)) {
			next++;
			id = commonConstants.CART_ID_PREFIX + next;
		}
		
		return id;
		
	}

}
