package com.air.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.air.core.TagManager;

@Controller
@RequestMapping("/")
public class MainController {
	
	@Autowired
	TagManager manager;
	
	@RequestMapping(method= RequestMethod.GET)
	String home(Model model)
	{				
		
		List li=manager.getMessageList();
		model.addAttribute("message",li);		
		
		return "index";
	}

}
