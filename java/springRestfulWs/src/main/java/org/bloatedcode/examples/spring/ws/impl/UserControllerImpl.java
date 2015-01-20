package org.bloatedcode.examples.spring.ws.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import org.bloatedcode.examples.spring.domain.User;
import org.bloatedcode.examples.spring.ws.UserController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.google.common.base.Strings;

@Controller
@RequestMapping("/users")
public class UserControllerImpl implements UserController {

	   private final static Logger log = LoggerFactory.getLogger(UserControllerImpl.class);
	   
	    // simple map to handle users
	    private Map<String, User> users = new HashMap<String, User>();
	    
	    public UserControllerImpl() {
			// Ugly, but just for testing
	    	User user = new User();
	    	user.setUsername("UserOne");
	    	user.setFirstName("fn");
	    	user.setLastName("ln");
	    	user.setId("1");
	    	users.put("1", user);
	    	
		}
	 
	    @RequestMapping(method = RequestMethod.GET)
	    public @ResponseBody List<User> findAll(){
	        List<User> toReturn  = new ArrayList<User>();
	        for (Entry<String, User> entry : users.entrySet()) {
	            toReturn.add(entry.getValue());
	        }
	        return toReturn;
	    }
	 
	    @RequestMapping(value="/{id}",method=RequestMethod.GET)
	    public @ResponseBody User findById(@PathVariable String id){
	        if(!users.containsKey(id)){
	            log.info("User with id {} not found",id);
	            throw new IllegalArgumentException("User not found");
	        }
	        log.debug("Found user with id {}", id);
	        return users.get(id);
	    }
	 
	    @RequestMapping(value="/add",method=RequestMethod.POST)
	    public @ResponseBody void persist(@RequestBody User user){
	        if( Strings.isNullOrEmpty(user.getId()))
	            user.setId(UUID.randomUUID().toString());
	        users.put(user.getId(), user);
	    }
	 
	    @RequestMapping(value="/error")
	    public @ResponseBody void error(){
	        throw new IllegalStateException("Not Implemented");
	    }
	    
	    @ExceptionHandler
	    @ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	    public @ResponseBody String handleExceptions(Exception e){
	    	return e.getMessage();
	    }
	    
	    
}
