package com.acn.webapp.eloa.client.mvp;

import com.acn.webapp.eloa.client.place.*;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers({
    DefaultPlace.Tokenizer.class,
    ContactListPlace.Tokenizer.class,
    ContactDetailPlace.Tokenizer.class,
    MailListPlace.Tokenizer.class,
    MailDetailPlace.Tokenizer.class,
    SettingsNavigationPlace.Tokenizer.class
})
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {
}
