package com.air.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TagManageViewController {
	
	@RequestMapping(value = "/tagManage")	
	String home()
	{
		System.out.println("test");
		return "tag";
	}

}
