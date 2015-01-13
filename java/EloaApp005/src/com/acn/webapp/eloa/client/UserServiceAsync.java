package com.acn.webapp.eloa.client;

import java.util.ArrayList;

import com.acn.webapp.eloa.shared.User;
import com.acn.webapp.eloa.shared.UserDetails;
import com.google.gwt.user.client.rpc.AsyncCallback;


public interface UserServiceAsync {
	
  void addUser(User user, AsyncCallback<User> callback);
  void deleteUser(String id, AsyncCallback<Boolean> callback); 
  void deleteUsers(ArrayList<String> ids, AsyncCallback<ArrayList<UserDetails>> callback);
  void getUserDetails(AsyncCallback<ArrayList<UserDetails>> callback);
  void getUser(String id, AsyncCallback<User> callback);
  void updateUser(User user, AsyncCallback<User> callback);
}
