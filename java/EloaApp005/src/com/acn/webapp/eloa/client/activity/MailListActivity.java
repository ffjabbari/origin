package com.acn.webapp.eloa.client.activity;

import com.acn.webapp.eloa.client.ClientFactory;
import com.acn.webapp.eloa.client.EntrypointLayout001;
import com.acn.webapp.eloa.client.place.MailDetailPlace;
import com.acn.webapp.eloa.client.ui.MailListView;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import static com.acn.webapp.eloa.client.domain.Product.MAILLIST;

public class MailListActivity extends AbstractActivity implements MailListView.Presenter {

  private MailListView view;

  private PlaceController placeController;

  public MailListActivity() {
    view = EntrypointLayout001.getServiceLocator().getClientFactory().getMailListView();
    placeController = EntrypointLayout001.getServiceLocator().getClientFactory().getPlaceController();
  }

  @Override
  public void start(AcceptsOneWidget panel, EventBus eventBus) {
    view.setPresenter(this);
    view.setMailList(MAILLIST.getMailList());
    panel.setWidget(view.asWidget());
  }

  @Override
  public void mailSelected(int id) {
    placeController.goTo(new MailDetailPlace(Integer.toString(id)));
  }

public PlaceController getPlaceController() {
	return placeController;
}

public void setPlaceController(PlaceController placeController) {
	this.placeController = placeController;
}

public MailListView getView() {
	return view;
}

public void setView(MailListView view) {
	this.view = view;
}
  
}
