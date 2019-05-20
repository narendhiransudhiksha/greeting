package com.rest.dockerspringgreeting.model;

import org.springframework.context.annotation.Configuration;

/*
 * Greeting Model Object.
 * 
 */
@Configuration 
public class Greeting {
	 private  String content;
	
	   public void setContent(String content) {
		   this.content = content;
	    }
	   /*
	    * Return Greeting Message
		*/
	    public String getContent() {
	        return content;
	    }
}
