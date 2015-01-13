package com.acn.webapp.eloa.client.activity;

import com.acn.webapp.eloa.client.ClientFactory;
import com.acn.webapp.eloa.client.EntrypointLayout001;
import com.acn.webapp.eloa.client.domain.Customer;
import com.acn.webapp.eloa.client.place.ContactDetailPlace;
import com.acn.webapp.eloa.client.ui.ContactDetailView;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

import static com.acn.webapp.eloa.client.domain.Customer.CONTACTS;

public class ContactDetailActivity extends AbstractActivity {

  interface EditorDriver extends SimpleBeanEditorDriver<Customer, ContactDetailView> {
  }

  private EditorDriver editor;
  private ContactDetailView view;
  private int contactId;

  @Inject
  public ContactDetailActivity(ContactDetailPlace place) {
    view = EntrypointLayout001.getServiceLocator().getClientFactory().getContactDetailView();
    editor = GWT.create(EditorDriver.class);
    editor.initialize(view);
    contactId = (place == null) ? 0 : Integer.valueOf(place.getContactId());
  }

  @Override
  public void start(AcceptsOneWidget container, EventBus eventBus) {
    Customer customer = CONTACTS.getContact(contactId);
    edit(customer);
    container.setWidget(view);
  }

  private void edit(Customer customer) {
    if (customer != null) {
      editor.edit(customer);
    }
  }

public EditorDriver getEditor() {
	return editor;
}

public void setEditor(EditorDriver editor) {
	this.editor = editor;
}

public ContactDetailView getView() {
	return view;
}

public void setView(ContactDetailView view) {
	this.view = view;
}

public int getContactId() {
	return contactId;
}

public void setContactId(int contactId) {
	this.contactId = contactId;
}

}
