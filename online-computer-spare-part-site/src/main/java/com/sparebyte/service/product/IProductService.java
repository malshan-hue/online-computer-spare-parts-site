package com.sparebyte.service.product;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.sparebyte.models.Product;
import com.sparebyte.service.user.IUserService;

public interface IProductService {
	
	public static final Logger log = Logger.getLogger(IUserService.class.getName());
	
	public void addProduct(Product product);
	
	public void deleteProduct(String productID);
	
	public void updateProduct(String productID, Product product);
	
	public ArrayList<Product> getProductById(String productID);
	
	public ArrayList<Product> getProducts();
}
