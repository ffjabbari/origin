package com.acn.webapp.eloa.shared;


import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface State extends Serializable
{
	public Map<String, Object> getState();
	public void setState(Map<String, Object> values);
	public boolean checkState(Map<String, Object> values);
	public void decorate(String decoratorName, Map<String, Object> values);
}
