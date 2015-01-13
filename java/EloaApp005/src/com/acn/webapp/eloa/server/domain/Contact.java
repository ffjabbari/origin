package com.acn.webapp.eloa.server.domain;


import java.io.Serializable;
import java.util.Map;

import java.util.HashMap;

import com.acn.webapp.eloa.server.AcnException;
import com.acn.webapp.eloa.server.AcnObject;
import com.acn.webapp.eloa.server.Decorator;


@SuppressWarnings("serial")
public class Contact  extends AcnObject implements Serializable {
	public String id;
  public String name;
  public String lastName;
  public String address;
	
	public Contact() {}
	
	public Contact(String id, String name, String lastName, String address) {
		this.id = id;
    this.name = name;
    this.lastName = lastName;
		this.address = address;
	}

	
	public String getId() { return id; }
	  public String getName() { return name; }
	  public String getLastName() { return lastName; }
	  public String getAddress() { return address; }
	  public void setId(String id) { this.id = id; }
	  public void setName(String name) { this.name = name; }
	  public void setLastName(String lastName) { this.lastName = lastName; }
	  public void setAddress(String address) { this.address = address; }
	  
@Override
public boolean checkState(Map<String, Object> mpValue) throws AcnException {
	// TODO Auto-generated method stub
	return true;
}

@Override
public Map<String, Object> getState() throws AcnException {
	Map<String, Object> mpValue = new HashMap<String, Object>();
	mpValue.put("id", getId());
	mpValue.put("name", getName());
	mpValue.put("lastName", getLastName());
	mpValue.put("address", getAddress());
	
	return mpValue;
}

@Override
public void setState(Map<String, Object> mpValue) throws AcnException {
	if  (mpValue.get("id")!= null){
		setId((String)mpValue.get("id"));
	}
	if  (mpValue.get("name")!= null){
		setName((String)mpValue.get("name"));
	}
	if  (mpValue.get("lastName")!= null){
		setName((String)mpValue.get("lastName"));
	}
	if  (mpValue.get("address")!= null){
		setName((String)mpValue.get("address"));
	}
}
@Override
public void decorate(String decoratorName, Map mpValue)  {
	if  (mpValue.get("id.decorator")!= null){
		setId(((Decorator<String>)mpValue.get("id.decorator")).decorate((String)mpValue.get("id")));
	}
	if  (mpValue.get("name.decorator")!= null){
		setName(((Decorator<String>)mpValue.get("name.decorator")).decorate((String)mpValue.get("name")));
	}
	if  (mpValue.get("lastName.decorator")!= null){
		setLastName(((Decorator<String>)mpValue.get("lastName.decorator")).decorate((String)mpValue.get("lastName")));
	}
	if  (mpValue.get("address.decorator")!= null){
		setAddress(((Decorator<String>)mpValue.get("address.decorator")).decorate((String)mpValue.get("address")));
	}
}
  
}