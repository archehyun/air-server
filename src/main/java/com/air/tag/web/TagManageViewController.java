package com.air.tag.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.air.tag.service.TagService;

@Controller
@RequestMapping("tagManage")
public class TagManageViewController {

	//@Autowired TagService service;

	@RequestMapping(method= RequestMethod.GET) 
	String home(Model model) {

		return "tagManage";


	}


	/*


	 * @RequestMapping(value="tagUser", method= RequestMethod.GET) String
	 * tagUser(Model model) { List li=service.selectTagUser();
	 * model.addAttribute("tagUsers",li); return "tagUser"; }
	 * 
	 * @RequestMapping(value="delete", method= RequestMethod.POST) String
	 * deleteTag(@RequestParam String id) { service.delete(id); return
	 * "redirect:/tagManage"; }
	 * 
	 * @RequestMapping(value="tagUserDelete", method= RequestMethod.POST) String
	 * deleteTagUser(@RequestParam String id,@RequestParam String user) {
	 * service.deleteTagUser(id, user); return "redirect:/tagManage/tagUser"; }
	 */
}
