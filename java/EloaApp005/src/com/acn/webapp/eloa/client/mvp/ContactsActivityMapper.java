package com.acn.webapp.eloa.client.mvp;

import com.acn.webapp.eloa.client.ClientFactory;
import com.acn.webapp.eloa.client.activity.ContactDetailActivity;
import com.acn.webapp.eloa.client.place.ContactDetailPlace;
import com.acn.webapp.eloa.client.place.ContactListPlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class ContactsActivityMapper implements ActivityMapper {
  

  public ContactsActivityMapper() {
    
  }

  @Override
  public Activity getActivity(Place place) {
    if (place instanceof ContactListPlace) {
      return new ContactDetailActivity(null);
    } else if (place instanceof ContactDetailPlace) {
      return new ContactDetailActivity((ContactDetailPlace) place);
    }

    return null;
  }
}
