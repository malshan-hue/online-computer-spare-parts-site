/**
 * OOP project year 2 semester 1, 2023
 * 
 * @author Malshan Rathnayake Software Engineering Undergraduate, SLIIT 
 * 
 * @version 1.0
 * Copyright: Malshan, All rights reserved
 * 
 */
package com.sparebyte.service.cart;

/**
 * Contract for the implementation of Cart Service.
 * 
 * @author Malshan Rathnayake, SLIIT Undergraduate
 * @version 1.0
 */
import java.util.ArrayList;
import java.util.logging.Logger;

import com.sparebyte.models.Cart;

public interface ICartService {

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(ICartService.class.getName());
	
	/**
	 * Add products to the cart table
	 * @param cart
	 */
	public void addToCart(Cart cart);
	
	/**
	 * Remove items from cart
	 * @param cartID
	 */
	public void deleteFromCart(String cartID);
	
	/**
	 * Delete all items for a praticular user
	 * @param userID
	 */
	public void clearCart(String userID);
	
	/**
	 * Get cart Details
	 * @param cartID
	 * @return cart
	 */
	public ArrayList<Cart> getCartdById(String cartID);
	
	/**
	 * 
	 * @param userID
	 * @return
	 */
	public ArrayList<Cart> getCart(String userID);

}
