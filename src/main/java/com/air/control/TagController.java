package com.air.control;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TagController {
	@RequestMapping(value = "/tag")	
	String home()
	{
		System.out.println("test");
		return "tag";
	}

}
