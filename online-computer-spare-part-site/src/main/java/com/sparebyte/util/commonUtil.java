package com.sparebyte.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sparebyte.service.user.IUserService;

public class commonUtil {
	
	public static final Logger log = Logger.getLogger(IUserService.class.getName());
	public static final Properties properties = new Properties();
	
	static {
		try {
			
			properties.load(queryUtil.class.getResourceAsStream(commonConstants.PROPERTY_FILE));
		}
		catch (IOException e){
				log.log(Level.SEVERE, e.getMessage());
		}
	}
	
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
