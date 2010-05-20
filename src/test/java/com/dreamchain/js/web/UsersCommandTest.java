package com.dreamchain.js.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import junit.framework.Assert;

import org.junit.Test;

import com.dreamchain.js.model.User;

public class UsersCommandTest {
	
	@Test
	public void valid() {

		UsersCommand usersCommand = new UsersCommand(getValidUsers());
		
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<UsersCommand>> violations = validator.validate(usersCommand); 
		Assert.assertTrue(violations.isEmpty());
	
	}

	private List<User> getValidUsers() {

		User user1 = new User();
		user1.setName("name1");
		user1.setEmail("name1@domain.net");
		user1.setAddress("address1");

		User user2 = new User();
		user2.setName("name2");
		user2.setEmail("name2@domain.net");
		user2.setAddress("address2");

		User user3 = new User();
		user3.setName("name3");
		user3.setEmail("name3@domain.net");
		user3.setAddress("address3");
		
		List<User> users = new ArrayList<User>();
		users.add(user1);
		users.add(user2);
		users.add(user3);
		return users;

	}
	
}
