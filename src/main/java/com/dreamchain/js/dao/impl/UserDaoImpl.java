package com.dreamchain.js.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dreamchain.js.dao.UserDao;
import com.dreamchain.js.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired(required=true)
	private SessionFactory sessionFactory;

	public User get(Long id) {
		return (User) sessionFactory.getCurrentSession()
			.createQuery("from User user where user.id = :id")
			.setLong("id", id).uniqueResult();
	}

	public void delete(User user) {
		sessionFactory.getCurrentSession().delete(user);
	}

	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	public void save(User user) {
		sessionFactory.getCurrentSession().merge(user);
		
	}

}
