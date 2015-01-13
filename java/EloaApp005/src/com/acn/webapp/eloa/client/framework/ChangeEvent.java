

package com.acn.webapp.eloa.client.framework;

import com.google.web.bindery.event.shared.Event;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.HandlerRegistration;


public class ChangeEvent extends Event<ChangeEvent.Handler> {
	protected static Names Names;
  /**
   * Implemented by objects that handle {@link ChangeEvent}.
   */
  public interface Handler {
    void onAction(ChangeEvent event);
  }
  public interface Names {
	    final String CHANGE = "CHANGE";
		  
	  }
  /**
   * The event type.
   */
  public static final Type<ChangeEvent.Handler> TYPE = new Type<ChangeEvent.Handler>();

  public static void fire(EventBus eventBus, String sourceName) {
    eventBus.fireEventFromSource(new ChangeEvent(), sourceName);
  }

  public static HandlerRegistration register(EventBus eventBus, String sourceName, Handler handler) {
    return eventBus.addHandlerToSource(TYPE, sourceName, handler);
  }

  /**
   * Protected contructor to encourage the use of
   * {@link #fire(EventBus, String)}.
   */
  public ChangeEvent() {
  }

  @Override
  public final Type<ChangeEvent.Handler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(ChangeEvent.Handler handler) {
    handler.onAction(this);
  }
}
