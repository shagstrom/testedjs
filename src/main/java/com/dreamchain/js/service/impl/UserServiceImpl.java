package com.dreamchain.js.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dreamchain.js.dao.UserDao;
import com.dreamchain.js.model.User;
import com.dreamchain.js.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired(required=true)
	private UserDao userDao;
	
	@Transactional(readOnly=true)
	public User get(Long id) {
		return userDao.get(id);
	}

	@Transactional
	public void delete(User user) {
		userDao.delete(user);
	}

	@Transactional(readOnly=true)
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Transactional
	public void save(User user) {
		userDao.save(user);
	}

	@Transactional
	public void saveAll(List<User> users) {
		for (User user : users)
			userDao.save(user);
	}
	
}
