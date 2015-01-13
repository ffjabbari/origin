package com.acn.webapp.eloa.shared;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface StateNew extends Serializable{
	public List<Param> getState();
	public void setState(Param param);
	public List<KeyValue> checkState();
	public long getId();
	public void setData(Param param);
	public List<Param> getData();
	public List<Error> validate();
	public void execute();
	public String toJson();
}
