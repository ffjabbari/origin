package com.acn.webapp.eloa.shared;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.acn.webapp.eloa.server.AcnException;
import com.acn.webapp.eloa.shared.Decorator;

@SuppressWarnings("serial")
public class UserDetails extends AcnObject{
  private String id;
  private String displayName;
  private String lastName;
  private String address;
  private String name;
  
  public UserDetails() {
    new UserDetails("0", "");
  }

  public UserDetails(String id, String displayName) {
	    this.id = id;
	    this.displayName = displayName;
	    this.name = name="name!!!";
	    this.lastName = "LastName!!!";
	    this.address = "adress!!!";
	  }
	  
  public UserDetails(String id, String displayName, String lastName, String address, String name) {
	    this.id = id;
	    this.displayName = displayName;
	    this.lastName = lastName;
	    this.address = address;
	    this.name = name;
	  }
	  
	  public String getId() { return id; }
  public void setId(String id) { this.id = id; }
  public String getDisplayName() { return displayName; }
  public void setDisplayName(String displayName) { this.displayName = displayName; } 
  public String getName() { return name; }
  public void setName(String name) { this.name = name; } 
  public String getLastName() { return lastName; }
  public void setLastName(String lastName) { this.lastName = lastName; } 
  public String getAddress() { return address; }
  public void setAddress(String address) { this.address = address; } 
  
  
  @Override
  public boolean checkState(Map<String, Object> mpValue) {
  	// TODO Auto-generated method stub
  	return true;
  }

  @Override
  public Map<String, Object> getState(){
  	Map<String, Object> mpValue = new HashMap<String, Object>();
  	mpValue.put("id", getId());
  	mpValue.put("displayName", getDisplayName());
  	mpValue.put("lastName", getLastName());
  	mpValue.put("address", getAddress());
  	mpValue.put("name", getName());
  	
  	
  	return mpValue;
  }

  @Override
  public void setState(Map<String, Object> mpValue) {
  	if  (mpValue.get("id")!= null){
  		setId((String)mpValue.get("id"));
  	}
  	if  (mpValue.get("displayName")!= null){
  		setDisplayName((String)mpValue.get("displayName"));
  	}
  	if  (mpValue.get("lastName")!= null){
  		setLastName((String)mpValue.get("lastName"));
  	}
  	if  (mpValue.get("address")!= null){
  		setAddress((String)mpValue.get("address"));
  	}
  	if  (mpValue.get("name")!= null){
  		setName((String)mpValue.get("name"));
  	}
  }
  @Override
	public void decorate(String decoratorName, Map mpValue)  {
		if  (mpValue.get("id")!= null){
			setId(((Decorator<String>)mpValue.get("id.decorator")).decorate((String)mpValue.get("id")));
	  	}
	  	if  (mpValue.get("displayName")!= null){
	  		setDisplayName(((Decorator<String>)mpValue.get("displayName.decorator")).decorate((String)mpValue.get("displayName")));
	  	}
	  	if  (mpValue.get("lastName")!= null){
	  		setLastName(((Decorator<String>)mpValue.get("lastName.decorator")).decorate((String)mpValue.get("lastName")));
	  	}
	  	if  (mpValue.get("address")!= null){
	  		setAddress(((Decorator<String>)mpValue.get("address.decorator")).decorate((String)mpValue.get("address")));
	  	}
	  	if  (mpValue.get("name")!= null){
	  		setName(((Decorator<String>)mpValue.get("name.decorator")).decorate((String)mpValue.get("name")));
	  	}
	}
}
