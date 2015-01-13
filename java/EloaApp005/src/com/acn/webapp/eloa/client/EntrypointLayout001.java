package com.acn.webapp.eloa.client;

import java.util.HashMap;
import java.util.Map;

import com.acn.webapp.eloa.client.domain.Address;
import com.acn.webapp.eloa.client.domain.Vendor;
import com.acn.webapp.eloa.client.mvp.*;
import com.acn.webapp.eloa.client.place.DefaultPlace;
import com.acn.webapp.eloa.client.ui.AppLayout;
import com.acn.webapp.eloa.client.ui.AppLayoutImpl;
import com.acn.webapp.eloa.shared.AcnObject;
import com.acn.webapp.eloa.shared.Phone;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanCodex;
import com.google.web.bindery.autobean.shared.AutoBeanFactory;
import com.google.web.bindery.autobean.shared.AutoBeanUtils;

public class EntrypointLayout001 implements EntryPoint {

	public class AutoBeanSetup {
		// Instantiate the factory
		MyFactory factory = GWT.create(MyFactory.class);

		// In non-GWT code, use AutoBeanFactorySource.create(MyFactory.class);

		public Vendor makePerson() {
		// Construct the AutoBean
		AutoBean<Vendor> vendor = factory.vendor();

		// Return the Vendor interface shim
		return vendor.as();
		}
		public Address makeAddress() {
			// Construct the AutoBean
			AutoBean<Address> address = factory.address();

			// Return the Vendor interface shim
			return address.as();
			}
		public String serializeToJson(Vendor vendor) {
		// Retrieve the AutoBean controller
		AutoBean<Vendor> bean = AutoBeanUtils.getAutoBean(vendor);

		return AutoBeanCodex.encode(bean).getPayload();
		}

		public Vendor deserializeFromJson(String json) {
		AutoBean<Vendor> bean = AutoBeanCodex.decode(factory, Vendor.class,
		json);
		return bean.as();
		}
	}

		

		// Declare the factory type
		public interface MyFactory extends AutoBeanFactory {
		public AutoBean<Address> address();

		public AutoBean<Vendor> vendor();
		}
		

	
	
  private Place defaultPlace = new DefaultPlace();
 	
  private static ServiceLocator serviceLocator;
  private static ObjectFactory objectFactory;
  public void onModuleLoad() {

	 
		//PlaceController placeController = injector.getPlaceController();  
	  
    ClientFactory clientFactory = GWT.create(ClientFactory.class);
    EventBus eventBus = clientFactory.getEventBus();
    serviceLocator = GWT.create(ServiceLocator.class);
    serviceLocator.setInit("Hi Fred");
    objectFactory = GWT.create(ObjectFactory.class);
    serviceLocator.setObjectFactory(objectFactory);
	  System.out.println("0:" + serviceLocator.getInit());
	  serviceLocator.setClientFactory(clientFactory);
	  
	  Map<String, Object> mpPhone2 = new HashMap<String, Object>();
		mpPhone2.put("number", "Phone1Number");
		mpPhone2.put("subscriber", "Phone1Subscriber");
		
	  AcnObject obj = serviceLocator.getObjectFactory().create(new Phone(), mpPhone2);
	  System.out.println("AcnObject:Phone:" + obj);
	  
	  //********************** AutoBean *********************************************
	  AutoBeanSetup autoBeanSetup = new AutoBeanSetup();
	  
	  //Create Objects
	  Vendor personx = autoBeanSetup.makePerson();
	  Address addressx = autoBeanSetup.makeAddress();
	  //Fill Data
	  addressx.setLine1("5956 Pershing Ave");
	  addressx.setLine2("Apt B");
	  addressx.setCity("ST LOUIS");
	  addressx.setState("MO");
	  personx.setFirstName("Fred");
	  personx.setLastName("Jabbari");
	  personx.setSsn("324589060");
	  addressx.setZip("63139");
	  personx.setAddress(addressx);
	  
	  //Convert Obj To JSON
	  String jsonx = autoBeanSetup.serializeToJson(personx);
	  
	  //Convert JSON to obj
	  Vendor persony = autoBeanSetup.deserializeFromJson(jsonx);
	  
	  //Print Result
	  System.out.println(">>JSON: " + jsonx);
	  System.out.println(">>Vendor: " + personx.getFirstName());
	  System.out.println(">>Vendor: " + personx.getLastName());
	  System.out.println(">>Vendor: " + personx.getSsn());
	  System.out.println(">>Vendor.Address: " + personx.getAddress().getLine1());
	  System.out.println(">>Vendor.Address: " + personx.getAddress().getLine2());
	  System.out.println(">>Vendor.Address: " + personx.getAddress().getCity());
	  System.out.println(">>Vendor.Address: " + personx.getAddress().getState());
	  System.out.println(">>Vendor.Address: " + personx.getAddress().getZip());
	  testObjectCreation();
	  //*****************************************************************************
	  
	  System.out.println("1:" + serviceLocator.getInit());
	  System.out.println("11:" + serviceLocator.getInit());
    //EventBus eventBus = injector.getEventBus();
    PlaceController placeController = clientFactory.getPlaceController();
    AppLayout appLayout = new AppLayoutImpl();

    // Vertical Master container Activity Mapper
    CachingVerticalMasterActivityMapper vMasterActivityMapper = new CachingVerticalMasterActivityMapper();
    ActivityManager vMasterActivityManager = new ActivityManager(vMasterActivityMapper, eventBus);
    vMasterActivityManager.setDisplay(appLayout.getContactListContainer());

    // Horizontal Master container Activity Mapper
    CachingHorizontalMasterActivityMapper hMasterActivityMapper = new CachingHorizontalMasterActivityMapper();
    ActivityManager hMasterActivityManager = new ActivityManager(hMasterActivityMapper, eventBus);
    hMasterActivityManager.setDisplay(appLayout.getMailListContainer());

    // Side Content container Activity Mapper
    SideContainerActivityMapper sideContainerActivityMapper = new SideContainerActivityMapper();
    ActivityManager sideContainerActivityManager = new ActivityManager(sideContainerActivityMapper, eventBus);
    sideContainerActivityManager.setDisplay(appLayout.getSettingsContainer());

    // Main Content container Activity Mapper
    MainContentActivityMapper mainContentContainerActivityMapper = new MainContentActivityMapper();
    ActivityManager mainContentContainerActivityManager = new ActivityManager(mainContentContainerActivityMapper, eventBus);
    mainContentContainerActivityManager.setDisplay(appLayout.getMainContainer());

    AppPlaceHistoryMapper historyMapper = GWT.create(AppPlaceHistoryMapper.class);

    //FRED:>>>PlaceController placeController = clientFactory.getPlaceController();
    PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
    historyHandler.register(placeController, eventBus, defaultPlace);

    RootLayoutPanel.get().add(appLayout.getMainLayoutPanel());
    AppController appController = new AppController(appLayout);

    historyHandler.handleCurrentHistory();
  }
  public static ServiceLocator getServiceLocator() {
		return serviceLocator;
	}
  public void testObjectCreation(){
	  
	  
		  
		  
			
			Map<String, Object> mpPhone1 = new HashMap<String, Object>();
			
			mpPhone1.put("number", "Phone1Number");
			mpPhone1.put("subscriber", "Phone1Subscriber");
			
			 AcnObject phone1 = serviceLocator.getObjectFactory().create(new Phone(), mpPhone1);
			
			
			AcnObject phone2 = objectFactory.create(new Phone(), phone1.toJson());
			System.out.println("phone2:"  + phone2.toString());
			System.out.println("phone2.json:"  + phone2.toJson());
			
			
			
			  return;
		  }

}