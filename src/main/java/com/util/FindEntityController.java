package com.util;

import java.io.File;

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



/*
 * @RestController : First of all, we are using Spring 4 new @RestController
 * annotation. This annotation eliminates the need of annotating each method
 * with @ResponseBody. Under the hood, @RestController is itself annotated with
 * @ResponseBody, and can be considered as combination of @Controller and
 * @ResponseBody.
 */

@RestController
@RequestMapping("/get")
public class FindEntityController {


	
	private static final Logger LOG = LoggerFactory.getLogger(FindEntityController.class);
	
	
	@CrossOrigin
	@RequestMapping(value = "/gethello", method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)	
	public String getEntityByName() {
		//"VPN Access DSL UPC
		
		return "hello";
		//entityExcelGenerateService.getEntityExcelGenerateService();
		
	}
	
	
}	
	
	
	
	
