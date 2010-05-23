package com.dreamchain.testedjs.web;

import org.junit.Test;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import com.dreamchain.testedjs.web.UserController;

public class UserControllerTests {
	
	private UserController controller = new UserController();
	
	@Test
	public void get() {
		Model model = new ExtendedModelMap();
		controller.get(model);
	}
	
}
