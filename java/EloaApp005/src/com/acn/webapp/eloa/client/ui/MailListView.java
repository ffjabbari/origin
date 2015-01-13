package com.acn.webapp.eloa.client.ui;


import com.acn.webapp.eloa.client.domain.Product;
import com.google.gwt.user.client.ui.IsWidget;

import java.util.List;

public interface MailListView extends IsWidget {
  void setMailList(List<Product> mailList);

  void setPresenter(Presenter presenter);

  public interface Presenter {
    void mailSelected(int id);
  }
}
