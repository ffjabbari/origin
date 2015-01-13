package com.acn.webapp.eloa.server;

public class UpperCaseDecorator implements Decorator<String>{

	@Override
	public String decorate(String t) {
		return t.toUpperCase();
	}

}
