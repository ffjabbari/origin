package com.acn.webapp.eloa.server;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UserDetails implements Serializable {
  private String id;
  private String displayName;
  
  public UserDetails() {
    new UserDetails("0", "");
  }

  public UserDetails(String id, String displayName) {
    this.id = id;
    this.displayName = displayName;
  }
  
  public String getId() { return id; }
  public void setId(String id) { this.id = id; }
  public String getDisplayName() { return displayName; }
  public void setDisplayName(String displayName) { this.displayName = displayName; } 
}
