package com.acn.webapp.eloa.client.ui;

import com.acn.webapp.eloa.client.domain.Product;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.editor.ui.client.adapters.ValueBoxEditor;
import com.google.gwt.user.client.ui.IsWidget;

public interface MailDetailView extends IsWidget, Editor<Product> {

  @Path("sender")
  IsEditor<ValueBoxEditor<String>> getSenderEditor();

  @Path("subject")
  IsEditor<ValueBoxEditor<String>> getSubjectEditor();

  @Path("body")
  IsEditor<ValueBoxEditor<String>> getBodyEditor();

}
