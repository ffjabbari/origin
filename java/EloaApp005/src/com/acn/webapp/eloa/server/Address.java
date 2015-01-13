package com.acn.webapp.eloa.server;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.core.client.GWT;

public class Address extends AcnObject{

	private String line1;
	private String line2;
	private String city;
	private String states;
	private String country;
	private String zip;
	static{
		System.out.println("Running in GWT Mode: " + com.google.gwt.core.client.GWT.isScript());
		if  (GWT.isScript()){
			ObjFactory.getRegistered().put(Address.class.getName(), GWT.create(Address.class));
		}
	}
	public Address(){
		super();
	}
	public String getLine1() {
		return line1;
	}
	public void setLine1(String line1) {
		this.line1 = line1;
	}
	public String getLine2() {
		return line2;
	}
	public void setLine2(String line2) {
		this.line2 = line2;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getStates() {
		return states;
	}
	public void setStates(String states) {
		this.states = states;
	}
	@Override
	public boolean checkState(Map mpValue) throws AcnException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Map<String, Object> getState() throws AcnException {
		Map<String, Object> mpValue = new HashMap<String, Object>();
		mpValue.put("line1", getLine1());
		mpValue.put("line2", getLine2());
		mpValue.put("city", getCity());
		mpValue.put("states", getStates());
		mpValue.put("country", getCountry());
		mpValue.put("zip", getZip());
		
		return mpValue;
	}
	@Override
	public void setState(Map<String, Object> mpValue) throws AcnException {
		if  (mpValue.get("line1")!= null){
			setLine1((String)mpValue.get("line1"));
		}
		if  (mpValue.get("line2")!= null){
			setLine2((String)mpValue.get("line2"));
		}
		if  (mpValue.get("city")!= null){
			setCity((String)mpValue.get("city"));
		}
		if  (mpValue.get("states")!= null){
			setStates((String)mpValue.get("states"));
		}
		if  (mpValue.get("country")!= null){
			setCountry((String)mpValue.get("country"));
		}
		if  (mpValue.get("zip")!= null){
			setZip((String)mpValue.get("zip"));
		}
	}
	@Override
	
	public void decorate(String decoratorName, Map mpValue)  {
		if  (mpValue.get("line1")!= null){
			setLine1(((Decorator<String>)mpValue.get("line1.decorator")).decorate((String)mpValue.get("line1")));
		}
		if  (mpValue.get("line2")!= null){
			setLine2(((Decorator<String>)mpValue.get("line2.decorator")).decorate((String)mpValue.get("line2")));
		}
		if  (mpValue.get("city")!= null){
			setCity(((Decorator<String>)mpValue.get("city.decorator")).decorate((String)mpValue.get("city")));
		}
		if  (mpValue.get("states")!= null){
			setStates(((Decorator<String>)mpValue.get("states.decorator")).decorate((String)mpValue.get("states")));
		}
		if  (mpValue.get("country")!= null){
			setCountry(((Decorator<String>)mpValue.get("country.decorator")).decorate((String)mpValue.get("country")));
		}
		if  (mpValue.get("zip")!= null){
			setZip(((Decorator<String>)mpValue.get("zip.decorator")).decorate((String)mpValue.get("zip")));
		}
	}
	
	

}
