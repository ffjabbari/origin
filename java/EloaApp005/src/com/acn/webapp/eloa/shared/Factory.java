package com.acn.webapp.eloa.shared;


import java.util.HashMap;
import java.util.Map;


public interface Factory
{
	public AcnObject create(AcnObject obj, Map mpValue);
	public AcnObject create(AcnObject obj, String json);
	
	
}
