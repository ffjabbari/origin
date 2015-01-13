package com.acn.webapp.eloa.client.mvp;

import com.acn.webapp.eloa.client.ClientFactory;
import com.acn.webapp.eloa.client.activity.ContactListActivity;
import com.acn.webapp.eloa.client.place.ContactListPlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class VerticalMasterActivityMapper implements ActivityMapper {

  private ClientFactory clientFactory;

  public VerticalMasterActivityMapper() {
    
  }

  public Activity getActivity(Place place) {

    if (place instanceof ContactListPlace) {
      return new ContactListActivity();
    }

    return null;
  }
}
