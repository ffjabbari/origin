package com.acn.webapp.eloa.client;

import com.acn.webapp.eloa.client.ClientFactory;

public interface ServiceLocator {
	
	String getInit();
	void setInit(String init);
	//ContactsGinjector getContactsGinJector();
	//void setContactsGinjector(ContactsGinjector contactsGinjector);
	ClientFactory getClientFactory();
	void setClientFactory(ClientFactory clientFactory);
	ObjectFactory getObjectFactory();
	void setObjectFactory(ObjectFactory objectFactory);

}
