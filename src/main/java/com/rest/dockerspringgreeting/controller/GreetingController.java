package com.rest.dockerspringgreeting.controller;

import java.util.Collections;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.dockerspringgreeting.model.Greeting;

/*
 *  Controller to return the Greeting Message 
 *  based on the Input Parameters
 * 
 */

@RestController
@Validated

public class GreetingController extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private Greeting oGreeting;
	@GetMapping(value = "/greeting")
	/*
	 * Method return Greeting message
	 *      
	 */
	public Set<String> greetingByQuery(
            @RequestParam(value = "account", required = true) @Valid @Pattern(regexp = "personal|business" , message = "Allowable values for account are personal and business") String account,
			@RequestParam(value="id", required=false) @Valid @PositiveOrZero(message = "Allowable values for id are all positive integers") Integer id,
			@RequestParam(value="type", required=false)@Valid @Pattern(regexp = "small|big" ,  message = "Allowable values for type are small and big") String type) 
	{
		 
		if("personal".equals(account)) {	
			if(id != null && id >= 0) {		
				oGreeting.setContent(String.format("%s %s", "Hi, userId ", id));				
				}else {
				throw new IllegalArgumentException();	
			}
		}else if("business".equals(account)){
			if("big".equals(type)) {			
				oGreeting.setContent(String.format("%s %s user!", "Welcome, ", account));			
			}else {	
				throw new IllegalArgumentException();	
			}		
		}else {
				throw new IllegalArgumentException();		
		}		       
		 return Collections.singleton(oGreeting.getContent());
    }	
	
}
