package com.acn.webapp.eloa.client.activity;

import com.acn.webapp.eloa.client.ClientFactory;
import com.acn.webapp.eloa.client.EntrypointLayout001;
import com.acn.webapp.eloa.client.ui.SettingsNavigationView;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class SettingsActivity extends AbstractActivity implements SettingsNavigationView.Presenter {

  private SettingsNavigationView view;

  public SettingsActivity() {
    view = EntrypointLayout001.getServiceLocator().getClientFactory().getSettingsNavigationView();
  }

  @Override
  public void start(AcceptsOneWidget panel, EventBus eventBus) {
    view.setPresenter(this);
    panel.setWidget(view.asWidget());
  }

public SettingsNavigationView getView() {
	return view;
}

public void setView(SettingsNavigationView view) {
	this.view = view;
}

}
