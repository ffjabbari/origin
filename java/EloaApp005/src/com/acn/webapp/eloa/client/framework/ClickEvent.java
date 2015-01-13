

package com.acn.webapp.eloa.client.framework;

import com.google.web.bindery.event.shared.Event;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.HandlerRegistration;


public class ClickEvent extends Event<ClickEvent.Handler> {
	protected static Names Names;
  /**
   * Implemented by objects that handle {@link ClickEvent}.
   */
  public interface Handler {
    void onAction(ClickEvent event);
  }
  public interface Names {
	    final String CLICK = "CLICK";
		  
	  }
  /**
   * The event type.
   */
  public static final Type<ClickEvent.Handler> TYPE = new Type<ClickEvent.Handler>();

  public static void fire(EventBus eventBus, String sourceName) {
    eventBus.fireEventFromSource(new ClickEvent(), sourceName);
  }

  public static HandlerRegistration register(EventBus eventBus, String sourceName, Handler handler) {
    return eventBus.addHandlerToSource(TYPE, sourceName, handler);
  }

  /**
   * Protected contructor to encourage the use of
   * {@link #fire(EventBus, String)}.
   */
  public ClickEvent() {
  }

  @Override
  public final Type<ClickEvent.Handler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(ClickEvent.Handler handler) {
    handler.onAction(this);
  }
}
