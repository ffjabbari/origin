package com.acn.webapp.eloa.client;

import com.acn.webapp.eloa.client.ui.*;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;

public interface ClientFactory {
  EventBus getEventBus();

  PlaceController getPlaceController();

  ContactListView getContactListView();

  ContactDetailView getContactDetailView();

  MailListView getMailListView();

  MailDetailView getMailDetailView();

  SettingsNavigationView getSettingsNavigationView();

  MainMenuViewImpl getMainMenuView();

}
