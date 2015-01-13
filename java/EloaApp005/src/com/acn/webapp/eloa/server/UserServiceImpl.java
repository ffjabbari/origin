package com.acn.webapp.eloa.server;

import com.acn.webapp.eloa.client.UserService;
import com.acn.webapp.eloa.client.domain.Customer;
import com.acn.webapp.eloa.shared.User;
import com.acn.webapp.eloa.shared.UserDetails;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


@SuppressWarnings("serial")
public class UserServiceImpl extends RemoteServiceServlet implements
    UserService {
	 
  private static final String[] usersFirstNameData = new String[] {
      "Fred1", "Fred2", "Fred3", "Fred4", "Fred5"};
  
  private final String[] usersLastNameData = new String[] {
      "Jabbari1", "Jabbari2", "Jabbari3", "Jabbari4", "Jabbari5"};
  
  private final String[] usersEmailData = new String[] {
      "P.O. Box 111 ST LOUIS, MO. 63043", "P.O. Box 112 ST LOUIS, MO. 63043", "P.O. Box 113 ST LOUIS, MO. 63043",
      "P.O. Box 114 ST LOUIS, MO. 63043", "P.O. Box 115 ST LOUIS, MO. 63043"};
      
  private final HashMap<String, User> users = new HashMap<String, User>();

  public UserServiceImpl() {
    initUsers();
  }
  
  private void initUsers() {
    // TODO: Create a real UID for each user
    //
    for (int i = 1; i < usersFirstNameData.length && i < usersLastNameData.length && i < usersEmailData.length; ++i) {
      User user = new User(String.valueOf(i), usersFirstNameData[i], usersLastNameData[i], usersEmailData[i]);
      users.put(user.getId(), user); 
    }
  }
  
@Override
public User addUser(User user) {
	 user.setId(String.valueOf(users.size()));
	    users.put(user.getId(), user); 
	    return user;
}

@Override
public ArrayList<UserDetails> deleteUsers(ArrayList<String> ids) {
	 for (int i = 0; i < ids.size(); ++i) {
	      deleteUser(ids.get(i));
	    }
	    
	    return getUserDetails();
}

@Override
public ArrayList<UserDetails> getUserDetails() {
ArrayList<UserDetails> userDetails = new ArrayList<UserDetails>();
    
    Iterator<String> it = users.keySet().iterator();
    while(it.hasNext()) { 
      User user = users.get(it.next());          
      userDetails.add(user.getLightWeightUser());
    }
    
    return userDetails;
}

@Override
public User getUser(String id) {
	return users.get(id);
}

@Override
public User updateUser(User user) {
	 users.remove(user.getId());
	    users.put(user.getId(), user); 
	    return user;
}
@Override
public Boolean deleteUser(String id) {
    users.remove(id);
    return true;
  }
}
