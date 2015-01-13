package com.acn.webapp.eloa.client.mvp;

import com.acn.webapp.eloa.client.ClientFactory;
import com.acn.webapp.eloa.client.place.ContactPlace;
import com.acn.webapp.eloa.client.place.MailPlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class MainContentActivityMapper implements ActivityMapper {

  private final MailActivityMapper mailActivityMapper;
  private final ContactsActivityMapper contactsActivityMapper;

  public MainContentActivityMapper() {
    mailActivityMapper = new MailActivityMapper();
    contactsActivityMapper = new ContactsActivityMapper();
  }

  public Activity getActivity(Place place) {

    if (place instanceof MailPlace) {
      return mailActivityMapper.getActivity(place);
    }

    if (place instanceof ContactPlace) {
      return contactsActivityMapper.getActivity(place);
    }

    return null;
  }
}
