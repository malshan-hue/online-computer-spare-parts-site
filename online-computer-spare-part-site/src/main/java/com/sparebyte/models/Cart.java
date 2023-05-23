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
 * This is the Cart model class
 * 
 * @author Malshan Rathnayake, SLIIT Undergraduate
 * @version 1.0
 */
public class Cart {
	
	private String cartID;
	private String userID;
	private String productName;
	private String Amount;
	
	
	/**
	 * 
	 * @return cartID
	 */
	public String getCartID() {
		return cartID;
	}
	
	/**
	 * 
	 * @param cartID
	 */
	public void setCartID(String cartID) {
		this.cartID = cartID;
	}
	/**
	 * 
	 * @return userID
	 */
	public String getUserID() {
		return userID;
	}
	
	/**
	 * 
	 * @param userID
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	/**
	 * 
	 * @return productName
	 */
	public String getProductName() {
		return productName;
	}
	
	/**
	 * 
	 * @param productName
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	/**
	 * 
	 * @return amount
	 */
	public String getAmount() {
		return Amount;
	}
	
	/**
	 * 
	 * @param amount
	 */
	public void setAmount(String amount) {
		Amount = amount;
	}
	
	

}
