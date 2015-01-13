package com.acn.webapp.eloa.shared;

public class UpperCaseDecorator implements Decorator<String>{

	@Override
	public String decorate(String t) {
		return t.toUpperCase();
	}

}
