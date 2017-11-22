package com.air.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.air.service.TagService;

@Controller
public class TagManageViewController {
	
	@Autowired
	TagService service;
	
	@RequestMapping(value = "/tagManage")	
	String home()
	{
		List li=service.select();
		System.out.println("test:"+li.size());
		return "tag";
	}

}
