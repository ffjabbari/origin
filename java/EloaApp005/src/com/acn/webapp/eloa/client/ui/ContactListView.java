package com.acn.webapp.eloa.client.ui;


import com.acn.webapp.eloa.client.domain.Customer;
import com.google.gwt.user.client.ui.IsWidget;

import java.util.List;

public interface ContactListView extends IsWidget {
  void setContactList(List<Customer> contactList);

  void setPresenter(Presenter presenter);

  public interface Presenter {
    void contactSelected(int id);
  }
}
