package com.acn.webapp.eloa.client;


import java.util.Map;

import com.acn.webapp.eloa.shared.AcnObject;
import com.acn.webapp.eloa.shared.JsonUtil;
import com.acn.webapp.eloa.shared.UpperCaseDecorator;


public class ObjectFactoryImpl implements ObjectFactory
{
	public ObjectFactoryImpl(){
		super();
	}
	public AcnObject create(AcnObject obj, Map values)
	{
		
		
			obj.setState(values);
			obj.checkState(values);
			if  (values.get("decorator") == null){
				values.put("decorator", new UpperCaseDecorator());
			}
			obj.decorate("decorator", values);

	return obj;
	}
	@Override
	public AcnObject create(AcnObject obj, String json) {
		
		Map<String, Object> mpValue = JsonUtil.toMapOfStringObject(json);
		obj.setState(mpValue);
		obj.checkState(mpValue);
		if  (mpValue.get("decorator") == null){
			mpValue.put("decorator", new UpperCaseDecorator());
		}
		obj.decorate("decorator", mpValue);
		return obj;
	}
	
	
}
