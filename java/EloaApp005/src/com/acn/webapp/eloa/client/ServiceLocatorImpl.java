package com.acn.webapp.eloa.client;
import com.acn.webapp.eloa.client.ClientFactory;


public class ServiceLocatorImpl implements ServiceLocator {

	private String init;
	private ClientFactory clientFactory;
	private ObjectFactory objectFactory;
	
    @Override
	public String getInit() {
		// TODO Auto-generated method stub
		return this.init;
	}

	@Override
	public void setInit(String init) {
		this.init = init;

	}

	@Override
	public ClientFactory getClientFactory() {
		return this.clientFactory;
	}

	@Override
	public void setClientFactory(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
		
	}

	@Override
	public ObjectFactory getObjectFactory() {
		return this.objectFactory;
	}

	@Override
	public void setObjectFactory(ObjectFactory objectFactory) {
		this.objectFactory = objectFactory;
		
	}

}
