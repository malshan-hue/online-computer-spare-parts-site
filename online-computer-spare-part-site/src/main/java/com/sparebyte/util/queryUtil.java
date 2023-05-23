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
 * This load Sql queries available in the queries.xml
 * 
 * @author Malshan Rathnayake, SLIIT Undergraduate
 * @version 1.0
 * @see #CommonUtil
 */
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.sparebyte.models.Product;
import com.sparebyte.service.user.UserServiceImpl;
import com.sparebyte.util.commonConstants;

/**
 * This method read the queries.xml file and retrieve the query by
 * query id.
 * 
 * @param id
 *            QueryID to retrieve elements
 * 
 * @return String formatted query will be returned as output
 * 
 * @throws ParserConfigurationException
 *             - Indicates a serious configuration error.
 * @throws IOException
 *             - This class is the general class of exceptions produced by
 *             failed or interrupted I/O operations.
 * @throws SAXException
 *             - Encapsulate a general SAX error or warning.
 *             
 * @see ProductServiceImpl#addProduct(Product product)
 * @see ProductServiceImpl#deleteProduct(String productID)
 * @see ProductServiceImpl#updateProduct(String productID, Product product)
 * @see ProductServiceImpl#getProductById(String productID)
 * @see ProductServiceImpl#getProducts()
 * 
 */

public class queryUtil extends commonUtil {
	
	public static String queryByID(String id) throws SAXException, IOException, ParserConfigurationException{
		
		NodeList nodelist;
		Element element = null;
		/*
		 * Read the queries.xml file and read each query node into node
		 * list. It refers tag name query
		 */
		
		nodelist = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(System.getProperty("catalina.base") + "\\wtpwebapps\\online-computer-spare-part-site\\WEB-INF\\queries.xml"))
				.getElementsByTagName(commonConstants.TAG_NAME);
		
		/*
		 * Extract the node from node list using query id, query id is taken from
		 * query node attribute
		 */
		for (int value = 0; value< nodelist.getLength(); value++) {
			
			element = (Element) nodelist.item(value);
			
			if(element.getAttribute(commonConstants.ATTRIB_ID).equals(id)) {
				break;
			}
			
		}
		
		return element.getTextContent().trim();
	}
	

}
