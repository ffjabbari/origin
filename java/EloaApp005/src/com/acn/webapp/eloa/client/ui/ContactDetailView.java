package com.acn.webapp.eloa.client.ui;

import com.acn.webapp.eloa.client.domain.Customer;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.editor.ui.client.adapters.ValueBoxEditor;
import com.google.gwt.user.client.ui.IsWidget;

public interface ContactDetailView extends IsWidget, Editor<Customer> {
  @Path("name")
  IsEditor<ValueBoxEditor<String>> getNameEditor();

  @Path("address")
  IsEditor<ValueBoxEditor<String>> getAddressEditor();

}
