package com.util;

import java.io.File;
import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import scala.annotation.meta.setter;



/*
 * @RestController : First of all, we are using Spring 4 new @RestController
 * annotation. This annotation eliminates the need of annotating each method
 * with @ResponseBody. Under the hood, @RestController is itself annotated with
 * @ResponseBody, and can be considered as combination of @Controller and
 * @ResponseBody.
 */

@RestController
public class FindEntityController {


	private static BigInteger nextId;
	private static Map<BigInteger, User> userMap;
	
	private static User save(User user) {
		
		if(userMap == null) {
			userMap = new HashMap<BigInteger, User>();
			nextId = BigInteger.ONE;					
		}
		user.setUserId(nextId);
		nextId = nextId.add(BigInteger.ONE);
		userMap.put(user.getUserId(), user);
		
		
	return user;	
	}
	
	static {
		User userOne = new User();
		userOne.setUserAddress("sb road");
		userOne.setUserName("shinkee");
		save(userOne);
		
		User userTwo = new User();
		
		userTwo.setUserAddress("sb road");
		userTwo.setUserName("rahul");
		save(userTwo);
		
		
		User userThree = new User();
		userThree.setUserAddress("akrudi");
		userThree.setUserName("satish");
		save(userThree);		
		
		
		User userFour = new User();
		userFour.setUserAddress("kothrud");
		userFour.setUserName("vaibhav");
		save(userFour);
		
		User userFive = new User();
		userFive.setUserAddress("ghorpadi");
		userFive.setUserName("varun");
		save(userFive);
		
		
	
	}
	
	
	
	
	
	
	private static final Logger LOG = LoggerFactory.getLogger(FindEntityController.class);
	
	
	@CrossOrigin
	@RequestMapping(value = "/getuser",
					method = RequestMethod.GET,
					produces = MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<Collection<User>> getUsers() {
				
		Collection<User> users =  userMap.values();
		
		return new ResponseEntity<Collection<User>>(users, HttpStatus.OK);
				
	}
	
	
	
	
	
}	
	
	
	
	
