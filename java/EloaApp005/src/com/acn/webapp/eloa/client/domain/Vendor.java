package com.acn.webapp.eloa.client.domain;


public interface Vendor {
	public Address getAddress();

	public String getFirstName();
	public void setFirstName(String firstName);
	public String getLastName();
	public void setLastName(String lastName);
	public String getSsn();
	public void setSsn(String ssn);

	public void setAddress(Address address);
	}
