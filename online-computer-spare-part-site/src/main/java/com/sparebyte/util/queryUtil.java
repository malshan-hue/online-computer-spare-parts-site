package com.sparebyte.util;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.sparebyte.service.user.UserServiceImpl;
import com.sparebyte.util.commonConstants;

public class queryUtil extends commonUtil {
	
	public static String queryByID(String id) throws SAXException, IOException, ParserConfigurationException{
		
		NodeList nodelist;
		Element element = null;
		
		nodelist = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(System.getProperty("catalina.base") + "\\wtpwebapps\\online-computer-spare-part-site\\WEB-INF\\queries.xml"))
				.getElementsByTagName(commonConstants.TAG_NAME);
		
		for (int value = 0; value< nodelist.getLength(); value++) {
			
			element = (Element) nodelist.item(value);
			
			if(element.getAttribute(commonConstants.ATTRIB_ID).equals(id)) {
				break;
			}
			
		}
		
		return element.getTextContent().trim();
	}
	

}
