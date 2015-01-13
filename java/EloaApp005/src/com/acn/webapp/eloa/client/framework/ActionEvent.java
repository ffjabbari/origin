

package com.acn.webapp.eloa.client.framework;

import com.google.web.bindery.event.shared.Event;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.HandlerRegistration;


public class ActionEvent extends Event<ActionEvent.Handler> {

  /**
   * Implemented by objects that handle {@link ActionEvent}.
   */
  public interface Handler {
    void onAction(ActionEvent event);
  }
  public interface Names {
	    final String ADD = "ADD";
		  final String CANCEL = "CANCEL";
		  final String RESET = "RESET";
		  final String SAVE = "SAVE";
	  }
  /**
   * The event type.
   */
  public static final Type<ActionEvent.Handler> TYPE = new Type<ActionEvent.Handler>();
protected static Names Names;

  public static void fire(EventBus eventBus, String sourceName) {
    eventBus.fireEventFromSource(new ActionEvent(), sourceName);
  }

  public static HandlerRegistration register(EventBus eventBus, String sourceName, Handler handler) {
    return eventBus.addHandlerToSource(TYPE, sourceName, handler);
  }

  /**
   * Protected contructor to encourage the use of
   * {@link #fire(EventBus, String)}.
   */
  public ActionEvent() {
  }

  @Override
  public final Type<ActionEvent.Handler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(ActionEvent.Handler handler) {
    handler.onAction(this);
  }
}
