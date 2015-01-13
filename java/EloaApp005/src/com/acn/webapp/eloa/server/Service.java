package com.acn.webapp.eloa.server;


import java.util.HashMap;
import java.util.Map;


public interface Service
{
	public AcnObject create(String classname, Map values) throws AcnException;
}
