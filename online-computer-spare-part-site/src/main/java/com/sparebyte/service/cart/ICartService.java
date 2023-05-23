package com.sparebyte.service.cart;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.sparebyte.models.Cart;
import com.sparebyte.service.brand.IBrandService;

public interface ICartService {
	
	public static final Logger log = Logger.getLogger(IBrandService.class.getName());
	
	public void addToCart(Cart cart);
	
	public void deleteFromCart(String cartID);
	
	public void clearCart(String userID);
	
	public ArrayList<Cart> getCartdById(String cartID);
	
	public ArrayList<Cart> getCart(String userID);

}
