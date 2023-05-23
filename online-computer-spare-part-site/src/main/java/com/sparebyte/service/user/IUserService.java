/**
 * OOP project year 2 semester 1, 2023
 * 
 * @author Malshan Rathnayake Software Engineering Undergraduate, SLIIT 
 * 
 * @version 1.0
 * Copyright: Malshan, All rights reserved
 * 
 */

package com.sparebyte.service.user;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.sparebyte.models.User;


/**
 * Contract for the implementation of User Service.
 * 
 * @author Malshan Rathnayake, SLIIT Undergraduate
 * @version 1.0
 */
public interface IUserService {
	
	/** Initialize logger */
	public static final Logger log = Logger.getLogger(IUserService.class.getName());
	
	/**
	 * Add users to the table
	 * @param user
	 */
	public void addUser(User user);
	
	/**
	 * Get praticular user
	 * @param userName
	 * @return user
	 */
	public User getUserByName(String userName);
	
	/**
	 * update existing user
	 * @param userID
	 * @param user
	 */
	public void updateUser(String userID, User user);
	
	/**
	 * Update existing user role
	 * @param userID
	 * @param user
	 */
	public void updateUserRole(String userID, User user);
	
	/**
	 * Get all users
	 * @return user
	 */
	public ArrayList<User> getUsers();

}
