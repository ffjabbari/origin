package com.acn.webapp.eloa.client.activity;

import java.util.ArrayList;
import java.util.List;

import com.acn.webapp.eloa.client.ClientFactory;
import com.acn.webapp.eloa.client.EntrypointLayout001;
import com.acn.webapp.eloa.client.ObjectFactory;
import com.acn.webapp.eloa.client.UserService;
import com.acn.webapp.eloa.client.UserServiceAsync;
import com.acn.webapp.eloa.client.domain.Customer;
import com.acn.webapp.eloa.client.place.ContactDetailPlace;
import com.acn.webapp.eloa.client.ui.ContactListView;
import com.acn.webapp.eloa.shared.UserDetails;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import static com.acn.webapp.eloa.client.domain.Customer.CONTACTS;

public class ContactListActivity extends AbstractActivity implements ContactListView.Presenter {

  private final ContactListView view;

  private PlaceController placeController;
  
  private List<UserDetails> userDetails;
  
  private final UserServiceAsync userService = GWT.create(UserService.class);
  
  public ContactListActivity() {
    view = EntrypointLayout001.getServiceLocator().getClientFactory().getContactListView();
    placeController = EntrypointLayout001.getServiceLocator().getClientFactory().getPlaceController();
  }

  @Override
  public void start(AcceptsOneWidget panel, EventBus eventBus) {
	List<UserDetails> lstUserDetails;
	getUserDetails(panel, eventBus); 
    
  }
  public void startSecondHalf(AcceptsOneWidget panel, EventBus eventBus, List<Customer> lstContact) {
		
	    view.setPresenter(this);
	    //view.setContactList(CONTACTS.getContactList());
	    view.setContactList(lstContact);
	    panel.setWidget(view.asWidget());
	  }


  @Override
  public void contactSelected(int id) {
    placeController.goTo(new ContactDetailPlace(Integer.toString(id)));
  }

  
  private void getUserDetails(final AcceptsOneWidget panel, final EventBus eventBus) {
	  final List<Customer> lstContact = new ArrayList<Customer>(); 
	  final ObjectFactory objectFactory = EntrypointLayout001.getServiceLocator().getObjectFactory();
	  userService.getUserDetails(new AsyncCallback<ArrayList<UserDetails>>() {
					public void onSuccess(ArrayList<UserDetails> result) {
						userDetails = result;
						List<String> data = new ArrayList<String>();
						sortUserDetails();
						for (int i = 0; i < result.size(); ++i) {
							data.add(userDetails.get(i).getDisplayName());
							lstContact.add((Customer)objectFactory.create(new Customer(), userDetails.get(i).getState()));
						}
                      int ixTesting123 = -1;
                      startSecondHalf(panel, eventBus, lstContact);
					} 

					public void onFailure(Throwable caught) {
						Window.alert("Error fetching contact details");
					}
				});
	  
	  return;
	}
public void sortUserDetails() {

		
		for (int i = 0; i < userDetails.size(); ++i) {
			for (int j = 0; j < userDetails.size() - 1; ++j) {
				if (userDetails.get(j).getDisplayName().compareToIgnoreCase(
						userDetails.get(j + 1).getDisplayName()) >= 0) {
					UserDetails tmp = userDetails.get(j);
					userDetails.set(j, userDetails.get(j + 1));
					userDetails.set(j + 1, tmp);
				}
			}
		}
	}
  
public PlaceController getPlaceController() {
	return placeController;
}

public void setPlaceController(PlaceController placeController) {
	this.placeController = placeController;
}

}
