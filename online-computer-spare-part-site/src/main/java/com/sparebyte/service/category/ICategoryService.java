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

import java.util.ArrayList;
import java.util.logging.Logger;

import com.sparebyte.models.Category;

/**
 * Contract for the implementation of Category Service.
 * 
 * @author Malshan Rathnayake, SLIIT Undergraduate
 * @version 1.0
 */
public interface ICategoryService {
	
	/** Initialize logger */
	public static final Logger log = Logger.getLogger(ICategoryService.class.getName());
	
	/**
	 * Add category to the table
	 * @param category
	 */
	public void addCategory(Category category);
	
	/**
	 * delete praticular category from table
	 * @param catID
	 */
	public void deleteCategory(String catID);
	
	/**
	 * Update existing category
	 * @param catID
	 * @param category
	 */
	public void updateCategory(String catID, Category category);
	
	/**
	 * Get praticular category
	 * @param catID
	 * @return category
	 */
	public ArrayList<Category> getCategoryById(String catID);
	
	/**
	 * Get all categories
	 * @return category
	 */
	public ArrayList<Category> getCategories();

}
