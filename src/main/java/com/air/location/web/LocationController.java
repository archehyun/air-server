package com.air.location.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.air.location.service.impl.LocationServiceImpl;

@Controller
@RequestMapping("location")
public class LocationController {
	
	@Autowired
	LocationServiceImpl service;
	
	@RequestMapping(method= RequestMethod.GET)
	String home(Model model)
	{
		/*
		 * List li=service.select(); model.addAttribute("locations",li);
		 */
		return "location";
	}

}
