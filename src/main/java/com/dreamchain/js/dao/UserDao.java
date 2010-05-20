package com.dreamchain.js.dao;

import java.util.List;

import com.dreamchain.js.model.User;

public interface UserDao {

	User get(Long id);
	void save(User user);
	void delete(User user);
	List<User> findAll();

}
