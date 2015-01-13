package com.acn.webapp.eloa.server;

public interface Constants {
	
	public static ServiceFactory SrvFactory = ServiceFactoryImpl.getInstance();
	public static ObjectFactory ObjFactory = ServiceFactoryImpl.getInstance().getObjectFactory();

}
