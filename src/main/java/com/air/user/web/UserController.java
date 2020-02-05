package com.air.user.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.air.user.service.UserServiceImpl;

@Controller
@RequestMapping("user")	
public class UserController {
	
	/*
	 * @Autowired UserService service;
	 * 
	 * @RequestMapping(method= RequestMethod.GET) String home(Model model) { List
	 * li=service.select(); model.addAttribute("users",li); return "user"; }
	 * 
	 * @RequestMapping(value="delete", method= RequestMethod.POST) String
	 * deleteTag(@RequestParam String id) { service.delete(id); return
	 * "redirect:/user"; }
	 */


}
