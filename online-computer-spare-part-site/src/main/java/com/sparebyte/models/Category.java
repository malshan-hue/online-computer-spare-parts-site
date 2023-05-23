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
 * This is the Category model class
 * 
 * @author Malshan Rathnayake, SLIIT Undergraduate
 * @version 1.0
 */
public class Category {
	
	private String catID;
	private String catName;
	private String catDesc;
	private String catCreatedDate;
	private String catUpdatedDate;
	
	/**
	 * 
	 * @return cartID
	 */
	public String getCatID() {
		return catID;
	}
	
	/**
	 * 
	 * @param catID
	 */
	public void setCatID(String catID) {
		this.catID = catID;
	}
	
	/**
	 * 	
	 * @return catName
	 */
	public String getCatName() {
		return catName;
	}
	
	/**
	 * 
	 * @param catName
	 */
	public void setCatName(String catName) {
		this.catName = catName;
	}
	
	/**
	 * 
	 * @return catDesc
	 */
	public String getCatDesc() {
		return catDesc;
	}
	
	/**
	 * 
	 * @param catDesc
	 */
	public void setCatDesc(String catDesc) {
		this.catDesc = catDesc;
	}
	
	/**
	 * 
	 * @return catCreatedDate
	 */
	public String getCatCreatedDate() {
		return catCreatedDate;
	}
	
	/**
	 * 
	 * @param catCreatedDate
	 */
	public void setCatCreatedDate(String catCreatedDate) {
		this.catCreatedDate = catCreatedDate;
	}
	
	/**
	 * 
	 * @return catUpdatedDate
	 */
	public String getCatUpdatedDate() {
		return catUpdatedDate;
	}
	
	/**
	 * 
	 * @param catUpdatedDate
	 */
	public void setCatUpdatedDate(String catUpdatedDate) {
		this.catUpdatedDate = catUpdatedDate;
	}
	

}
