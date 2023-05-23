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

import java.util.ArrayList;
import java.util.logging.Logger;

import com.sparebyte.models.Product;
import com.sparebyte.service.user.IUserService;


/**
 * Contract for the implementation of Product Service.
 * 
 * @author Malshan Rathnayake, SLIIT Undergraduate
 * @version 1.0
 */
public interface IProductService {
	
	/** Initialize logger */
	public static final Logger log = Logger.getLogger(IUserService.class.getName());
	
	/**
	 * Add product to  the product table
	 * @param product
	 */
	public void addProduct(Product product);
	
	/**
	 * Remove existing product
	 * @param productID
	 */
	public void deleteProduct(String productID);
	
	/**
	 * Update existing product
	 * @param productID
	 * @param product 
	 */
	public void updateProduct(String productID, Product product);
	
	/**
	 * Get a praticular product
	 * @param productID
	 * @return product
	 */
	public ArrayList<Product> getProductById(String productID);
	
	/**
	 * Get all products
	 * @return product
	 */
	public ArrayList<Product> getProducts();
}
