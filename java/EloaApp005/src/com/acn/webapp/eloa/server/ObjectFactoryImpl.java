package com.acn.webapp.eloa.server;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.acn.webapp.eloa.shared.UpperCaseDecorator;


public class ObjectFactoryImpl implements ObjectFactory
{
	private HashMap<String, AcnObject> registered = new HashMap<String, AcnObject>();
	public AcnObject create(String classname, Map values) throws AcnException
	{
		AcnObject obj = null;
		
		try {
			Object objx = (Object)registered.get(classname);
			if  (objx != null)
			{
				if  (objx.getClass().getName().equals(classname))
				{
					obj = (AcnObject)((AcnObject)objx).clone();
				}
				else
				{
					obj = (AcnObject)Class.forName(classname).newInstance();
					registered.put(classname, obj);
				}
			}
			else
			{
				obj = (AcnObject)Class.forName(classname).newInstance();
				registered.put(classname, obj);
			}
			obj.setState(values);
			obj.checkState(values);
			if  (values.get("decorator") == null){
				values.put("decorator", new UpperCaseDecorator());
			}
			obj.decorate("decorator", values);
		} catch (RuntimeException e) {
			throw new AcnException("could not clone cgObject: " + classname, e);
		} catch (InstantiationException e) {
			throw new AcnException("could not clone cgObject: " + classname, e);
		} catch (IllegalAccessException e) {
			throw new AcnException("could not clone cgObject: " + classname, e);
			
		} catch (ClassNotFoundException e) {
			throw new AcnException("could not clone cgObject: " + classname, e);
		}

	return obj;
	}
	public AcnObject create(boolean bGwt, String classname, String jValue) throws AcnException
	{
		AcnObject obj = null;
		
		if  (!bGwt){
			obj = create(classname, jValue);
		}

		return obj;
	}
	public AcnObject create(String classname, String jValue) throws AcnException
	{
		AcnObject obj = null;
		
		try {
			Object objx = (Object)registered.get(classname);
			if  (objx != null)
			{
				if  (objx.getClass().getName().equals(classname))
				{
					obj = (AcnObject)((AcnObject)objx).clone();
				}
				else
				{
					obj = (AcnObject)Class.forName(classname).newInstance();
					registered.put(classname, obj);
				}
			}
			else
			{
				obj = (AcnObject)Class.forName(classname).newInstance();
				registered.put(classname, obj);
			}
			HashMap<String,Object> mpValue = new ObjectMapper().readValue(jValue, new TypeReference<HashMap<String,Object>>() {});
			obj.setState(mpValue);
		} catch (RuntimeException e) {
			throw new AcnException("could not clone cgObject: " + classname, e);
		} catch (InstantiationException e) {
			throw new AcnException("could not clone cgObject: " + classname, e);
		} catch (IllegalAccessException e) {
			throw new AcnException("could not clone cgObject: " + classname, e);
			
		} catch (ClassNotFoundException e) {
			throw new AcnException("could not clone cgObject: " + classname, e);
		} catch (JsonMappingException e) {
			throw new AcnException("could not clone cgObject: " + classname, e);
		} catch (JsonParseException e) {
			throw new AcnException("could not clone cgObject: " + classname, e);
		} catch (IOException e) {
			throw new AcnException("could not clone cgObject: " + classname, e);
		}
		

	return obj;
	}
	public AcnObject create(boolean bGwt, String classname, Map values) throws AcnException
	{
		AcnObject obj = null;
		
		if  (!bGwt){
			obj = create(classname, values);
		}

		return obj;
	}
	public HashMap getRegistered()
	{
		return registered;
	}
	public void setRegistered(HashMap registered)
	{
		this.registered = registered;
	}
}
