package com.acn.webapp.eloa.shared;

import java.util.HashMap;
import java.util.Map;

import com.acn.webapp.eloa.shared.Decorator;
import com.google.gwt.core.client.GWT;

public class Phone extends AcnObject{

	private String number;
	private String subscriber;
	
	public Phone(){
		super();
	}
	
	
	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public String getSubscriber() {
		return subscriber;
	}


	public void setSubscriber(String subscriber) {
		this.subscriber = subscriber;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	@Override
	public boolean checkState(Map mpValue){
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Map<String, Object> getState(){
		Map<String, Object> mpValue = new HashMap();
		mpValue.put("number", getNumber());
		mpValue.put("subscriber", getSubscriber());
		
		return mpValue;
		
	}


	@Override
	public void setState(Map mpValue)  {
		if  (mpValue.get("number")!= null){
			setNumber((String)mpValue.get("number"));
		}
		if  (mpValue.get("subscriber")!= null){
			setSubscriber((String)mpValue.get("subscriber"));
		}
		
		
	}
	@Override
	public void decorate(String decoratorName, Map mpValue)  {
		if  (mpValue.get("number.decorator")!= null){
			setNumber(((Decorator<String>)mpValue.get("number.decorator")).decorate((String)mpValue.get("number")));
		}
		if  (mpValue.get("subscriber.decorator")!= null){
			setSubscriber(((Decorator<String>)mpValue.get("subscriber.decorator")).decorate((String)mpValue.get("subscriber")));
		}
	}

}
