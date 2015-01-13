package com.acn.webapp.eloa.client;

import com.acn.webapp.eloa.shared.User;
import com.acn.webapp.eloa.shared.UserDetails;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import java.util.ArrayList;


@RemoteServiceRelativePath("userService")
public interface UserService extends RemoteService {
	
  User addUser(User user);
  Boolean deleteUser(String id); 
  ArrayList<UserDetails> deleteUsers(ArrayList<String> ids);
  ArrayList<UserDetails> getUserDetails();
  User getUser(String id);
  User updateUser(User user);
}
