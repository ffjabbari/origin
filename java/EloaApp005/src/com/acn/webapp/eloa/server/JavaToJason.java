package com.acn.webapp.eloa.server;


import java.io.File;
import java.io.IOException;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.acn.webapp.eloa.shared.User;
 
public class JavaToJason {
    public static void main(String[] args) {
 
	User user = new User();
	ObjectMapper mapper = new ObjectMapper();
 
	try {
 
		// convert user object to json string, and save to a file
		mapper.writeValue(new File("c:\\Data\\user.json"), user);
 
		// display to console
		System.out.println(mapper.writeValueAsString(user));
 
	} catch (JsonGenerationException e) {
 
		e.printStackTrace();
 
	} catch (JsonMappingException e) {
 
		e.printStackTrace();
 
	} catch (IOException e) {
 
		e.printStackTrace();
 
	}
 
  }
 
}
