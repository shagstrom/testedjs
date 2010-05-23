package com.dreamchain.testedjs.service;

import java.util.List;

import com.dreamchain.testedjs.model.User;

public interface UserService {
	
	User get(Long id);
	void save(User user);
	void delete(User user);
	List<User> findAll();
	void saveAll(List<User> users);
	
}
