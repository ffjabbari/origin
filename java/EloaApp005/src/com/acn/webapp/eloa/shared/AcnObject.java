package com.acn.webapp.eloa.shared;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.acn.webapp.eloa.client.framework.AcnEvent;
import com.acn.webapp.eloa.client.framework.AcnEvent.Handler;
import com.acn.webapp.eloa.client.framework.AcnEventNames;
import com.acn.webapp.eloa.client.framework.ActionEvent;
import com.acn.webapp.eloa.client.framework.ChangeEvent;
import com.acn.webapp.eloa.client.framework.ClickEvent;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.HandlerRegistration;
import com.google.web.bindery.event.shared.Event.Type;

public abstract class AcnObject implements State{
	protected long id;
	protected List<Param> optionalData;
	protected List<Param> error;
	static final Type<Handler> AcnType = new Type<AcnEvent.Handler>();
	static final Type<ActionEvent.Handler> ActionType = new Type<ActionEvent.Handler>();
	static final Type<ClickEvent.Handler> ClickType = new Type<ClickEvent.Handler>();
	static final Type<ChangeEvent.Handler> ChangeType = new Type<ChangeEvent.Handler>();
	public AcnObject() {
		super();
	}

	public abstract boolean checkState(Map<String, Object> mpValue);
			

	public abstract Map<String, Object> getState();

	public abstract void setState(Map<String, Object> mpValue);
		

	//protected Object clone() throws CloneNotSupportedException {
	/*protected Object clone() throws CloneNotSupportedException {
	
		AcnObject clone=null;
		try {
			clone = (AcnObject) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return clone;

	}*/

	public static HandlerRegistration register(EventBus eventBus,
			String sourceName, AcnEvent.Handler handler) {

		

		return eventBus.addHandlerToSource(AcnType, sourceName, handler);
	}

	public static HandlerRegistration register(EventBus eventBus,
			String sourceName, ActionEvent.Handler handler) {

		

		return eventBus.addHandlerToSource(ActionType, sourceName, handler);
	}

	public static HandlerRegistration register(EventBus eventBus,
			String sourceName, ChangeEvent.Handler handler) {

		

		return eventBus.addHandlerToSource(ChangeType, sourceName, handler);
	}

	public static HandlerRegistration register(EventBus eventBus,
			String sourceName, ClickEvent.Handler handler) {

		

		return eventBus.addHandlerToSource(ClickType, sourceName, handler);
	}

	public static void fire(EventBus eventBus, AcnEvent.Names sourceName, String[] aryAction) {
		for  (int ix = 0; ix < aryAction.length; ix++){
	    	eventBus.fireEventFromSource(new AcnEvent(), aryAction[ix]);
	    }
	}
	
	public static void fire(EventBus eventBus, ActionEvent.Names sourceName, String[] aryAction) {
	    for  (int ix = 0; ix < aryAction.length; ix++){
	    	eventBus.fireEventFromSource(new ActionEvent(), aryAction[ix]);
	    }
	}
	
	public static void fire(EventBus eventBus, ClickEvent.Names sourceName, String[] aryAction) {
		for  (int ix = 0; ix < aryAction.length; ix++){
	    	eventBus.fireEventFromSource(new ClickEvent(), aryAction[ix]);
	    }
	}
	
	public static void fire(EventBus eventBus, ChangeEvent.Names sourceName, String[] aryAction) {
		for  (int ix = 0; ix < aryAction.length; ix++){
	    	eventBus.fireEventFromSource(new ChangeEvent(), aryAction[ix]);
	    }
	}
	
	public String toString() {
		StringBuffer buf = new StringBuffer();
		for (Map.Entry<String, Object> entry : getState().entrySet()) {
			buf.append("\n" + entry.getKey() + "/" + entry.getValue());
		}

		return buf.toString();

	}
/*
	public String toJson() {

		String strx = "";

		try {

			ObjectMapper mapper = new ObjectMapper();

			strx = mapper.writeValueAsString(getState());
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AcnException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return strx;

	}*/
	public String toJson() {

		String strx = "";

		strx = JsonUtil.toJsonFromMapOfObject(getState());
		
		return strx;

	}
}
