package com.acn.webapp.eloa.server;

public class LowerCaseDecorator implements Decorator<String>{

	@Override
	public String decorate(String t) {
		return t.toLowerCase();
	}

}
