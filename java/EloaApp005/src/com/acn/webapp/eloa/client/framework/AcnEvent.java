/*
 * Copyright 2011 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.acn.webapp.eloa.client.framework;

import com.google.web.bindery.event.shared.Event;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.HandlerRegistration;


/**
 * Fired when the user wants the app to do something. Action events are fired
 * with a string name, and handlers monitor the event bus for them based on that
 * name.
 */
public class AcnEvent extends Event<AcnEvent.Handler> {

  /**
   * Implemented by objects that handle {@link AcnEvent}.
   */
  public interface Handler {
    void onAcnAction(AcnEvent event);
  }
  public interface Names {
	    final static String BEGIN = "BEGIN";
	  }

  /**
   * The event type.
   */
  public static final Type<AcnEvent.Handler> TYPE = new Type<AcnEvent.Handler>();
protected static Names Names;

  public static void fire(EventBus eventBus, String sourceName) {
    eventBus.fireEventFromSource(new AcnEvent(), sourceName);
  }

  public static HandlerRegistration register(EventBus eventBus, String sourceName, Handler handler) {
    return eventBus.addHandlerToSource(TYPE, sourceName, handler);
  }

  /**
   * Protected contructor to encourage the use of
   * {@link #fire(EventBus, String)}.
   */
  public AcnEvent() {
  }

  @Override
  public final Type<AcnEvent.Handler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(AcnEvent.Handler handler) {
    handler.onAcnAction(this);
  }
}
