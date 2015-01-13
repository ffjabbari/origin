package com.acn.webapp.eloa.client.framework;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceChangeEvent;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.storage.client.Storage;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.UmbrellaException;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The heart of the applicaiton, mainly concerned with bootstrapping.
 */
public class App {
	private static final String HISTORY_SAVE_KEY = "SAVEPLACE";

	private static final Logger log = Logger.getLogger(App.class.getName());

	private final EventBus eventBus;

	public App(EventBus eventBus) {
		this.eventBus = eventBus;
	}

	public void run(HasWidgets.ForIsWidget parentView) {

		ActionEvent.register(eventBus, ActionEventNames.ADD,
				new ActionEvent.Handler() {
					@Override
					public void onAction(ActionEvent event) {
						System.out.println("onActionEvent...1");
					}
				});

		eventBus.addHandler(ActionEvent.TYPE, new ActionEvent.Handler() {
			@Override
			public void onAction(ActionEvent event) {
				System.out.println("onActionEvent...2");
			}
		});

	}

}
