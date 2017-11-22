package com.air.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.air.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService service;
	
	@RequestMapping(value = "/user")	
	String home()
	{		
		service.insert();
		System.out.println("user");
		return "user";
	}


}
