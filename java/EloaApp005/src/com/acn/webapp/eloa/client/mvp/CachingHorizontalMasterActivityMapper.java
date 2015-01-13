package com.acn.webapp.eloa.client.mvp;

import com.acn.webapp.eloa.client.ClientFactory;
import com.acn.webapp.eloa.client.place.MailDetailPlace;
import com.acn.webapp.eloa.client.place.MailListPlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.activity.shared.CachingActivityMapper;
import com.google.gwt.activity.shared.FilteredActivityMapper;
import com.google.gwt.place.shared.Place;

public class CachingHorizontalMasterActivityMapper implements ActivityMapper {

  private ActivityMapper filteredActivityMapper;

  public CachingHorizontalMasterActivityMapper() {

    FilteredActivityMapper.Filter filter = new FilteredActivityMapper.Filter() {
      @Override
      public Place filter(Place place) {
        return place instanceof MailDetailPlace ? new MailListPlace() : place;
      }
    };

    HorizontalMasterActivityMapper mapper = new HorizontalMasterActivityMapper();
    CachingActivityMapper cachingActivityMapper = new CachingActivityMapper(mapper);
    filteredActivityMapper = new FilteredActivityMapper(filter, cachingActivityMapper);
  }

  @Override
  public Activity getActivity(Place place) {
    return filteredActivityMapper.getActivity(place);
  }
}
