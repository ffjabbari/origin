package com.acn.webapp.eloa.client;


import java.util.HashMap;
import java.util.Map;

import com.acn.webapp.eloa.shared.AcnObject;


public interface Factory
{
	public AcnObject create(AcnObject obj, Map mpValue) throws RuntimeException;
	
	
}
