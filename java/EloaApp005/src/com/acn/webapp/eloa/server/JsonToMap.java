package com.acn.webapp.eloa.server;


import java.io.File;
import java.io.IOException;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
 
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.acn.webapp.eloa.shared.User;
 
public class JsonToMap {
    public static void main(String[] args) {
 
	ObjectMapper mapper = new ObjectMapper();
	HashMap<String,Object> mpData;
	try {
 
		// read from file, convert it to user class
		User user = mapper.readValue(new File("c:\\Data\\user.json"), User.class);
		mpData = new ObjectMapper().readValue(new File("c:\\Data\\user.json"), new TypeReference<HashMap<String,Object>>() {});
		// display to console
		System.out.println(mpData);
 
	} catch (JsonGenerationException e) {
 
		e.printStackTrace();
 
	} catch (JsonMappingException e) {
 
		e.printStackTrace();
 
	} catch (IOException e) {
 
		e.printStackTrace();
 
	}
 
  }
 
}