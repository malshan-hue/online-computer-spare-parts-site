/**
 * OOP project year 2 semester 1, 2023
 * 
 * @author Malshan Rathnayake Software Engineering Undergraduate, SLIIT 
 * 
 * @version 1.0
 * Copyright: Malshan, All rights reserved
 * 
 */

package com.sparebyte.util;


/**
 * This is the common constants file for Java Web project.
 * 
 * @author Malshan Rathnayake, SLIIT undergraduate
 * @version 1.0
 */
public class commonConstants {
	
	/** Constant for config.properties key for query file path */
	public static final String QUERY_XML = "queryFilePath";
	
	/** Constant for file path of config.properties */
	public static final String PROPERTY_FILE = "config.properties";
	
	/** Constant for query tag in queries.xml */
	public static final String TAG_NAME = "query";
	
	/** Constant for query id in queries.xml */
	public static final String ATTRIB_ID = "id";
	
	/** Constant for comma */
	public static final String COMMA = ",";
	
	/** Constant for url key of MySQL database in config.properties */
	public static final String URL = "url";
	
	/** Constant for user name key of MySQL database in config.properties */
	public static final String USERNAME = "username";
	
	/** Constant for password key of MySQL database in config.properties */
	public static final String PASSWORD = "password";
	
	/** Constant for driver name key of MySQL database in config.properties */
	public static final String DRIVER_NAME = "driverName";
	
	/** Constant for Column index one */
	public static final int COLUMN_INDEX_ONE = 1;
	
	/** Constant for Column index two */
	public static final int COLUMN_INDEX_TWO = 2;
	
	/** Constant for Column index three */
	public static final int COLUMN_INDEX_THREE = 3;
	
	/** Constant for Column index four */
	public static final int COLUMN_INDEX_FOUR = 4;
	
	/** Constant for Column index five */
	public static final int COLUMN_INDEX_FIVE = 5;
	
	/** Constant for Column index six */
	public static final int COLUMN_INDEX_SIX = 6;
	
	/** Constant for Column index seven */
	public static final int COLUMN_INDEX_SEVEN = 7;
	
	/** Constant for Column index eight */
	public static final int COLUMN_INDEX_EIGHT = 8;
	
	/** Constant for Column index nine */
	public static final int COLUMN_INDEX_NINE = 9;
	
	
	/**
	 * 	user constsnts
	 */
	
	/** Constant for user id prefix */
	public static final String USER_ID_PREFIX = "U100";
	
	/** Constant for query id of create_user_table in queries.xml */
	public static final String QUERY_ID_CREATE_USER_TABLE = "create_user_tables";
	
	/** Constant for query id of drop_table in queries.xml */
	public static final String QUERY_ID_DROP_USER_TABLE = "drop_table";
	
	/** Constant for query id of insert_user in queries.xml */
	public static final String QUERY_ID_INSERT_USER = "insert_user";
	
	/** Constant for query id of user_ids in queries.xml */
	public static final String QUERY_ID_GET_USER_IDS = "user_ids";
	
	/** Constant for query id of user_by_id in queries.xml */
	public static final String QUERY_ID_GET_USER = "user_by_id";
	
	/** Constant for query id of all_users in queries.xml */
	public static final String QUERY_ID_ALL_USERS = "all_users";
	
	/** Constant for query id of update_user in queries.xml */
	public static final String QUERY_ID_UPDATE_USER = "update_user";
	
	/** Constant for query id of update_user_role in queries.xml */
	public static final String QUERY_ID_UPDATE_USER_ROLE = "update_user_role";
	
	
	/**
	 * 	product constants
	 */
	
	/** Constant for product id prefix */
	public static final String PRODUCT_ID_PREFIX = "P100";
	
	/** Constant for query id of create_product_table in queries.xml */
	public static final String QUERY_ID_CREATE_PRODUCT_TABLE = "create_product_table";
	
	/** Constant for query id of drop_product_table in queries.xml */
	public static final String QUERY_ID_DROP_PRODUCT_TABLE = "drop_product_table";
	
	/** Constant for query id of insert_product in queries.xml */
	public static final String QUERY_ID_INSERT_PRODUCT = "insert_product";
	
	/** Constant for query id of product_ids in queries.xml */
	public static final String QUERY_ID_GET_PRODUCT_IDS = "product_ids";
	
	/** Constant for query id of product_by_id in queries.xml */
	public static final String QUERY_ID_GET_PRODUCT = "product_by_id";
	
	/** Constant for query id of all_products in queries.xml */
	public static final String QUERY_ID_GET_ALL_PRODUCTS = "all_products";
	
	/** Constant for query id of delete_product in queries.xml */
	public static final String QUERY_ID_DELETE_PRODUCT = "delete_product";
	
	/** Constant for query id of update_product in queries.xml */
	public static final String QUERY_ID_UPDATE_PRODUCT = "update_product";
	
	/**
	 * category consttants
	 */
	
	/** Constant for category id prefix */
	public static final String CATEGORY_ID_PREFIX = "CAT100";
	
	/** Constant for query id of create_category_table in queries.xml */
	public static final String QUERY_ID_CREATE_CATEGORY_TABLE = "create_category_table";
	
	/** Constant for query id of drop_category_table in queries.xml */
	public static final String QUERY_ID_DROP_CATEGORY_TABLE = "drop_category_table";
	
	/** Constant for query id of insert_category in queries.xml */
	public static final String QUERY_ID_INSERT_CATEGORY = "insert_category";
	
	/** Constant for query id of category_ids in queries.xml */
	public static final String QUERY_ID_GET_CATEGORY_IDS = "category_ids";
	
	/** Constant for query id of category_by_id in queries.xml */
	public static final String QUERY_ID_GET_CATEGORY = "category_by_id";
	
	/** Constant for query id of all_categories in queries.xml */
	public static final String QUERY_ID_GET_ALL_CATEGORIES = "all_categories";
	
	/** Constant for query id of delete_category in queries.xml */
	public static final String QUERY_ID_DELETE_CATEGORY = "delete_category";
	
	/** Constant for query id of update_category in queries.xml */
	public static final String QUERY_ID_UPDATE_CATEGORY = "update_category";
	
	/**
	 * brand constants
	 */
	
	/** Constant for product id prefix */
	public static final String BRAND_ID_PREFIX = "BRD100";
	
	/** Constant for query id of create_brand_table in queries.xml */
	public static final String QUERY_ID_CREATE_BRAND_TABLE = "create_brand_table";
	
	/** Constant for query id of drop_brand_table in queries.xml */
	public static final String QUERY_ID_DROP_BRAND_TABLE = "drop_brand_table";
	
	/** Constant for query id of insert_brand in queries.xml */
	public static final String QUERY_ID_INSERT_BRAND = "insert_brand";
	
	/** Constant for query id of brand_ids in queries.xml */
	public static final String QUERY_ID_GET_BRAND_IDS = "brand_ids";
	
	/** Constant for query id of brand_by_id in queries.xml */
	public static final String QUERY_ID_GET_BRAND = "brand_by_id";
	
	/** Constant for query id of all_brands in queries.xml */
	public static final String QUERY_D_GET_ALL_BRANDS = "all_brands";
	
	/** Constant for query id of delete_brand in queries.xml */
	public static final String QUERY_ID_DELETE_BRAND = "delete_brand";
	
	/** Constant for query id of update_brand in queries.xml */
	public static final String QUERY_ID_UPDATE_BRAND = "update_brand";
	
	/**
	 * cart constants
	 */
	
	/** Constant for product id prefix */
	public static final String CART_ID_PREFIX = "CRT100";
	
	/** Constant for query id of create_cart_table in queries.xml */
	public static final String QUERY_ID_CREATE_CART_TABLE = "create_cart_table";
	
	/** Constant for query id of drop_cart_table in queries.xml */
	public static final String QUERY_ID_DROP_CART_TABLE = "drop_cart_table";
	
	/** Constant for query id of insert_cart in queries.xml */
	public static final String QUERY_ID_INSERT_CART = "insert_cart";
	
	/** Constant for query id of cart_ids in queries.xml */
	public static final String QUERY_ID_GET_CART_IDS = "cart_ids";
	
	/** Constant for query id of cart_by_id in queries.xml */
	public static final String QUERY_ID_GET_CART = "cart_by_id";
	
	/** Constant for query id of all_cart in queries.xml */
	public static final String QUERY_TD_GET_ALL_CART = "all_cart";
	
	/** Constant for query id of delete_cart in queries.xml */
	public static final String QUERY_ID_DELETE_CART = "delete_cart";
	
	/** Constant for query id of clear_cart in queries.xml */
	public static final String QUERY_ID_CLEAR_CART = "clear_cart";
	
	/**
	 * order constants
	 */
	
	/** Constant for product id prefix */
	public static final String ORDER_ID_PREFIX = "ODR100";
	
	public static final String QUERY_ID_CREATE_ORDER_TABLE = "create_Order_table";
	
	public static final String QUERY_ID_DROP_ORDER_TABLE = "drop_order_table";
	
	public static final String QUERY_ID_INSERT_ORDER = "insert_order";
	
	public static final String QUERY_ID_GET_ORDER_IDS = "order_ids";
	
	public static final String QUERY_TD_GET_ALL_ORDER = "all_order";
	
	public static final String QUERY_ID_DELETE_ORDER = "delete_order";
	
	public static final String QUERY_ID_GET_ORDER_PRODUCT = "order_product";
	

}
