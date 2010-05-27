package com.dreamchain.testedjs.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dreamchain.testedjs.service.TreeService;

@Controller()
@RequestMapping(value = "/treeExample")
public class TreeExampleController {

	@Autowired TreeService treeService;
	
	@RequestMapping(method = RequestMethod.GET)
	public void get(Model model) {
		model.addAttribute("tree", treeService.getRandomTree());
	}

	@RequestMapping(method = RequestMethod.POST, params="action=getChildren")
	public String getChildren(Model model) {
		model.addAttribute("children", treeService.getRandomTree().getChildren());
		return "children";
	}

}
