package com.acn.webapp.eloa.server;

public interface Decorator<T> {
	
	T decorate(T t);
}
