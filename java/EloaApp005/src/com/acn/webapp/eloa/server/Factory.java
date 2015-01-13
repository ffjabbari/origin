package com.acn.webapp.eloa.server;


import java.util.HashMap;
import java.util.Map;


public interface Factory
{
	public AcnObject create(String classname, Map mpValue) throws AcnException;
	public AcnObject create(boolean bGwt, String classname, Map mpValue) throws AcnException;
	public AcnObject create(String classname, String jValue) throws AcnException;
	public AcnObject create(boolean bGwt, String classname, String jValue) throws AcnException;
	
}
