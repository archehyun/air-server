package com.air.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.air.core.TagManager;




@RestController
public class TagController {
	
	@Autowired
	TagManager tagManager;
			
	@RequestMapping(value = "/tag", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
	String home(@RequestBody String body, @RequestHeader HttpHeaders headers)
	{
		System.out.println("send:"+body);
		
		tagManager.addMessage(body);
		return "redirect:/tagManage/tagUser";
	}

}
