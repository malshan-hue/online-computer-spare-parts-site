package com.sparebyte.service.brand;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.sparebyte.models.Brand;

public interface IBrandService {
	
	public static final Logger log = Logger.getLogger(IBrandService.class.getName());
	
	public void addBrand(Brand brand);
	
	public void deleteBrand(String brandID);
	
	public void updateBrand(String brandID, Brand brand);
	
	public ArrayList<Brand> getBrandById(String brandID);
	
	public ArrayList<Brand> getBrands();
	
}
