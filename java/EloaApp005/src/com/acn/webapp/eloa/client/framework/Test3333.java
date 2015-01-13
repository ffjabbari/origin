package com.acn.webapp.eloa.client.framework;

import java.util.HashMap;
import java.util.Map;

import com.acn.webapp.eloa.shared.AcnObject;
import com.acn.webapp.eloa.shared.Address;
import com.acn.webapp.eloa.shared.Phone;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;




public class Test3333 {
	
	EventBus eventBus = new SimpleEventBus();
	
	public Test3333(){
		super();
	}

	public void doSomething(){
		doSomethingFred();
		doSomethingEventRegister();
		doSomethingEventFire();
		doSomethingEventRegister2();
		doSomethingEventFire2();
		
	}
	
	
	public void doSomethingFred(){
		  
			  
			
		
		
		
		  return;
	  }
public void doSomethingEventRegister(){
		
		System.out.println("****************** ABOUT TO REGISTER **********************************");
		System.out.println("onAction.ADD Registered For and Waiting For events to get fired...");
		System.out.println("****************** END OF REGISTERATION **********************************");
		AcnObject.register(eventBus, ActionEventNames.ADD, new ActionEvent.Handler() {
		      @Override
		      public void onAction(ActionEvent event) {
		        System.out.println("onAction.ADD Event Was Recieved...1");
		      }
		    });
		
		
		return;
	}
	public void doSomethingEventFire(){
		
		System.out.println(Thread.currentThread().getName());
	    for(int i=0; i<2; i++){
	      new Thread("" + i){
	        public void run(){
	          System.out.println("Thread: " + getName() + " running. ADD Event Fired...1");
	          AcnObject.fire(eventBus, ActionEvent.Names, new String[]{ActionEventNames.ADD});
	        }
	      }.start();
	    }
		
		return;
	}
	
public void doSomethingEventRegister2(){
		
		System.out.println("****************** ABOUT TO REGISTER **********************************");
		System.out.println("onAction.ADD Registered For and Waiting For events to get fired...");
		System.out.println("****************** END OF REGISTERATION **********************************");
		ActionEvent.register(eventBus, ActionEventNames.ADD, new ActionEvent.Handler() {
		      @Override
		      public void onAction(ActionEvent event) {
		        System.out.println("onAction.ADD Event Was Recieved...2");
		      }
		    });
		
		
		return;
	}
	public void doSomethingEventFire2(){
		
		System.out.println(Thread.currentThread().getName());
	    for(int i=0; i<2; i++){
	      new Thread("" + i){
	        public void run(){
	          System.out.println("Thread: " + getName() + " running. ADD Event Fired...2");
	          ActionEvent.fire(eventBus, ActionEventNames.ADD);
	        }
	      }.start();
	    }
		
		return;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Test3333 tst = new Test3333();
		tst.doSomething();
	}

}
