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
 * This is the User model class
 * 
 * @author Malshan Rathnayake, SLIIT Undergraduate
 * @version 1.0
 */
public class User {
	
	private String UserId;
	private String UserName;
	private String Email;
	private String Password;
	private String MobileNo;
	private String userRole;
	
	/**
	 * 
	 * @param userId
	 */
	public void setUserId(String userId) {
		
		UserId = userId;
	}
	
	/**
	 * 
	 * @return userID
	 */
	public String getUserId() {
		
		return UserId;
	}
	
	/**
	 * 
	 * @param userName
	 */
	public void setUserName(String userName) {
		
		UserName = userName;
	}
	
	/**
	 * 
	 * @return userName
	 */
	public String getUserName() {
		
		return UserName;
	}
	
	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		
		Email = email;
	}
	
	/**
	 * 
	 * @return email
	 */
	public String getEmail() {
		
		return Email;
	}
	
	/**
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		
		Password = password;
	}
	
	/**
	 * 
	 * @return passwrod
	 */
	public String getPassword() {
		
		return Password;
	}
	
	/**
	 * 
	 * @param string
	 */
	public void setMobileNo(String string) {
		
		MobileNo = string;
	}
	
	/**
	 * 
	 * @return mobileNo
	 */
	public String getMobileNo() {
		
		return MobileNo;
	}
	
	/**
	 * 
	 * @return userRole
	 */
	public String getUserRole() {
		return userRole;
	}
	
	/**
	 * 
	 * @param userRole
	 */
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}


}


