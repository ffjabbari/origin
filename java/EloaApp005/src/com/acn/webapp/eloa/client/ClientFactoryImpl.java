package com.acn.webapp.eloa.client;

import com.acn.webapp.eloa.client.ui.*;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;

public class ClientFactoryImpl implements ClientFactory {
  private static final EventBus eventBus = new SimpleEventBus();
  private static final PlaceController placeController = new PlaceController(eventBus);
  private static final ContactListView contactListView = new ContactListViewImpl();
  private static final ContactDetailView contactDetailView = new ContactDetailViewImpl();
  private static final MailListView mailListView = new MailListViewImpl();
  private static final MailDetailView mailDetailView = new MailDetailViewImpl();
  private static final SettingsNavigationView settingsNavigationView = new SettingsNavigationViewImpl();
  private static final MainMenuViewImpl mainMenuView = new MainMenuViewImpl();

  @Override
  public EventBus getEventBus() {
    return eventBus;
  }

  @Override
  public PlaceController getPlaceController() {
    return placeController;
  }

  @Override
  public ContactListView getContactListView() {
    return contactListView;
  }

  @Override
  public ContactDetailView getContactDetailView() {
    return contactDetailView;
  }

  @Override
  public MailListView getMailListView() {
    return mailListView;
  }

  @Override
  public MailDetailView getMailDetailView() {
    return mailDetailView;
  }

  @Override
  public SettingsNavigationView getSettingsNavigationView() {
    return settingsNavigationView;
  }

  @Override
  public MainMenuViewImpl getMainMenuView() {
    return mainMenuView;
  }
}
