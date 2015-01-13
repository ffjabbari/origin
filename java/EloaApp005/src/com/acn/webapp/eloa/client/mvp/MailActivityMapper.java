package com.acn.webapp.eloa.client.mvp;

import com.acn.webapp.eloa.client.ClientFactory;
import com.acn.webapp.eloa.client.activity.MailDetailActivity;
import com.acn.webapp.eloa.client.place.MailDetailPlace;
import com.acn.webapp.eloa.client.place.MailListPlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class MailActivityMapper implements ActivityMapper {

  private ClientFactory clientFactory;

  public MailActivityMapper() {
    
  }

  @Override
  public Activity getActivity(Place place) {
    if (place instanceof MailListPlace) {
      return new MailDetailActivity(null);
    }

    if (place instanceof MailDetailPlace) {
      return new MailDetailActivity((MailDetailPlace) place);
    }

    return null;
  }
}
