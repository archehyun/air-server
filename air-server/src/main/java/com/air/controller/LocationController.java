package com.air.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.air.service.LocationService;


@Controller
@RequestMapping("location")
public class LocationController {
	
	@Autowired
	LocationService service;
	
	@RequestMapping(method= RequestMethod.GET)
	String home(Model model)
	{
		List li=service.select();
		model.addAttribute("locations",li);		
		return "location";
	}

}
