package se.supportix.camelreboot.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import se.supportix.camelreboot.xml.Order;


public class FixerBean {

	private static final Logger logger = LoggerFactory.getLogger(FixerBean.class);
	
	public void setCorrectValues(Order order) {
		logger.info("I ordered a {}", order.getProduct());
		
	}
	
}
