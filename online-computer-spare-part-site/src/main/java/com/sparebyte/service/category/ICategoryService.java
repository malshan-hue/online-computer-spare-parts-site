package com.sparebyte.service.category;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.sparebyte.models.Category;

public interface ICategoryService {
	
	public static final Logger log = Logger.getLogger(ICategoryService.class.getName());
	
	public void addCategory(Category category);
	
	public void deleteCategory(String catID);
	
	public void updateCategory(String catID, Category category);
	
	public ArrayList<Category> getCategoryById(String catID);
	
	public ArrayList<Category> getCategories();

}
