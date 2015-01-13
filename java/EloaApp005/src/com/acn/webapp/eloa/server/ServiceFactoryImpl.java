package com.acn.webapp.eloa.server;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class ServiceFactoryImpl  implements ServiceFactory
{
	private static ServiceFactoryImpl instance = null;
	
	private static ObjectFactory objectFactory = null;
	
	static
	{
		if  (instance == null)
		{
			instance = new ServiceFactoryImpl();
		}
	}
	
	
	public ServiceFactoryImpl()
	{
		
	}
	public static ServiceFactory getInstance()
	{
		return instance;
	}
	
	public ObjectFactory getObjectFactory() throws AcnException
	{
		if  (objectFactory == null)
		{
			objectFactory = new ObjectFactoryImpl();
		}
		return objectFactory;
	}
	
	
	
	
}
