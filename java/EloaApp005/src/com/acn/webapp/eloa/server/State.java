package com.acn.webapp.eloa.server;


import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface State extends Serializable, Constants
{
	public Map<String, Object> getState() throws AcnException;
	public void setState(Map<String, Object> values) throws AcnException;
	public boolean checkState(Map<String, Object> values) throws AcnException;
	public void decorate(String decoratorName, Map<String, Object> values);
}
