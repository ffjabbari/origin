package com.acn.webapp.eloa.client.mvp;

import com.acn.webapp.eloa.client.ClientFactory;
import com.acn.webapp.eloa.client.activity.SettingsActivity;
import com.acn.webapp.eloa.client.place.SettingsNavigationPlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class SideContainerActivityMapper implements ActivityMapper {

  private ClientFactory clientFactory;

  public SideContainerActivityMapper() {
    
  }

  public Activity getActivity(Place place) {

    if (place instanceof SettingsNavigationPlace) {
      return new SettingsActivity();
    }

    return null;
  }
}
