package com.acn.webapp.eloa.client;

import com.acn.webapp.eloa.client.place.*;
import com.acn.webapp.eloa.client.ui.AppLayout;
import com.acn.webapp.eloa.client.ui.MainMenuView;
import com.acn.webapp.eloa.client.ui.MainMenuViewImpl;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceChangeEvent;
import com.google.gwt.place.shared.PlaceController;

public class AppController implements MainMenuView.Presenter {

  private PlaceController placeController;

  public AppController(final AppLayout appLayout) {
    placeController = EntrypointLayout001.getServiceLocator().getClientFactory().getPlaceController();
    MainMenuViewImpl mainMenutView = EntrypointLayout001.getServiceLocator().getClientFactory().getMainMenuView();
    mainMenutView.setPresenter(this);
    EventBus eventBus = EntrypointLayout001.getServiceLocator().getClientFactory().getEventBus();
    eventBus.addHandler(PlaceChangeEvent.TYPE, new HandlePlaceLayout(appLayout));
  }

  public void gotoContactListPlace() {
    placeController.goTo(new ContactListPlace());
  }

  public void gotoMailListPlace() {
    placeController.goTo(new MailListPlace());
  }

  public void gotoDefaultPlace() {
    placeController.goTo(new DefaultPlace());
  }

  public void gotoSettingsNavigationPlace() {
    placeController.goTo(new SettingsNavigationPlace());
  }

  private static class HandlePlaceLayout implements PlaceChangeEvent.Handler {
    private final AppLayout appLayout;

    public HandlePlaceLayout(AppLayout appLayout) {
      this.appLayout = appLayout;
    }

    @Override
    public void onPlaceChange(PlaceChangeEvent event) {
      Place newPlace = event.getNewPlace();
      if (newPlace instanceof MailPlace) {
        appLayout.setMailLayout();
      } else if (newPlace instanceof ContactPlace) {
        appLayout.setContactsLayout();
      } else if (newPlace instanceof SettingsNavigationPlace) {
        appLayout.setSettingsLayout();
      } else {
        appLayout.setDefaultLayout();
      }
    }
  }

public PlaceController getPlaceController() {
	return placeController;
}

public void setPlaceController(PlaceController placeController) {
	this.placeController = placeController;
}
  
}
