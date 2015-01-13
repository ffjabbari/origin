package com.acn.webapp.eloa.client.activity;

import com.acn.webapp.eloa.client.ClientFactory;
import com.acn.webapp.eloa.client.EntrypointLayout001;
import com.acn.webapp.eloa.client.domain.Product;
import com.acn.webapp.eloa.client.place.MailDetailPlace;
import com.acn.webapp.eloa.client.ui.MailDetailView;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import static com.acn.webapp.eloa.client.domain.Product.MAILLIST;

public class MailDetailActivity extends AbstractActivity {

  interface EditorDriver extends SimpleBeanEditorDriver<Product, MailDetailView> {
  }

  private EditorDriver editor;
  private MailDetailView view;
  private int mailId;

  public MailDetailActivity(MailDetailPlace place) {
    view = EntrypointLayout001.getServiceLocator().getClientFactory().getMailDetailView();
    editor = GWT.create(EditorDriver.class);
    editor.initialize(view);
    mailId = (place == null) ? 0 : Integer.valueOf(place.getMailId());
  }

  @Override
  public void start(AcceptsOneWidget container, EventBus eventBus) {
    Product product = MAILLIST.getMail(mailId);
    edit(product);
    container.setWidget(view);
  }

  private void edit(Product product) {
    if (product != null) {
      editor.edit(product);
    }
  }

public EditorDriver getEditor() {
	return editor;
}

public void setEditor(EditorDriver editor) {
	this.editor = editor;
}

public MailDetailView getView() {
	return view;
}

public void setView(MailDetailView view) {
	this.view = view;
}

public int getMailId() {
	return mailId;
}

public void setMailId(int mailId) {
	this.mailId = mailId;
}

}
