package com.acn.webapp.eloa.client.ui;

import com.acn.webapp.eloa.client.domain.Product;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import java.util.List;

public class MailListViewImpl implements MailListView {
  private HTMLPanel mailListPanel;

  interface MailListViewImplUiBinder extends UiBinder<HTMLPanel, MailListViewImpl> {
  }

  private static MailListViewImplUiBinder binder = GWT.create(MailListViewImplUiBinder.class);

  private Presenter presenter;

  @UiField
  CellTable<Product> table;

  public MailListViewImpl() {
    mailListPanel = binder.createAndBindUi(this);

    TextColumn<Product> sender = new TextColumn<Product>() {
      @Override
      public String getValue(Product product) {
        return product.getSender();
      }
    };

    TextColumn<Product> subject = new TextColumn<Product>() {
      @Override
      public String getValue(Product product) {
        return product.getSubject();
      }
    };

    table.addColumn(sender, "Product Name");
    table.addColumn(subject, "Product Price");

    // handle row selection
    final SingleSelectionModel<Product> selectionModel = new SingleSelectionModel<Product>();
    table.setSelectionModel(selectionModel);
    selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
      public void onSelectionChange(SelectionChangeEvent event) {
        Product selected = selectionModel.getSelectedObject();
        if (selected != null) {
          presenter.mailSelected(selected.getId());
        }
      }
    });

  }

  @Override
  public void setPresenter(Presenter presenter) {
    this.presenter = presenter;
  }

  public void setMailList(List<Product> mailList) {
    table.setRowCount(mailList.size(), true);
    table.setRowData(0, mailList);
  }

  @Override
  public Widget asWidget() {
    return mailListPanel;
  }

}
