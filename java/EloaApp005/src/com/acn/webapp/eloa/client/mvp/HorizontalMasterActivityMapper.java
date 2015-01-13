package com.acn.webapp.eloa.client.mvp;

import com.acn.webapp.eloa.client.ClientFactory;
import com.acn.webapp.eloa.client.activity.MailListActivity;
import com.acn.webapp.eloa.client.place.MailListPlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class HorizontalMasterActivityMapper implements ActivityMapper {

  private ClientFactory clientFactory;

  public HorizontalMasterActivityMapper() {
    
  }

  public Activity getActivity(Place place) {
    if (place instanceof MailListPlace) {
      return new MailListActivity();
    }

    return null;
  }
}
