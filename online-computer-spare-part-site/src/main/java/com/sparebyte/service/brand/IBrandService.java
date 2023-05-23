/**
 * OOP project year 2 semester 1, 2023
 * 
 * @author Malshan Rathnayake Software Engineering Undergraduate, SLIIT 
 * 
 * @version 1.0
 * Copyright: Malshan, All rights reserved
 * 
 */

package com.sparebyte.service.brand;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.sparebyte.models.Brand;


/**
 * Contract for the implementation of Brand Service.
 * 
 * @author Malshan Rathnayake, SLIIT Undergraduate
 * @version 1.0
 */
public interface IBrandService {
	
	/** Initialize logger */
	public static final Logger log = Logger.getLogger(IBrandService.class.getName());
	
	/**
	 * Add brands to the brand table
	 * @param brand
	 */
	public void addBrand(Brand brand);
	
	/**
	 * remove existing brand
	 * @param brandID
	 */
	public void deleteBrand(String brandID);
	
	/**
	 * update existing brand
	 * @param brandID
	 * @param brand
	 */
	public void updateBrand(String brandID, Brand brand);
	
	/**
	 * Get a praticular brand
	 * @param brandID
	 * @return brand
	 */
	public ArrayList<Brand> getBrandById(String brandID);
	
	/**
	 * Get all brands
	 * @return brand
	 */
	public ArrayList<Brand> getBrands();
	
}
