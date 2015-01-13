package com.acn.webapp.eloa.client.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.acn.webapp.eloa.client.EntrypointLayout001;
import com.acn.webapp.eloa.client.ObjectFactory;
import com.acn.webapp.eloa.shared.Decorator;
import com.acn.webapp.eloa.shared.AcnObject;

public class Customer extends AcnObject {
	private int id;
	private String name;
	private String address;

	public Customer() {
		super();
		this.id = -1;
		this.name = "";
		this.address = "";

	}

	public Customer(int id, String name, String address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	private static HashMap<Integer, Customer> constantData = new HashMap<Integer, Customer>();

	static {
		final ObjectFactory objectFactory = EntrypointLayout001.getServiceLocator().getObjectFactory();
		Map<String, Object> mpValue = new HashMap<String, Object>();
		
		for  (int ix = 0; ix < 5; ix++){
			mpValue.put("id",ix);
			mpValue.put("name","Fred_" + ix +  "Jabbari");
			mpValue.put("address","P.O. Box 11"+ix + ", 111 Fred Ave..");
			constantData.put(ix, (Customer)objectFactory.create(new Customer(), mpValue));
		}
		
	}

	public static class CONTACTS {
		private static List<Customer> list = new ArrayList<Customer>(
				constantData.values());

		public static List<Customer> getContactList() {
			return list;
		}

		public static Customer getContact(int id) {
			return constantData.get(id);
		}

	}

	@Override
	public boolean checkState(Map<String, Object> mpValue) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Map<String, Object> getState() {
		Map<String, Object> mpValue = new HashMap<String, Object>();
		mpValue.put("id", getId());
		mpValue.put("name", getName());
		mpValue.put("address", getAddress());

		return mpValue;
	}

	@Override
	public void setState(Map<String, Object> mpValue) {
		Object obj = null;
		int ix = -1;
		if (mpValue.get("id") != null) {
			obj = mpValue.get("id");
			if  (obj instanceof String)ix = new Integer((String)mpValue.get("id")).intValue();
			if  (obj instanceof Integer)ix = new Integer((Integer)mpValue.get("id")).intValue();
			setId(ix);
		}
		if (mpValue.get("name") != null) {
			setName((String) mpValue.get("name"));
		}

		if (mpValue.get("address") != null) {
			setAddress((String) mpValue.get("address"));
		}
	}

	@Override
	public void decorate(String decoratorName, Map mpValue) {
		Decorator<String> decorator;
		Object obj = null; 
		int ix = -1;
		decorator = (Decorator<String>) mpValue.get(decoratorName);
		if (decorator != null) {
			obj = mpValue.get("id");
			if  (obj instanceof String)ix = new Integer((String)mpValue.get("id")).intValue();
			if  (obj instanceof Integer)ix = new Integer((Integer)mpValue.get("id")).intValue();
			setId(ix); 
			setName(decorator.decorate((String) mpValue.get("name")));
			setAddress(decorator.decorate((String) mpValue.get("address")));
			
		}
		if (mpValue.get("id." + decoratorName) != null) {
			setName(decorator.decorate((String) mpValue.get("name." + decoratorName)));
		}

		if (mpValue.get("name." + decoratorName) != null) {
			setAddress(((Decorator<String>) mpValue.get("name." + decoratorName))
					.decorate((String) mpValue.get("name")));
		}
		if (mpValue.get("address." + decoratorName) != null) {
			setAddress(((Decorator<String>) mpValue.get("address." + decoratorName))
					.decorate((String) mpValue.get("address")));
		}
	}
}
