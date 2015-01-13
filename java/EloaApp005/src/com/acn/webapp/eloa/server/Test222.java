package com.acn.webapp.eloa.server;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.core.client.GWT;




public class Test222 implements Constants {
	
	public Test222(){
		super();
	}

	public void doSomething(){
		doSomethingFred();
	}
	
	
	public void doSomethingFred(){
		  
		Map<String, Object> mpAddress1 = new HashMap<String, Object>();
		Map<String, Object> mpAddress2 = new HashMap<String, Object>();
		Map<String, Object> mpPhone1 = new HashMap<String, Object>();
		Map<String, Object> mpPhone2 = new HashMap<String, Object>();
		
		mpAddress1.put("line1", "Address1Line1");
		mpAddress1.put("line2", "Address1Line2");
		mpAddress1.put("city", "Address1City");
		mpAddress1.put("states", "Address1States");
		mpAddress1.put("country", "Address1Country");
		mpAddress1.put("zip", "Address1Zip");
		
		mpPhone1.put("number", "Phone1Number");
		mpPhone1.put("subscriber", "Phone1Subscriber");
		
		mpAddress2.put("line1", "Address2Line1");
		mpAddress2.put("line2", "Address2Line2");
		mpAddress2.put("city", "Address2City");
		mpAddress2.put("states", "Address2States");
		mpAddress2.put("country", "Address2Country");
		mpAddress2.put("zip", "Address2Zip");
		
		mpPhone2.put("number", "Phone2Number");
		mpPhone2.put("subscriber", "Phone2Subscriber");
		
		AcnObject address1 = ObjFactory.create(GWT.isScript(), Address.class.getName(), mpAddress1);
		AcnObject phone1 = ObjFactory.create(GWT.isScript(), Phone.class.getName(), mpPhone1);
		
		AcnObject address2 = ObjFactory.create(GWT.isScript(), Address.class.getName(), mpAddress2);
		AcnObject phone2 = ObjFactory.create(GWT.isScript(), Phone.class.getName(), mpPhone2);
		  
		System.out.println("Adderss1:"  + address1.toString());
		System.out.println("phone1:"  + phone1.toString());
		System.out.println("Adderss2:"  + address2.toString());
		System.out.println("phone2:"  + phone2.toString());
		
		
		  return;
	  }
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Test222 tst = new Test222();
		tst.doSomething();
	}

}
