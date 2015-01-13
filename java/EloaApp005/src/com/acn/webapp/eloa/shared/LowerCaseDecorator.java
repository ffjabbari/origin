package com.acn.webapp.eloa.shared;

public class LowerCaseDecorator implements Decorator<String>{

	@Override
	public String decorate(String t) {
		return t.toLowerCase();
	}

}
