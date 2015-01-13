
package com.acn.webapp.eloa.client.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Product {
  private final int id;
  private final String sender;
  private final String subject;
  private final String body;

  public Product(int id, String sender, String subject, String body) {
    this.id = id;
    this.sender = sender;
    this.subject = subject;
    this.body = body;
  }

  public int getId() {
    return id;
  }

  public String getSender() {
    return sender;
  }

  public String getSubject() {
    return subject;
  }

  public String getBody() {
    return body;
  }

  private static HashMap<Integer, Product> bunchOfMail = new HashMap<Integer, Product>();

  static {
    String messageBody = "Lorem ipsum dolor sit amet, consectetur adipisicing elit..";
    bunchOfMail.put(1, new Product(1, "vivamus@seddiamlorem.ca", "Job opening", messageBody));
    bunchOfMail.put(2, new Product(2, "faucibus@sit.com", "REST security", messageBody));
    bunchOfMail.put(3, new Product(3, "tellus.lorem.eu@sagittisNullam.org", "switching to mac", messageBody));
    bunchOfMail.put(4, new Product(4, "luctus@sem.org", "problem with javac", messageBody));
    bunchOfMail.put(5, new Product(5, "magnis@elitafeugiat.edu", "subversion", messageBody));
  }

  public static class MAILLIST {
    private static List<Product> list = new ArrayList<Product>(bunchOfMail.values());

    public static List<Product> getMailList() {
      return list;
    }

    public static Product getMail(int id) {
      return bunchOfMail.get(id);
    }

  }

}
