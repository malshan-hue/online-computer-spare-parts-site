/**
 * OOP project year 2 semester 1, 2023
 * 
 * @author Malshan Rathnayake Software Engineering Undergraduate, SLIIT 
 * 
 * @version 1.0
 * Copyright: Malshan, All rights reserved
 * 
 */

package com.sparebyte.models;

/**
 * This is the Brand model class
 * 
 * @author Malshan Rathnayake, SLIIT Undergraduate
 * @version 1.0
 */
public class Brand {
	
	private String brandID;
	private String brandName;
	private String brandOrigin;
	private String brandProductFocus;
	private String brandProductPortfolio;
	
	/**
	 * @return the BrandID
	 */
	public String getBrandID() {
		return brandID;
	}
	
	/**
	 * @param set the BrandID
	 */
	public void setBrandID(String brandID) {
		this.brandID = brandID;
	}
	
	/**
	 * @return the BrandName
	 */
	public String getBrandName() {
		return brandName;
	}
	
	/**
	 * @param set the brandName
	 */
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	
	/**
	 * @return brandOrigin
	 */
	public String getBrandOrigin() {
		return brandOrigin;
	}
	
	/**
	 * 
	 * @param brandOrigin
	 */
	public void setBrandOrigin(String brandOrigin) {
		this.brandOrigin = brandOrigin;
	}
	
	/**
	 * 
	 * @return brandProductFocus
	 */
	public String getBrandProductFocus() {
		return brandProductFocus;
	}
	
	/**
	 * 
	 * @param brandProductFocus
	 */
	public void setBrandProductFocus(String brandProductFocus) {
		this.brandProductFocus = brandProductFocus;
	}
	
	/**
	 * 
	 * @return brandProductPortfolio
	 */
	public String getBrandProductPortfolio() {
		return brandProductPortfolio;
	}
	
	/**
	 * 
	 * @param brandProductPortfolio
	 */
	public void setBrandProductPortfolio(String brandProductPortfolio) {
		this.brandProductPortfolio = brandProductPortfolio;
	}
	
	
	

}
