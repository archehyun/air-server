package com.air.controller;

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
		service.select();
		System.out.println("user");
		return "user";
	}


}
