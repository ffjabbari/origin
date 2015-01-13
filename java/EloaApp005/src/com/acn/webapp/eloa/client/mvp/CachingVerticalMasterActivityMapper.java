package com.acn.webapp.eloa.client.mvp;

import com.acn.webapp.eloa.client.ClientFactory;
import com.acn.webapp.eloa.client.place.ContactDetailPlace;
import com.acn.webapp.eloa.client.place.ContactListPlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.activity.shared.CachingActivityMapper;
import com.google.gwt.activity.shared.FilteredActivityMapper;
import com.google.gwt.place.shared.Place;

public class CachingVerticalMasterActivityMapper implements ActivityMapper {

  private ActivityMapper filteredActivityMapper;

  public CachingVerticalMasterActivityMapper() {

    FilteredActivityMapper.Filter filter = new FilteredActivityMapper.Filter() {
      @Override
      public Place filter(Place place) {
        return place instanceof ContactDetailPlace ? new ContactListPlace() : place;
      }
    };

    VerticalMasterActivityMapper mapper = new VerticalMasterActivityMapper();
    CachingActivityMapper cachingActivityMapper = new CachingActivityMapper(mapper);
    filteredActivityMapper = new FilteredActivityMapper(filter, cachingActivityMapper);
  }

  @Override
  public Activity getActivity(Place place) {
    return filteredActivityMapper.getActivity(place);
  }
}
