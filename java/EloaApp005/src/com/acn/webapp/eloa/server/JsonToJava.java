package com.acn.webapp.eloa.server;

import java.io.File;
import java.io.IOException;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
 
import java.io.File;
import java.io.IOException;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.acn.webapp.eloa.shared.User;
 
public class JsonToJava {
    public static void main(String[] args) {
 
	ObjectMapper mapper = new ObjectMapper();
 
	try {
 
		// read from file, convert it to user class
		User user = mapper.readValue(new File("c:\\Data\\user.json"), User.class);
 
		// display to console
		System.out.println(user);
 
	} catch (JsonGenerationException e) {
 
		e.printStackTrace();
 
	} catch (JsonMappingException e) {
 
		e.printStackTrace();
 
	} catch (IOException e) {
 
		e.printStackTrace();
 
	}
 
  }
 
}