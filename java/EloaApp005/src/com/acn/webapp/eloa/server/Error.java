package com.acn.webapp.eloa.server;

import java.util.List;

public interface Error extends StateNew{
	public List<KeyValue> getLstError();
	public void add(KeyValue keyValue);
}
